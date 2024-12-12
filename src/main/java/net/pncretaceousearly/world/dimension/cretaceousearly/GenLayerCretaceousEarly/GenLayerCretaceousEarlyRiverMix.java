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
    public Biome CRETACEOUS_FLOODPLAIN_CREEK_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_europe_field"));
    public int CRETACEOUS_FLOODPLAIN_CREEK_EUROPE_ID = Biome.getIdForBiome(CRETACEOUS_FLOODPLAIN_CREEK_EUROPE);
    public Biome CRETACEOUS_EARLY_CREEK_MACQUIS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_europe_maquis"));
    public int CRETACEOUS_EARLY_CREEK_MACQUIS_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_MACQUIS);
    public Biome CRETACEOUS_EARLY_CREEK_EUROPE_WOOD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_europe_field_copse"));
    public int CRETACEOUS_EARLY_CREEK_EUROPE_WOOD_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_EUROPE_WOOD);

    public Biome CRETACEOUS_EARLY_CREEK_NAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_north_america_braided"));
    public int CRETACEOUS_EARLY_CREEK_NAMERICA_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_NAMERICA);
    public Biome CRETACEOUS_EARLY_CREEK_NAMERICA_SHRUB = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_namerica_shrubland"));
    public int CRETACEOUS_EARLY_CREEK_NAMERICA_SHRUB_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_NAMERICA_SHRUB);
    public Biome CRETACEOUS_EARLY_CREEK_NAMERICA_COPSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_namerica_shrubland_copse"));
    public int CRETACEOUS_EARLY_CREEK_NAMERICA_COPSE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_NAMERICA_COPSE);

    public Biome CRETACEOUS_EARLY_CREEK_AUS_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_creek"));
    public int CRETACEOUS_EARLY_CREEK_AUS_FOREST_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_FOREST);
    public Biome CRETACEOUS_EARLY_CREEK_AUS_PADDOCK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_australia_antarctica_paddock"));
    public int CRETACEOUS_EARLY_CREEK_AUS_PADDOCK_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_PADDOCK);
    public Biome CRETACEOUS_EARLY_CREEK_AUS_JUNGLE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_rainforest"));
    public int CRETACEOUS_EARLY_CREEK_AUS_JUNGLE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_JUNGLE);
    public Biome CRETACEOUS_EARLY_CREEK_AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_beach_australia_antarctica_inland_sea"));
    public int CRETACEOUS_EARLY_CREEK_AUS_BEACH_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_AUS_BEACH);
    public Biome AUS_BEACH_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_coastal"));
    public int AUS_BEACH_CREEK_ID = Biome.getIdForBiome(AUS_BEACH_CREEK);
    public Biome AUS_CLIFF_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_coastal_cliffs"));
    public int AUS_CLIFF_CREEK_ID = Biome.getIdForBiome(AUS_CLIFF_CREEK);

    public Biome TICOA_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_patagonia"));
    public int TICOA_CREEK_ID = Biome.getIdForBiome(TICOA_CREEK);
    public Biome S_AMERICA_ARID_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_arid"));
    public int S_AMERICA_ARID_CREEK_ID = Biome.getIdForBiome(S_AMERICA_ARID_CREEK);
    public Biome S_AMERICA_DESERT_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_sandy_desert"));
    public int S_AMERICA_DESERT_CREEK_ID = Biome.getIdForBiome(S_AMERICA_DESERT_CREEK);
    public Biome S_AMERICA_FLATS_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats"));
    public int S_AMERICA_FLATS_CREEK_ID = Biome.getIdForBiome(S_AMERICA_FLATS_CREEK);

    public Biome AFRO_SAVANNA_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_africa_savanna"));
    public int AFRO_SAVANNA_CREEK_ID = Biome.getIdForBiome(AFRO_SAVANNA_CREEK);
    public Biome AFRO_SWAMP_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_africa_swamp"));
    public int AFRO_SWAMP_CREEK_ID = Biome.getIdForBiome(AFRO_SWAMP_CREEK);

    public Biome TETORI_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_boggy_glades"));
    public int TETORI_CREEK_ID = Biome.getIdForBiome(TETORI_CREEK);

    public Biome PHRYGANA_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_asia_phyrgana"));
    public int PHRYGANA_CREEK_ID = Biome.getIdForBiome(PHRYGANA_CREEK);
    public Biome BANDED_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_banded_desert"));
    public int BANDED_CREEK_ID = Biome.getIdForBiome(BANDED_CREEK);
    public Biome DROOPING_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_asia_drooping_swamp"));
    public int DROOPING_CREEK_ID = Biome.getIdForBiome(DROOPING_CREEK);
    public Biome REFUGIUM_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_refugium"));
    public int REFUGIUM_CREEK_ID = Biome.getIdForBiome(REFUGIUM_CREEK);
    public Biome SHRUBLAND_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_shrubland"));
    public int SHRUBLAND_CREEK_ID = Biome.getIdForBiome(SHRUBLAND_CREEK);

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
    public static Biome AUS_PADDOCK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock"));
    public static int AUS_PADDOCK_ID =  Biome.getIdForBiome(AUS_PADDOCK);
    public static Biome AUS_JUNGLE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_rainforest"));
    public static int AUS_JUNGLE_ID =  Biome.getIdForBiome(AUS_JUNGLE);
    public static Biome AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public static int AUS_BEACH_ID =  Biome.getIdForBiome(AUS_BEACH);
    public static Biome AUS_LUSH_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea"));
    public static int AUS_LUSH_BEACH_ID =  Biome.getIdForBiome(AUS_LUSH_BEACH);
    public Biome EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock_winter"));
    public int EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN);
    public Biome EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN= Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_winter"));
    public int EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID =  Biome.getIdForBiome(EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN);
    public Biome AUS_COAST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int AUS_COAST_ID = Biome.getIdForBiome(AUS_COAST);
    public Biome AUS_CLIFFS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_cliffs"));
    public int AUS_CLIFFS_ID = Biome.getIdForBiome(AUS_CLIFFS);

    public Biome DIVIDER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_divider"));
    public int DIVIDER_ID = Biome.getIdForBiome(DIVIDER);
    public Biome LAKE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_lakes_edge"));
    public int LAKE_EDGE_ID = Biome.getIdForBiome(LAKE_EDGE);

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

    public Biome TICOA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public int TICOA_ID = Biome.getIdForBiome(TICOA);
    public Biome S_AMERICA_ARID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public int S_AMERICA_ARID_ID = Biome.getIdForBiome(S_AMERICA_ARID);
    public Biome S_AMERICA_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public int S_AMERICA_DESERT_ID = Biome.getIdForBiome(S_AMERICA_DESERT);
    public Biome S_AMERICA_DESERT_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert_spikes"));
    public int S_AMERICA_DESERT_SPIKES_ID = Biome.getIdForBiome(S_AMERICA_DESERT_SPIKES);
    public Biome S_AMERICA_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public int S_AMERICA_FLATS_ID = Biome.getIdForBiome(S_AMERICA_FLATS);

    public Biome AFRO_SAVANNA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna"));
    public int AFRO_SAVANNA_ID = Biome.getIdForBiome(AFRO_SAVANNA);
    public Biome AFRO_SAVANNA_HOLE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna_hole"));
    public int AFRO_SAVANNA_HOLE_ID = Biome.getIdForBiome(AFRO_SAVANNA_HOLE);
    public Biome AFRO_SAVANNA_HOLE_CENTRE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna_hole_centre"));
    public int AFRO_SAVANNA_HOLE_CENTRE_ID = Biome.getIdForBiome(AFRO_SAVANNA_HOLE_CENTRE);


    public Biome AFRO_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp"));
    public int AFRO_SWAMP_ID = Biome.getIdForBiome(AFRO_SWAMP);
    public Biome AFRO_SWAMP_OPEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp_open"));
    public int AFRO_SWAMP_OPEN_ID = Biome.getIdForBiome(AFRO_SWAMP_OPEN);

    public static Biome EURO_LAKE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes_edge"));
    public static int EURO_LAKE_EDGE_ID =  Biome.getIdForBiome(EURO_LAKE_EDGE);
    public static Biome EURO_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes"));
    public static int EURO_LAKES_ID =  Biome.getIdForBiome(EURO_LAKES);
    public static Biome EURO_MACQUIS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_maquis"));
    public static int EURO_MACQUIS_ID =  Biome.getIdForBiome(EURO_MACQUIS);
    public static Biome EURO_FLOODPLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field"));
    public static int EURO_FLOODPLAIN_ID =  Biome.getIdForBiome(EURO_FLOODPLAIN);
    public static Biome EURO_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field_copse"));
    public static int EURO_WOODLAND_ID =  Biome.getIdForBiome(EURO_WOODLAND);

    public static Biome RIFT1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_centre"));
    public static int RIFT1_ID =  Biome.getIdForBiome(RIFT1);
    public static Biome RIFT2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_rift"));
    public static int RIFT2_ID =  Biome.getIdForBiome(RIFT2);

    public static Biome SPRINGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland_springs"));
    public static int DARK_SPRINGS_ID =  Biome.getIdForBiome(SPRINGS);

    public static Biome TETORI = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public static int TETORI_ID =  Biome.getIdForBiome(TETORI);
    public static Biome PHRYGANA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana"));
    public static int PHRYGANA_ID =  Biome.getIdForBiome(PHRYGANA);
    public static Biome PHRYGANA_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana_lake"));
    public static int PHRYGANA_LAKE_ID =  Biome.getIdForBiome(PHRYGANA_LAKE);
    public static Biome BANDED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_banded_desert"));
    public static int BANDED_ID =  Biome.getIdForBiome(BANDED);
    public static Biome DROOPING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_drooping_swamp"));
    public static int DROOPING_ID =  Biome.getIdForBiome(DROOPING);
    public static Biome DROOPING_KNOLL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_drooping_swamp_mound"));
    public static int DROOPING_KNOLL_ID =  Biome.getIdForBiome(DROOPING_KNOLL);
    public static Biome REFUGIUM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_refugium"));
    public static int REFUGIUM_ID =  Biome.getIdForBiome(REFUGIUM);
    public static Biome STEPPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_barren_hills"));
    public static int STEPPE_ID =  Biome.getIdForBiome(STEPPE);

    public static Biome SHRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland"));
    public static int SHRUBLAND_ID =  Biome.getIdForBiome(SHRUBLAND);
    public static Biome DUNES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland_dunes"));
    public static int DUNES_ID =  Biome.getIdForBiome(DUNES);
    public static Biome OASIS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland_oasis"));
    public static int OASIS_ID =  Biome.getIdForBiome(OASIS);

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
                        || aint[i] == N_AMERICA_2_ID
                        || aint[i] == CRETACEOUS_INLAND_SEA_SOUTH_ID
                        || aint[i] == EURO_LAKE_EDGE_ID
                        || aint[i] == EURO_LAKES_ID
                        || aint[i] == RIFT1_ID
                        || aint[i] == RIFT2_ID
                        || aint[i] == DARK_SPRINGS_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    if (aint[i] == N_AMERICA_4_ID) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_NAMERICA_SHRUB_ID;
                    }
                    else if (aint[i] == N_AMERICA_5_ID) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_NAMERICA_COPSE_ID;
                    }
                    else if (isEurope(aint[i])) {
                        if (aint[i] == EURO_FLOODPLAIN_ID) {
                            aint2[i] = CRETACEOUS_FLOODPLAIN_CREEK_EUROPE_ID;
                        }
                        else if (aint[i] == EURO_MACQUIS_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_MACQUIS_ID;
                        }
                        else if (aint[i] == EURO_WOODLAND_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_EUROPE_WOOD_ID;
                        }
                        else {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_EUROPE_ID;
                        }
                    }
                    else if (aint[i] == TICOA_ID) {
                        aint2[i] = TICOA_CREEK_ID;
                    }
                    else if (aint[i] == S_AMERICA_ARID_ID) {
                        aint2[i] = S_AMERICA_ARID_CREEK_ID;
                    }
                    else if (aint[i] == S_AMERICA_DESERT_ID
                    || aint[i] == S_AMERICA_DESERT_SPIKES_ID) {
                        aint2[i] = S_AMERICA_DESERT_CREEK_ID;
                    }
                    else if (aint[i] == S_AMERICA_FLATS_ID) {
                        aint2[i] = S_AMERICA_FLATS_CREEK_ID;
                    }
                    else if (aint[i] == AFRO_SAVANNA_ID || aint[i] == AFRO_SAVANNA_HOLE_ID ||aint[i] == AFRO_SAVANNA_HOLE_CENTRE_ID) {
                        aint2[i] = AFRO_SAVANNA_CREEK_ID;
                    }
                    else if (aint[i] == AFRO_SWAMP_ID || aint[i] == AFRO_SWAMP_OPEN_ID) {
                        aint2[i] = AFRO_SWAMP_CREEK_ID;
                    }
                    else if (isNAmerica(aint[i])) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_NAMERICA_ID;
                    }
                    else if (aint[i] == TETORI_ID) {
                        aint2[i] = TETORI_CREEK_ID;
                    }
                    else if (aint[i] == BANDED_ID) {
                        aint2[i] = BANDED_CREEK_ID;
                    }
                    else if (aint[i] == REFUGIUM_ID || aint[i] == STEPPE_ID) {
                        aint2[i] = REFUGIUM_CREEK_ID;
                    }
                    else if (aint[i] == SHRUBLAND_ID || aint[i] == DUNES_ID || aint[i] == OASIS_ID) {
                        aint2[i] = SHRUBLAND_CREEK_ID;
                    }
                    else if (aint[i] == DROOPING_ID || aint[i] == DROOPING_KNOLL_ID) {
                        aint2[i] = DROOPING_CREEK_ID;
                    }
                    else if (aint[i] == PHRYGANA_ID|| aint[i] == PHRYGANA_LAKE_ID) {
                        aint2[i] = PHRYGANA_CREEK_ID;
                    }
                    else if (isAus(aint[i])) {
                        if (aint[i] == AUS_FOREST_ID || aint[i] == EARLY_CRETACEOUS_AUSTRO_FOREST_FROZEN_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_FOREST_ID;
                        }
                        else if (aint[i] == AUS_PADDOCK_ID || aint[i] == EARLY_CRETACEOUS_AUSTRO_PADDOCK_FROZEN_ID
                                || aint[i] == DIVIDER_ID || aint[i] == LAKE_EDGE_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_PADDOCK_ID;
                        }
                        else if (aint[i] == AUS_BEACH_ID
                            || aint[i] == AUS_LUSH_BEACH_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_BEACH_ID;
                        }
                        else if (aint[i] == AUS_JUNGLE_ID) {
                            aint2[i] = CRETACEOUS_EARLY_CREEK_AUS_JUNGLE_ID;
                        }
                        else if (aint[i] == AUS_CLIFFS_ID) {
                            aint2[i] = AUS_CLIFF_CREEK_ID;
                        }
                        else if (aint[i] == AUS_COAST_ID) {
                            aint2[i] = AUS_BEACH_CREEK_ID;
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
