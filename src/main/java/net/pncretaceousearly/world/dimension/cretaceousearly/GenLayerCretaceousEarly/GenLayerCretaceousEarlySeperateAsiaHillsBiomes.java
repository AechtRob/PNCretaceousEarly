package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlySeperateAsiaHillsBiomes extends GenLayer
{

    public static Biome STEPPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_barren_hills"));
    public static int STEPPE_ID =  Biome.getIdForBiome(STEPPE);

    public static Biome REFUGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_refugium"));
    public static int REFUGE_ID =  Biome.getIdForBiome(REFUGE);

    public GenLayerCretaceousEarlySeperateAsiaHillsBiomes(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int[] VariantBiomes = new int[] {
            REFUGE_ID,
            REFUGE_ID,
            REFUGE_ID,
            STEPPE_ID
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

                if (k == REFUGE_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((l1 != REFUGE_ID && l1 != STEPPE_ID)
                            || (k2 != REFUGE_ID && k2 != STEPPE_ID)
                            || (j3 != REFUGE_ID && j3 != STEPPE_ID)
                            || (i4 != REFUGE_ID && i4 != STEPPE_ID)
                    )
                    {
                        aint1[j + i * areaWidth] = STEPPE_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = VariantBiomes[nextInt(VariantBiomes.length)];;
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
