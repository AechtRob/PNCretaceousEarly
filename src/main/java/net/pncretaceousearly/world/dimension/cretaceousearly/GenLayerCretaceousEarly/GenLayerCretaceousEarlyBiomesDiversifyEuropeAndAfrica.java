package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAfrica;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandEurope;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandSAmerica;

public class GenLayerCretaceousEarlyBiomesDiversifyEuropeAndAfrica extends GenLayer {

    public Biome CRETACEOUS_EARLY_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int CRETACEOUS_EARLY_EUROPE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_EUROPE);
    public Biome CRETACEOUS_EARLY_AFRICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public int CRETACEOUS_EARLY_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AFRICA);

    public Biome CRETACEOUS_EARLY_NAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public int CRETACEOUS_EARLY_NAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_NAMERICA);
    public Biome CRETACEOUS_EARLY_SAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int CRETACEOUS_EARLY_SAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA);
    public Biome EARLY_CRETACEOUS_EUROPE_FIELD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field"));
    public int EARLY_CRETACEOUS_EUROPE_FIELD_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_EUROPE_FIELD);

    private final int EuropeBiomes[] = new int[] {
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            EARLY_CRETACEOUS_EUROPE_FIELD_ID
    };

    private final int AfricaBiomes[] = new int[] {
            CRETACEOUS_EARLY_SAMERICA_ID,
            CRETACEOUS_EARLY_AFRICA_ID
    };

    public GenLayerCretaceousEarlyBiomesDiversifyEuropeAndAfrica(long seed, GenLayer genlayer) {
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
                if (Biome.getBiome(center) == BiomeEarlyCretaceousLandEurope.biome) {
                    output[i] = EuropeBiomes[nextInt(EuropeBiomes.length)];
                }
                else if (Biome.getBiome(center) == BiomeEarlyCretaceousLandSAmerica.biome) {
                    output[i] = AfricaBiomes[nextInt(AfricaBiomes.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }

}