package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMixAfricaSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome AFRO_BROWNSTONE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public int AFRO_BROWNSTONE_ID = Biome.getIdForBiome(AFRO_BROWNSTONE);

    public Biome AFRO_VALLEYS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_valley"));
    public int AFRO_VALLEYS_ID = Biome.getIdForBiome(AFRO_VALLEYS);


    public GenLayerCretaceousEarlyRiverMixAfricaSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
                if (aint[i] == AFRO_BROWNSTONE_ID) {
                    aint2[i] = AFRO_VALLEYS_ID;
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
