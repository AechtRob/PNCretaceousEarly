package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSmallerIslandBiomes extends GenLayer
{

    public static Biome OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public static int OCEAN_ID =  Biome.getIdForBiome(OCEAN);

    public static Biome ASIA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public static int ASIA_1_ID =  Biome.getIdForBiome(ASIA_1);
    public static Biome ASIA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana"));
    public static int ASIA_2_ID =  Biome.getIdForBiome(ASIA_2);

    public static Biome EUROPE_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public static int EUROPE_1_ID =  Biome.getIdForBiome(EUROPE_1);
    public static Biome EUROPE_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public static int EUROPE_2_ID =  Biome.getIdForBiome(EUROPE_2);
    public static Biome EUROPE_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field"));
    public static int EUROPE_3_ID =  Biome.getIdForBiome(EUROPE_3);

    public static Biome GOND_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public static int GOND_1_ID =  Biome.getIdForBiome(GOND_1);
    public static Biome GOND_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public static int GOND_2_ID =  Biome.getIdForBiome(GOND_2);
    public static Biome GOND_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public static int GOND_3_ID =  Biome.getIdForBiome(GOND_3);
    public static Biome GOND_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public static int GOND_4_ID =  Biome.getIdForBiome(GOND_4);
    public static Biome GOND_5 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public static int GOND_5_ID =  Biome.getIdForBiome(GOND_5);

    public static Biome AFRICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public static int AFRICA_1_ID =  Biome.getIdForBiome(AFRICA_1);
    public static Biome AFRICA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp"));
    public static int AFRICA_2_ID =  Biome.getIdForBiome(AFRICA_2);

    public static Biome AUS_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public static int AUS_1_ID =  Biome.getIdForBiome(AUS_1);
    public static Biome AUS_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public static int AUS_2_ID =  Biome.getIdForBiome(AUS_2);

    public GenLayerSmallerIslandBiomes(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int SeaBiomes[] = new int[] {
            ASIA_1_ID,
            ASIA_2_ID,
            EUROPE_1_ID,
            EUROPE_2_ID,
            EUROPE_3_ID,
            GOND_1_ID,
            GOND_2_ID,
            GOND_3_ID,
            GOND_4_ID,
            GOND_5_ID,
            AFRICA_1_ID,
            AFRICA_2_ID,
            AUS_1_ID,
            AUS_2_ID
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

                if (isSea(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    if (isSea(l1)
                            && isSea(k2)
                            && isSea(j3)
                            && isSea(i4))
                    {
                        if (nextInt(5) == 0) {
                            aint1[j + i * areaWidth] = SeaBiomes[nextInt(SeaBiomes.length)];
                        }
                        else {
                            aint1[j + i * areaWidth] = k;
                        }
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    public static boolean isSea(int i) {
        return i == OCEAN_ID;
    }
    
}
