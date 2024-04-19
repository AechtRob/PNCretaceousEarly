package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerEuropeanSwampLakes extends GenLayer
{

    public static Biome EURO_LAKE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes_edge"));
    public static int EURO_LAKE_EDGE_ID =  Biome.getIdForBiome(EURO_LAKE_EDGE);

    public static Biome EURO_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes"));
    public static int EURO_LAKES_ID =  Biome.getIdForBiome(EURO_LAKES);


    public GenLayerEuropeanSwampLakes(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int SwampBiomes[] = new int[] {
            EURO_LAKE_EDGE_ID,
            EURO_LAKES_ID
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

                if (k == EURO_LAKE_EDGE_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == EURO_LAKE_EDGE_ID)
                        && (k2 == EURO_LAKE_EDGE_ID)
                        && (j3 == EURO_LAKE_EDGE_ID)
                        && (i4 == EURO_LAKE_EDGE_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = SwampBiomes[nextInt(SwampBiomes.length)];
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
