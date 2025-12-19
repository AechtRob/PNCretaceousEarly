package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAustroAntarcticContinent extends GenLayer
{

    public Biome CRETACEOUS_DEEP_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public int CRETACEOUS_DEEP_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_DEEP_OCEAN);

    public Biome CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA);



    public GenLayerAustroAntarcticContinent(long seed, GenLayer genLayer)
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

                if (k == CRETACEOUS_DEEP_OCEAN_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == CRETACEOUS_DEEP_OCEAN_ID)
                        && (k2 == CRETACEOUS_DEEP_OCEAN_ID)
                        && (j3 == CRETACEOUS_DEEP_OCEAN_ID)
                        && (i4 == CRETACEOUS_DEEP_OCEAN_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID;
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
