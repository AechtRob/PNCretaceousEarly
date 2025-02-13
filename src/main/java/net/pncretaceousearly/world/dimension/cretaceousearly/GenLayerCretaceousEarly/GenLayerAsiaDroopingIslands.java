package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAsiaDrooping;

public class GenLayerAsiaDroopingIslands extends GenLayer {


    public static Biome ASIA_DROOPING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_drooping_swamp"));
    public static int ASIA_DROOPING_ID =  Biome.getIdForBiome(ASIA_DROOPING);

    public static Biome ASIA_ISLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_drooping_swamp_mound"));
    public static int ASIA_ISLANDS_ID =  Biome.getIdForBiome(ASIA_ISLANDS);

    private final int[] DroopingBiomes = new int[] {
            ASIA_DROOPING_ID,
            ASIA_DROOPING_ID,
            ASIA_DROOPING_ID,
            ASIA_ISLANDS_ID
    };

    public GenLayerAsiaDroopingIslands(long seed, GenLayer genlayer) {
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
                if (Biome.getBiome(center) == BiomeEarlyCretaceousLandAsiaDrooping.biome) {
                        output[i] = DroopingBiomes[nextInt(DroopingBiomes.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }

}