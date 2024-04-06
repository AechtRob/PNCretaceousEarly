package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAddShallowSea2 extends GenLayer
{

    public Biome CRETACEOUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN);

    public Biome OCEAN_SHORE_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public int OCEAN_SHORE_TETHYS_ID =  Biome.getIdForBiome(OCEAN_SHORE_TETHYS);
    public Biome OCEAN_SHORE_NATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_north_atlantic"));
    public int OCEAN_SHORE_NATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_NATLANTIC);
    public Biome OCEAN_SHORE_SATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_south_atlantic"));
    public int OCEAN_SHORE_SATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_SATLANTIC);
    public Biome OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public int OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(OCEAN_SHORE_SOUTHERN);
    public Biome OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public int OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_PACIFIC);

    public GenLayerAddShallowSea2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int EuropeSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_NATLANTIC_ID
    };

    private final int AfricaSeas[] = new int[] {
            OCEAN_SHORE_NATLANTIC_ID,
            OCEAN_SHORE_SATLANTIC_ID,
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_TETHYS_ID,
    };

    private final int AsiaSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_PACIFIC_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    private final int NorthAmericaSeas[] = new int[] {
            OCEAN_SHORE_NATLANTIC_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    private final int SouthAmericaSeas[] = new int[] {
            OCEAN_SHORE_NATLANTIC_ID,
            OCEAN_SHORE_SATLANTIC_ID,
            OCEAN_SHORE_PACIFIC_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    private final int AustraliaSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_SOUTHERN_ID,
            OCEAN_SHORE_PACIFIC_ID
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

                if (k == CRETACEOUS_OCEAN_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    if (isEurope(l1) || isEurope(k2) || isEurope(j3) || isEurope(i4))
                    {
                        aint1[j + i * areaWidth] = EuropeSeas[nextInt(EuropeSeas.length)];
                    }
                    else if (isAsia(l1) || isAsia(k2) || isAsia(j3) || isAsia(i4))
                    {
                        aint1[j + i * areaWidth] = AsiaSeas[nextInt(AsiaSeas.length)];
                    }
                    else if (isAfrica(l1) || isAfrica(k2) || isAfrica(j3) || isAfrica(i4))
                    {
                        aint1[j + i * areaWidth] = AfricaSeas[nextInt(AfricaSeas.length)];
                    }
                    else if (isAus(l1) || isAus(k2) || isAus(j3) || isAus(i4))
                    {
                        aint1[j + i * areaWidth] = AustraliaSeas[nextInt(AustraliaSeas.length)];
                    }
                    else if (isNAmerica(l1) || isNAmerica(k2) || isNAmerica(j3) || isNAmerica(i4))
                    {
                        aint1[j + i * areaWidth] = NorthAmericaSeas[nextInt(NorthAmericaSeas.length)];
                    }
                    else if (isSAmerica(l1) || isSAmerica(k2) || isSAmerica(j3) || isSAmerica(i4))
                    {
                        aint1[j + i * areaWidth] = SouthAmericaSeas[nextInt(SouthAmericaSeas.length)];
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

    public static boolean isAsia(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Asia;
        }
        return false;
    }
    
}
