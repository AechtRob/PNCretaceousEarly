package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyYixianRim2 extends GenLayer
{

    public static Biome ASIA_YIXIAN_HIGHLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_highland"));
    public static int ASIA_YIXIAN_HIGHLAND_ID =  Biome.getIdForBiome(ASIA_YIXIAN_HIGHLAND);
    public static Biome ASIA_YIXIAN_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_mountains"));
    public static int ASIA_YIXIAN_MOUNTAINS_ID =  Biome.getIdForBiome(ASIA_YIXIAN_MOUNTAINS);

    public static Biome ASIA_YIXIAN_LAKES_A = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_a"));
    public static int ASIA_YIXIAN_LAKES_A_ID =  Biome.getIdForBiome(ASIA_YIXIAN_LAKES_A);

    public static Biome ASIA_YIXIAN_LAKES_B = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_b"));
    public static int ASIA_YIXIAN_LAKES_B_ID =  Biome.getIdForBiome(ASIA_YIXIAN_LAKES_B);

    public GenLayerCretaceousEarlyYixianRim2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int[] VariantBiomes = new int[] {
            ASIA_YIXIAN_HIGHLAND_ID,
            ASIA_YIXIAN_HIGHLAND_ID,
            ASIA_YIXIAN_MOUNTAINS_ID
    };

    private final int[] VariantBiomes2 = new int[] {
            ASIA_YIXIAN_LAKES_A_ID,
            ASIA_YIXIAN_LAKES_A_ID,
            ASIA_YIXIAN_LAKES_A_ID,
            ASIA_YIXIAN_LAKES_A_ID,
            ASIA_YIXIAN_LAKES_A_ID,
            ASIA_YIXIAN_HIGHLAND_ID,
            ASIA_YIXIAN_HIGHLAND_ID,
            ASIA_YIXIAN_MOUNTAINS_ID
    };

    private final int[] VariantBiomes3 = new int[] {
            ASIA_YIXIAN_LAKES_B_ID,
            ASIA_YIXIAN_LAKES_B_ID,
            ASIA_YIXIAN_LAKES_B_ID,
            ASIA_YIXIAN_LAKES_B_ID,
            ASIA_YIXIAN_LAKES_B_ID,
            ASIA_YIXIAN_HIGHLAND_ID,
            ASIA_YIXIAN_HIGHLAND_ID,
            ASIA_YIXIAN_MOUNTAINS_ID
    };

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k == ASIA_YIXIAN_LAKES_A_ID || k == ASIA_YIXIAN_LAKES_B_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isRimmed(l1))
                            || (!isRimmed(k2))
                            || (!isRimmed(j3))
                            || (!isRimmed(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = VariantBiomes[nextInt(VariantBiomes.length)];;;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    public static boolean isRimmed(int i) {
        return i == ASIA_YIXIAN_MOUNTAINS_ID
                || i == ASIA_YIXIAN_HIGHLAND_ID
                || i == ASIA_YIXIAN_LAKES_A_ID
                || i == ASIA_YIXIAN_LAKES_B_ID;
    }


}
