package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerNorthAmericaMountains0 extends GenLayer
{

    public static Biome N_AMERICA_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public static int N_AMERICA_LAND_ID =  Biome.getIdForBiome(N_AMERICA_LAND);
    public static Biome N_AMERICA_LAND_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_forest"));
    public static int N_AMERICA_LAND_2_ID =  Biome.getIdForBiome(N_AMERICA_LAND_2);
    public static Biome N_AMERICA_LAND_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_lagoons"));
    public static int N_AMERICA_LAND_3_ID =  Biome.getIdForBiome(N_AMERICA_LAND_3);

    public static Biome N_AMERICA_UPLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_transition"));
    public static int N_AMERICA_UPLAND_ID =  Biome.getIdForBiome(N_AMERICA_UPLAND);


    public GenLayerNorthAmericaMountains0(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int NAmericaBiomes1[] = new int[] {
            N_AMERICA_UPLAND_ID,
            N_AMERICA_UPLAND_ID,
            N_AMERICA_LAND_ID
    };

    private final int NAmericaBiomes2[] = new int[] {
            N_AMERICA_UPLAND_ID,
            N_AMERICA_UPLAND_ID,
            N_AMERICA_LAND_2_ID
    };

    private final int NAmericaBiomes3[] = new int[] {
            N_AMERICA_UPLAND_ID,
            N_AMERICA_UPLAND_ID,
            N_AMERICA_LAND_3_ID
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

                if (k == N_AMERICA_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == N_AMERICA_LAND_ID)
                        && (k2 == N_AMERICA_LAND_ID)
                        && (j3 == N_AMERICA_LAND_ID)
                        && (i4 == N_AMERICA_LAND_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = NAmericaBiomes1[nextInt(NAmericaBiomes1.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (k == N_AMERICA_LAND_2_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    (l1 == N_AMERICA_LAND_2_ID)
                                            && (k2 == N_AMERICA_LAND_2_ID)
                                            && (j3 == N_AMERICA_LAND_2_ID)
                                            && (i4 == N_AMERICA_LAND_2_ID)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = NAmericaBiomes2[nextInt(NAmericaBiomes2.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (k == N_AMERICA_LAND_3_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    (l1 == N_AMERICA_LAND_3_ID)
                                            && (k2 == N_AMERICA_LAND_3_ID)
                                            && (j3 == N_AMERICA_LAND_3_ID)
                                            && (i4 == N_AMERICA_LAND_3_ID)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = NAmericaBiomes3[nextInt(NAmericaBiomes3.length)];
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
