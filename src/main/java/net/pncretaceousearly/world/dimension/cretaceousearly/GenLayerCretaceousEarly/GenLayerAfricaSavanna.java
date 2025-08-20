package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAfricaSavanna extends GenLayer
{

    public static Biome AFRO_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public static int AFRO_MOUNTAINS_ID =  Biome.getIdForBiome(AFRO_MOUNTAINS);

    public static Biome AFRO_SAVANNA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna"));
    public static int AFRO_SAVANNA_ID =  Biome.getIdForBiome(AFRO_SAVANNA);


    public GenLayerAfricaSavanna(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AfroBiomes[] = new int[] {
            AFRO_MOUNTAINS_ID,
            AFRO_SAVANNA_ID,
            AFRO_SAVANNA_ID
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

                if (k == AFRO_MOUNTAINS_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == AFRO_MOUNTAINS_ID || l1 == AFRO_SAVANNA_ID)
                        && (k2 == AFRO_MOUNTAINS_ID || k2 == AFRO_SAVANNA_ID)
                        && (j3 == AFRO_MOUNTAINS_ID || j3 == AFRO_SAVANNA_ID)
                        && (i4 == AFRO_MOUNTAINS_ID || i4 == AFRO_SAVANNA_ID)
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
