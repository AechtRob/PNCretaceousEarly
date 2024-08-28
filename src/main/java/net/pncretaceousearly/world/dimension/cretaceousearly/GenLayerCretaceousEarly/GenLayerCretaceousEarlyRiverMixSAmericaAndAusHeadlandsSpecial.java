package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMixSAmericaAndAusHeadlandsSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome SAMERICA_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int SAMERICA_LAND_ID = Biome.getIdForBiome(SAMERICA_LAND);

    public Biome AFRICA_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public int AFRICA_LAND_ID = Biome.getIdForBiome(AFRICA_LAND);

    public Biome CRETACEOUS_AUS_COASTAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_AUS_COASTAL_ID = Biome.getIdForBiome(CRETACEOUS_AUS_COASTAL);
    public Biome CRETACEOUS_AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public int CRETACEOUS_AUS_BEACH_ID = Biome.getIdForBiome(CRETACEOUS_AUS_BEACH);
    public Biome CRETACEOUS_AUS_BEACH_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea"));
    public int CRETACEOUS_AUS_BEACH_LUSH_ID = Biome.getIdForBiome(CRETACEOUS_AUS_BEACH_LUSH);

    //Creeks to use:
    public Biome CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide"));
    public int CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE);

    public Biome CRETACEOUS_EARLY_CREEK_SAMERICA_CENTRE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_centre"));
    public int CRETACEOUS_EARLY_CREEK_SAMERICA_CENTRE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_SAMERICA_CENTRE);

    public Biome CRETACEOUS_AUS_HEADLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_cliffs"));
    public int CRETACEOUS_AUS_HEADLANDS_ID = Biome.getIdForBiome(CRETACEOUS_AUS_HEADLANDS);

    public Biome DESERT_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_desert"));
    public int DESERT_CREEK_ID = Biome.getIdForBiome(DESERT_CREEK);
    public Biome ARID_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_arid"));
    public int ARID_CREEK_ID = Biome.getIdForBiome(ARID_CREEK);
    public Biome FLATS_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats"));
    public int FLATS_CREEK_ID = Biome.getIdForBiome(FLATS_CREEK);
    public Biome FLATS_STREAM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats_stream"));
    public int FLATS_STREAM_ID = Biome.getIdForBiome(FLATS_STREAM);
    public Biome PATAGONIA_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_patagonia"));
    public int PATAGONIA_CREEK_ID = Biome.getIdForBiome(PATAGONIA_CREEK);
    public Biome SANDY_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_sandy_desert"));
    public int SANDY_CREEK_ID = Biome.getIdForBiome(SANDY_CREEK);
    public Biome SWAMP_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_africa_swamp"));
    public int SWAMP_CREEK_ID = Biome.getIdForBiome(SWAMP_CREEK);
    public Biome SAVANNA_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_africa_savanna"));
    public int SAVANNA_CREEK_ID = Biome.getIdForBiome(SAVANNA_CREEK);
    public Biome BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_africa"));
    public int BEACH_ID = Biome.getIdForBiome(BEACH);


    public Biome RIFT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_rift"));
    public int RIFT_ID = Biome.getIdForBiome(RIFT);

    public GenLayerCretaceousEarlyRiverMixSAmericaAndAusHeadlandsSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER) || aint1[i] == RIFT_ID)
            {

                //Add the rivers we want:
                if (aint[i] == SAMERICA_LAND_ID || aint[i] == CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID
                        || aint[i] == DESERT_CREEK_ID || aint[i] == ARID_CREEK_ID
                        || aint[i] == FLATS_CREEK_ID || aint[i] == FLATS_STREAM_ID
                        || aint[i] == PATAGONIA_CREEK_ID || aint[i] == SANDY_CREEK_ID
                        || aint[i] == SWAMP_CREEK_ID || aint[i] == SAVANNA_CREEK_ID
                        || aint[i] == BEACH_ID) {
                    if (aint1[i] == RIFT_ID) {
                        aint2[i] = RIFT_ID;
                    }
                    else {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_SAMERICA_CENTRE_ID;
                    }
                }
                else if (aint[i] == CRETACEOUS_AUS_COASTAL_ID
                        || aint[i] == CRETACEOUS_AUS_BEACH_ID
                        || aint[i] == CRETACEOUS_AUS_BEACH_LUSH_ID) {
                    aint2[i] = CRETACEOUS_AUS_HEADLANDS_ID;
                }
                else {
                    aint2[i] = aint[i];
                }
            }
            else if (aint1[i] == CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID && aint[i] == SAMERICA_LAND_ID) {
                aint2[i] = CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID;
            }
            else if (aint1[i] == CRETACEOUS_EARLY_CREEK_SAMERICA_WIDE_ID && aint[i] == AFRICA_LAND_ID) {
                aint2[i] = CRETACEOUS_EARLY_CREEK_SAMERICA_CENTRE_ID;
            }
            else {
                aint2[i] = aint[i];
            }
            
        }

        return aint2;
    }

}
