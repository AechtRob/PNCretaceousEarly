package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAsiaYixianLakesA;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAsiaYixianLakesB;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandNAmericaShrubland;

public class GenLayerYixianDead extends GenLayer {

    public Biome YIXIAN_A = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_a"));
    public int YIXIAN_A_ID =  Biome.getIdForBiome(YIXIAN_A);
    public Biome YIXIAN_B = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_b"));
    public int YIXIAN_B_ID =  Biome.getIdForBiome(YIXIAN_B);
    public Biome YIXIAN_DEAD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_dead"));
    public int YIXIAN_DEAD_ID =  Biome.getIdForBiome(YIXIAN_DEAD);

    private final int YixianBiomes1[] = new int[] {
            YIXIAN_A_ID,
            YIXIAN_A_ID,
            YIXIAN_A_ID,
            YIXIAN_A_ID,
            YIXIAN_DEAD_ID
    };

    private final int YixianBiomes2[] = new int[] {
            YIXIAN_B_ID,
            YIXIAN_B_ID,
            YIXIAN_B_ID,
            YIXIAN_B_ID,
            YIXIAN_DEAD_ID
    };

    public GenLayerYixianDead(long seed, GenLayer genlayer) {
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
                if (Biome.getBiome(center) == BiomeEarlyCretaceousLandAsiaYixianLakesA.biome) {
                    output[i] = YixianBiomes1[nextInt(YixianBiomes1.length)];
                }
                else if (Biome.getBiome(center) == BiomeEarlyCretaceousLandAsiaYixianLakesB.biome) {
                    output[i] = YixianBiomes2[nextInt(YixianBiomes2.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }

}