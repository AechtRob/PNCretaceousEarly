package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

        public class GenLayerAddInlandSeas2 extends GenLayer
{

    public Biome AUS_INLAND_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_australia"));
    public int AUS_INLAND_SEA_ID =  Biome.getIdForBiome(AUS_INLAND_SEA);

    public GenLayerAddInlandSeas2(long seed, GenLayer genLayer)
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

                if (isAus(k) && nextInt(4) != 0)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    l1 == AUS_INLAND_SEA_ID
                                            && isAusNotInlandSea(k2)
                                            && isAusNotInlandSea(j3)
                                            && isAusNotInlandSea(i4)
                            )
                            ||
                            (
                                    k2 == AUS_INLAND_SEA_ID
                                            && isAusNotInlandSea(l1)
                                            && isAusNotInlandSea(j3)
                                            && isAusNotInlandSea(i4)
                            )
                            ||
                            (
                                    j3 == AUS_INLAND_SEA_ID
                                            && isAusNotInlandSea(k2)
                                            && isAusNotInlandSea(l1)
                                            && isAusNotInlandSea(i4)
                            )
                            ||
                            (
                                    i4 == AUS_INLAND_SEA_ID
                                            && isAusNotInlandSea(k2)
                                            && isAusNotInlandSea(j3)
                                            && isAusNotInlandSea(l1)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AUS_INLAND_SEA_ID;
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

    public boolean isAus(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Austro_Antarctica;
        }
        return false;
    }

    public boolean isAusNotInlandSea(int i) {
        return (i != AUS_INLAND_SEA_ID) && isAus(i);
    }


    
}
