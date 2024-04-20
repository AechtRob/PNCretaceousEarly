package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAfricanDesertSpikes extends GenLayer
{

    public static Biome AFRICAN_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public static int AFRICAN_DESERT_ID =  Biome.getIdForBiome(AFRICAN_DESERT);

    public static Biome AFRICAN_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_desert_spikes"));
    public static int AFRICAN_SPIKES_ID =  Biome.getIdForBiome(AFRICAN_SPIKES);


    public GenLayerAfricanDesertSpikes(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AfricaBiomes[] = new int[] {
            AFRICAN_DESERT_ID,
            AFRICAN_DESERT_ID,
            AFRICAN_DESERT_ID,
            AFRICAN_DESERT_ID,
            AFRICAN_DESERT_ID,
            AFRICAN_SPIKES_ID
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

                if (k == AFRICAN_DESERT_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == AFRICAN_DESERT_ID)
                        && (k2 == AFRICAN_DESERT_ID)
                        && (j3 == AFRICAN_DESERT_ID)
                        && (i4 == AFRICAN_DESERT_ID)
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
