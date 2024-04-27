package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousDiversifyAustroAntarctica extends GenLayer
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

    public Biome CRETACEOUS_EARLY_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_EARLY_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN);


    public GenLayerCretaceousDiversifyAustroAntarctica(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AusBiomes[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID
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

                if (k == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID)
                        && (k2 == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID)
                        && (j3 == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID)
                        && (i4 == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_SAMERICA_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AusBiomes[nextInt(AusBiomes.length)];
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
