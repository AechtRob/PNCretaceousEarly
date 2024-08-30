package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverBorderRiftMagma extends GenLayer
{


    public Biome RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_centre"));
    public int RIVER_ID = Biome.getIdForBiome(RIVER);

    public Biome MAGMA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_rift"));
    public int MAGMA_ID = Biome.getIdForBiome(MAGMA);

    public GenLayerCretaceousEarlyRiverBorderRiftMagma(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int RiftBiomes[] = new int[] {
            RIVER_ID,
            RIVER_ID,
            RIVER_ID,
            RIVER_ID,
            RIVER_ID,
            RIVER_ID,
            MAGMA_ID
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

                if (k == RIVER_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == RIVER_ID)
                        && (k2 == RIVER_ID)
                        && (j3 == RIVER_ID)
                        && (i4 == RIVER_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = RiftBiomes[nextInt(RiftBiomes.length)];
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
