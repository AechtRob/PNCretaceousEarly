package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAfricaPinnacles extends GenLayer
{

    public static Biome AFRO_PINNACLES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_pinnacles"));
    public static int AFRO_PINNACLES_ID =  Biome.getIdForBiome(AFRO_PINNACLES);

    public static Biome AFRO_PEAKS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_peaks"));
    public static int AFRO_PEAKS_ID =  Biome.getIdForBiome(AFRO_PEAKS);


    public GenLayerAfricaPinnacles(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AfroBiomes[] = new int[] {
            AFRO_PEAKS_ID,
            AFRO_PEAKS_ID,
            AFRO_PINNACLES_ID
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

                if (k == AFRO_PEAKS_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == AFRO_PEAKS_ID)
                        && (k2 == AFRO_PEAKS_ID)
                        && (j3 == AFRO_PEAKS_ID)
                        && (i4 == AFRO_PEAKS_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AfroBiomes[nextInt(AfroBiomes.length)];
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
