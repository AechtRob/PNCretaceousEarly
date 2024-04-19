package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRiverbanksSAmericaRiver extends GenLayer
{

    public static int VANILLA_RIVER_ID = Biome.getIdForBiome(Biomes.RIVER);

    public Biome CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide"));
    public int CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE);

    public GenLayerRiverbanksSAmericaRiver(long seed, GenLayer genLayer)
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

                if (k == VANILLA_RIVER_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (!isBordered(l1))
                        || (!isBordered(k2))
                        || (!isBordered(j3))
                        || (!isBordered(i4))
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID;
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

    public boolean isBordered(int i) {
        return i == VANILLA_RIVER_ID || i == CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID;
    }
    
}
