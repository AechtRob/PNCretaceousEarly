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
    public Biome OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public int OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_ATLANTIC);
    public Biome OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public int OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(OCEAN_SHORE_SOUTHERN);
    public Biome OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public int OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(OCEAN_SHORE_PACIFIC);

    public static Biome N_AMERICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public static int N_AMERICA_1_ID =  Biome.getIdForBiome(N_AMERICA_1);
    public static Biome N_AMERICA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_mountains"));
    public static int N_AMERICA_2_ID =  Biome.getIdForBiome(N_AMERICA_2);
    public static Biome N_AMERICA_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_foothills"));
    public static int N_AMERICA_3_ID =  Biome.getIdForBiome(N_AMERICA_3);
    public static Biome N_AMERICA_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_shrubland"));
    public static int N_AMERICA_4_ID =  Biome.getIdForBiome(N_AMERICA_4);
    public static Biome N_AMERICA_5 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_shrubland_copse"));
    public static int N_AMERICA_5_ID =  Biome.getIdForBiome(N_AMERICA_5);
    public static Biome N_AMERICA_6 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_transition"));
    public static int N_AMERICA_6_ID =  Biome.getIdForBiome(N_AMERICA_6);
    public static Biome N_AMERICA_7 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_forest"));
    public static int N_AMERICA_7_ID =  Biome.getIdForBiome(N_AMERICA_7);

    public static Biome LAGOONS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_lagoons"));
    public static int LAGOONS_ID =  Biome.getIdForBiome(LAGOONS);

    public static Biome S_AMERICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public static int S_AMERICA_1_ID =  Biome.getIdForBiome(S_AMERICA_1);
    public static Biome S_AMERICA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public static int S_AMERICA_2_ID =  Biome.getIdForBiome(S_AMERICA_2);
    public static Biome S_AMERICA_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid_spikes"));
    public static int S_AMERICA_3_ID =  Biome.getIdForBiome(S_AMERICA_3);
    public static Biome S_AMERICA_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low"));
    public static int S_AMERICA_4_ID =  Biome.getIdForBiome(S_AMERICA_4);
    public static Biome S_AMERICA_5 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_spikes"));
    public static int S_AMERICA_5_ID =  Biome.getIdForBiome(S_AMERICA_5);
    public static Biome S_AMERICA_6 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public static int S_AMERICA_6_ID =  Biome.getIdForBiome(S_AMERICA_6);
    public static Biome S_AMERICA_7 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public static int S_AMERICA_7_ID =  Biome.getIdForBiome(S_AMERICA_7);
    public static Biome S_AMERICA_8 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public static int S_AMERICA_8_ID =  Biome.getIdForBiome(S_AMERICA_8);
    public static Biome S_AMERICA_9 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert_spikes"));
    public static int S_AMERICA_9_ID =  Biome.getIdForBiome(S_AMERICA_9);

    public GenLayerAddShallowSea2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int EuropeSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_ATLANTIC_ID
    };

    private final int AfricaSeas[] = new int[] {
            OCEAN_SHORE_ATLANTIC_ID,
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_TETHYS_ID,
    };

    private final int AsiaSeas[] = new int[] {
            OCEAN_SHORE_TETHYS_ID,
            OCEAN_SHORE_PACIFIC_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    private final int NorthAmericaSeas[] = new int[] {
            OCEAN_SHORE_ATLANTIC_ID,
            OCEAN_SHORE_PACIFIC_ID
    };

    private final int SouthAmericaSeas[] = new int[] {
            OCEAN_SHORE_ATLANTIC_ID,
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
                        if (isEuropeLagoons(l1) || isEuropeLagoons(k2) || isEuropeLagoons(j3) || isEuropeLagoons(i4)) {
                            aint1[j + i * areaWidth] = OCEAN_SHORE_ATLANTIC_ID;
                        }
                        else {
                            aint1[j + i * areaWidth] = OCEAN_SHORE_TETHYS_ID;
                        }
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
            return (!isNAmerica(i)) && biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Euro_America;
        }
        return false;
    }

    public static boolean isEuropeLagoons(int i) {
        return i == LAGOONS_ID;
    }

    public static boolean isAfrica(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return (!isSAmerica(i)) && biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
        }
        return false;
    }

    public static boolean isNAmerica(int i) {
        return i == N_AMERICA_1_ID
                || i == N_AMERICA_2_ID
                || i == N_AMERICA_3_ID
                || i == N_AMERICA_4_ID
                || i == N_AMERICA_5_ID
                || i == N_AMERICA_6_ID
                || i == N_AMERICA_7_ID;
    }

    public static boolean isSAmerica(int i) {
        return i == S_AMERICA_1_ID
                || i == S_AMERICA_2_ID
                || i == S_AMERICA_3_ID
                || i == S_AMERICA_4_ID
                || i == S_AMERICA_5_ID
                || i == S_AMERICA_6_ID
                || i == S_AMERICA_7_ID
                || i == S_AMERICA_8_ID
                || i == S_AMERICA_9_ID;
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
    
}
