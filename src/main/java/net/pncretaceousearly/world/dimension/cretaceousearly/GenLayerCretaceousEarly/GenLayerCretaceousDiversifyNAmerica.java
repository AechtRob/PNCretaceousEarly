package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeDictionary;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandEurope;

public class GenLayerCretaceousDiversifyNAmerica extends GenLayer
{

    public Biome CRETACEOUS_EARLY_NAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public int CRETACEOUS_EARLY_NAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_NAMERICA);
    public Biome CRETACEOUS_EARLY_NAMERICA_LAGOONS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_lagoons"));
    public int CRETACEOUS_EARLY_NAMERICA_LAGOONS_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_NAMERICA_LAGOONS);

    public Biome CRETACEOUS_EARLY_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int CRETACEOUS_EARLY_EUROPE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_EUROPE);
    public Biome EARLY_CRETACEOUS_EUROPE_FIELD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field"));
    public int EARLY_CRETACEOUS_EUROPE_FIELD_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_EUROPE_FIELD);

    public GenLayerCretaceousDiversifyNAmerica(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AmericaBiomes[] = new int[] {
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_NAMERICA_LAGOONS_ID
    };

    private final int EuropeBiomesInit[] = new int[] {
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            EARLY_CRETACEOUS_EUROPE_FIELD_ID
    };

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (Biome.getBiome(k) == BiomeEarlyCretaceousLandEurope.biome) {
                    int biomeInit = EuropeBiomesInit[nextInt(EuropeBiomesInit.length)];

                    if (biomeInit == CRETACEOUS_EARLY_NAMERICA_ID) {
                        aint1[j + i * areaWidth] = AmericaBiomes[nextInt(AmericaBiomes.length)];
                    } else {
                        aint1[j + i * areaWidth] = biomeInit;
                    }
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

}
