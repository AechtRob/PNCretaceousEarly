package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandEurope;

public class GenLayerCretaceousDiversifyEuroAmerica extends GenLayer {

    public Biome EARLY_CRETACEOUS_EUROPE_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int EARLY_CRETACEOUS_EUROPE_SWAMP_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_EUROPE_SWAMP);
    public Biome EARLY_CRETACEOUS_EUROPE_DRY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_maquis"));
    public int EARLY_CRETACEOUS_EUROPE_DRY_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_EUROPE_DRY);

    private final int[] EuropeBiomes = new int[] {
            EARLY_CRETACEOUS_EUROPE_SWAMP_ID,
            EARLY_CRETACEOUS_EUROPE_DRY_ID
    };

    public GenLayerCretaceousDiversifyEuroAmerica(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int[] input = this.parent.getInts(x, z, width, height);
        int[] output = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                //if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeEarlyCretaceousLandEurope.biome) {
                        output[i] = EuropeBiomes[nextInt(EuropeBiomes.length)];
                    }
                    else output[i] = center;
                //} else output[i] = center;
            }
        }
        return output;
    }

}