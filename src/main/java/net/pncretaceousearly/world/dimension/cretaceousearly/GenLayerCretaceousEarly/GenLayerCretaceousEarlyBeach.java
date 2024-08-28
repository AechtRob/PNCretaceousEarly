package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousCreekAsiaPhrygana;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAsiaPhrygana;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAsiaPhryganaLake;

public class GenLayerCretaceousEarlyBeach extends GenLayer
{

    public Biome CRETACEOUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN);

    public Biome CRETACEOUS_OCEAN_SHORE_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public int CRETACEOUS_OCEAN_SHORE_TETHYS_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_TETHYS);
    public Biome CRETACEOUS_OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public int CRETACEOUS_OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_ATLANTIC);
    public Biome CRETACEOUS_OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public int CRETACEOUS_OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_SOUTHERN);
    public Biome CRETACEOUS_OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public int CRETACEOUS_OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_PACIFIC);

    public Biome CRETACEOUS_INLAND_SEA_SOUTH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_australia"));
    public int CRETACEOUS_INLAND_SEA_SOUTH_ID =  Biome.getIdForBiome(CRETACEOUS_INLAND_SEA_SOUTH);

    public Biome CRETACEOUS_BEACH_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_europe"));
    public int CRETACEOUS_BEACH_EUROPE_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_EUROPE);
    public Biome CRETACEOUS_BEACH_ASIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia"));
    public int CRETACEOUS_BEACH_ASIA_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_ASIA);
    public Biome CRETACEOUS_BEACH_ASIA_CRAGGY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia_craggy"));
    public int CRETACEOUS_BEACH_ASIA_CRAGGY_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_ASIA_CRAGGY);
    public Biome CRETACEOUS_BEACH_AFRICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_africa"));
    public int CRETACEOUS_BEACH_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AFRICA);
    public Biome CRETACEOUS_BEACH_AUSTRALIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public int CRETACEOUS_BEACH_AUSTRALIA_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AUSTRALIA);
    public Biome CRETACEOUS_BEACH_AUSTRALIA_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea"));
    public int CRETACEOUS_BEACH_AUSTRALIA_LUSH_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AUSTRALIA_LUSH);


    public GenLayerCretaceousEarlyBeach(long seed, GenLayer genLayer)
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
                //Biome biome = Biome.getBiome(k);

                if (!hasNoBeach(k))
                {
                    if (!isOcean(k))
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (!isOcean(l1) && !isOcean(k2) && !isOcean(j3) && !isOcean(i4))
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                        else
                        {
                            if (isInlandOcean(l1)
                                || isInlandOcean(k2)
                                || isInlandOcean(j3)
                                || isInlandOcean(i4)  ) {
                                aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AUSTRALIA_LUSH_ID;
                            }
                            else if (isEurope(k)) {
                                aint1[j + i * areaWidth] = CRETACEOUS_BEACH_EUROPE_ID;
                            }
                            else if (isAsia(k)) {
                                if (isCraggy(k)) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_ASIA_CRAGGY_ID;
                                }
                                else {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_ASIA_ID;
                                }
                            }
                            else if (isAfrica(k)) {
                                aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AFRICA_ID;
                            }
                            else if (isAus(k)) {
                                aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AUSTRALIA_ID;
                            }
                            else {
                                aint1[j + i * areaWidth] = k;
                            }
                        }
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }
        return aint1;
    }

    private boolean isOcean(int biomeID) {
        return biomeID == CRETACEOUS_OCEAN_ID || biomeID == CRETACEOUS_INLAND_SEA_SOUTH_ID
                || biomeID == CRETACEOUS_OCEAN_SHORE_PACIFIC_ID || biomeID == CRETACEOUS_OCEAN_SHORE_ATLANTIC_ID
                || biomeID == CRETACEOUS_OCEAN_SHORE_TETHYS_ID || biomeID == CRETACEOUS_OCEAN_SHORE_SOUTHERN_ID;
    }

    private boolean isInlandOcean(int biomeID) {
        return biomeID == CRETACEOUS_INLAND_SEA_SOUTH_ID;
    }

    private boolean hasNoBeach(int biomeID) {
        return false;
    }

    public static boolean isEurope(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Euro_America;
        }
        return false;
    }

    public static boolean isAfrica(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
        }
        return false;
    }

    public static boolean isAus(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Austro_Antarctica;
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

    public static boolean isCraggy(int i) {
        Biome biome = Biome.getBiome(i);
        return biome == BiomeEarlyCretaceousLandAsiaPhrygana.biome
                || biome == BiomeEarlyCretaceousLandAsiaPhryganaLake.biome
                || biome == BiomeEarlyCretaceousCreekAsiaPhrygana.biome;
    }

}
