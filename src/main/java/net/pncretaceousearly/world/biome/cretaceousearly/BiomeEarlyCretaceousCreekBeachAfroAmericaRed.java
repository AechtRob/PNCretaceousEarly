
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockBaiera;
import net.lepidodendron.block.BlockBrachyphyllumLeaves;
import net.lepidodendron.block.BlockBrachyphyllumLog;
import net.lepidodendron.block.BlockBrachyphyllumSapling;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeEarlyCretaceousCreekBeachAfroAmericaRed extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_creek_beach_afroamerica_red")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousCreekBeachAfroAmericaRed(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.BEACH);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SANDY);
	}

	static class BiomeGenCustom extends BiomeCretaceousEarly {
		public BiomeGenCustom() {
			super(new BiomeProperties("E. Cretaceous Afro-American Red Beach Creek").setBaseHeight(-0.525F).setHeightVariation(0.01F).setTemperature(0.9F).setRainfall(0.4F));
			setRegistryName("lepidodendron:cretaceous_early_creek_beach_afroamerica_red");
			topBlock = Blocks.SAND.getStateFromMeta(1);
			fillerBlock = Blocks.SAND.getStateFromMeta(1);
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			decorator.clayPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		
		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenLeafblock LEAFBLOCK_GENERATOR = new WorldGenLeafblock();
		protected static final WorldGenRockPilesAfricanSavannaECreatceous ROCK_PILES_GENERATOR = new WorldGenRockPilesAfricanSavannaECreatceous();
		protected static final WorldGenPrehistoricGroundCoverPangaean GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverPangaean();
		protected static final WorldGenPrehistoricGroundCoverSandy SANDY_GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverSandy();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	return NULL_TREE;
	    }

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				int i = rand.nextInt(2);
				if (rand.nextInt(3) == 0) {
					for (int j = 0; j < i; ++j) {
						int k = rand.nextInt(12) + 10;
						int l = rand.nextInt(12) + 10;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						ROCK_PILES_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 8; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAFBLOCK_GENERATOR.generate((BlockBush) BlockBrachyphyllumSapling.block, BlockBrachyphyllumLeaves.block.getDefaultState(), BlockBrachyphyllumLog.block.getDefaultState().withProperty(BlockBrachyphyllumLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 60, 80);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 6; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockBaiera.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 60, 80, false, false, true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 16; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 16; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SANDY_GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
		}

	}

}
