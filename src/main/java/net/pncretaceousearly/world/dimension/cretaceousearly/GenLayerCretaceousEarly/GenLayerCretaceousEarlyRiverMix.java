package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome CRETACEOUS_EARLY_CREEK_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys_europe"));
    public int CRETACEOUS_EARLY_CREEK_EUROPE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_EUROPE);

    public Biome CRETACEOUS_EARLY_CREEK_NAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_north_america_braided"));
    public int CRETACEOUS_EARLY_CREEK_NAMERICA_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_NAMERICA);

    public Biome CRETACEOUS_EARLY_CREEK_AUS_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_creek"));
    public int CRETACEOUS_EARLY_CREEK_AUS_FOREST_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_FOREST);
    public Biome CRETACEOUS_EARLY_CREEK_AUS_JUNGLE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_rainforest"));
    public int CRETACEOUS_EARLY_CREEK_AUS_JUNGLE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_JUNGLE);
    public Biome CRETACEOUS_EARLY_CREEK_AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_beach_australia_antarctica_inland_sea"));
    public int CRETACEOUS_EARLY_CREEK_AUS_BEACH_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_BEACH);

    //Biomes to exclude for rivers:
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

    public static Biome AUS_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public static int AUS_FOREST_ID =  Biome.getIdForBiome(AUS_FOREST);
    public static Biome AUS_JUNGLE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_rainforest"));
    public static int AUS_JUNGLE_ID =  Biome.getIdForBiome(AUS_JUNGLE);
    public static Biome AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public static int AUS_BEACH_ID =  Biome.getIdForBiome(AUS_BEACH);
    public static Biome AUS_LUSH_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea"));
    public static int AUS_LUSH_BEACH_ID =  Biome.getIdForBiome(AUS_LUSH_BEACH);

    public static Biome N_AMERICA_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_mountains"));
    public static int N_AMERICA_4_ID =  Biome.getIdForBiome(N_AMERICA_4);

    public static Biome N_AMERICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public static int N_AMERICA_1_ID =  Biome.getIdForBiome(N_AMERICA_1);
    public static Biome N_AMERICA_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_foothills"));
    public static int N_AMERICA_2_ID =  Biome.getIdForBiome(N_AMERICA_2);
    public static Biome N_AMERICA_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_transition"));
    public static int N_AMERICA_3_ID =  Biome.getIdForBiome(N_AMERICA_3);

    public static Biome S_AMERICA_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public static int S_AMERICA_1_ID =  Biome.getIdForBiome(S_AMERICA_1);



    public GenLayerCretaceousEarlyRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == CRETACEOUS_OCEAN_ID
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_TETHYS_ID
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_ATLANTIC_ID
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_SOUTHERN_ID
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_PACIFIC_ID
                        || aint[i] == N_AMERICA_4_ID
                        || aint[i] == CRETACEOUS_INLAND_SEA_SOUTH_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    if (isEurope(aint[i])) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_EUROPE_ID;
                    }
                    if (isNAmerica(aint[i])) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_NAMERICA_ID;
                    }
                    if (isAus(aint[i])) {
                        if (aint[i] == AUS_FOREST_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_FOREST_ID;
                        }
                        else if (aint[i] == AUS_BEACH_ID
                            || aint[i] == AUS_LUSH_BEACH_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_BEACH_ID;
                        }
                        else if (aint[i] == AUS_JUNGLE_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_JUNGLE_ID;
                        }
                        else {
                            aint2[i] = aint[i];
                        }
                    }
                    else {
                        aint2[i] = aint[i];
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }

    public static boolean isEurope(int i) {
        Biome biome = Biome.getBiome(i);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return (!isNAmerica(i)) && biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Euro_America;
        }
        return false;
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
                || i == N_AMERICA_3_ID;
    }

    public static boolean isSAmerica(int i) {
        return i == S_AMERICA_1_ID;
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
