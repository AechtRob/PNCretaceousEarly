
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.WorldGenCorallineAlgae;
import net.lepidodendron.world.gen.WorldGenNullTree;
import net.lepidodendron.world.gen.WorldGenRockPilesCretaceousEarlyDeepOcean;
import net.lepidodendron.world.gen.WorldGenRockPilesCretaceousEarlySouthernOcean;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeEarlyCretaceousOceanShoreSouthern extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_ocean_shore_southern")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousOceanShoreSouthern(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
	}

	static class BiomeGenCustom extends BiomeCretaceousEarly {
		public BiomeGenCustom() {
			super(new BiomeProperties("E. Cretaceous Southern Ocean").setRainfall(0.5F).setBaseHeight(-0.65F).setHeightVariation(0.11F));
			setRegistryName("lepidodendron:cretaceous_early_ocean_shore_southern");

			topBlock = Blocks.SAND.getDefaultState();
			fillerBlock = Blocks.SAND.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 20;
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
		protected static final WorldGenCorallineAlgae CORALLINE_GENERATOR = new WorldGenCorallineAlgae();
		protected static final WorldGenRockPilesCretaceousEarlySouthernOcean ROCK_PILES_GENERATOR = new WorldGenRockPilesCretaceousEarlySouthernOcean();


		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	return NULL_TREE;
	    }


		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				int k = rand.nextInt(12) + 10;
				int l = rand.nextInt(12) + 10;
				BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
				if (rand.nextInt(12) == 0) {
					ROCK_PILES_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 38; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CORALLINE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}


			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Ocean_Shore_Southern;
		}

	}
}
