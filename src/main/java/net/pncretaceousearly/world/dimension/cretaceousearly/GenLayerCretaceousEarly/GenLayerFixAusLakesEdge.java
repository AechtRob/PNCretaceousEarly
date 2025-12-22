package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerFixAusLakesEdge extends GenLayer
{

    public static Biome AUSTRO_LAKE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_inner"));
    public static int AUSTRO_LAKE_EDGE_ID =  Biome.getIdForBiome(AUSTRO_LAKE_EDGE);

    public static Biome AUSTRO_LAKE_EDGE_OUTER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_outer"));
    public static int AUSTRO_LAKE_EDGE_OUTER_ID =  Biome.getIdForBiome(AUSTRO_LAKE_EDGE_OUTER);

    public static Biome AUSTRO_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes"));
    public static int AUSTRO_LAKE_ID =  Biome.getIdForBiome(AUSTRO_LAKE);


    public GenLayerFixAusLakesEdge(long seed, GenLayer genLayer)
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
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k == AUSTRO_LAKE_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == AUSTRO_LAKE_EDGE_OUTER_ID)
                        || (k2 == AUSTRO_LAKE_EDGE_OUTER_ID)
                        || (j3 == AUSTRO_LAKE_EDGE_OUTER_ID)
                        || (i4 == AUSTRO_LAKE_EDGE_OUTER_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AUSTRO_LAKE_EDGE_ID;
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
