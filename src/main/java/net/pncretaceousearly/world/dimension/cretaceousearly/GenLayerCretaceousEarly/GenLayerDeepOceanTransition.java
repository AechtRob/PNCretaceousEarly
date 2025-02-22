package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDeepOceanTransition extends GenLayer
{

    public static Biome OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public static int OCEAN_ID =  Biome.getIdForBiome(OCEAN);
    public static Biome OCEAN_TRANSITION = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_transition"));
    public static int OCEAN_TRANSITION_ID =  Biome.getIdForBiome(OCEAN_TRANSITION);

    public static Biome OCEAN_SHORE_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public static int OCEAN_SHORE_TETHYS_ID =  Biome.getIdForBiome(OCEAN_SHORE_TETHYS);
    public static Biome OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public static int OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_ATLANTIC);
    public static Biome OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public static int OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(OCEAN_SHORE_SOUTHERN);
    public static Biome OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public static int OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_PACIFIC);


    public GenLayerDeepOceanTransition(long seed, GenLayer genLayer)
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

                if (k == OCEAN_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                            isNotDeepSea(l1)
                            || isNotDeepSea(k2)
                            || isNotDeepSea(j3)
                            || isNotDeepSea(i4)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = OCEAN_TRANSITION_ID;
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

    public static boolean isNotDeepSea(int i) {
        return i != OCEAN_ID && i != OCEAN_TRANSITION_ID;
    }
    
}
