package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMixCratoAusCoastSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome CRATO_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int CRATO_SWAMP_ID = Biome.getIdForBiome(CRATO_SWAMP);
    public Biome CRATO_SWAMP_LOW = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low"));
    public int CRATO_SWAMP_LOW_ID = Biome.getIdForBiome(CRATO_SWAMP_LOW);

    public Biome AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int AUS_BEACH_ID = Biome.getIdForBiome(AUS_BEACH);

    public Biome TICOA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public int TICOA_ID = Biome.getIdForBiome(TICOA);


    //Creeks to use:
    public Biome CRETACEOUS_EARLY_CREEK_CRATO = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_desert"));
    public int CRETACEOUS_EARLY_CREEK_CRATO_ID = Biome.getIdForBiome(CRETACEOUS_EARLY_CREEK_CRATO);

    public Biome AUS_BEACH_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_coastal"));
    public int AUS_BEACH_CREEK_ID = Biome.getIdForBiome(AUS_BEACH_CREEK);

    public Biome TICOA_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_patagonia"));
    public int TICOA_CREEK_ID = Biome.getIdForBiome(TICOA_CREEK);

    public GenLayerCretaceousEarlyRiverMixCratoAusCoastSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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

                //Add the rivers we want:
                if (aint[i] == CRATO_SWAMP_ID || aint[i] == CRATO_SWAMP_LOW_ID) {
                    aint2[i] = CRETACEOUS_EARLY_CREEK_CRATO_ID;
                }
                else if (aint[i] == AUS_BEACH_ID) {
                    aint2[i] = AUS_BEACH_CREEK_ID;
                }
                else if (aint[i] == TICOA_ID) {
                    aint2[i] = TICOA_CREEK_ID;
                }
                else {
                    aint2[i] = aint[i];
                }
            }
            else {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }

}
