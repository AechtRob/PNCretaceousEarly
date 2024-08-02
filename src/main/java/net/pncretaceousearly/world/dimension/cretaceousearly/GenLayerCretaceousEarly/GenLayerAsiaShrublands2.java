package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAsiaShrublands2 extends GenLayer
{

    public static Biome SHRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland"));
    public static int SHRUBLAND_ID =  Biome.getIdForBiome(SHRUBLAND);

    public static Biome DUNES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland_dunes"));
    public static int DUNES_ID =  Biome.getIdForBiome(DUNES);

    public static Biome SPRINGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland_springs"));
    public static int SPRINGS_ID =  Biome.getIdForBiome(SPRINGS);


    public GenLayerAsiaShrublands2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int ShrublandBiomes[] = new int[] {
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SHRUBLAND_ID,
            SPRINGS_ID
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

                if (k == SHRUBLAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == SHRUBLAND_ID)
                        && (k2 == SHRUBLAND_ID)
                        && (j3 == SHRUBLAND_ID)
                        && (i4 == SHRUBLAND_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = ShrublandBiomes[nextInt(ShrublandBiomes.length)];
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
