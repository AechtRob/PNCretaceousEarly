
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockCedarLeaves;
import net.lepidodendron.block.BlockCedarLog;
import net.lepidodendron.block.BlockCedarSapling;
import net.lepidodendron.block.BlockSandstoneBlack;
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
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeEarlyCretaceousLandAsiaBarrenHills extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_barren_hills")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousLandAsiaBarrenHills(ElementsLepidodendronMod instance) {
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
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SANDY);
	}

	static class BiomeGenCustom extends BiomeCretaceousEarly {
		public BiomeGenCustom() {
			super(new BiomeProperties("E. Cretaceous Asia Dusty Hills").setBaseHeight(0.75F).setHeightVariation(0.29F).setTemperature(0.8F));
			setRegistryName("lepidodendron:cretaceous_early_barren_hills");
			topBlock = Blocks.DIRT.getStateFromMeta(1);
			fillerBlock = BlockSandstoneBlack.block.getDefaultState();
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		protected static final WorldGenBristleconeTree BRISTLECONE_TREE = new WorldGenBristleconeTree(false);
		protected static final net.minecraft.world.gen.feature.WorldGenDeadBush DEAD_BUSH_GENERATOR = new net.minecraft.world.gen.feature.WorldGenDeadBush();

		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenLeafblock LEAFBLOCK_GENERATOR = new WorldGenLeafblock();

		protected static final WorldGenPrehistoricGroundCoverPangaean GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverPangaean();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			if (rand.nextInt(12) == 0) {
				return BRISTLECONE_TREE;
			}
			return NULL_TREE;
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				for (int i = 0; i < 7; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					DEAD_BUSH_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 2; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAFBLOCK_GENERATOR.generate((BlockBush) BlockCedarSapling.block, BlockCedarLeaves.block.getDefaultState(), BlockCedarLog.block.getDefaultState().withProperty(BlockCedarLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 71, 85);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 6; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Asia;
		}

	}

}
