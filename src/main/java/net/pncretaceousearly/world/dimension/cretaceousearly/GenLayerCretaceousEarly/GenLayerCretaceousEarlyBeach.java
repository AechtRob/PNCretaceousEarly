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

    public Biome COASTAL_FLATS_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats_stream"));
    public int COASTAL_FLATS_1_ID =  Biome.getIdForBiome(COASTAL_FLATS_1);
    public Biome COASTAL_FLATS_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats"));
    public int COASTAL_FLATS_2_ID =  Biome.getIdForBiome(COASTAL_FLATS_2);
    public Biome COASTAL_FLATS_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public int COASTAL_FLATS_3_ID =  Biome.getIdForBiome(COASTAL_FLATS_3);

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

    public Biome CRETACEOUS_BEACH_EUROPE_FERNY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_europe_ferny"));
    public int CRETACEOUS_BEACH_EUROPE_FERNY_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_EUROPE_FERNY);
    public Biome CRETACEOUS_BEACH_EUROPE_DRY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_europe_dry"));
    public int CRETACEOUS_BEACH_EUROPE_DRY_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_EUROPE_DRY);
    public Biome CRETACEOUS_BEACH_EUROPE_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_europe_swamp"));
    public int CRETACEOUS_BEACH_EUROPE_SWAMP_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_EUROPE_SWAMP);

    public Biome CRETACEOUS_BEACH_NA_LAGOONS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_namerica_lagoons"));
    public int CRETACEOUS_BEACH_NA_LAGOONS_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_NA_LAGOONS);
    public Biome CRETACEOUS_BEACH_NA_COVE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_namerica_cove"));
    public int CRETACEOUS_BEACH_NA_COVE_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_NA_COVE);

    public Biome CRETACEOUS_BEACH_ASIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia"));
    public int CRETACEOUS_BEACH_ASIA_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_ASIA);
    public Biome CRETACEOUS_BEACH_ASIA_CRAGGY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia_craggy"));
    public int CRETACEOUS_BEACH_ASIA_CRAGGY_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_ASIA_CRAGGY);
    public Biome CRETACEOUS_BEACH_ASIA_MARSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia_marsh"));
    public int CRETACEOUS_BEACH_ASIA_MARSH_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_ASIA_MARSH);


    public Biome CRETACEOUS_BEACH_AFRICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_africa"));
    public int CRETACEOUS_BEACH_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AFRICA);
    public Biome CRETACEOUS_BEACH_AFRICA_ROCKY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_afroamerica_rocky"));
    public int CRETACEOUS_BEACH_AFRICA_ROCKY_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AFRICA_ROCKY);
    public Biome CRETACEOUS_BEACH_AFRICA_RED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_afroamerica_red"));
    public int CRETACEOUS_BEACH_AFRICA_RED_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AFRICA_RED);

    public Biome CRETACEOUS_BEACH_AUSTRALIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public int CRETACEOUS_BEACH_AUSTRALIA_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AUSTRALIA);
    public Biome CRETACEOUS_BEACH_AUSTRALIA_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea"));
    public int CRETACEOUS_BEACH_AUSTRALIA_LUSH_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AUSTRALIA_LUSH);
    public Biome CRETACEOUS_BEACH_AUSTRALIA_MUDDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_muddy"));
    public int CRETACEOUS_BEACH_AUSTRALIA_MUDDY_ID =  Biome.getIdForBiome(CRETACEOUS_BEACH_AUSTRALIA_MUDDY);

    public Biome SANDY_MACQUIS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_maquis"));
    public int SANDY_MACQUIS_ID =  Biome.getIdForBiome(SANDY_MACQUIS);

    public Biome FERNY_FLOODPLAIN_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field"));
    public int FERNY_FLOODPLAIN_1_ID =  Biome.getIdForBiome(FERNY_FLOODPLAIN_1);
    public Biome FERNY_FLOODPLAIN_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field_copse"));
    public int FERNY_FLOODPLAIN_2_ID =  Biome.getIdForBiome(FERNY_FLOODPLAIN_2);

    public Biome EYOTTS_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int EYOTTS_1_ID =  Biome.getIdForBiome(EYOTTS_1);
    public Biome EYOTTS_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes"));
    public int EYOTTS_2_ID =  Biome.getIdForBiome(EYOTTS_2);
    public Biome EYOTTS_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes_edge"));
    public int EYOTTS_3_ID =  Biome.getIdForBiome(EYOTTS_3);

    public Biome NAMERICA_FLOODPLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public int NAMERICA_FLOODPLAIN_ID =  Biome.getIdForBiome(NAMERICA_FLOODPLAIN);
    public Biome NAMERICA_LAGOONS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_lagoons"));
    public int NAMERICA_LAGOONS_ID =  Biome.getIdForBiome(NAMERICA_LAGOONS);

    public Biome ASIA_BOGGY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public int ASIA_BOGGY_ID =  Biome.getIdForBiome(ASIA_BOGGY);

    public Biome AUS_RAINFOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_rainforest"));
    public int AUS_RAINFOREST_ID =  Biome.getIdForBiome(AUS_RAINFOREST);
    public Biome AUS_CLIFFS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_cliffs"));
    public int AUS_CLIFFS_ID =  Biome.getIdForBiome(AUS_CLIFFS);
    public Biome AUS_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes"));
    public int AUS_LAKES_ID =  Biome.getIdForBiome(AUS_LAKES);
    public Biome AUS_LAKES_PEAKS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_peaks"));
    public int AUS_LAKES_PEAKS_ID =  Biome.getIdForBiome(AUS_LAKES_PEAKS);
    public Biome AUS_LAKES_RIM_INNER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_inner"));
    public int AUS_LAKES_RIM_INNER_ID =  Biome.getIdForBiome(AUS_LAKES_RIM_INNER);
    public Biome AUS_LAKES_RIM_OUTER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_outer"));
    public int AUS_LAKES_RIM_OUTER_ID =  Biome.getIdForBiome(AUS_LAKES_RIM_OUTER);

    public Biome SOUTH_AMERICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int SOUTH_AMERICA_1_ID =  Biome.getIdForBiome(SOUTH_AMERICA_1);
    public Biome SOUTH_AMERICA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public int SOUTH_AMERICA_2_ID =  Biome.getIdForBiome(SOUTH_AMERICA_2);
    public Biome SOUTH_AMERICA_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid_spikes"));
    public int SOUTH_AMERICA_3_ID =  Biome.getIdForBiome(SOUTH_AMERICA_3);
    public Biome SOUTH_AMERICA_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low"));
    public int SOUTH_AMERICA_4_ID =  Biome.getIdForBiome(SOUTH_AMERICA_4);
    public Biome SOUTH_AMERICA_5 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_spikes"));
    public int SOUTH_AMERICA_5_ID =  Biome.getIdForBiome(SOUTH_AMERICA_5);
    public Biome SOUTH_AMERICA_6 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public int SOUTH_AMERICA_6_ID =  Biome.getIdForBiome(SOUTH_AMERICA_6);
    public Biome SOUTH_AMERICA_7 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public int SOUTH_AMERICA_7_ID =  Biome.getIdForBiome(SOUTH_AMERICA_7);
    public Biome SOUTH_AMERICA_8 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public int SOUTH_AMERICA_8_ID =  Biome.getIdForBiome(SOUTH_AMERICA_8);
    public Biome SOUTH_AMERICA_9 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert_spikes"));
    public int SOUTH_AMERICA_9_ID =  Biome.getIdForBiome(SOUTH_AMERICA_9);

    public Biome RIFT_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_rift"));
    public int RIFT_1_ID =  Biome.getIdForBiome(RIFT_1);
    public Biome RIFT_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_centre"));
    public int RIFT_2_ID =  Biome.getIdForBiome(RIFT_2);
    public Biome RIFT_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide"));
    public int RIFT_3_ID =  Biome.getIdForBiome(RIFT_3);


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
                                if (k == FERNY_FLOODPLAIN_1_ID || k == FERNY_FLOODPLAIN_2_ID) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_EUROPE_FERNY_ID;
                                }
                                else if (k == SANDY_MACQUIS_ID) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_EUROPE_DRY_ID;
                                }
                                else if (k == EYOTTS_1_ID || k == EYOTTS_2_ID || k == EYOTTS_3_ID) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_EUROPE_SWAMP_ID;
                                }
                                else {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_NA_COVE_ID;
                                }
                            }
                            else if (isAsia(k)) {
                                if (isCraggy(k)) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_ASIA_CRAGGY_ID;
                                }
                                else if (k == ASIA_BOGGY_ID) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_ASIA_MARSH_ID;
                                }
                                else {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_ASIA_ID;
                                }
                            }
                            else if (isAfrica(k)) {
                                if (isSAmerica(k)) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AFRICA_ID;
                                }
                                else if (k == RIFT_1_ID || k == RIFT_2_ID || k == RIFT_3_ID) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AFRICA_ROCKY_ID;
                                }
                                else {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AFRICA_RED_ID;
                                }
                            }
                            else if (isAus(k)) {
                                if (k == AUS_RAINFOREST_ID) {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AUSTRALIA_MUDDY_ID;
                                }
                                else {
                                    aint1[j + i * areaWidth] = CRETACEOUS_BEACH_AUSTRALIA_ID;
                                }
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
        return biomeID == COASTAL_FLATS_1_ID
                || biomeID == COASTAL_FLATS_2_ID
                || biomeID == COASTAL_FLATS_3_ID
                || biomeID == NAMERICA_FLOODPLAIN_ID
                || biomeID == NAMERICA_LAGOONS_ID
                || biomeID == AUS_CLIFFS_ID
                || biomeID == AUS_LAKES_ID
                || biomeID == AUS_LAKES_PEAKS_ID
                || biomeID == AUS_LAKES_RIM_INNER_ID
                || biomeID == AUS_LAKES_RIM_OUTER_ID;
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

    public boolean isSAmerica(int i) {
       return i == SOUTH_AMERICA_1_ID
               || i == SOUTH_AMERICA_2_ID
               || i == SOUTH_AMERICA_3_ID
               || i == SOUTH_AMERICA_4_ID
               || i == SOUTH_AMERICA_5_ID
               || i == SOUTH_AMERICA_6_ID
               || i == SOUTH_AMERICA_7_ID
               || i == SOUTH_AMERICA_8_ID
               || i == SOUTH_AMERICA_9_ID;
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
