package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeDictionary;

public class GenLayerCretaceousDiversifyNAmerica extends GenLayer
{

    public Biome CRETACEOUS_EARLY_NAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica"));
    public int CRETACEOUS_EARLY_NAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_NAMERICA);
    public Biome CRETACEOUS_EARLY_NAMERICA_LAGOONS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_lagoons"));
    public int CRETACEOUS_EARLY_NAMERICA_LAGOONS_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_NAMERICA_LAGOONS);

    public GenLayerCretaceousDiversifyNAmerica(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AmericaBiomes[] = new int[] {
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_NAMERICA_ID,
            CRETACEOUS_EARLY_NAMERICA_LAGOONS_ID
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

                if (k == CRETACEOUS_EARLY_NAMERICA_ID)
                {
                    aint1[j + i * areaWidth] = AmericaBiomes[nextInt(AmericaBiomes.length)];
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

}
