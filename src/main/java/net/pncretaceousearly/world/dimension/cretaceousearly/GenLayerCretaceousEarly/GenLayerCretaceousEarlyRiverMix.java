package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome CRETACEOUS_EARLY_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public int CRETACEOUS_EARLY_RIVER_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_RIVER);

    //Creeks to use:
    public Biome CRETACEOUS_EARLY_CREEK_FERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_fern_pasture"));
    public int CRETACEOUS_EARLY_CREEK_FERN_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_FERN);
    public Biome CRETACEOUS_EARLY_CREEK_FLOODPLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_floodplain"));
    public int CRETACEOUS_EARLY_CREEK_FLOODPLAIN_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_FLOODPLAIN);
    public Biome CRETACEOUS_EARLY_CREEK_GARRIGUE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_garrigue"));
    public int CRETACEOUS_EARLY_CREEK_GARRIGUE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_GARRIGUE);
    public Biome CRETACEOUS_EARLY_CREEK_REDWOOD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_coniferous_forest"));
    public int CRETACEOUS_EARLY_CREEK_REDWOOD_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_REDWOOD);
    public Biome CRETACEOUS_EARLY_CREEK_SOUTHERN_TAIGA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_southern_taiga"));
    public int CRETACEOUS_EARLY_CREEK_SOUTHERN_TAIGA_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_SOUTHERN_TAIGA);
    public Biome CRETACEOUS_EARLY_CREEK_Araucaria = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_Araucaria_woodland"));
    public int CRETACEOUS_EARLY_CREEK_Araucaria_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_Araucaria);
    public Biome CRETACEOUS_EARLY_CREEK_COASTAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_coastal"));
    public int CRETACEOUS_EARLY_CREEK_COASTAL_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_COASTAL);
    public Biome CRETACEOUS_EARLY_CREEK_MIRE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_mire_lakes"));
    public int CRETACEOUS_EARLY_CREEK_MIRE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_MIRE);
    public Biome CRETACEOUS_EARLY_CREEK_ISLAND_LARGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_large_creek"));
    public int CRETACEOUS_EARLY_CREEK_ISLAND_LARGE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_ISLAND_LARGE);
    public Biome CRETACEOUS_EARLY_CREEK_ISLAND_LARGE_FOG = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_large_creek_fog"));
    public int CRETACEOUS_EARLY_CREEK_ISLAND_LARGE_FOG_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_ISLAND_LARGE_FOG);
    public Biome CRETACEOUS_EARLY_CREEK_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_desert"));
    public int CRETACEOUS_EARLY_CREEK_DESERT_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_DESERT);

    //Biomes to exclude for rivers:
    public Biome CRETACEOUS_EARLY_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore"));
    public int CRETACEOUS_EARLY_OCEAN_SHORE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN_SHORE);
    public Biome CRETACEOUS_EARLY_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public  int CRETACEOUS_EARLY_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN);
    public Biome CRETACEOUS_EARLY_GLASS_SPONGE_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_glass_sponge_reef"));
    public  int CRETACEOUS_EARLY_GLASS_SPONGE_REEF_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_GLASS_SPONGE_REEF);
    public  Biome CRETACEOUS_EARLY_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_rough_hills"));
    public  int CRETACEOUS_EARLY_MOUNTAINS_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_MOUNTAINS);
    public  Biome CRETACEOUS_EARLY_ATOLLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_sandy"));
    public  int CRETACEOUS_EARLY_ATOLLS_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ATOLLS);
    public  Biome CRETACEOUS_EARLY_ATOLLS2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_sandy_forest"));
    public  int CRETACEOUS_EARLY_ATOLLS2_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ATOLLS2);
    public  Biome CRETACEOUS_EARLY_FORESTED_ISLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_forested"));
    public  int CRETACEOUS_EARLY_FORESTED_ISLAND_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_FORESTED_ISLAND);
    public  Biome CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_sandy_white"));
    public  int CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE);
    public  Biome CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_sandy_white_edge"));
    public  int CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE_EDGE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE_EDGE);
    public  Biome CRETACEOUS_EARLY_ATOLLS3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_sandy_hills"));
    public  int CRETACEOUS_EARLY_ATOLLS3_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ATOLLS3);
