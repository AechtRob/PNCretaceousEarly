package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandEurope;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousOceanCrags;

public class GenLayerCretaceousDiversifyOceanCrags extends GenLayer
{

    public Biome CRAG = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_crags"));
    public int CRAG_ID =  Biome.getIdForBiome(CRAG);
    public Biome CRAG_NOROOST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_crags_noroost"));
    public int CRAG_NOROOST_ID =  Biome.getIdForBiome(CRAG_NOROOST);

    public GenLayerCretaceousDiversifyOceanCrags(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int CragBiomes[] = new int[] {
            CRAG_NOROOST_ID,
            CRAG_NOROOST_ID,
            CRAG_NOROOST_ID,
            CRAG_NOROOST_ID,
            CRAG_ID
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

                if (Biome.getBiome(k) == BiomeEarlyCretaceousOceanCrags.biome) {
                    aint1[j + i * areaWidth] = CragBiomes[nextInt(CragBiomes.length)];
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

}
