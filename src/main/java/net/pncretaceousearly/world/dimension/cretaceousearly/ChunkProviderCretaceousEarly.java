package net.pncretaceousearly.world.dimension.cretaceousearly;

import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.util.Functions;
import net.lepidodendron.world.biome.ChunkGenSpawner;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.WorldGenPangaeanDryLakes;
import net.lepidodendron.world.gen.WorldGenPrehistoricLakes;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.*;
import net.pncretaceousearly.world.biome.cretaceousearly.*;
import static java.lang.Math.toIntExact;
import net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly.GenLayerCretaceousEarlyYixianFoothills;

import java.util.List;
import java.util.Random;

public class ChunkProviderCretaceousEarly implements IChunkGenerator {
    public static final IBlockState STONE = Blocks.STONE.getStateFromMeta(0);
    //public static final IBlockState STONE2 = Blocks.STONE.getStateFromMeta(0);
    public static final IBlockState LAVA = BlockLavaRock.block.getDefaultState();
    //public static final IBlockState FLUID = Blocks.FLOWING_WATER.getDefaultState();

    public final String BANDING_CODE;

    public static final IBlockState FLUID = Blocks.WATER.getDefaultState();
    public static final IBlockState FLUID_FLOWING = Blocks.FLOWING_WATER.getDefaultState();
    public static final int ANTARCIC_LAKES_SEA_LEVEL = 87;
    public static final int YIXIAN_LAKES_SEA_LEVEL = 140;

    public static final IBlockState AIR = Blocks.AIR.getDefaultState();
    public static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
    public static final int SEALEVEL = 63;
    public final Random random;
    private NoiseGeneratorOctaves perlin1;
    private NoiseGeneratorOctaves perlin2;
    private NoiseGeneratorOctaves perlin;
    private NoiseGeneratorPerlin height;
    private NoiseGeneratorOctaves depth;
    public final World world;
    public final WorldType terrainType;
    public final MapGenBase caveGenerator;
    public final MapGenBase ravineGenerator;
    public Biome[] biomesForGeneration;
    public double[] heightMap;
    public double[] depthbuff = new double[256];
    public double[] noiseRegMain;
    public double[] limitRegMin;
    public double[] limitRegMax;
    public double[] depthReg;
    public float[] biomeWeights;

    public ChunkProviderCretaceousEarly(World worldIn, long seed) {

        //Get the banding code for this seed:
        long seedVal = worldIn.getSeed();
        int seedInt = 0;
        try {
            seedInt = Math.abs(toIntExact(seedVal));
        }
        catch (ArithmeticException e) {
            seedInt = Math.abs((int) (2147483647L - (Math.abs(seedVal) % 2147483647L)));
        }

        boolean allFound = false;
        String b5 = "";
        while (!allFound) {
            //Convert to Base 5 as we have five possible layers:
            b5 = Functions.convertFromDecimalToBaseX(seedInt, 5);
            allFound = b5.contains("0") && b5.contains("1") && b5.contains("2") && b5.contains("3") && b5.contains("4");
            if (!allFound) {
                try {
                    seedInt = seedInt + 1;
                }
                catch (ArithmeticException e) {
                    seedInt = 0;
                }
            }
        }
        //And next remove any adjacent same numbers:
        String strFinal = "";
        String ss = "";
        for (int n = 0; n < b5.length(); n++) {
            if (!(ss.equalsIgnoreCase(b5.substring(n, n + 1)))) {
                strFinal = strFinal + b5.substring(n, n + 1);
                ss = b5.substring(n, n + 1);
            }
        }
        if (strFinal.substring(0, 1).equalsIgnoreCase(ss)) {
            strFinal = strFinal.substring(0, strFinal.length() - 1);
        }
        this.BANDING_CODE = strFinal;


        worldIn.setSeaLevel(SEALEVEL);
        caveGenerator = new MapGenCaves() {
            @Override
            protected boolean canReplaceBlock(IBlockState a, IBlockState b) {
                if (a.getBlock() == STONE.getBlock()
                        || a.getMaterial() == Material.ROCK
                        || a.getMaterial() == Material.SAND
                        || a.getMaterial() == Material.GROUND)
                    return true;
                return super.canReplaceBlock(a, b);
            }
        };
        ravineGenerator = new MapGenRavine() {
            @Override
            protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop) {
                Biome biome = world.getBiome(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
//                if (biome == BiomeJurassicBeachBlack.biome || biome == BiomeEarlyCretaceousBeach.biome
//                    || biome == BiomeJurassicMudflats.biome || biome == BiomeJurassicMudflatsHelper.biome
//                    || biome == BiomeEarlyCretaceousRiver.biome || biome == BiomeJurassicRiverbank.biome
//                    || biome == BiomeJurassicSandyIsland.biome || biome == BiomeJurassicSandyIslandForest.biome
//                    || biome == BiomeJurassicSandyIslandHills.biome || biome == BiomeJurassicSandyIslandWhite.biome) {return;}
                IBlockState state = data.getBlockState(x, y, z);
                if (state.getBlock() == STONE.getBlock() || state.getBlock() == biome.topBlock.getBlock()
                        || state.getBlock() == biome.fillerBlock.getBlock()
                        || state.getMaterial() == Material.ROCK
                        || state.getMaterial() == Material.SAND
                        || state.getMaterial() == Material.CLAY
                        || state.getMaterial() == Material.GROUND ) {
                    if (y - 1 < 10) {
                        data.setBlockState(x, y, z, FLOWING_LAVA);
                    }
                    else {
                        data.setBlockState(x, y, z, AIR);
                        if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == biome.fillerBlock.getBlock()) {
                            data.setBlockState(x, y - 1, z, biome.topBlock.getBlock().getDefaultState());
                        }
                    }
                }
            }
        };
        this.world = worldIn;
        this.terrainType = worldIn.getWorldInfo().getTerrainType();
        this.random = new Random(seed);
        this.perlin1 = new NoiseGeneratorOctaves(this.random, 16);
        this.perlin2 = new NoiseGeneratorOctaves(this.random, 16);
        this.perlin = new NoiseGeneratorOctaves(this.random, 8);
        this.height = new NoiseGeneratorPerlin(this.random, 4);
        this.depth = new NoiseGeneratorOctaves(this.random, 16);
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];
        for (int i = -2; i <= 2; i++)
            for (int j = -2; j <= 2; j++)
                this.biomeWeights[i + 2 + (j + 2) * 5] = 10 / MathHelper.sqrt((float) (i * i + j * j) + 0.2f);
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        this.random.setSeed((long) x * 535358712L + (long) z * 347539041L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(x, z, chunkprimer);
        //this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);
        this.caveGenerator.generate(this.world, x, z, chunkprimer);
//        if (this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicMudflats.biome
//            && this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicMudflatsHelper.biome
//            && this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicSandyIsland.biome
//            && this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicSandyIslandForest.biome
//            && this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicSandyIslandHills.biome
//            && this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicSandyIslandWhite.biome
//            && this.world.getBiome(new BlockPos (x, 0, z)) != BiomeJurassicSandyIslandWhiteEdge.biome) {
            this.ravineGenerator.generate(this.world, x, z, chunkprimer);
//        }
        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();
        for (int i = 0; i < abyte.length; ++i)
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {
        BlockFalling.fallInstantly = true;
        int i = x * 16;
        int j = z * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
        this.random.setSeed(this.world.getSeed());
        long k = this.random.nextLong() / 2 * 2 + 1;
        long l = this.random.nextLong() / 2 * 2 + 1;
        this.random.setSeed((long) x * k + (long) z * l ^ this.world.getSeed());
        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.random, x, z, false);

//        if (biome == BiomeJurassicMudflatsEstuary.biome) //Many extra lakes in the estuary
//            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
//                    net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
//                for (int lake = 0; lake < 12; ++lake) {
//                    int i1 = this.random.nextInt(16) + 8;
//                    int j1 = this.random.nextInt(256);
//                    int k1 = this.random.nextInt(16) + 8;
//                    (new WorldGenPrehistoricLakes(FLUID.getBlock())).generate(this.world, this.random, blockpos.add(i1, j1, k1));
//                }
//            }


//        if (biome == BiomeJurassicMire.biome || biome == BiomeJurassicMireHelper.biome) //Many extra lakes in the estuary
//            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
//                    net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
//                for (int lake = 0; lake < 2; ++lake) {
//                    int i1 = this.random.nextInt(16) + 8;
//                    int j1 = this.random.nextInt(256);
//                    int k1 = this.random.nextInt(16) + 8;
//                    (new WorldGenPrehistoricLakes(FLUID.getBlock())).generate(this.world, this.random, blockpos.add(i1, j1, k1));
//                }
//            }

        int chanceLake = 4;

        if (world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeEarlyCretaceousLandSouthAmericanDesertSpikes.biome
                || world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeEarlyCretaceousLandAfrica.biome) {
            chanceLake = 9;
        }

        if (world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeEarlyCretaceousLandSouthAmericanArid.biome
            || world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeEarlyCretaceousLandAfricaSavanna.biome) {
            chanceLake = 24;
        }

        if (this.random.nextInt(chanceLake) == 0
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousAustroAntarcticLakes.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousAustroAntarcticLakesRimInner.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousAustroAntarcticLakesRimOuter.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousAustroAntarcticLakesPeaks.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandSouthAmericanAridSpikes.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandSouthAmericanSandyDesert.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandSouthAmericanSandyDesertSpikes.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAfrica.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAfricaBrownstonePeaks.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaPhrygana.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaBandedDesert.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaBarrenHills.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaRefugium.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousCreekAsiaRefugium.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaShrubland.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaShrublandDunes.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAsiaShrublandOasis.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousCreekAsiaShrubland.biome
                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeEarlyCretaceousLandAustraliaAntarcticaColdDivider.biome
//                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeJurassicDesertRimDesertSide.biome
//                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeJurassicSandyIslandWhite.biome
//                && world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) != BiomeJurassicSandyIslandWhiteEdge.biome
        )
            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
                    net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
                int i1 = this.random.nextInt(16) + 8;
                int j1 = this.random.nextInt(256);
                int k1 = this.random.nextInt(16) + 8;
                if (!world.getBiome(blockpos.add(i1, j1, k1)).getRegistryName().toString().equalsIgnoreCase("lepidodendron:cretaceous_early_barren_hills"))
                (new WorldGenPrehistoricLakes(FLUID.getBlock())).generate(this.world, this.random, blockpos.add(i1, j1, k1));
            }

        if (world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeEarlyCretaceousLandAsiaRefugium.biome
        )
            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
                    net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
                int i1 = this.random.nextInt(16) + 8;
                int j1 = this.random.nextInt(256);
                int k1 = this.random.nextInt(16) + 8;
                (new WorldGenPangaeanDryLakes(FLUID.getBlock())).generate(this.world, this.random, blockpos.add(i1, j1, k1));
            }

