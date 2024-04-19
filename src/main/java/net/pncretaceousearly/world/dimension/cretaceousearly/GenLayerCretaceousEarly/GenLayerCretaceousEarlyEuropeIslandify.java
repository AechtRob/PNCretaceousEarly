package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyEuropeIslandify extends GenLayer
{

    public Biome EARLY_CRETACEOUS_RIVER_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public int EARLY_CRETACEOUS_RIVER_TETHYS_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_RIVER_TETHYS);

    public Biome CRETACEOUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN);

    public Biome AUS_INLAND_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_australia"));
    public int AUS_INLAND_SEA_ID =  Biome.getIdForBiome(AUS_INLAND_SEA);
    public Biome N_AMERICA_INLAND_SEA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_north_america"));
    public int N_AMERICA_INLAND_SEA_ID =  Biome.getIdForBiome(N_AMERICA_INLAND_SEA);

    public Biome OCEAN_SHORE_TETHYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys"));
    public int OCEAN_SHORE_TETHYS_ID =  Biome.getIdForBiome(OCEAN_SHORE_TETHYS);
    public Biome OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public int OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_ATLANTIC);
    public Biome OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public int OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(OCEAN_SHORE_SOUTHERN);
    public Biome OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public int OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_PACIFIC);

    public Biome EARLY_CRETACEOUS_BEACH_AFRICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_africa"));
    public int EARLY_CRETACEOUS_BEACH_AFRICA_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_BEACH_AFRICA);
    public Biome EARLY_CRETACEOUS_BEACH_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_europe"));
    public int EARLY_CRETACEOUS_BEACH_EUROPE_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_BEACH_EUROPE);
    public Biome EARLY_CRETACEOUS_BEACH_ASIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia"));
    public int EARLY_CRETACEOUS_BEACH_ASIA_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_BEACH_ASIA);
    public Biome EARLY_CRETACEOUS_BEACH_AUS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public int EARLY_CRETACEOUS_BEACH_AUS_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_BEACH_AUS);

    public Biome EARLY_CRETACEOUS_SWAMP_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int EARLY_CRETACEOUS_SWAMP_EUROPE_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_SWAMP_EUROPE);
    public Biome EARLY_CRETACEOUS_DRY_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_maquis"));
    public int EARLY_CRETACEOUS_DRY_EUROPE_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_DRY_EUROPE);
    public Biome EARLY_CRETACEOUS_EUROPE_SWAMP_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes_edge"));
    public int EARLY_CRETACEOUS_EUROPE_SWAMP_LAKES_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_EUROPE_SWAMP_LAKES);

    public static Biome N_AMERICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public static int N_AMERICA_1_ID =  Biome.getIdForBiome(N_AMERICA_1);
    public static Biome N_AMERICA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_foothills"));
    public static int N_AMERICA_2_ID =  Biome.getIdForBiome(N_AMERICA_2);
    public static Biome N_AMERICA_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_transition"));
    public static int N_AMERICA_3_ID =  Biome.getIdForBiome(N_AMERICA_3);
    public static Biome N_AMERICA_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_mountains"));
    public static int N_AMERICA_4_ID =  Biome.getIdForBiome(N_AMERICA_4);

    public GenLayerCretaceousEarlyEuropeIslandify(long seed, GenLayer genLayer)
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

                    if (isEuropeSwamp(k)) {

                        if ((!isEuropeSwamp(l1) && !isOceanOrBeach(l1))
                                || (!isEuropeSwamp(k2) && !isOceanOrBeach(k2))
                                || (!isEuropeSwamp(j3) && !isOceanOrBeach(j3))
                                || (!isEuropeSwamp(i4) && !isOceanOrBeach(i4))
                        ) {
                            aint1[j + i * areaWidth] = EARLY_CRETACEOUS_RIVER_TETHYS_ID;
                        }
                        else {
                            aint1[j + i * areaWidth] = k;
                        }
                    }
                    else if (isEuropeDry(k)) {

                        if ((!isEuropeDry(l1) && !isOceanOrBeach(l1))
                                || (!isEuropeDry(k2) && !isOceanOrBeach(k2))
                                || (!isEuropeDry(j3) && !isOceanOrBeach(j3))
                                || (!isEuropeDry(i4) && !isOceanOrBeach(i4))
                        ) {
                            aint1[j + i * areaWidth] = EARLY_CRETACEOUS_RIVER_TETHYS_ID;
                        }
                        else {
                            aint1[j + i * areaWidth] = k;
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

    private boolean isOceanOrBeach(int biomeID) {
        return biomeID == CRETACEOUS_OCEAN_ID
                || biomeID == AUS_INLAND_SEA_ID
                || biomeID == N_AMERICA_INLAND_SEA_ID
                || biomeID == OCEAN_SHORE_TETHYS_ID
                || biomeID == OCEAN_SHORE_ATLANTIC_ID
                || biomeID == OCEAN_SHORE_PACIFIC_ID
                || biomeID == OCEAN_SHORE_SOUTHERN_ID
                || biomeID == EARLY_CRETACEOUS_BEACH_AFRICA_ID
                || biomeID == EARLY_CRETACEOUS_BEACH_EUROPE_ID
                || biomeID == EARLY_CRETACEOUS_BEACH_ASIA_ID
                || biomeID == EARLY_CRETACEOUS_BEACH_AUS_ID;
    }

    private boolean isEuropeSwamp(int biomeID) {
        return biomeID == EARLY_CRETACEOUS_SWAMP_EUROPE_ID
                || biomeID == EARLY_CRETACEOUS_EUROPE_SWAMP_LAKES_ID;
    }

    private boolean isEuropeDry(int biomeID) {
        return biomeID == EARLY_CRETACEOUS_DRY_EUROPE_ID;
    }


    public static boolean isEurope(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return (!isNAmerica(i)) && biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Euro_America;
        }
        return false;
    }

    public static boolean isNAmerica(int i) {
        return i == N_AMERICA_1_ID
                || i == N_AMERICA_2_ID
                || i == N_AMERICA_3_ID
                || i == N_AMERICA_4_ID;
    }

}
