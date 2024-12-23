
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.WorldGenNullTree;
import net.lepidodendron.world.gen.WorldGenRockPiles;
import net.lepidodendron.world.gen.WorldGenRockPilesCretaceousEarlyDeepOcean;
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
public class BiomeEarlyCretaceousOcean extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_ocean")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousOcean(ElementsLepidodendronMod instance) {
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
			super(new BiomeProperties("E. Cretaceous Deep Ocean").setBaseHeight(-1.995F).setHeightVariation(0.21F));
			setRegistryName("lepidodendron:cretaceous_early_ocean");
			topBlock = Blocks.GRAVEL.getDefaultState();
			fillerBlock = Blocks.GRAVEL.getDefaultState();
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
		protected static final WorldGenRockPilesCretaceousEarlyDeepOcean ROCK_PILES_GENERATOR = new WorldGenRockPilesCretaceousEarlyDeepOcean();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	return NULL_TREE;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				int i = rand.nextInt(5);
				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(12) + 10;
					int l = rand.nextInt(12) + 10;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					if (rand.nextInt(5) != 0) {
						ROCK_PILES_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}
			}

	        super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Ocean;
		}

	}

}
