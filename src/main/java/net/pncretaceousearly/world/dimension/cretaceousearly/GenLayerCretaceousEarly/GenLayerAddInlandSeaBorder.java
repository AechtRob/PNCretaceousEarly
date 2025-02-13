package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAddInlandSeaBorder extends GenLayer
{

    public Biome AUS_INLAND_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_australia"));
    public int AUS_INLAND_SEA_ID =  Biome.getIdForBiome(AUS_INLAND_SEA);
    public Biome AUS_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int AUS_LAND_ID =  Biome.getIdForBiome(AUS_LAND);


    public GenLayerAddInlandSeaBorder(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int CretaceousEarlyBiomes[] = new int[] {
            AUS_INLAND_SEA_ID,
            AUS_LAND_ID,
            AUS_LAND_ID,
            AUS_LAND_ID,
            AUS_LAND_ID
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

                if (k == AUS_INLAND_SEA_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        ((!isAusSeaBounded(l1)))
                        || (!isAusSeaBounded(k2))
                        || (!isAusSeaBounded(j3))
                        || (!isAusSeaBounded(i4))
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = CretaceousEarlyBiomes[nextInt(CretaceousEarlyBiomes.length)];
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

    public boolean isAusSeaBounded(int i) {
        return (i == AUS_LAND_ID
                || i == AUS_INLAND_SEA_ID);
    }

    
}
