package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAustroAntarcticCraterTransition extends GenLayer
{

    public Biome CRATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_crater"));
    public int CRATER_ID =  Biome.getIdForBiome(CRATER);

    public Biome CRATER_TRANSITION = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_crater_rim"));
    public int CRATER_TRANSITION_ID =  Biome.getIdForBiome(CRATER_TRANSITION);

    public Biome PODOCARP_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_lakes"));
    public int PODOCARP_LAKE_ID =  Biome.getIdForBiome(PODOCARP_LAKE);

    public Biome PODOCARP_LAKE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_lakes_edge"));
    public int PODOCARP_LAKE_EDGE_ID =  Biome.getIdForBiome(PODOCARP_LAKE_EDGE);


    public GenLayerAustroAntarcticCraterTransition(long seed, GenLayer genLayer)
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

                if (k == PODOCARP_LAKE_ID) {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isCraterOrEdge(l1) || isCraterOrEdge(k2) || isCraterOrEdge(j3) || isCraterOrEdge(i4))
                    {
                        aint1[j + i * areaWidth] = PODOCARP_LAKE_EDGE_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }

                }

                else if (!isCrater(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (
                            (isCrater(l1) || isCrater(k2) || isCrater(j3) || isCrater(i4))

                    )
                    {
                        aint1[j + i * areaWidth] = CRATER_TRANSITION_ID;
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

    private boolean isCrater(int biomeID) {
        if (biomeID == CRATER_ID) {
            return true;
        }
        return false;
    }

    private boolean isCraterOrEdge(int biomeID) {
        if (biomeID == CRATER_ID
            || biomeID == CRATER_TRANSITION_ID) {
            return true;
        }
        return false;
    }

}
