package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAsiaPhrygana;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousOcean;

public class GenLayerCretaceousPhryganaLakes extends GenLayer {

    public static Biome PHRYGANA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana"));
    public static int CRETACEOUS_PHRYGANA_ID =  Biome.getIdForBiome(PHRYGANA);
    public static Biome PHRYGANA_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana_lake"));
    public static int CRETACEOUS_PHRYGANA_LAKES_ID =  Biome.getIdForBiome(PHRYGANA_LAKE);

    private final int CretaceousPhryganaBiomes[] = new int[] {
            CRETACEOUS_PHRYGANA_ID,
            CRETACEOUS_PHRYGANA_ID,
            CRETACEOUS_PHRYGANA_ID,
            CRETACEOUS_PHRYGANA_ID,
            CRETACEOUS_PHRYGANA_ID,
            CRETACEOUS_PHRYGANA_ID,
            CRETACEOUS_PHRYGANA_LAKES_ID
    };

    public GenLayerCretaceousPhryganaLakes(long seed, GenLayer genlayer) {
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
                if (Biome.getBiome(center) == BiomeEarlyCretaceousLandAsiaPhrygana.biome) {
                    output[i] = CretaceousPhryganaBiomes[nextInt(CretaceousPhryganaBiomes.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }
}