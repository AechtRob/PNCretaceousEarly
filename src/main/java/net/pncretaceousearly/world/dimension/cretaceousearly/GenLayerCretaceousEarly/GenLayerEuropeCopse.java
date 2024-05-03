package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandEuropeField;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandNAmericaShrubland;

public class GenLayerEuropeCopse extends GenLayer {

    public Biome FIELD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field"));
    public int FIELD_ID =  Biome.getIdForBiome(FIELD);
    public Biome COPSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field_copse"));
    public int COPSE_ID =  Biome.getIdForBiome(COPSE);

    private final int CopseBiomes[] = new int[] {
            FIELD_ID,
            FIELD_ID,
            FIELD_ID,
            FIELD_ID,
            COPSE_ID
    };

    public GenLayerEuropeCopse(long seed, GenLayer genlayer) {
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
                if (Biome.getBiome(center) == BiomeEarlyCretaceousLandEuropeField.biome) {
                    output[i] = CopseBiomes[nextInt(CopseBiomes.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }

}