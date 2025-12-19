package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOceanReefs extends GenLayer
{


    public static Biome RUDIST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys_rudist"));
    public static int RUDIST_ID =  Biome.getIdForBiome(RUDIST);
    public static Biome CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys_coral"));
    public static int CORAL_ID =  Biome.getIdForBiome(CORAL);
    public static Biome TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public static int TETHYS_ID =  Biome.getIdForBiome(TETHYS);

    public GenLayerOceanReefs(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }


    private final int TethysBiomes[] = new int[] {
            TETHYS_ID,
            TETHYS_ID,
            TETHYS_ID,
            TETHYS_ID,
            RUDIST_ID,
            CORAL_ID
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

                if (isTethys(k))
                {

                    aint1[j + i * areaWidth] = TethysBiomes[nextInt(TethysBiomes.length)];

                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }


    public static boolean isTethys(int i) {
        return i == TETHYS_ID;
    }
    
}
