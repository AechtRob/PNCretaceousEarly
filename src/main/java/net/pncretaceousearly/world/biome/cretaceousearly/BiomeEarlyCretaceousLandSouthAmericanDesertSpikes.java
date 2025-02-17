
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.util.Functions;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.WorldGenBrachyphyllumTree;
import net.lepidodendron.world.gen.WorldGenCycadeoidea;
import net.lepidodendron.world.gen.WorldGenLeafblock;
import net.lepidodendron.world.gen.WorldGenSinglePlantOptionalWater;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeEarlyCretaceousLandSouthAmericanDesertSpikes extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_samerica_desert_spikes")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousLandSouthAmericanDesertSpikes(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DRY);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SWAMP);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HOT);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WASTELAND);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SAVANNA);
	}

	static class BiomeGenCustom extends BiomeCretaceousEarly {
		public BiomeGenCustom() {
			//was height 0.001
			super(new BiomeProperties("E. Cretaceous West Gondwana S. America Xeric Floodplain").setRainfall(0.0F).setBaseHeight(2.58F).setHeightVariation(0.37F).setTemperature(1.8F).setRainDisabled().setWaterColor(-10724281));
			setRegistryName("lepidodendron:cretaceous_early_samerica_desert_spikes");
			topBlock = BlockSandGrey.block.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.treesPerChunk = 48;
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

		protected static final WorldGenBrachyphyllumTree BRACHYPHYLLUM_TREE = new WorldGenBrachyphyllumTree(false);

		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenLeafblock LEAFBLOCK_GENERATOR = new WorldGenLeafblock();
		protected static final WorldGenCycadeoidea CYCADEOIDEA_GENERATOR = new WorldGenCycadeoidea();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			return BRACHYPHYLLUM_TREE;

		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 128; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockAridHorsetail.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 70, false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockBaiera.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 70, false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 24; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockEphedra.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 5, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 20,false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockErdtmanithecales.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 5, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 20,false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockArlenea.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 4, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 15,false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CYCADEOIDEA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), false, 0, Functions.getAdjustedSeaLevel(worldIn, pos.add(j, l, k)) + 10);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAFBLOCK_GENERATOR.generate((BlockBush) BlockBrachyphyllumSapling.block, BlockBrachyphyllumLeaves.block.getDefaultState().withProperty(BlockBrachyphyllumLeaves.BlockCustom.DECAYABLE, false).withProperty(BlockBrachyphyllumLeaves.BlockCustom.CHECK_DECAY, false), BlockBrachyphyllumLeaves.block.getDefaultState().withProperty(BlockBrachyphyllumLeaves.BlockCustom.DECAYABLE, false).withProperty(BlockBrachyphyllumLeaves.BlockCustom.CHECK_DECAY, false), worldIn, rand, pos.add(j, l, k), 0, 75);
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
		}

	}

}
