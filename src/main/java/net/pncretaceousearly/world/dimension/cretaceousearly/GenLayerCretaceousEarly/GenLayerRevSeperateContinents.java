package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRevSeperateContinents extends GenLayer
{

    public static Biome OCEAN_SHORE_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public static int OCEAN_SHORE_TETHYS_ID =  Biome.getIdForBiome(OCEAN_SHORE_TETHYS);
    public static Biome OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public static int OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_ATLANTIC);
    public static Biome OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public static int OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(OCEAN_SHORE_SOUTHERN);
    public static Biome OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public static int OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_PACIFIC);

    private final int AsiaSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_PACIFIC_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    private final int AustraliaSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    public GenLayerRevSeperateContinents(long seed, GenLayer genLayer)
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
                        aint1[j + i * areaWidth] = OCEAN_SHORE_ATLANTIC_ID;
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
                        aint1[j + i * areaWidth] =  AsiaSeas[nextInt(AsiaSeas.length)];
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
                        aint1[j + i * areaWidth] = OCEAN_SHORE_ATLANTIC_ID;
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
                        aint1[j + i * areaWidth] =  AustraliaSeas[nextInt(AustraliaSeas.length)];
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
            return isSea(i) || biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Euro_America;
        }
        return false;
    }

    public static boolean isAfrica(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return isSea(i) || biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
        }
        return false;
    }

    public static boolean isAus(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return isSea(i) || biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Austro_Antarctica;
        }
        return false;
    }

    public static boolean isAsia(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return isSea(i) || biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Asia;
        }
        return false;
    }

    public static boolean isNotEurope(int i) {
        return isAfrica(i) || isAsia(i) || isAus(i);
    }

    public static boolean isNotAfrica(int i) {
        return isEurope(i) || isAsia(i) || isAus(i);
    }

    public static boolean isNotAsia(int i) {
        return isEurope(i) || isAfrica(i) || isAus(i);
    }

    public static boolean isNotAus(int i) {
        return isEurope(i) || isAfrica(i) || isAsia(i);
    }

    public static boolean isSea(int i) {
        return i == OCEAN_SHORE_TETHYS_ID
                || i == OCEAN_SHORE_ATLANTIC_ID
                || i == OCEAN_SHORE_SOUTHERN_ID
                || i == OCEAN_SHORE_PACIFIC_ID;
    }
}
