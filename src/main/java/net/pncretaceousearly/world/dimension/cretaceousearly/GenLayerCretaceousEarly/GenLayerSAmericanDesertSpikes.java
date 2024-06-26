package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSAmericanDesertSpikes extends GenLayer
{

    public static Biome SAMERICAN_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public static int SAMERICAN_DESERT_ID =  Biome.getIdForBiome(SAMERICAN_DESERT);

    public static Biome SAMERICAN_SWAMPY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low"));
    public static int SAMERICAN_SWAMPY_ID =  Biome.getIdForBiome(SAMERICAN_SWAMPY);

    public static Biome SAMERICAN_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_spikes"));
    public static int SAMERICAN_SPIKES_ID =  Biome.getIdForBiome(SAMERICAN_SPIKES);

    public static Biome SAMERICAN_ARID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public static int SAMERICAN_ARID_ID =  Biome.getIdForBiome(SAMERICAN_ARID);

    public static Biome SAMERICAN_ARID_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid_spikes"));
    public static int SAMERICAN_ARID_SPIKES_ID =  Biome.getIdForBiome(SAMERICAN_ARID_SPIKES);

    public GenLayerSAmericanDesertSpikes(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AridBiomes[] = new int[] {
            SAMERICAN_ARID_ID,
            SAMERICAN_ARID_ID,
            SAMERICAN_ARID_ID,
            SAMERICAN_ARID_ID,
            SAMERICAN_ARID_SPIKES_ID
    };

    private final int AfricaBiomes[] = new int[] {
            SAMERICAN_DESERT_ID,
            SAMERICAN_DESERT_ID,
            SAMERICAN_DESERT_ID,
            SAMERICAN_DESERT_ID,
            SAMERICAN_SPIKES_ID
    };

    private final int AfricaSwampyBiomes[] = new int[] {
            SAMERICAN_SWAMPY_ID,
            SAMERICAN_SWAMPY_ID,
            SAMERICAN_SWAMPY_ID,
            SAMERICAN_SWAMPY_ID,
            SAMERICAN_SWAMPY_ID,
            SAMERICAN_SPIKES_ID
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

                if (k == SAMERICAN_DESERT_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                            (l1 == SAMERICAN_DESERT_ID || l1 == SAMERICAN_SWAMPY_ID)
                            && (k2 == SAMERICAN_DESERT_ID || k2 == SAMERICAN_SWAMPY_ID)
                            && (j3 == SAMERICAN_DESERT_ID || j3 == SAMERICAN_SWAMPY_ID)
                            && (i4 == SAMERICAN_DESERT_ID || i4 == SAMERICAN_SWAMPY_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AfricaBiomes[nextInt(AfricaBiomes.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (k == SAMERICAN_SWAMPY_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                            (l1 == SAMERICAN_DESERT_ID || l1 == SAMERICAN_SWAMPY_ID)
                            && (k2 == SAMERICAN_DESERT_ID || k2 == SAMERICAN_SWAMPY_ID)
                            && (j3 == SAMERICAN_DESERT_ID || j3 == SAMERICAN_SWAMPY_ID)
                            && (i4 == SAMERICAN_DESERT_ID || i4 == SAMERICAN_SWAMPY_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AfricaSwampyBiomes[nextInt(AfricaSwampyBiomes.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }

                else if (k == SAMERICAN_ARID_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    (l1 == SAMERICAN_ARID_ID)
                                            && (k2 == SAMERICAN_ARID_ID)
                                            && (j3 == SAMERICAN_ARID_ID)
                                            && (i4 == SAMERICAN_ARID_ID)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AridBiomes[nextInt(AridBiomes.length)];
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
    
}
