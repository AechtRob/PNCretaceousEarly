package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSAmericanDesertLows extends GenLayer
{

    public static Biome SAMERICAN_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public static int SAMERICAN_DESERT_ID =  Biome.getIdForBiome(SAMERICAN_DESERT);

    public static Biome SAMERICAN_DESERT_LOW = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low"));
    public static int SAMERICAN_DESERT_LOW_ID =  Biome.getIdForBiome(SAMERICAN_DESERT_LOW);


    public GenLayerSAmericanDesertLows(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AfricaBiomes[] = new int[] {
            SAMERICAN_DESERT_ID,
            SAMERICAN_DESERT_ID,
            SAMERICAN_DESERT_LOW_ID
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
                        (l1 == SAMERICAN_DESERT_ID)
                        && (k2 == SAMERICAN_DESERT_ID)
                        && (j3 == SAMERICAN_DESERT_ID)
                        && (i4 == SAMERICAN_DESERT_ID)
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
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }
    
}
