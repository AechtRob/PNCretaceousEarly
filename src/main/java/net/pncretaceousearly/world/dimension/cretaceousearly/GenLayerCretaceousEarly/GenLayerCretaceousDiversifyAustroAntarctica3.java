package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousDiversifyAustroAntarctica3 extends GenLayer
{

    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST);
    public Biome EARLY_CRETACEOUS_AUSTRO_RAINFOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_rainforest"));
    public int EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_RAINFOREST);
    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_winter"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN);
    public Biome EARLY_CRETACEOUS_AUSTRO_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_inner"));
    public int EARLY_CRETACEOUS_AUSTRO_LAKES_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_LAKES);

    public GenLayerCretaceousDiversifyAustroAntarctica3(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AusBiomes[] = new int[] {
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_RAINFOREST_ID,
            EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID,
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

                if (k == EARLY_CRETACEOUS_AUSTRO_FOREST_ID)
                {
                    aint1[j + i * areaWidth] = AusBiomes[nextInt(AusBiomes.length)];
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }
    
}
