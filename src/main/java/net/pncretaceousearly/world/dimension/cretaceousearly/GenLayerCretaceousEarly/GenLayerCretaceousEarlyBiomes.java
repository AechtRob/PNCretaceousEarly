package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousOcean;

public class GenLayerCretaceousEarlyBiomes extends GenLayer {

    public Biome CRETACEOUS_EARLY_ASIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public int CRETACEOUS_EARLY_ASIA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ASIA);
    public Biome CRETACEOUS_EARLY_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int CRETACEOUS_EARLY_EUROPE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_EUROPE);
    public Biome CRETACEOUS_EARLY_SAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int CRETACEOUS_EARLY_SAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA);
    public Biome CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA);

    public Biome CRETACEOUS_EARLY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_EARLY_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY);

    private final int CretaceousEarlyBiomes[] = new int[] {
            CRETACEOUS_EARLY_ASIA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            CRETACEOUS_EARLY_SAMERICA_ID,
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID,
            CRETACEOUS_EARLY_ASIA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            CRETACEOUS_EARLY_SAMERICA_ID,
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID,
            CRETACEOUS_EARLY_ASIA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            CRETACEOUS_EARLY_SAMERICA_ID,
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID,
            CRETACEOUS_EARLY_ID
    };

    public GenLayerCretaceousEarlyBiomes(long seed, GenLayer genlayer) {
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
                if (Biome.getBiome(center) == BiomeEarlyCretaceousOcean.biome) {
                    output[i] = CretaceousEarlyBiomes[nextInt(CretaceousEarlyBiomes.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }
}