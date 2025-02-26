
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.util.Functions;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeEarlyCretaceousCreekSouthAmericanArid extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_creek_samerica_arid")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousCreekSouthAmericanArid(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DRY);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HOT);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SAVANNA);
	}

	static class BiomeGenCustom extends BiomeCretaceousEarly {
		public BiomeGenCustom() {
			//was height 0.001
			super(new BiomeProperties("E. Cretaceous West Gondwana S. America Arid Lands Creek").setRainfall(0.0F).setBaseHeight(-0.50F).setHeightVariation(0.01F).setTemperature(1.8F).setRainDisabled());
			setRegistryName("lepidodendron:cretaceous_early_creek_samerica_arid");
			topBlock = BlockCoarseSandyDirt.block.getDefaultState();
			fillerBlock = BlockBrownstone.block.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 20;
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
		protected static final WorldGenSandNearWater SAND_GENERATOR = new WorldGenSandNearWater();
		protected static final WorldGenRockPiles ROCK_GENERATOR = new WorldGenRockPiles();
		protected static final WorldGenSahnioxylon SAHNIOXYLON_GENERATOR = new WorldGenSahnioxylon();
		protected static final WorldGenCycadeoidea CYCADEOIDEA_GENERATOR = new WorldGenCycadeoidea();

		protected static final WorldGenPrehistoricGroundCover GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCover();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			return NULL_TREE;

		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{
			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					SAND_GENERATOR.generate(worldIn, rand, worldIn.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + j, 0, pos.getZ() + k)).up());
				}

//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				if (worldIn.rand.nextInt(10) == 0)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					ROCK_GENERATOR.generate(worldIn, rand, worldIn.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + j, 0, pos.getZ() + k)).up());
//				}
//

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockSantaniella.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 1, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 6, false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 64; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockWelwitschiophyllum.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 70, true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 64; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockAridHorsetail.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 70, true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockBaiera.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 70, true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockArlenea.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 1, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 4, false);
				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 6; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PLANT_GENERATOR.generate(BlockOtozamites.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 2, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 6, false);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 14; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PLANT_GENERATOR.generate(BlockChloranthus.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 5, false);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 16; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PLANT_GENERATOR.generate(BlockEphedra.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 5, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 20,false);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 12; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PLANT_GENERATOR.generate(BlockErdtmanithecales.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 5, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 20,false);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 12; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PLANT_GENERATOR.generate(BlockArlenea.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 4, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 15,false);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 3; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					SAHNIOXYLON_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 4; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					CYCADEOIDEA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), false, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 2, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 10);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 4; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					LEAFBLOCK_GENERATOR.generate((BlockBush) BlockHirmeriellaSapling.block, BlockHirmeriellaLeaves.block.getDefaultState().withProperty(BlockHirmeriellaLeaves.BlockCustom.DECAYABLE, false).withProperty(BlockHirmeriellaLeaves.BlockCustom.CHECK_DECAY, false), BlockHirmeriellaLeaves.block.getDefaultState().withProperty(BlockHirmeriellaLeaves.BlockCustom.DECAYABLE, false).withProperty(BlockHirmeriellaLeaves.BlockCustom.CHECK_DECAY, false), worldIn, rand, pos.add(j, l, k), 0, 75);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 156; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
		}

	}

}
