package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAfricaSavannaHoles2 extends GenLayer
{

    public static Biome AFRO_HOLE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna_hole"));
    public static int AFRO_HOLE_ID =  Biome.getIdForBiome(AFRO_HOLE);

    public static Biome AFRO_HOLE_CENTER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna_hole_centre"));
    public static int AFRO_HOLE_CENTER_ID =  Biome.getIdForBiome(AFRO_HOLE_CENTER);


    public GenLayerAfricaSavannaHoles2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

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

                if (k == AFRO_HOLE_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        (l1 == AFRO_HOLE_ID || l1 == AFRO_HOLE_CENTER_ID)
                        && (k2 == AFRO_HOLE_ID || k2 == AFRO_HOLE_CENTER_ID)
                        && (j3 == AFRO_HOLE_ID || j3 == AFRO_HOLE_CENTER_ID)
                        && (i4 == AFRO_HOLE_ID || i4 == AFRO_HOLE_CENTER_ID)
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = AFRO_HOLE_CENTER_ID;
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
    
}
