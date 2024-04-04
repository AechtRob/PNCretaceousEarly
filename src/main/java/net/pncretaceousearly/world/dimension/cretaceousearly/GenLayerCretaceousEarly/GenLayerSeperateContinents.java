package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSeperateContinents extends GenLayer
{

    public Biome CRETACEOUS_EARLY_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_EARLY_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN);

    public GenLayerSeperateContinents(long seed, GenLayer genLayer)
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

                if (isEurope(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        isNotEurope(l1)
                        || isNotEurope(k2)
                        || isNotEurope(j3)
                        || isNotEurope(i4)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
               else if (isAsia(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isNotAsia(l1)
                                            || isNotAsia(k2)
                                            || isNotAsia(j3)
                                            || isNotAsia(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isAfrica(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isNotAfrica(l1)
                                            || isNotAfrica(k2)
                                            || isNotAfrica(j3)
                                            || isNotAfrica(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isAus(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isNotAus(l1)
                                            || isNotAus(k2)
                                            || isNotAus(j3)
                                            || isNotAus(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isInd(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isNotInd(l1)
                                            || isNotInd(k2)
                                            || isNotInd(j3)
                                            || isNotInd(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isNAmerica(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isNotNAmerica(l1)
                                            || isNotNAmerica(k2)
                                            || isNotNAmerica(j3)
                                            || isNotNAmerica(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isSAmerica(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                            (
                                    isNotSAmerica(l1)
                                            || isNotSAmerica(k2)
                                            || isNotSAmerica(j3)
                                            || isNotSAmerica(i4)
                            )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] =  CRETACEOUS_EARLY_OCEAN_ID;
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

    public static boolean isEurope(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Europe;
        }
        return false;
    }

    public static boolean isAfrica(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Africa;
        }
        return false;
    }

    public static boolean isNAmerica(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_North_America;
        }
        return false;
    }

    public static boolean isSAmerica(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_South_America;
        }
        return false;
    }

    public static boolean isAus(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Australia_Antarctica;
        }
        return false;
    }

    public static boolean isInd(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_India_Madagascar;
        }
        return false;
    }

    public static boolean isAsia(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Asia;
        }
        return false;
    }

    public static boolean isNotEurope(int i) {
        return isAfrica(i) || isAsia(i) || isAus(i)
                || isInd(i) || isNAmerica(i) || isSAmerica(i);
    }

    public static boolean isNotAfrica(int i) {
        return isEurope(i) || isAsia(i) || isAus(i)
                || isInd(i) || isNAmerica(i) || isSAmerica(i);
    }

    public static boolean isNotAsia(int i) {
        return isEurope(i) || isAfrica(i) || isAus(i)
                || isInd(i) || isNAmerica(i) || isSAmerica(i);
    }

    public static boolean isNotAus(int i) {
        return isEurope(i) || isAfrica(i) || isAsia(i)
                || isInd(i) || isNAmerica(i) || isSAmerica(i);
    }

    public static boolean isNotInd(int i) {
        return isEurope(i) || isAfrica(i) || isAsia(i)
                || isAus(i) || isNAmerica(i) || isSAmerica(i);
    }

    public static boolean isNotNAmerica(int i) {
        return isEurope(i) || isAfrica(i) || isAsia(i)
                || isAus(i) || isInd(i) || isSAmerica(i);
    }

    public static boolean isNotSAmerica(int i) {
        return isEurope(i) || isAfrica(i) || isAsia(i)
                || isAus(i) || isInd(i) || isNAmerica(i);
    }
    
}
