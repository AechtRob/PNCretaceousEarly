package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerReduceAustro extends GenLayer
{

    public Biome CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA);

    public Biome CRETACEOUS_EARLY_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_EARLY_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN);

    public GenLayerReduceAustro(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AustroBiomeShrink[] = new int[] {
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID,
            CRETACEOUS_EARLY_OCEAN_ID
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

                if (k == CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 != CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID)
                            || (k2 != CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID)
                            || (j3 != CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID)
                            || (i4 != CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AustroBiomeShrink[nextInt(AustroBiomeShrink.length)];
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
