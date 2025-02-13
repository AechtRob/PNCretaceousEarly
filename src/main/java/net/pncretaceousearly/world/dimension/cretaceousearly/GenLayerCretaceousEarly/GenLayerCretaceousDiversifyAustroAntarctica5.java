package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousDiversifyAustroAntarctica5 extends GenLayer
{

    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST);
    public Biome EARLY_CRETACEOUS_AUSTRO_PADDOCK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock"));
    public int EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_PADDOCK);
    public Biome EARLY_CRETACEOUS_AUSTRO_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_lakes"));
    public int EARLY_CRETACEOUS_AUSTRO_LAKE_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_LAKE);

    public GenLayerCretaceousDiversifyAustroAntarctica5(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AusBiomes[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_LAKE_ID
    };

    private final int AusBiomesPaddock[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID,
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID,
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID,
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID,
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID,
            EARLY_CRETACEOUS_AUSTRO_LAKE_ID
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

                if (k == EARLY_CRETACEOUS_AUSTRO_FOREST_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    (isPodocarp(l1))
                                            && (isPodocarp(k2))
                                            && (isPodocarp(j3))
                                            && (isPodocarp(i4))
                            )
                    );
                    if (flag) {
                        aint1[j + i * areaWidth] = AusBiomes[nextInt(AusBiomes.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (k == EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID) {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    (isPodocarp(l1))
                                            && (isPodocarp(k2))
                                            && (isPodocarp(j3))
                                            && (isPodocarp(i4))
                            )
                    );
                    if (flag) {
                        aint1[j + i * areaWidth] = AusBiomesPaddock[nextInt(AusBiomesPaddock.length)];
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


    public boolean isPodocarp(int i) {
        return i == EARLY_CRETACEOUS_AUSTRO_FOREST_ID || i == EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID;
    }
    
}
