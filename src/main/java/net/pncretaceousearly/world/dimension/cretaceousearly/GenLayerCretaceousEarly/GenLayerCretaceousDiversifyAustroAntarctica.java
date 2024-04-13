package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAustraliaAntarctica;

public class GenLayerCretaceousDiversifyAustroAntarctica extends GenLayer {

    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST);
    public Biome EARLY_CRETACEOUS_AUSTRO_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_inner"));
    public int EARLY_CRETACEOUS_AUSTRO_LAKES_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_LAKES);

    private final int[] AustroBiomes = new int[] {
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_LAKES_ID
    };

    public GenLayerCretaceousDiversifyAustroAntarctica(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeEarlyCretaceousLandAustraliaAntarctica.biome) {
                        output[i] = AustroBiomes[nextInt(AustroBiomes.length)];
                    }
                    else output[i] = center;
                //} else output[i] = center;
            }
        }
        return output;
    }

}