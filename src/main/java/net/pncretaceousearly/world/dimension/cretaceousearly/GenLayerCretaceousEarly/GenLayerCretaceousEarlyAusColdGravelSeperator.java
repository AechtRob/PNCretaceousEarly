package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyAusColdGravelSeperator extends GenLayer
{

    public Biome DIVIDER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_divider"));
    public int DIVIDER_ID = Biome.getIdForBiome(DIVIDER);
    public Biome PADDOCK_SNOW = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock_winter"));
    public int PADDOCK_SNOW_ID = Biome.getIdForBiome(PADDOCK_SNOW);
    public Biome FOREST_SNOW = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_winter"));
    public int FOREST_SNOW_ID = Biome.getIdForBiome(FOREST_SNOW);

    public GenLayerCretaceousEarlyAusColdGravelSeperator(long seed, GenLayer genLayer)
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
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k == FOREST_SNOW_ID || k== PADDOCK_SNOW_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isColdAustralia(l1))
                            || (!isColdAustralia(k2))
                            || (!isColdAustralia(j3))
                            || (!isColdAustralia(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = DIVIDER_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isColdAustralia(int biomeID) {
        if (biomeID == FOREST_SNOW_ID
                || biomeID == PADDOCK_SNOW_ID
                || biomeID == DIVIDER_ID) {
            return true;
        }
        return false;
    }

}