//    public  Biome CRETACEOUS_EARLY_ISLANDS_LARGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_large"));
//    public  int CRETACEOUS_EARLY_ISLANDS_LARGE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ISLANDS_LARGE);
    public  Biome CRETACEOUS_EARLY_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_lakes"));
    public  int CRETACEOUS_EARLY_LAKES_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_LAKES);
    public Biome CRETACEOUS_EARLY_OCEAN_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_rafts"));
    public int CRETACEOUS_EARLY_OCEAN_RAFTS_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN_RAFTS);
    public Biome CRETACEOUS_EARLY_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_coral"));
    public int CRETACEOUS_EARLY_CORAL_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_CORAL);
    public Biome CRETACEOUS_EARLY_DESERT_RIM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_desert_rim"));
    public int CRETACEOUS_EARLY_DESERT_RIM_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_DESERT_RIM);
    public Biome CRETACEOUS_EARLY_DESERT_RIM_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_desert_rim_helper"));
    public int CRETACEOUS_EARLY_DESERT_RIM_HELPER_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_DESERT_RIM_HELPER);
    public Biome CRETACEOUS_EARLY_DESERT_RIM_DESERT_SIDE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_desert_rim_desert_side"));
    public int CRETACEOUS_EARLY_DESERT_RIM_DESERT_SIDE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_DESERT_RIM_DESERT_SIDE);
//    public Biome CRETACEOUS_EARLY_ISLANDS_LARGE_SCRUB = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_large_scrub"));
//    public int CRETACEOUS_EARLY_ISLANDS_LARGE_SCRUB_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ISLANDS_LARGE_SCRUB);
//    public Biome CRETACEOUS_EARLY_ISLANDS_LARGE_WET = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_island_large_wet"));
//    public int CRETACEOUS_EARLY_ISLANDS_LARGE_WET_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ISLANDS_LARGE_WET);


    public GenLayerCretaceousEarlyRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == CRETACEOUS_EARLY_OCEAN_SHORE_ID
                        || aint[i] == CRETACEOUS_EARLY_OCEAN_ID
                        || aint[i] == CRETACEOUS_EARLY_CORAL_ID
                        || aint[i] == CRETACEOUS_EARLY_GLASS_SPONGE_REEF_ID
                        || aint[i] == CRETACEOUS_EARLY_MOUNTAINS_ID
                        || aint[i] == CRETACEOUS_EARLY_ATOLLS_ID
                        || aint[i] == CRETACEOUS_EARLY_ATOLLS2_ID
                        || aint[i] == CRETACEOUS_EARLY_ATOLLS3_ID
                        || aint[i] == CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE_ID
                        || aint[i] == CRETACEOUS_EARLY_ISLANDS_SANDY_WHITE_EDGE_ID
                        || aint[i] == CRETACEOUS_EARLY_LAKES_ID
                        || aint[i] == CRETACEOUS_EARLY_OCEAN_RAFTS_ID
                        || aint[i] == CRETACEOUS_EARLY_DESERT_RIM_ID
                        || aint[i] == CRETACEOUS_EARLY_DESERT_RIM_HELPER_ID
                        || aint[i] == CRETACEOUS_EARLY_DESERT_RIM_DESERT_SIDE_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeCretaceousEarly) {
                        BiomeCretaceousEarly biomeCretaceousEarly = (BiomeCretaceousEarly) biome;
//                        if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Garrigue
//                            || biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Rocks) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_GARRIGUE_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Forest
//                            || biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Floodplain) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_FLOODPLAIN_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Araucaria
//                            || biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Lake) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_Araucaria_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Pasture) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_FERN_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Coniferous) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_REDWOOD_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Taiga) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_SOUTHERN_TAIGA_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Ocean) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_COASTAL_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Mire) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_MIRE_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.Desert) {
//                            aint2[i] = CRETACEOUS_EARLY_CREEK_DESERT_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.ForestIsland) {
//                            aint2[i] = CRETACEOUS_EARLY_OCEAN_SHORE_ID;
//                        }
//                        else if (biomeCretaceousEarly.getBiomeType() == EnumBiomeTypeCretaceousEarly.IslandRock) {
////                            if (biomeCretaceousEarly == BiomeCretaceousEarlyIslandLargeWet.biome) {
////                                aint2[i] = CRETACEOUS_EARLY_CREEK_ISLAND_LARGE_FOG_ID;
////                            }
////                            else {
//                                aint2[i] = CRETACEOUS_EARLY_CREEK_ISLAND_LARGE_ID;
////                            }
//                        }
//                        else {
                            aint2[i] = CRETACEOUS_EARLY_RIVER_ID;
                            aint2[i] = aint[i];
//                        }
                    }
                    else {
                        aint2[i] = CRETACEOUS_EARLY_RIVER_ID;
                        aint2[i] = aint[i];
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
