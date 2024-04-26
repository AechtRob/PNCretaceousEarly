package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousDiversifyAustroAntarctica2 extends GenLayer
{

    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST);
    public Biome EARLY_CRETACEOUS_AUSTRO_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_inner"));
    public int EARLY_CRETACEOUS_AUSTRO_LAKES_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_LAKES);
    public Biome EARLY_CRETACEOUS_AUSTRO_RAINFOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_rainforest"));
    public int EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_RAINFOREST);
    public Biome EARLY_CRETACEOUS_AUSTRO_PADDOCK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock"));
    public int EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_PADDOCK);
    public Biome EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock_winter"));
    public int EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN);
    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_winter"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN);
    public Biome CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA);


    public GenLayerCretaceousDiversifyAustroAntarctica2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AusBiomesNormal[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_ID
    };

    private final int AusBiomesFrozen[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID,
            EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN_ID
    };

    private final int AusBiomesRainforest[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_LAKES_ID
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

                if (isReplaceableNormal(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        isReplaceableNormal(l1)
                        && isReplaceableNormal(k2)
                        && isReplaceableNormal(j3)
                        && isReplaceableNormal(i4)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AusBiomesNormal[nextInt(AusBiomesNormal.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isReplaceableFrozen(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isReplaceableFrozen(l1)
                                            && isReplaceableFrozen(k2)
                                            && isReplaceableFrozen(j3)
                                            && isReplaceableFrozen(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AusBiomesFrozen[nextInt(AusBiomesFrozen.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isReplaceableRainforest(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isReplaceableRainforest(l1)
                                            && isReplaceableRainforest(k2)
                                            && isReplaceableRainforest(j3)
                                            && isReplaceableRainforest(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AusBiomesRainforest[nextInt(AusBiomesRainforest.length)];
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

    boolean isReplaceableNormal(int i) {
        return i == EARLY_CRETACEOUS_AUSTRO_FOREST_ID
                || i == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID;
    }

    boolean isReplaceableFrozen(int i) {
        return i == EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID
                || i == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID;
    }

    boolean isReplaceableRainforest(int i) {
        return i == EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID
                || i == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID;
    }
    
}
