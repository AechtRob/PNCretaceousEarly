
package net.pncretaceousearly.world.biome.cretaceousearly;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeEarlyCretaceousLandAsiaYixianLakesB extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:cretaceous_early_yixian_lakes_b")
	public static final BiomeGenCustom biome = null;
	public BiomeEarlyCretaceousLandAsiaYixianLakesB(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HILLS);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD);
	}

	static class BiomeGenCustom extends BiomeCretaceousEarly {
		public BiomeGenCustom() {
			super(new BiomeProperties("E. Cretaceous Lakelands B").setBaseHeight(4.9F).setHeightVariation(0.29F).setTemperature(0.2F));
			setRegistryName("lepidodendron:cretaceous_early_yixian_lakes_b");
			topBlock = Blocks.DIRT.getStateFromMeta(2);
			fillerBlock = Blocks.DIRT.getStateFromMeta(2);
			decorator.treesPerChunk = -999;
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

		protected static final WorldGenAnomozamites ANOMOZAMITES_GENERATOR = new WorldGenAnomozamites();
		protected static final WorldGenAnomozamitesShoot ANOMOZAMITES_SHOOT_GENERATOR = new WorldGenAnomozamitesShoot();
		protected static final WorldGenCycadeoidea CYCADEOIDEA_GENERATOR = new WorldGenCycadeoidea();
		protected static final WorldGenPterophyllum PTEROPHYLLUM_GENERATOR = new WorldGenPterophyllum();
		protected static final WorldGenPtilophyllum PTILOPHYLLUM_GENERATOR = new WorldGenPtilophyllum();
		protected static final WorldGenPtilophyllumShoot PTILOPHYLLUM_SHOOT_GENERATOR = new WorldGenPtilophyllumShoot();
		protected static final WorldGenSahnioxylon SAHNIOXYLON_GENERATOR = new WorldGenSahnioxylon();
		protected static final WorldGenWilliamsonia WILLIAMSONIA_GENERATOR = new WorldGenWilliamsonia();
		protected static final WorldGenZamites ZAMITES_GENERATOR = new WorldGenZamites();
		protected static final WorldGenZamitesShoot ZAMITES_SHOOT_GENERATOR = new WorldGenZamitesShoot();

		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenLeafblock LEAFBLOCK_GENERATOR = new WorldGenLeafblock();

		protected static final WorldGenFern FERN_GENERATOR = new WorldGenFern();
		protected static final WorldGenWaterHorsetail WATER_HORSETAIL_GENERATOR = new WorldGenWaterHorsetail();
		protected static final WorldGenIsoetes IOSETES_GENERATOR = new WorldGenIsoetes();

		protected static final WorldGenPrehistoricGroundCoverSandy GROUNDCOVER_GENERATOR_SAND = new WorldGenPrehistoricGroundCoverSandy();
		protected static final WorldGenPrehistoricGroundCover GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCover();
		protected static final WorldGenEarlyCretaceousMuddyOasisNearWater WATERSIDE_GENERATOR = new WorldGenEarlyCretaceousMuddyOasisNearWater();
		protected static final WorldGenAncientMoss ANCIENT_MOSS_GENERATOR = new WorldGenAncientMoss();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			return NULL_TREE;
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{


			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeCretaceousEarly getBiomeType() {
			return EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Asia;
		}

	}

}