//        if (this.random.nextInt(350) == 0 &&
//                (world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeJurassicSouthernTaigaHills.biome
//                        || world.getBiome(new BlockPos(i, world.getSeaLevel(), j)) == BiomeJurassicSouthernTaiga.biome)
//            )
//            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
//                    net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
//                int i1 = this.random.nextInt(16) + 8;
//                int j1 = this.random.nextInt(256);
//                int k1 = this.random.nextInt(16) + 8;
//                new WorldGenJurassicVolcanos().generate(this.world, this.random, blockpos.add(i1, j1, k1));
//            }


        net.minecraftforge.common.MinecraftForge.EVENT_BUS
                .post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(this.world, this.random, blockpos));
        biome.decorate(this.world, this.random, new BlockPos(i, 0, j));
        net.minecraftforge.common.MinecraftForge.EVENT_BUS
                .post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(this.world, this.random, blockpos));

        if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
                net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS)) {
            //int i1 = this.random.nextInt(16) + 8; //This is in the spawner instead:
            //int k1 = this.random.nextInt(16) + 8; //This is in the spawner instead:
            ChunkGenSpawner.executeProcedure(this.world, blockpos, this.random, null, true);
        }

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.random, x, z, false);
        BlockFalling.fallInstantly = false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return this.world.getBiome(pos).getSpawnableList(creatureType);
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {
    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }

    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    public void setBlocksInChunk(int x, int z, ChunkPrimer primer) {
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        this.generateHeightmap(x * 4, 0, z * 4);
        for (int i = 0; i < 4; ++i) {
            int j = i * 5;
            int k = (i + 1) * 5;
            for (int l = 0; l < 4; ++l) {
                int i1 = (j + l) * 33;
                int j1 = (j + l + 1) * 33;
                int k1 = (k + l) * 33;
                int l1 = (k + l + 1) * 33;
                for (int i2 = 0; i2 < 32; ++i2) {
                    double d0 = 0.125D;
                    double d1 = this.heightMap[i1 + i2];
                    double d2 = this.heightMap[j1 + i2];
                    double d3 = this.heightMap[k1 + i2];
                    double d4 = this.heightMap[l1 + i2];
                    double d5 = (this.heightMap[i1 + i2 + 1] - d1) * 0.125D;
                    double d6 = (this.heightMap[j1 + i2 + 1] - d2) * 0.125D;
                    double d7 = (this.heightMap[k1 + i2 + 1] - d3) * 0.125D;
                    double d8 = (this.heightMap[l1 + i2 + 1] - d4) * 0.125D;
                    for (int j2 = 0; j2 < 8; ++j2) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.25D;
                        double d13 = (d4 - d2) * 0.25D;
                        for (int k2 = 0; k2 < 4; ++k2) {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * 0.25D;
                            double lvt_45_1_ = d10 - d16;
                            for (int l2 = 0; l2 < 4; ++l2) {
                                if ((lvt_45_1_ += d16) > 0.0D) {
                                    primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, STONE);
                                } else if (i2 * 8 + j2 < SEALEVEL) {
                                    primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, FLUID);
                                }
                            }
                            d10 += d12;
                            d11 += d13;
                        }
                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void generateHeightmap(int p_185978_1_, int p_185978_2_, int p_185978_3_) {
        this.depthReg = this.depth.generateNoiseOctaves(this.depthReg, p_185978_1_, p_185978_3_, 5, 5, (double) 200, (double) 200, (double) 0.5f);
        float f = 684.412f;
        float f1 = 684.412f;
        this.noiseRegMain = this.perlin.generateNoiseOctaves(this.noiseRegMain, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5,
                (double) (f / 80), (double) (f1 / 160), (double) (f / 80));
        this.limitRegMin = this.perlin1.generateNoiseOctaves(this.limitRegMin, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5, (double) f,
                (double) f1, (double) f);
        this.limitRegMax = this.perlin2.generateNoiseOctaves(this.limitRegMax, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5, (double) f,
                (double) f1, (double) f);
        int i = 0;
        int j = 0;
        for (int k = 0; k < 5; ++k) {
            for (int l = 0; l < 5; ++l) {
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;
                int i1 = 2;
                Biome biome = this.biomesForGeneration[k + 2 + (l + 2) * 10];
                for (int j1 = -2; j1 <= 2; ++j1) {
                    for (int k1 = -2; k1 <= 2; ++k1) {
                        Biome biome1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
                        float f5 = 0 + biome1.getBaseHeight() * 1;
                        float f6 = 0 + biome1.getHeightVariation() * 1;
                        //if (this.terrainType == WorldType.AMPLIFIED && f5 > 0.0F) {
                        //    f5 = 1.0F + f5 * 2.0F;
                        //    f6 = 1.0F + f6 * 4.0F;
                        //}
                        float f7 = this.biomeWeights[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);
                        if (biome1.getBaseHeight() > biome.getBaseHeight()) {
                            f7 /= 2.0F;
                        }
                        f2 += f6 * f7;
                        f3 += f5 * f7;
                        f4 += f7;
                    }
                }
                f2 = f2 / f4;
                f3 = f3 / f4;
                f2 = f2 * 0.9F + 0.1F;
                f3 = (f3 * 4.0F - 1.0F) / 8.0F;
                double d7 = this.depthReg[j] / 8000.0D;
                if (d7 < 0.0D) {
                    d7 = -d7 * 0.3D;
                }
                d7 = d7 * 3.0D - 2.0D;
                if (d7 < 0.0D) {
                    d7 = d7 / 2.0D;
                    if (d7 < -1.0D) {
                        d7 = -1.0D;
                    }
                    d7 = d7 / 1.4D;
                    d7 = d7 / 2.0D;
                } else {
                    if (d7 > 1.0D) {
                        d7 = 1.0D;
                    }
                    d7 = d7 / 8.0D;
                }
                ++j;
                double d8 = (double) f3;
                double d9 = (double) f2;
                d8 = d8 + d7 * 0.2D;
                d8 = d8 * (double) 8.5f / 8.0D;
                double d0 = (double) 8.5f + d8 * 4.0D;
                for (int l1 = 0; l1 < 33; ++l1) {
                    double d1 = ((double) l1 - d0) * (double) 12 * 128.0D / 256.0D / d9;
                    if (d1 < 0.0D) {
                        d1 *= 4.0D;
                    }
                    double d2 = this.limitRegMin[i] / (double) 512;
                    double d3 = this.limitRegMax[i] / (double) 512;
                    double d4 = (this.noiseRegMain[i] / 10.0D + 1.0D) / 2.0D;

                    if (biome == BiomeEarlyCretaceousLandAfricaSwampFlat.biome) {
                        //Flatten these out somewhat:
                        d4 = (d4 + 5D) / 6D;
                        d2 = d4;
                        d3 = d4;
                    }

                    if (biome == BiomeEarlyCretaceousLandSouthAmericanFlats.biome
                        || biome == BiomeEarlyCretaceousCreekSouthAmericanFlatsStream.biome) {
                        //Flatten these out:
                        d4 = 1D;
                        d2 = d4;
                        d3 = d4;
                    }

                    double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;
                    if (l1 > 29) {
                        double d6 = (double) ((float) (l1 - 29) / 3.0F);
                        d5 = d5 * (1.0D - d6) + -10.0D * d6;
                    }
                    this.heightMap[i] = d5;
                    ++i;
                }
            }
        }
    }

    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        this.depthbuff = this.height.getRegion(this.depthbuff, (double) (x * 16), (double) (z * 16), 16, 16, 0.0625, 0.0625, 1);
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                generateBiomeTerrain(this.world, this.random, primer, x * 16 + i, z * 16 + j, this.depthbuff[j + i * 16], biomesIn[j + i * 16]);
    }

    /**
     * Given x, z coordinates, we count down all the y positions starting at 255 and
     * working our way down. When we hit a non-air block, we replace it with
     * biome.topBlock (default grass, descendants may set otherwise), and then a
     * relatively shallow layer of blocks of type biome.fillerBlock (default dirt).
     * A random set of blocks below y == 5 (but always including y == 0) is replaced
     * with bedrock. If we don't hit non-air until somewhat below sea level, we top
     * with gravel and fill down with stone. If biome.fillerBlock is red sand, we
     * replace some of that with red sandstone.
     */

    public final void generateBiomeTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal, Biome biome) {
        int i = SEALEVEL;
        if (biome == BiomeEarlyCretaceousAustroAntarcticLakes.biome
            || biome == BiomeEarlyCretaceousAustroAntarcticLakesRimInner.biome) {
            i = ANTARCIC_LAKES_SEA_LEVEL;
        }
        if (biome == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome
                || biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome
                || biome == BiomeEarlyCretaceousLandAsiaYixianLakesBurned.biome) {
            i = YIXIAN_LAKES_SEA_LEVEL;
        }
        IBlockState iblockstate = biome.topBlock;
        IBlockState iblockstate1 = biome.fillerBlock;
        int j = -1;
        int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        for (int j1 = 255; j1 >= 0; --j1) {
            IBlockState iblockstate5 = chunkPrimerIn.getBlockState(i1, j1, l);
//            if ((biome == BiomeJurassicDesertRim.biome || biome == BiomeJurassicDesertRimDesertSide.biome)
//                 && iblockstate5.getMaterial() == Material.WATER
//            ) {
//                chunkPrimerIn.setBlockState(i1, j1, l, FLUID_FLOWING);
//            }
            if (j1 <= rand.nextInt(5)) {
                chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
            }
            else if ((biome == BiomeEarlyCretaceousAustroAntarcticLakes.biome || biome == BiomeEarlyCretaceousAustroAntarcticLakesPeaks.biome)
                    && iblockstate5.getMaterial() == Material.AIR && j1 <= ANTARCIC_LAKES_SEA_LEVEL && j1 >= ANTARCIC_LAKES_SEA_LEVEL - 6) {
                chunkPrimerIn.setBlockState(i1, j1, l, FLUID);
            }
            else if ((biome == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome || biome == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome)
                    && iblockstate5.getMaterial() == Material.AIR && j1 <= YIXIAN_LAKES_SEA_LEVEL && j1 >= YIXIAN_LAKES_SEA_LEVEL - 6) {
                chunkPrimerIn.setBlockState(i1, j1, l, FLUID);
            }
            else if ((biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome || biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome)
                    && iblockstate5.getMaterial() == Material.AIR && j1 <= YIXIAN_LAKES_SEA_LEVEL && j1 >= YIXIAN_LAKES_SEA_LEVEL - 6) {
                chunkPrimerIn.setBlockState(i1, j1, l, FLUID);
            }
            else if ((biome == BiomeEarlyCretaceousLandAsiaYixianLakesBurned.biome || biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome)
                    && iblockstate5.getMaterial() == Material.AIR && j1 <= YIXIAN_LAKES_SEA_LEVEL && j1 >= YIXIAN_LAKES_SEA_LEVEL - 6) {
                chunkPrimerIn.setBlockState(i1, j1, l, FLUID);
            }
            else {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);
                if (iblockstate2.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (iblockstate2.getBlock() == STONE.getBlock()) {
                    if (j == -1) {
                        if (k <= 0) {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                            //} else if (j1 >= i - 4 && j1 <= i + 1) {
                        }
                        else if (j1 <= i + 2 && j1 >= i - 1 && Math.random() > 0.25
                                && (biome == BiomeEarlyCretaceousCreekSouthAmericanSandyDesert.biome)
                        ) {
                            iblockstate = BlockDriedMud.block.getDefaultState();
                        }
                        else if (j1 <= i - 7 - k) {
                            iblockstate = biome.topBlock;
                            //iblockstate1 = biome.fillerBlock;
                            iblockstate1 = getIBlockstateForWater(biome, j1, iblockstate1, rand);
                        }
                        if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
                            if (biome.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
                                iblockstate = FLUID;
                            } else {
                                iblockstate = FLUID;
                            }
                        }

                        //Special terrain treatments here:
                        //-------------------------------
                        //In the European Swamp:
                        if (biome == BiomeEarlyCretaceousLandEurope.biome
                        ) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(8) == 0 && j1 > i + 4) {
                                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandEuropeMaquis.biome
                        ) {
                            if (rand.nextInt(8) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousCreekSAmericaWide.biome
                                || biome == BiomeEarlyCretaceousCreekSAmericaWideCentre.biome
                                || biome == BiomeEarlyCretaceousCreekSAmericaWideCentreRift.biome
                        ) {
                            if (rand.nextInt(16) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            else if (rand.nextInt(16) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            else if (rand.nextInt(16) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            else if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            else if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPeat.block.getDefaultState();
                            }
                            else if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            else if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandNAmerica.biome //Braided floodplain lower
                        ) {
                            if (rand.nextInt(6) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(6) == 0 && j1 > i + 3) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(5) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0 && j1 < i + 1) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(3) == 0 && j1 < i) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(24) == 0 && j1 < i + 2) {
                                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(14) == 0 && j1 < i + 1) {
                                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(5) == 0 && j1 < i) {
                                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                        }
                        if (biome == BiomeEarlyCretaceousLandNAmericaTransition.biome //Braided floodplain upper
                        ) {
                            if (rand.nextInt(3) == 0) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAustraliaAntarctica.biome
                        ) {
                            if (rand.nextInt(3) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockLeafLitter.block.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousAustroAntarcticRainforest.biome
                        ) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPeat.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousBeachAustroAntarcticaInlandSea.biome
                        ) {
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = Blocks.SAND.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAustroAntarcticPaddock.biome
                        ) {
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandEuropeField.biome) {
                            if (rand.nextInt(16) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandEuropeFieldCopse.biome) {
                            if (rand.nextInt(2) != 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(10) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockLeafLitter.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousAustroAntarcticCoastal.biome) {
                            if (rand.nextInt(8) == 0) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = Blocks.SAND.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousCreekAustraliaAntarctica.biome) {
                            if (rand.nextInt(8) == 0) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = Blocks.SAND.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandNAmericaShrubland.biome) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getStateFromMeta(1);
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandNAmericaShrublandCopse.biome) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getStateFromMeta(1);
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandSouthAmericanSandyDesert.biome
                                || biome == BiomeEarlyCretaceousCreekSouthAmericanSandyDesert.biome
                                || biome == BiomeEarlyCretaceousLandSouthAmericanSandyDesertSpikes.biome) {
                            if (j1 > Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + 5 + rand.nextInt(5)) {
                                iblockstate = Blocks.SAND.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.SAND.getDefaultState();
                            }
                            if (rand.nextInt(18) == 0) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            //If it's over 75 blocks then start to fill in more as stone
                            //up to 90 where it almost fully stone - sometimes cobble
                            int minHeight = 75;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 90 - j1);
                                double stoneFactor = (double) j2 / (90D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = BlockBrownstone.block.getDefaultState();
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = BlockDriedMud.block.getDefaultState();
                                    }
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = BlockBrownstone.block.getDefaultState();
                                }
                                if (rand.nextInt(12) == 0) {
                                    iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAfrica.biome) {
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockSandyDirtGrey.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(8);
                            }
                            if (rand.nextInt(24) == 0) {
                                iblockstate = Blocks.HARDENED_CLAY.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaShrubland.biome) {
                            iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            if (rand.nextInt(2) == 0) {
                                iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                            }
                            if (rand.nextInt(11) == 0) {
                                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(18) == 0) {
                                iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                            }
                            if (rand.nextInt(32) == 0) {
                                iblockstate = BlockSandPangaean.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaShrublandDunes.biome) {
                            iblockstate = BlockSandPangaeanWavy.block.getDefaultState();
                            if (rand.nextInt(48) == 0) {
                                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(48) == 0) {
                                iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaShrublandOasis.biome
                            || biome == BiomeEarlyCretaceousCreekAsiaShrubland.biome) {
                            iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            if (rand.nextInt(2) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                            }
                            if (rand.nextInt(17) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(29) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaShrublandSprings.biome) {
                            iblockstate = BlockToxicMud.block.getDefaultState();
                            if (rand.nextInt(5) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaRefugium.biome
                            || biome == BiomeEarlyCretaceousCreekAsiaRefugium.biome) {
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockSandPangaean.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaPhrygana.biome
                                || biome == BiomeEarlyCretaceousCreekAsiaPhrygana.biome
                                || biome == BiomeEarlyCretaceousLandAsiaPhryganaLake.biome) {
                            if (rand.nextInt(12) == 0) {
                                iblockstate = Blocks.COBBLESTONE.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = Blocks.STONE.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockSandstoneGrey.block.getDefaultState();
                            }
                            if (j1 == 62 && rand.nextInt(5) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (j1 == 62 && rand.nextInt(10) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (j1 == 63 && rand.nextInt(5) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (j1 == 64 && rand.nextInt(12) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (j1 == 65 && rand.nextInt(32) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (j1 <= 67 && rand.nextInt(6) == 0 && biome == BiomeEarlyCretaceousCreekAsiaPhrygana.biome) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (j1 <= 63 && rand.nextInt(4) == 0 && biome == BiomeEarlyCretaceousCreekAsiaPhrygana.biome) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousBeachAsiaCraggy.biome) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.COBBLESTONE.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            if (rand.nextInt(5) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0 && j1 < 65) {
                                iblockstate = Blocks.SAND.getStateFromMeta(0);
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAfricaSavanna.biome
                                || biome == BiomeEarlyCretaceousCreekAfricaSavanna.biome
                                || biome == BiomeEarlyCretaceousLandAfricaSavannaWateringHole.biome
                                || biome == BiomeEarlyCretaceousLandAfricaSavannaWateringHoleCentre.biome) {
                            if (rand.nextInt(10) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = Blocks.SAND.getStateFromMeta(1);
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                            }
                            if (rand.nextInt(48) == 0) {
                                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(24) == 0 && j1 <= 70) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsia.biome
                            || biome == BiomeEarlyCretaceousCreekBoggy.biome) {
                            int p = rand.nextInt(100);
                            if (j1 == 62) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                                if (p >= 99) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 97) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 94) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                                else if (p >= 56) {
                                    iblockstate = BlockPeat.block.getDefaultState();
                                }
                            }
                            else if (j1 == 63) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                                if (p >= 98) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 92) {
                                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                }
                                else if (p >= 88) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 81) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 67) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 49) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                                else if (p >= 27) {
                                    iblockstate = BlockPeat.block.getDefaultState();
                                }
                            }
                            else if (j1 == 64) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                                if (p >= 89) {
                                    iblockstate = BlockDriedMud.block.getDefaultState();
                                }
                                else if (p >= 74) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 88) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 56) {
                                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                }
                                else if (p >= 41) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 24) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 19) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 19) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                            }
                            else {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                if (p >= 90) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                                else if (p >= 79) {
                                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                                }
                                else if (p >= 44) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 29) {
                                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                }
                                else if (p >= 20) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 5) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaDrooping.biome
                                || biome == BiomeEarlyCretaceousLandAsiaDroopingMound.biome
                                || biome == BiomeEarlyCretaceousCreekAsiaDrooping.biome
                                || biome == BiomeEarlyCretaceousLandAsiaYixianSkirt.biome) {
                            int p = rand.nextInt(100);
                            if (j1 == 62) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                if (p >= 80) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 60) {
                                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                                }
                                else if (p >= 48) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                                else if (p >= 33) {
                                    iblockstate = BlockPeat.block.getDefaultState();
                                }
                                else if (p >= 26) {
                                    iblockstate = BlockPrehistoricGroundSandBlack.block.getDefaultState();
                                }
                                else if (p >= 20) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                            }
                            else if (j1 == 63) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                if (p >= 80) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 52) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 42) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 28) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                            }
                            else if (j1 == 64 &&
                                    (biome == BiomeEarlyCretaceousLandAsiaDroopingMound.biome
                                    || biome == BiomeEarlyCretaceousLandAsiaYixianSkirt.biome)) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                if (p >= 86) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 75) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 62) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                                else if (p >= 58) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 40) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 24) {
                                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                                }
                                else if (p >= 16) {
                                    iblockstate = BlockVolcanicAshDark.block.getDefaultState();
                                }
                            }
                            else if (j1 >= 65 &&
                                    (biome == BiomeEarlyCretaceousLandAsiaDroopingMound.biome
                                    || biome == BiomeEarlyCretaceousLandAsiaYixianSkirt.biome)
                                ){
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                                if (p >= 86) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 78) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 66) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                                else if (p >= 58) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 40) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 29) {
                                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                                }
                                else if (p >= 20) {
                                    iblockstate = BlockVolcanicAshDark.block.getDefaultState();
                                }
                                else if (p >= 15) {
                                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                }
                                else if (p >= 10) {
                                    iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                }
                            }
                            else if (j1 >= 64) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                if (p >= 86) {
                                    iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                }
                                else if (p >= 75) {
                                    iblockstate = BlockLeafLitter.block.getDefaultState();
                                }
                                else if (p >= 62) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                                else if (p >= 58) {
                                    iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                }
                                else if (p >= 40) {
                                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                                }
                                else if (p >= 24) {
                                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                                }
                                else if (p >= 16) {
                                    iblockstate = BlockVolcanicAshDark.block.getDefaultState();
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaBandedDesert.biome
                            || biome == BiomeEarlyCretaceousCreekAsiaBandedDesert.biome) {
                            int p = rand.nextInt(100);
                            if (j1 == 62) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                if (p >= 75) {
                                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                                }
                                else if (p >= 50) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                                else if (p >= 25) {
                                    iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                                }
                            }
                            else if (j1 == 63) {
                                iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                                if (p >= 75) {
                                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                                }
                                else if (p >= 50) {
                                    if (rand.nextInt(2) == 0) {
                                        iblockstate = Blocks.SAND.getStateFromMeta(1);
                                    }
                                    else {
                                        iblockstate = BlockSandRedWavy.block.getDefaultState();
                                    }
                                }
                                else if (p >= 28) {
                                    iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                                }
                                else if (p >= 25) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                            }
                            else if (j1 >= 64 && j1 <= 65) {
                                iblockstate = Blocks.SAND.getStateFromMeta(1);
                                if (p >= 90) {
                                    iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                                }
                                else if (p >= 80) {
                                    iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                                }
                            }
                            else if (j1 >= 66 && j1 <= 67) {
                                iblockstate = BlockSandstonePangaean.block.getDefaultState();
                                if (p >= 80) {
                                    if (rand.nextInt(2) == 0) {
                                        iblockstate = BlockSandPangaean.block.getDefaultState();
                                    }
                                    else {
                                        iblockstate = BlockSandPangaeanWavy.block.getDefaultState();
                                    }
                                }
                                else if (p >= 60) {
                                    if (rand.nextInt(2) == 0) {
                                        iblockstate = Blocks.SAND.getStateFromMeta(1);
                                    }
                                    else {
                                        iblockstate = BlockSandRedWavy.block.getDefaultState();
                                    }
                                }
                                else if (p >= 40) {
                                    iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                                }
                                else if (p >= 20) {
                                    iblockstate = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                                }
                            }
                            // Banding:
                            else if (j1 >= 68) {
                                iblockstate = getBandedSandType(world, j1, random);
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAfricaSavannaWateringHole.biome
                                || biome == BiomeEarlyCretaceousLandAfricaSavannaWateringHoleCentre.biome) {
                            IBlockState blockstateNormal = BlockPrehistoricGroundBasic.block.getDefaultState();
                            if (rand.nextInt(10) == 0) {
                                blockstateNormal = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(16) == 0) {
                                blockstateNormal = Blocks.SAND.getStateFromMeta(1);
                            }
                            if (rand.nextInt(16) == 0) {
                                blockstateNormal = BlockDriedMud.block.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                blockstateNormal = BlockCoarseSandyDirtRed.block.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                blockstateNormal = BlockCoarseSandyDirtPangaean.block.getDefaultState();
                            }
                            if (rand.nextInt(48) == 0) {
                                blockstateNormal = BlockCoarseSiltyDirt.block.getDefaultState();
                            }
                            if (rand.nextInt(24) == 0 && j1 <= 70) {
                                blockstateNormal = BlockPrehistoricGroundLush.block.getDefaultState();
                            }

                            //If it's over 63 blocks then start to fill in more as stone
                            //up to 71 where it almost back to normal
                            int minHeight = 63;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 71 - j1);
                                double stoneFactor = (double) j2 / (71D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = blockstateNormal;
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAfricaBrownstoneValley.biome) {
                            if (rand.nextInt(8) == 0 && j1 < 80 + rand.nextInt(3) - rand.nextInt(3)) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0 && j1 > 78 + rand.nextInt(3) - rand.nextInt(3)) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                            }
                            if (rand.nextInt(8) == 0 && j1 > 84 + rand.nextInt(3) - rand.nextInt(3)) {
                                iblockstate = Blocks.COBBLESTONE.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0 && j1 > 80 + rand.nextInt(3) - rand.nextInt(3)) {
                                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                            }
                            if (rand.nextInt(14) == 0 && j1 < 86 + rand.nextInt(3) - rand.nextInt(3)) {
                                iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0 && j1 < 83 + rand.nextInt(3) - rand.nextInt(3)) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            IBlockState blockstateNormal = BlockBrownstone.block.getDefaultState();
                            if (rand.nextInt(12) == 0) {
                                blockstateNormal = BlockSandyDirtGrey.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                blockstateNormal = Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(8);
                            }
                            if (rand.nextInt(24) == 0) {
                                blockstateNormal = Blocks.HARDENED_CLAY.getDefaultState();
                            }
                            //If it's over 80 blocks then start to fill in more as stone
                            //up to 97 where it almost back to normal
                            int minHeight = 80;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 97 - j1);
                                double stoneFactor = (double) j2 / (97D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = blockstateNormal;
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandSouthAmericanArid.biome
                                || biome == BiomeEarlyCretaceousCreekSouthAmericanArid.biome) {
                            if (rand.nextInt(10) == 0) {
                                iblockstate = Blocks.SAND.getDefaultState();
                            }
                            if (rand.nextInt(10) == 0) {
                                iblockstate = BlockSandWavy.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            //If it's over 65 blocks then start to fill in more as stone
                            //up to 85 where it almost fully stone - sometimes cobble
                            int minHeight = 65;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 85 - j1);
                                double stoneFactor = (double) j2 / (85D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandSouthAmericanAridSpikes.biome) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                            //If it's over 65 blocks then start to fill in more as stone
                            //up to 105 where it almost fully stone - sometimes cobble
                            int minHeight = 65;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 105 - j1);
                                double stoneFactor = (double) j2 / (105D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandSouthAmericanPatagonia.biome
                            || biome == BiomeEarlyCretaceousCreekSouthAmericanPatagonia.biome) {
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                            }
                            if (rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockLeafLitter.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandSAmerica.biome
                                || biome == BiomeEarlyCretaceousLandSouthAmericanDesertLow.biome
                                || biome == BiomeEarlyCretaceousCreekSouthAmericanDesert.biome
                        ) {
                            if (rand.nextInt(3) == 0) {
                                iblockstate = Blocks.GRAVEL.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = Blocks.STONE.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = Blocks.COBBLESTONE.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousCreekSouthAmericanFlatsStream.biome
                                || biome == BiomeEarlyCretaceousCreekSouthAmericanFlats.biome
                                || biome == BiomeEarlyCretaceousLandSouthAmericanFlats.biome
                        ) {
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousCreekSouthAmericanFlatsStream.biome
                        ) {
                            if (rand.nextInt(16) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandSAmerica.biome
                                || biome == BiomeEarlyCretaceousLandSouthAmericanDesertLow.biome
                                || biome == BiomeEarlyCretaceousCreekSouthAmericanDesert.biome
                        ) {
                            if (j1 <= Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + 16 + rand.nextInt(3) - rand.nextInt(3)
                                    && rand.nextInt(6) == 0
                            ) {
                                iblockstate = BlockSandGrey.block.getDefaultState();
                            }
                            if (j1 <= Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + 4 + rand.nextInt(3) - rand.nextInt(3)
                                    && rand.nextInt(3) != 0
                            ) {
                                iblockstate = BlockDriedMud.block.getDefaultState();
                                if (j1 <= Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + 1 + rand.nextInt(3) - rand.nextInt(3)
                                        && rand.nextInt(4) == 0
                                ) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                            }
                            if (j1 <= Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + 1 + rand.nextInt(3) - rand.nextInt(3)
                                    && rand.nextInt(3) != 0
                            ) {
                                iblockstate = BlockCarboniferousMud.block.getDefaultState();
                                if (j1 <= Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + 1 + rand.nextInt(3) - rand.nextInt(3)
                                    && rand.nextInt(6) == 0
                                ) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                                if (j1 <= Functions.getAdjustedSeaLevel(world, new BlockPos(i1,j1, l)) + rand.nextInt(3) - rand.nextInt(3)
                                        && rand.nextInt(3) == 0
                                ) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                            }
                        }

                        //Craggy
                        if (biome == BiomeEarlyCretaceousLandNAmericaMountainsFoothills.biome
                        ) {
                            //If it's over 90 blocks then start to fill in more as stone
                            //up to 120 where it almost fully stone - sometimes cobble
                            int minHeight = 90;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 120 - j1);
                                double stoneFactor = (double) j2 / (120D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                            }
                        }

                        //Australian Divider ridge:
                        if (biome == BiomeEarlyCretaceousLandAustraliaAntarcticaColdDivider.biome
                        ) {
                            //If it's over 63 blocks then start to fill in more as Gravel
                            //up to 78 where it almost fully Gravel
                            int minHeight = 63;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 85 - j1);
                                double stoneFactor = (double) j2 / (85D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.GRAVEL.getStateFromMeta(0);
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.GRAVEL.getStateFromMeta(0);
                                }
                            }
                        }

                        //Yixian
                        //Mountains:
                        if (biome == BiomeEarlyCretaceousLandAsiaYixianMountains.biome
                        ) {
                            //If it's over 180 blocks then start to fill in more as snow
                            //up to 200 where it almost fully snow
                            int minHeight = 180;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 200 - j1);
                                double stoneFactor = (double) j2 / (200D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.SNOW.getStateFromMeta(0);
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.SNOW.getStateFromMeta(0);
                                }
                            }
                        }

                        //Hills/Rim
                        if (biome == BiomeEarlyCretaceousLandAsiaYixianHighland.biome
                                || biome == BiomeEarlyCretaceousLandAsiaYixianMountains.biome
                        ) {
                            //If it's over 140 blocks then start to fill in more as stone
                            //up to 190 where it almost fully stone - sometimes cobble
                            int minHeight = 140;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 190 - j1);
                                double stoneFactor = (double) j2 / (190D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.COBBLESTONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = Blocks.GRAVEL.getDefaultState();
                                    }
                                    if (rand.nextInt(22) == 0) {
                                        iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.COBBLESTONE.getStateFromMeta(0);
                                }
                            }
                            if (rand.nextInt(4) == 0) {
                                if (j1 <= 170 - rand.nextInt(4) && j1 >= 160 - rand.nextInt(4)) {
                                    iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                                }
                            }
                            if (rand.nextInt(4) == 0) {
                                if (j1 <= 160 - rand.nextInt(4) && j1 >= 150 - rand.nextInt(4)) {
                                    iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                                }
                            }
                            if (rand.nextInt(4) == 0) {
                                if (j1 <= 160 - rand.nextInt(4) && j1 >= 140 - rand.nextInt(4)) {
                                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                                }
                            }
                            if (rand.nextInt(7) == 0) {
                                if (j1 <= 165 - rand.nextInt(4) && j1 >= 120 - rand.nextInt(4)) {
                                    iblockstate = Blocks.GRAVEL.getDefaultState();
                                }
                            }
                            //If it's over 180 blocks then start to fill in more as snow
                            //up to 200 where it almost fully snow
                            minHeight = 180;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 200 - j1);
                                double stoneFactor = (double) j2 / (200D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.SNOW.getStateFromMeta(0);
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.SNOW.getStateFromMeta(0);
                                }
                            }
                        }
                        //Lakes A
                        if (biome == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome) {
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            if (j1 >= 141 && j1 <= 160 && rand.nextInt(8) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (j1 >= 142 && j1 <= 160 && rand.nextInt(2) == 0) {
                                iblockstate = Blocks.DIRT.getStateFromMeta(2);
                            }
                            if (j1 >= 142 && j1 <= 160 && rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                            if (j1 >= 142 && j1 <= 160 && rand.nextInt(16) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            //If it's over 143 blocks then start to fill in more as stone
                            //up to 178 where it almost fully stone - sometimes cobble
                            int minHeight = 143;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 178 - j1);
                                double stoneFactor = (double) j2 / (178D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(2) == 0) {
                                        iblockstate = Blocks.GRAVEL.getDefaultState();
                                    }
                                    if (rand.nextInt(4) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                    if (rand.nextInt(8) == 0) {
                                        iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                }
                            }
                            //If it's over 180 blocks then start to fill in more as snow
                            //up to 200 where it almost fully snow
                            minHeight = 180;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 200 - j1);
                                double stoneFactor = (double) j2 / (200D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.SNOW.getStateFromMeta(0);
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.SNOW.getStateFromMeta(0);
                                }
                            }
                        }
                        //Lakes B
                        if (biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome) {
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                            if (rand.nextInt(6) == 0) {
                                iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            if (j1 >= 141 && j1 <= 160 && rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (j1 >= 142 && j1 <= 160 && rand.nextInt(2) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (j1 >= 142 && j1 <= 160 && rand.nextInt(4) == 0) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                            if (j1 >= 142 && j1 <= 160 && rand.nextInt(16) == 0) {
                                iblockstate = BlockVolcanicAsh.block.getDefaultState();
                            }
                            //If it's over 143 blocks then start to fill in more as stone
                            //up to 178 where it almost fully stone - sometimes cobble
                            int minHeight = 143;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 178 - j1);
                                double stoneFactor = (double) j2 / (178D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(2) == 0) {
                                        iblockstate = Blocks.GRAVEL.getDefaultState();
                                    }
                                    if (rand.nextInt(4) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                    if (rand.nextInt(8) == 0) {
                                        iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                }
                            }
                            //If it's over 180 blocks then start to fill in more as snow
                            //up to 200 where it almost fully snow
                            minHeight = 180;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 200 - j1);
                                double stoneFactor = (double) j2 / (200D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.SNOW.getStateFromMeta(0);
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.SNOW.getStateFromMeta(0);
                                }
                            }
                        }
                        //Lakes Burned
                        if (biome == BiomeEarlyCretaceousLandAsiaYixianLakesBurned.biome) {
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            if (rand.nextInt(18) == 0) {
                                iblockstate = BlockScorchedEarth.block.getDefaultState();
                            }
                            if (rand.nextInt(16) == 0) {
                                iblockstate = BlockVolcanicAsh.block.getDefaultState();
                            }
                            if (rand.nextInt(24) == 0) {
                                iblockstate = BlockVolcanicAshLight.block.getDefaultState();
                            }
                            if (rand.nextInt(24) == 0) {
                                iblockstate = BlockVolcanicAshDark.block.getDefaultState();
                            }
                            if (rand.nextInt(10) == 0) {
                                iblockstate = BlockScorchedEarth.block.getDefaultState();
                            }
                            if (rand.nextInt(14) == 0) {
                                iblockstate = BlockPrehistoricGroundLush.block.getDefaultState();
                            }
                            if (rand.nextInt(14) == 0) {
                                iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            if (rand.nextInt(8) == 0) {
                                iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            //If it's over 143 blocks then start to fill in more as stone
                            //up to 178 where it almost fully stone - sometimes cobble
                            int minHeight = 143;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 178 - j1);
                                double stoneFactor = (double) j2 / (178D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(16) == 0) {
                                        iblockstate = BlockVolcanicAsh.block.getDefaultState();
                                    }
                                    if (rand.nextInt(24) == 0) {
                                        iblockstate = BlockVolcanicAshLight.block.getDefaultState();
                                    }
                                    if (rand.nextInt(24) == 0) {
                                        iblockstate = BlockVolcanicAshDark.block.getDefaultState();
                                    }
                                    if (rand.nextInt(2) == 0) {
                                        iblockstate = Blocks.GRAVEL.getDefaultState();
                                    }
                                    if (rand.nextInt(4) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                    if (rand.nextInt(8) == 0) {
                                        iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                }
                            }
                            //If it's over 180 blocks then start to fill in more as snow
                            //up to 200 where it almost fully snow
                            minHeight = 180;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 200 - j1);
                                double stoneFactor = (double) j2 / (200D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.SNOW.getStateFromMeta(0);
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.SNOW.getStateFromMeta(0);
                                }
                            }
                        }

                        if (biome == BiomeEarlyCretaceousLandAsiaBarrenHills.biome
                        ) {
                            //If it's over 80 blocks then start to fill in more as stone
                            //up to 110 where it almost fully stone - sometimes cobble
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockPrehistoricGroundBasic.block.getDefaultState();
                            }
                            if (rand.nextInt(3) == 0) {
                                iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            if (rand.nextInt(12) == 0) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            if (rand.nextInt(2) == 0 && j1 <= 70 + rand.nextInt(3)) {
                                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            int minHeight = 80;
                            if (j1 >= minHeight) {
                                int j2 = Math.max(0, 100 - j1);
                                double stoneFactor = (double) j2 / (100D - (double) minHeight);
                                if (Math.random() >= stoneFactor) {
                                    iblockstate = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(16) == 0) {
                                        iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate = Blocks.GRAVEL.getDefaultState();
                                    }
                                }
                                if (Math.random() >= stoneFactor) {
                                    iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                    if (rand.nextInt(12) == 0) {
                                        iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
                                    }
                                }
                            }
                        }

                        if (biome instanceof BiomeCretaceousEarly) {
                            BiomeCretaceousEarly biomeCretaceousEarly = (BiomeCretaceousEarly) biome;
                            if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Austro_Antarctica)
                            {
                                //If it's over 80 blocks then start to fill in more as stone
                                //up to 110 where it almost fully stone - sometimes cobble
                                int minHeight = 80;
                                if (j1 >= minHeight) {
                                    int j2 = Math.max(0, 110 - j1);
                                    double stoneFactor = (double) j2 / (110D - (double) minHeight);
                                    if (biome == BiomeEarlyCretaceousAustroAntarcticLakes.biome) {
                                        if (!(j1 > ANTARCIC_LAKES_SEA_LEVEL + 3 + rand.nextInt(3)) ){
                                            stoneFactor = 100;
                                        }
                                        else {
                                            if (Math.random() >= stoneFactor) {
                                                iblockstate = Blocks.DIRT.getStateFromMeta(1);
                                            }
                                        }
                                    }
                                    if (Math.random() >= stoneFactor) {
                                        iblockstate = Blocks.STONE.getStateFromMeta(0);
                                        if (rand.nextInt(8) == 0) {
                                            iblockstate = Blocks.COBBLESTONE.getDefaultState();
                                        }
                                        if (rand.nextInt(12) == 0) {
                                            iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                        }
                                    }
                                    if (Math.random() >= stoneFactor) {
                                        iblockstate1 = Blocks.STONE.getStateFromMeta(0);
                                        if (rand.nextInt(8) == 0) {
                                            iblockstate1 = Blocks.COBBLESTONE.getDefaultState();
                                        }
                                        if (rand.nextInt(12) == 0) {
                                            iblockstate1 = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                                        }
                                    }
                                    if ((biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome)
                                            && j1 >= 103 + rand.nextInt(3) - rand.nextInt(3) && j1 <= 117 + rand.nextInt(3) - rand.nextInt(3) && rand.nextInt(3) != 0) {
                                        iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                    }
                                    if ((biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome)
                                            && j1 >= 103 + rand.nextInt(3) - rand.nextInt(3) && j1 <= 117 + rand.nextInt(3) - rand.nextInt(3) && rand.nextInt(5) == 0) {
                                        iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                    }
                                    if ((biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome)
                                            && j1 >= 103 + rand.nextInt(3) - rand.nextInt(3) && rand.nextInt(16) == 0) {
                                        iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                                    }
                                    if ((biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome)
                                            && j1 >= 103 + rand.nextInt(3) - rand.nextInt(3) && rand.nextInt(16) == 0) {
                                        iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                                    }
                                    if ((biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome)
                                            && j1 >= 107 + rand.nextInt(3) - rand.nextInt(3) && j1 <= 117 + rand.nextInt(3) - rand.nextInt(3) && rand.nextInt(5) == 0) {
                                        iblockstate = BlockPrehistoricGroundFern.block.getDefaultState();
                                    }
                                    if ((biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome)
                                            && j1 >= 107 + rand.nextInt(3) - rand.nextInt(3) && j1 <= 117 + rand.nextInt(3) - rand.nextInt(3) && rand.nextInt(12) == 0) {
                                        iblockstate = BlockPrehistoricGroundMossy.block.getDefaultState();
                                    }
                                }
                            }
                        }

                        j = k;
                        if ((j1 == i - 1 && i != SEALEVEL)) {
                            iblockstate1 = getIBlockstateForWater(biome, j1, iblockstate1, rand);
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                        }
                        else if (j1 >= i - 1) {
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                        }
                        else if (j1 <= i - 1) {
                            iblockstate = AIR;
                            iblockstate1 = STONE;

                            iblockstate1 = getIBlockstateForWater(biome, j1, iblockstate1, rand);
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                        }
                    } else if (j > 0) {
                        --j;
                        if ((biome == BiomeEarlyCretaceousLandAsiaBandedDesert.biome
                                || biome == BiomeEarlyCretaceousCreekAsiaBandedDesert.biome)
                                && j1 >= 71) {
                            iblockstate1 = getBandedSandType(world, j1, random);
                        }
                        chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1); //filler

                        if (j1 > 100 && (biome == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome
                                || biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome
                                || biome == BiomeEarlyCretaceousLandAsiaYixianLakesBurned.biome)) {

                            IBlockState yixianLayer1;
                            IBlockState yixianLayer2;

                            yixianLayer1 = BlockVolcanicAsh.block.getDefaultState();
                            if (rand.nextInt(3) == 0) {
                                yixianLayer1 = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1, l, yixianLayer1);

                            yixianLayer2 = iblockstate1;
                            if (rand.nextInt(5) == 0) {
                                yixianLayer2 = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 1, l, yixianLayer2);

                            yixianLayer1 = BlockVolcanicAsh.block.getDefaultState();
                            if (rand.nextInt(3) == 0) {
                                yixianLayer1 = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 2, l, yixianLayer1);

                            yixianLayer2 = iblockstate1;
                            if (rand.nextInt(5) == 0) {
                                yixianLayer2 = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 3, l, yixianLayer2);

                            yixianLayer1 = BlockVolcanicAsh.block.getDefaultState();
                            if (rand.nextInt(3) == 0) {
                                yixianLayer1 = BlockCoarseSandyDirtGrey.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 4, l, yixianLayer1);

                            yixianLayer2 = iblockstate1;
                            if (rand.nextInt(5) == 0) {
                                yixianLayer2 = BlockCoarseSandyDirtBlack.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 5, l, yixianLayer2);

                        }

                        if (j1 > 230 - rand.nextInt(8) && biome == BiomeEarlyCretaceousLandAsiaYixianMountains.biome) {

                            IBlockState yixianLayer1;
                            IBlockState yixianLayer2;

                            yixianLayer1 = BlockVolcanicAsh.block.getDefaultState();
                            if (rand.nextInt(3) == 0) {
                                yixianLayer1 = BlockVolcanicAshLight.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1, l, yixianLayer1);

                            yixianLayer2 = Blocks.SNOW.getDefaultState();
                            if (rand.nextInt(4) == 0) {
                                yixianLayer2 = Blocks.SNOW.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 1, l, yixianLayer2);

                            yixianLayer1 = BlockVolcanicAsh.block.getDefaultState();
                            if (rand.nextInt(3) == 0) {
                                yixianLayer1 = BlockVolcanicAshLight.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 2, l, yixianLayer1);

                            yixianLayer2 = Blocks.SNOW.getDefaultState();
                            if (rand.nextInt(4) == 0) {
                                yixianLayer2 = Blocks.PACKED_ICE.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 3, l, yixianLayer2);

                            yixianLayer1 = BlockVolcanicAsh.block.getDefaultState();
                            if (rand.nextInt(3) == 0) {
                                yixianLayer1 = BlockVolcanicAshLight.block.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 4, l, yixianLayer1);

                            yixianLayer2 = Blocks.SNOW.getDefaultState();
                            if (rand.nextInt(4) == 0) {
                                yixianLayer2 = Blocks.PACKED_ICE.getDefaultState();
                            }
                            chunkPrimerIn.setBlockState(i1, j1 - 5, l, yixianLayer2);

                        }

                        if (j == 0 && (iblockstate1.getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock() || iblockstate1.getBlock() == BlockSandWavy.block) && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = Blocks.SANDSTONE.getDefaultState();
                        }
                        else if (j == 0 && (iblockstate1.getBlock() == Blocks.SAND.getStateFromMeta(1).getBlock() || iblockstate1.getBlock() == BlockSandRedWavy.block) && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = Blocks.RED_SANDSTONE.getDefaultState();
                        }
                        else if (j == 0 && (iblockstate1.getBlock() == BlockSandBlack.block || iblockstate1.getBlock() == BlockSandBlackWavy.block) && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = BlockSandstoneBlack.block.getDefaultState();
                        }
                        else if (j == 0 && (iblockstate1.getBlock() == BlockSandWhite.block || iblockstate1.getBlock() == BlockSandWhiteWavy.block) && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = BlockSandstoneWhite.block.getDefaultState();
                        }
                        else if (j == 0 && (iblockstate1.getBlock() == BlockSandGrey.block || iblockstate1.getBlock() == BlockSandGreyWavy.block) && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = BlockSandstoneGrey.block.getDefaultState();
                        }
                    }
                }
            }
        }
    }

    public static IBlockState getIBlockstateForWater(Biome biome, int posY, IBlockState iblockstate, Random rand) {

        //Asia:
        //====
        if (biome == BiomeEarlyCretaceousLandAsia.biome
            || biome == BiomeEarlyCretaceousCreekBoggy.biome) {
            iblockstate = BlockCarboniferousMud.block.getDefaultState();
            if (rand.nextInt(10) < 3) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome
                || biome == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome
                || biome == BiomeEarlyCretaceousLandAsiaYixianLakesBurned.biome) {
            iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            if (posY >= 135 + (rand.nextInt(3) - 1)) {
                if (rand.nextInt(3) == 0) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                if (rand.nextInt(3) == 0) {
                    iblockstate = BlockVolcanicAsh.block.getDefaultState();
                }
                if (rand.nextInt(3) == 0) {
                    if (rand.nextInt(2) == 0) {
                        iblockstate = BlockSandGreyWavy.block.getDefaultState();
                    } else {
                        iblockstate = BlockSandGrey.block.getDefaultState();
                    }
                }
                if (rand.nextInt(3) == 0) {
                    if (rand.nextInt(2) == 0) {
                        iblockstate = BlockGravelWavy.block.getDefaultState();
                    } else {
                        iblockstate = Blocks.GRAVEL.getDefaultState();
                    }
                }
            }
            else {
                if (rand.nextInt(3) == 0) {
                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                }
                if (rand.nextInt(3) == 0) {
                    iblockstate = BlockVolcanicAshDark.block.getDefaultState();
                }
                if (rand.nextInt(3) == 0) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                if (rand.nextInt(3) == 0) {
                    if (rand.nextInt(2) == 0) {
                        iblockstate = BlockGravelWavy.block.getDefaultState();
                    } else {
                        iblockstate = Blocks.GRAVEL.getDefaultState();
                    }
                }
                if (rand.nextInt(3) == 0) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandAsiaRefugium.biome
                || biome == BiomeEarlyCretaceousCreekAsiaRefugium.biome) {
            iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            if (rand.nextInt(6) == 0) {
                iblockstate = Blocks.SAND.getDefaultState();
            }
            if (rand.nextInt(6) == 0) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAsiaShrublandOasis.biome
                || biome == BiomeEarlyCretaceousCreekAsiaShrubland.biome
                || biome == BiomeEarlyCretaceousLandAsiaShrubland.biome) {
            iblockstate = BlockCarboniferousMud.block.getDefaultState();
            if (rand.nextInt(4) == 0) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            if (rand.nextInt(11) == 0) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            if (rand.nextInt(18) == 0) {
                iblockstate = BlockVolcanicAshDark.block.getDefaultState();
            }
            if (rand.nextInt(32) == 0) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAsiaShrublandSprings.biome) {
            iblockstate = BlockVolcanicAshDark.block.getDefaultState();
            if (rand.nextInt(3) == 0) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            if (rand.nextInt(3) == 0) {
                iblockstate = BlockToxicMud.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAsiaDrooping.biome
                || biome == BiomeEarlyCretaceousLandAsiaDroopingMound.biome
                || biome == BiomeEarlyCretaceousCreekAsiaDrooping.biome
                || biome == BiomeEarlyCretaceousLandAsiaYixianSkirt.biome) {
            iblockstate = BlockCarboniferousMud.block.getDefaultState();
            if (rand.nextInt(8) == 0) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            if (rand.nextInt(10) == 0) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            if (posY == 61) {
                if (rand.nextInt(7) == 0) {
                    iblockstate = BlockSandBlack.block.getDefaultState();
                }
                if (rand.nextInt(8) == 0) {
                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandAsiaBandedDesert.biome
                || biome == BiomeEarlyCretaceousCreekAsiaBandedDesert.biome) {
            iblockstate = Blocks.SAND.getStateFromMeta(1);
            if (rand.nextInt(10) < 3) {
                iblockstate = BlockClayRed.block.getDefaultState();
            }
            if (posY < 62) {
                if (rand.nextInt(3) == 0) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
            }
            else {
                if (rand.nextInt(8) == 0) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
            }
        }
        
        if (biome == BiomeEarlyCretaceousCreekSAmericaWideCentre.biome
                || biome == BiomeEarlyCretaceousCreekSAmericaWide.biome
                || biome == BiomeEarlyCretaceousCreekSAmericaWideCentreRift.biome) {
            if (rand.nextInt(2) == 0) {
                iblockstate = BlockSandBlackWavy.block.getDefaultState();
            }
            else {
                iblockstate = BlockLavaCobble.block.getDefaultState();
                if (rand.nextInt(4) == 0) {
                    iblockstate = BlockLavaCobbleMossy.block.getDefaultState();
                }
                if (rand.nextInt(10) == 0 && posY <= 50 && biome == BiomeEarlyCretaceousCreekSAmericaWideCentreRift.biome) {
                    iblockstate = BlockLavaCobbleMolten.block.getDefaultState();
                }
            }
            if (rand.nextInt(5) == 0 && posY <= 40 && biome == BiomeEarlyCretaceousCreekSAmericaWideCentreRift.biome) {
                iblockstate = Blocks.MAGMA.getDefaultState();
            }
            if (rand.nextInt(12) == 0) {
                iblockstate = Blocks.OBSIDIAN.getDefaultState();
            }
            if (rand.nextInt(18) == 0) {
                iblockstate = BlockToxicMud.block.getDefaultState();
            }
            if (rand.nextInt(14) == 0) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            if (rand.nextInt(16) == 0) {
                iblockstate = BlockLavaRock.block.getDefaultState();
                if (rand.nextInt(10) == 0) {
                    iblockstate = BlockSulphurOreLavaRock.block.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousCreekAsiaPhrygana.biome
                || biome == BiomeEarlyCretaceousLandAsiaPhryganaLake.biome
                || biome == BiomeEarlyCretaceousCreekAsiaPhrygana.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 80) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 70) {
                iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
            }
            else if (i >= 55) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 30) {
                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            }
            else if (i >= 25) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 20) {
                iblockstate = BlockGravelWavy.block.getDefaultState();
            }
            else if (i >= 18) {
                iblockstate = BlockSandGrey.block.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = BlockSandGreyWavy.block.getDefaultState();
            }
            else if (i >= 14) {
                iblockstate = Blocks.COBBLESTONE.getDefaultState();
            }
            else if (i >= 12) {
                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
            }
            else if (i >= 9) {
                iblockstate = Blocks.STONE.getDefaultState();
            }
            else {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
        }

        //Europe and America:
        //==================
        if (biome == BiomeEarlyCretaceousLandEuropeField .biome
                || biome == BiomeEarlyCretaceousCreekEuropeField.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 97) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 90) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 75) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 60) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 45) {
                    iblockstate = Blocks.SAND.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
            }
            else if (posY >= 58 + rand.nextInt(3) - 1) {
                if (i >= 90) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 70) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 35) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 25) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = Blocks.SAND.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
            }
            else {
                if (i >= 75) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 50) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 10) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 5) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 3) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandEuropeMaquis .biome
                || biome == BiomeEarlyCretaceousCreekEuropeMaquis.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 75) {
                iblockstate = Blocks.SAND.getDefaultState();
            }
            else if (i >= 25) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else if (i >= 20) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 10) {
                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.CLAY.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandEurope .biome
                || biome == BiomeEarlyCretaceousCreekEuropeanTethys.biome
                || biome == BiomeEarlyCretaceousLandEuropeSwampLakes.biome
                || biome == BiomeEarlyCretaceousLandEuropeSwampLakesEdge.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 70) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            else if (i >= 40) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else if (i >= 20) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 10) {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
        }

        if (biome == BiomeEarlyCretaceousLandEuropeFieldCopse.biome
                || biome == BiomeEarlyCretaceousCreekEuropeFieldCopse.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 93) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 90) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 65) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 45) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 35) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
                else if (i >= 30) {
                    iblockstate = Blocks.SAND.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
                else {
                    iblockstate = BlockLeafLitter.block.getDefaultState();
                }
            }
            else if (posY >= 58 + rand.nextInt(3) - 1) {
                if (i >= 90) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 80) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 60) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 45) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 35) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
                else if (i >= 30) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockLeafLitter.block.getDefaultState();
                }
                else {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
            }
            else {
                if (i >= 77) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 60) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 40) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 30) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 23) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
                else if (i >= 22) {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
                else if (i >= 15) {
                    iblockstate = BlockLeafLitter.block.getDefaultState();
                }
                else {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandNAmericaMountains .biome
                || biome == BiomeEarlyCretaceousLandNAmericaMountainsFoothills.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 50) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 10) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
        }

        if (biome == BiomeEarlyCretaceousLandNAmerica.biome
                || biome == BiomeEarlyCretaceousCreekNAmericaBraided.biome
                || biome == BiomeEarlyCretaceousLandNAmericaTransition.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 70) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 50) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 5) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
            }
            else if (posY >= 58 + rand.nextInt(3) - 1) {
                if (i >= 87) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 80) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 35) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
            }
            else {
                if (i >= 55) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandNAmericaShrubland.biome
                || biome == BiomeEarlyCretaceousCreekNAmericaShrubland.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 75) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 60) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 25) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
        }

        if (biome == BiomeEarlyCretaceousLandNAmericaShrublandCopse .biome
                || biome == BiomeEarlyCretaceousCreekNAmericaShrublandCopse.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 65) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 45) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
        }

        //Austro-Antarctic:
        if (biome == BiomeEarlyCretaceousAustroAntarcticCoastalCliffs.biome
                || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastalCliffs.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 20) {
                iblockstate = Blocks.STONE.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = Blocks.COBBLESTONE.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
            }
            else {
                iblockstate = BlockSandyDirtGrey.block.getStateFromMeta(1);
            }
        }

        if (biome == BiomeEarlyCretaceousAustroAntarcticCoastal.biome
                || biome == BiomeEarlyCretaceousCreekAustroAntarcticCoastal.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 94) {
                iblockstate = Blocks.SAND.getDefaultState();
            }
            else if (i >= 77) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else if (i >= 75) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 65) {
                iblockstate = BlockGravelWavy.block.getDefaultState();
            }
            else if (i >= 40) {
                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
            }
            else if (i >= 20) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else {
                iblockstate = BlockCoarseSiltyDirt.block.getStateFromMeta(1);
            }
        }

        if (biome == BiomeEarlyCretaceousLandAustroAntarcticPaddock.biome
                || biome == BiomeEarlyCretaceousLandAustroAntarcticPaddockWinter.biome
                || biome == BiomeEarlyCretaceousCreekAustroAntarcticPaddock.biome
                || biome == BiomeEarlyCretaceousLandAustraliaAntarcticaColdDivider.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 50) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 25) {
                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            }
            else if (i >= 18) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = Blocks.SAND.getDefaultState();
            }
            else if (i >= 8) {
                iblockstate = BlockGravelWavy.block.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else {
                iblockstate = Blocks.STONE.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAustraliaAntarctica.biome
                || biome == BiomeEarlyCretaceousLandAustraliaAntarcticaWinter.biome
                || biome == BiomeEarlyCretaceousLandAustraliaAntarcticaPodocarpLake.biome
                || biome == BiomeEarlyCretaceousLandAustraliaAntarcticaPodocarpLakeEdge.biome
                || biome == BiomeEarlyCretaceousCreekAustraliaAntarctica.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 35) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 27) {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
            else if (i >= 20) {
                iblockstate = BlockLeafLitter.block.getDefaultState();
            }
            else if (i >= 17) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = Blocks.SAND.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = BlockGravelWavy.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousAustroAntarcticRainforest.biome
                || biome == BiomeEarlyCretaceousCreekAustroAntarcticRainforest.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 70) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 40) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 25) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
                else if (i >= 15) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 5) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
            }
            else if (posY >= 58 + rand.nextInt(3) - 1) {
                if (i >= 90) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 80) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 65) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
                else if (i >= 50) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 25) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                else {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
            }
            else {
                if (i >= 97) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 95) {
                    iblockstate = BlockPeat.block.getDefaultState();
                }
                else if (i >= 85) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(2);
                }
                else if (i >= 70) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 40) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 25) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                else {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousAustroAntarcticLakes.biome
                || biome == BiomeEarlyCretaceousAustroAntarcticLakesPeaks.biome
                || biome == BiomeEarlyCretaceousAustroAntarcticLakesRimInner.biome
                || biome == BiomeEarlyCretaceousAustroAntarcticLakesRimOuter.biome) {
            int i = rand.nextInt(300) + 1;
            if (i >= 100) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else if (i >= 95) {
                iblockstate = Blocks.COBBLESTONE.getDefaultState();
            }
            else if (i >= 85) {
                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
            }
            else if (i >= 65) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 55) {
                iblockstate = Blocks.STONE.getDefaultState();
            }
            else if (i >= 25) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 22) {
                iblockstate = Blocks.SAND.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else {
                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousBeachAustroAntarcticaInlandSea.biome
                || biome == BiomeEarlyCretaceousInlandSeaAustralia.biome
                || biome == BiomeEarlyCretaceousCreekBeachAustroAntarcticaInlandSea.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 95) {
                    iblockstate = Blocks.SAND.getDefaultState();
                }
                else if (i >= 50) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else if (i >= 45) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                else if (i >= 40) {
                    iblockstate = BlockClayBrown.block.getDefaultState();
                }
                else if (i >= 35) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = BlockSandGrey.block.getDefaultState();
                }
                else {
                    iblockstate = BlockSandGreyWavy.block.getDefaultState();
                }
            }
            else if (posY >= 58 + rand.nextInt(3) - 1) {
                if (i >= 90) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else if (i >= 80) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                else if (i >= 60) {
                    iblockstate = BlockClayBrown.block.getDefaultState();
                }
                else if (i >= 50) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 30) {
                    iblockstate = BlockSandGrey.block.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockSandGreyWavy.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
            }
            else {
                if (i >= 90) {
                    iblockstate = BlockCoarseSandyDirtGrey.block.getDefaultState();
                }
                else if (i >= 50) {
                    iblockstate = BlockClayBrown.block.getDefaultState();
                }
                else if (i >= 35) {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
                else if (i >= 30) {
                    iblockstate = BlockSandGrey.block.getDefaultState();
                }
                else if (i >= 10) {
                    iblockstate = BlockSandGreyWavy.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
            }
        }

        //Africa-SAmerica:
        //===============
        if (biome == BiomeEarlyCretaceousLandAfricaBrownstonePeaks.biome
                || biome == BiomeEarlyCretaceousLandAfricaBrownstonePinnacles.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 35) {
                iblockstate = BlockBrownstone.block.getDefaultState();
            }
            else if (i >= 20) {
                iblockstate = Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(8);
            }
            else if (i >= 5) {
                iblockstate = Blocks.HARDENED_CLAY.getDefaultState();
            }
            else {
                iblockstate = BlockSandyDirtGrey.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAfricaBrownstoneValley.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 95) {
                iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
            }
            else if (i >= 80) {
                iblockstate = Blocks.COBBLESTONE.getDefaultState();
            }
            else if (i >= 60) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 30) {
                iblockstate = BlockBrownstone.block.getDefaultState();
            }
            else if (i >= 30) {
                iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.SAND.getStateFromMeta(1);
            }
        }

        if (biome == BiomeEarlyCretaceousLandAfricaSavanna.biome
                || biome == BiomeEarlyCretaceousLandAfricaSavannaWateringHole.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 60) {
                iblockstate = Blocks.SAND.getStateFromMeta(1);
            }
            else if (i >= 55) {
                iblockstate = Blocks.GRAVEL.getStateFromMeta(1);
            }
            else if (i >= 45) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 20) {
                iblockstate = BlockCoarseSandyDirtRed.block.getDefaultState();
            }
            else {
                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandAfricaSavannaWateringHoleCentre.biome
                || biome == BiomeEarlyCretaceousCreekAfricaSavanna.biome) {
            iblockstate = BlockCarboniferousMud.block.getDefaultState();

        }

        if (biome == BiomeEarlyCretaceousCreekAfricaSwamp.biome
                || biome == BiomeEarlyCretaceousLandAfricaSwampOpen.biome) { //Africa swamp general
            int i = rand.nextInt(100) + 1;
            if (i >= 55) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else if (i >= 30) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 2) {
                iblockstate = BlockLeafLitter.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
        }

        if (biome == BiomeEarlyCretaceousLandAfricaSwampFlat.biome) { //Africa swamp woodland
            int i = rand.nextInt(100) + 1;
            if (i >= 60) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else if (i >= 25) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
        }

        if (biome == BiomeEarlyCretaceousLandSouthAmericanArid.biome
                || biome == BiomeEarlyCretaceousCreekSouthAmericanArid.biome
                || biome == BiomeEarlyCretaceousLandSouthAmericanAridSpikes.biome) {
            int i = rand.nextInt(112) + 1;
            if (i >= 100) {
                iblockstate = BlockPebblestone.block.getDefaultState();
            }
            else if (i >= 65) {
                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
            }
            else if (i >= 40) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 25) {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
            else if (i >= 15) {
                iblockstate = Blocks.GRAVEL.getDefaultState();
            }
            else if (i >= 5) {
                iblockstate = BlockBrownstone.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.STONE.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousCreekSAmericaWide.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 75) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            else if (i >= 50) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else if (i >= 40) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 25) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 15) {
                iblockstate = BlockSandBlackWavy.block.getDefaultState();
            }
            else {
                iblockstate = Blocks.DIRT.getStateFromMeta(2);
            }
        }

        if (biome == BiomeEarlyCretaceousCreekSouthAmericanSandyDesert.biome
                || biome == BiomeEarlyCretaceousLandSouthAmericanSandyDesert.biome
                || biome == BiomeEarlyCretaceousLandSouthAmericanSandyDesertSpikes.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 90) {
                    iblockstate = Blocks.SAND.getDefaultState();
                }
                else if (i >= 55) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else if (i >= 20) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
            }
            else {
                if (i >= 98) {
                    iblockstate = Blocks.SAND.getDefaultState();
                }
                else if (i >= 95) {
                    iblockstate = BlockSandWavy.block.getDefaultState();
                }
                else if (i >= 55) {
                    iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
                }
                else if (i >= 35) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 25) {
                    iblockstate = Blocks.CLAY.getDefaultState();
                }
                else {
                    iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandSouthAmericanPatagonia.biome
            || biome == BiomeEarlyCretaceousCreekSouthAmericanPatagonia.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 95) {
                iblockstate = BlockPeat.block.getDefaultState();
            }
            else if (i >= 80) {
                iblockstate = BlockLeafLitter.block.getDefaultState();
            }
            else if (i >= 65) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else if (i >= 35) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else if (i >= 20) {
                iblockstate = Blocks.DIRT.getStateFromMeta(1);
            }
            else if (i >= 5) {
                iblockstate = BlockCoarseSandyDirt.block.getDefaultState();
            }
            else {
                iblockstate = BlockSandWavy.block.getDefaultState();
            }
        }

        if (biome == BiomeEarlyCretaceousLandSouthAmericanDesertLow.biome
                || biome == BiomeEarlyCretaceousLandSouthAmericanDesertSpikes.biome
                || biome == BiomeEarlyCretaceousLandSAmerica.biome
                || biome == BiomeEarlyCretaceousCreekSouthAmericanDesert.biome) {
            int i = rand.nextInt(100) + 1;
            if (posY >= 60 + rand.nextInt(3) - 1) {
                if (i >= 35) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 25) {
                    iblockstate = BlockBrownstone.block.getDefaultState();
                }
                else if (i >= 15) {
                    iblockstate = Blocks.DIRT.getStateFromMeta(1);
                }
                else if (i >= 10) {
                    iblockstate = BlockSandGrey.block.getDefaultState();
                }
                else if (i >= 5) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else if (i >= 3) {
                    iblockstate = Blocks.STONE.getDefaultState();
                }
                else {
                    iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                }
            }
            else {
                if (i >= 15) {
                    iblockstate = BlockCarboniferousMud.block.getDefaultState();
                }
                else if (i >= 13) {
                    iblockstate = BlockBrownstone.block.getDefaultState();
                }
                else if (i >= 5) {
                    iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
                }
                else if (i >= 4) {
                    iblockstate = BlockSandGrey.block.getDefaultState();
                }
                else if (i >= 2) {
                    iblockstate = Blocks.GRAVEL.getDefaultState();
                }
                else {
                    iblockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                }
            }
        }

        if (biome == BiomeEarlyCretaceousLandSouthAmericanFlats.biome
                || biome == BiomeEarlyCretaceousCreekSouthAmericanFlatsStream.biome
                || biome == BiomeEarlyCretaceousCreekSouthAmericanFlats.biome) {
            int i = rand.nextInt(100) + 1;
            if (i >= 25) {
                iblockstate = BlockCarboniferousMud.block.getDefaultState();
            }
            else if (i >= 2) {
                iblockstate = BlockCoarseSandyDirtBlack.block.getDefaultState();
            }
            else {
                iblockstate = BlockCoarseSiltyDirt.block.getDefaultState();
            }
        }


        return iblockstate;
    }

    public IBlockState getBandedSandType(World world, int height, Random random) {

        if (height < 1 || height > 255) {
            return getBand1(random);
        }
        IBlockState state;
        //Use the world seed to generate a unique banding pattern for this world:

        int lenStr = this.BANDING_CODE.length();
        int band = 1;
        if (height <= lenStr) {
            band = height;
        }
        else {
            band = Integer.parseInt(this.BANDING_CODE.substring((height % lenStr), (height % lenStr) + 1));
        }

        //layer 1:
        switch (band) {
            case 0: default:
                return getBand1(random);
            case 1:
                return getBand2(random);
            case 2:
                return getBand3(random);
            case 3:
                return getBand4(random);
            case 4:
                return getBand5(random);
        }

    }

    public static IBlockState getBand1(Random random) {
        IBlockState state = Blocks.RED_SANDSTONE.getDefaultState();
        if (random.nextInt(2) == 0) {
            state = Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(1);
        }
        if (random.nextInt(36) == 0) {
            state = Blocks.SAND.getStateFromMeta(1);
        }
        if (random.nextInt(36) == 0) {
            state = BlockSandRedWavy.block.getDefaultState();
        }
        if (random.nextInt(36) == 0) {
            state = BlockCoarseSandyDirtRed.block.getDefaultState();
        }
        return state;
    }

    public static IBlockState getBand2(Random random) {
        IBlockState state = Blocks.SANDSTONE.getDefaultState();
        if (random.nextInt(36) == 0) {
            state = Blocks.SAND.getDefaultState();
        }
        if (random.nextInt(36) == 0) {
            state = BlockSandWavy.block.getDefaultState();
        }
        return state;
    }

    public static IBlockState getBand3(Random random) {
        IBlockState state = BlockClayRed.block.getDefaultState();
        if (random.nextInt(8) == 0) {
            state = Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(14);
        }
        return state;
    }

    public static IBlockState getBand4(Random random) {
        IBlockState state = BlockSandstonePangaean.block.getDefaultState();

        if (random.nextInt(36) == 0) {
            state = BlockSandPangaean.block.getDefaultState();
        }
        if (random.nextInt(36) == 0) {
            state = BlockSandPangaeanWavy.block.getDefaultState();
        }
        if (random.nextInt(36) == 0) {
            state = BlockCoarseSandyDirtPangaean.block.getDefaultState();
        }
        return state;
    }

    public static IBlockState getBand5(Random random) {
        IBlockState state = Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(8);
        if (random.nextInt(12) == 0) {
            state = BlockBrownstone.block.getDefaultState();
        }
        return state;
    }


}