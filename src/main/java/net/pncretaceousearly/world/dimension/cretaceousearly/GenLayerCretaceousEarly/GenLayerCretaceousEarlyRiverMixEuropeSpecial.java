package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMixEuropeSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome EUROPE_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int EUROPE_SWAMP_ID = Biome.getIdForBiome(EUROPE_SWAMP);

    public Biome NAMERICA_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public int NAMERICA_SWAMP_ID = Biome.getIdForBiome(NAMERICA_SWAMP);

    //Creeks to use:
    public Biome CRETACEOUS_EARLY_CREEK_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys_europe"));
    public int CRETACEOUS_EARLY_CREEK_EUROPE_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_EUROPE);

    public Biome CRETACEOUS_EARLY_CREEK_NAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_north_america_braided"));
    public int CRETACEOUS_EARLY_CREEK_NAMERICA_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_NAMERICA);

    //Biomes to exclude for rivers:
    public Biome CRETACEOUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN);
    public Biome CRETACEOUS_OCEAN_SHORE_ATLANTIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic"));
    public int CRETACEOUS_OCEAN_SHORE_ATLANTIC_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_ATLANTIC);
    public Biome CRETACEOUS_OCEAN_SHORE_SOUTHERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern"));
    public int CRETACEOUS_OCEAN_SHORE_SOUTHERN_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_SOUTHERN);
    public Biome CRETACEOUS_OCEAN_SHORE_PACIFIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific"));
    public int CRETACEOUS_OCEAN_SHORE_PACIFIC_ID =  Biome.getIdForBiome(CRETACEOUS_OCEAN_SHORE_PACIFIC);
    public Biome CRETACEOUS_INLAND_SEA_SOUTH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_australia"));
    public int CRETACEOUS_INLAND_SEA_SOUTH_ID =  Biome.getIdForBiome(CRETACEOUS_INLAND_SEA_SOUTH);


    public GenLayerCretaceousEarlyRiverMixEuropeSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_ATLANTIC_ID
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_SOUTHERN_ID
                        || aint[i] == CRETACEOUS_OCEAN_SHORE_PACIFIC_ID
                        || aint[i] == CRETACEOUS_INLAND_SEA_SOUTH_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    if (aint[i] == EUROPE_SWAMP_ID) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_EUROPE_ID;
                    }
                    else if (aint[i] == NAMERICA_SWAMP_ID) {
                        aint2[i] = CRETACEOUS_EARLY_CREEK_NAMERICA_ID;
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

}
