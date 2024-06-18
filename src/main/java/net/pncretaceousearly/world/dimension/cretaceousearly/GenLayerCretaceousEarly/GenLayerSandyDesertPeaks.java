package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSandyDesertPeaks extends GenLayer
{

    public static Biome DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public static int DESERT_ID =  Biome.getIdForBiome(DESERT);

    public static Biome PEAKS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert_spikes"));
    public static int PEAKS_ID =  Biome.getIdForBiome(PEAKS);


    public GenLayerSandyDesertPeaks(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int DesertBiomes[] = new int[] {
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            DESERT_ID,
            PEAKS_ID
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

                if (k == DESERT_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == DESERT_ID)
                        && (k2 == DESERT_ID)
                        && (j3 == DESERT_ID)
                        && (i4 == DESERT_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = DesertBiomes[nextInt(DesertBiomes.length)];
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
