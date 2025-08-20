package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverMixAusHeadlandsSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome CRETACEOUS_AUS_COASTAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_AUS_COASTAL_ID = Biome.getIdForBiome(CRETACEOUS_AUS_COASTAL);
    public Biome CRETACEOUS_AUS_COASTAL_DUNES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_dunes"));
    public int CRETACEOUS_AUS_COASTAL_DUNES_ID = Biome.getIdForBiome(CRETACEOUS_AUS_COASTAL_DUNES);
    public Biome CRETACEOUS_AUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica"));
    public int CRETACEOUS_AUS_BEACH_ID = Biome.getIdForBiome(CRETACEOUS_AUS_BEACH);
    public Biome CRETACEOUS_AUS_BEACH_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea"));
    public int CRETACEOUS_AUS_BEACH_LUSH_ID = Biome.getIdForBiome(CRETACEOUS_AUS_BEACH_LUSH);
    public Biome CRETACEOUS_AUS_BEACH_MUDDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_muddy"));
    public int CRETACEOUS_AUS_BEACH_MUDDY_ID = Biome.getIdForBiome(CRETACEOUS_AUS_BEACH_MUDDY);

    public Biome CRETACEOUS_AUS_HEADLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_cliffs"));
    public int CRETACEOUS_AUS_HEADLANDS_ID = Biome.getIdForBiome(CRETACEOUS_AUS_HEADLANDS);
    public Biome CRETACEOUS_AUS_HEADLANDS_NOROOST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_cliffs_noroost"));
    public int CRETACEOUS_AUS_HEADLANDS_NOROOST_ID = Biome.getIdForBiome(CRETACEOUS_AUS_HEADLANDS_NOROOST);


    public GenLayerCretaceousEarlyRiverMixAusHeadlandsSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
                if (aint[i] == CRETACEOUS_AUS_COASTAL_ID
                        || aint[i] == CRETACEOUS_AUS_BEACH_ID
                        || aint[i] == CRETACEOUS_AUS_BEACH_MUDDY_ID
                        || aint[i] == CRETACEOUS_AUS_BEACH_LUSH_ID
                        || aint[i] == CRETACEOUS_AUS_COASTAL_DUNES_ID) {
                    if (nextInt(5) == 0) {
                        aint2[i] = CRETACEOUS_AUS_HEADLANDS_ID;
                    }
                    else {
                        aint2[i] = CRETACEOUS_AUS_HEADLANDS_NOROOST_ID;
                    }
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
