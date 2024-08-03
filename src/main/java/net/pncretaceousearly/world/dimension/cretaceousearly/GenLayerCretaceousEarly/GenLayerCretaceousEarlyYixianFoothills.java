package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyYixianFoothills extends GenLayer
{

    public static Biome ASIA_YIXIAN_HIGHLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_highland"));
    public static int ASIA_YIXIAN_HIGHLAND_ID =  Biome.getIdForBiome(ASIA_YIXIAN_HIGHLAND);
    public static Biome ASIA_YIXIAN_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_mountains"));
    public static int ASIA_YIXIAN_MOUNTAINS_ID =  Biome.getIdForBiome(ASIA_YIXIAN_MOUNTAINS);

    public static Biome ASIA_YIXIAN_LAKES_A = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_a"));
    public static int ASIA_YIXIAN_LAKES_A_ID =  Biome.getIdForBiome(ASIA_YIXIAN_LAKES_A);

    public static Biome ASIA_YIXIAN_LAKES_B = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_b"));
    public static int ASIA_YIXIAN_LAKES_B_ID =  Biome.getIdForBiome(ASIA_YIXIAN_LAKES_B);

    public static Biome FOOTHILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_yixian_foothills"));
    public static int FOOTHILLS_ID =  Biome.getIdForBiome(FOOTHILLS);

    public GenLayerCretaceousEarlyYixianFoothills(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

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

                if (k != ASIA_YIXIAN_LAKES_A_ID && k != ASIA_YIXIAN_LAKES_B_ID && k != ASIA_YIXIAN_HIGHLAND_ID && k != ASIA_YIXIAN_MOUNTAINS_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((l1 == ASIA_YIXIAN_LAKES_A_ID || l1 == ASIA_YIXIAN_LAKES_B_ID || l1 == ASIA_YIXIAN_HIGHLAND_ID || l1 == ASIA_YIXIAN_MOUNTAINS_ID)
                            || (k2 == ASIA_YIXIAN_LAKES_A_ID || k2 == ASIA_YIXIAN_LAKES_B_ID || k2 == ASIA_YIXIAN_HIGHLAND_ID || k2 == ASIA_YIXIAN_MOUNTAINS_ID)
                            || (j3 == ASIA_YIXIAN_LAKES_A_ID || j3 == ASIA_YIXIAN_LAKES_B_ID || j3 == ASIA_YIXIAN_HIGHLAND_ID || j3 == ASIA_YIXIAN_MOUNTAINS_ID)
                            || (i4 == ASIA_YIXIAN_LAKES_A_ID || i4 == ASIA_YIXIAN_LAKES_B_ID || i4 == ASIA_YIXIAN_HIGHLAND_ID || i4 == ASIA_YIXIAN_MOUNTAINS_ID)
                    )
                    {
                        aint1[j + i * areaWidth] = FOOTHILLS_ID;
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


}
