package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDeepOcean extends GenLayer
{

    public static Biome OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public static int OCEAN_ID =  Biome.getIdForBiome(OCEAN);

    public static Biome OCEAN_SHORE_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public static int OCEAN_SHORE_TETHYS_ID =  Biome.getIdForBiome(OCEAN_SHORE_TETHYS);
    public static Biome OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public static int OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_ATLANTIC);
    public static Biome OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public static int OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(OCEAN_SHORE_SOUTHERN);
    public static Biome OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public static int OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_PACIFIC);


    public GenLayerDeepOcean(long seed, GenLayer genLayer)
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

                if (isSea(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                            isSea(l1)
                            && isSea(k2)
                            && isSea(j3)
                            && isSea(i4)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = OCEAN_ID;
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

    public static boolean isSea(int i) {
        return i == OCEAN_ID
                || i == OCEAN_SHORE_TETHYS_ID
                || i == OCEAN_SHORE_SOUTHERN_ID
                || i == OCEAN_SHORE_ATLANTIC_ID
                || i == OCEAN_SHORE_PACIFIC_ID;
    }
    
}
