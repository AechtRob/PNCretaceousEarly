package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import javax.security.auth.login.CredentialException;

public class GenLayerAustroAntarcticCrater extends GenLayer
{

    public Biome CRATERABLE_1 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock"));
    public int CRATERABLE_1_ID =  Biome.getIdForBiome(CRATERABLE_1);
    public Biome CRATERABLE_2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_winter"));
    public int CRATERABLE_2_ID =  Biome.getIdForBiome(CRATERABLE_2);
//    public Biome CRATERABLE_3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_lakes_edge"));
//    public int CRATERABLE_3_ID =  Biome.getIdForBiome(CRATERABLE_3);
//    public Biome CRATERABLE_4 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_lakes"));
//    public int CRATERABLE_4_ID =  Biome.getIdForBiome(CRATERABLE_4);
    public Biome CRATERABLE_5 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_divider"));
    public int CRATERABLE_5_ID =  Biome.getIdForBiome(CRATERABLE_5);
    public Biome CRATERABLE_6 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock_winter"));
    public int CRATERABLE_6_ID =  Biome.getIdForBiome(CRATERABLE_6);
    public Biome CRATERABLE_7 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int CRATERABLE_7_ID =  Biome.getIdForBiome(CRATERABLE_7);

    public Biome CRATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_crater"));
    public int CRATER_ID =  Biome.getIdForBiome(CRATER);

    public GenLayerAustroAntarcticCrater(long seed, GenLayer genLayer)
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
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                Biome biome = Biome.getBiome(k);

                if (isCraterable(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isCraterable(l1) && isCraterable(k2) && isCraterable(j3) && isCraterable(i4))
                    {
                        if (k == CRATERABLE_1_ID) {
                            aint1[j + i * areaWidth] = Crater1[nextInt(Crater1.length)];
                        }
                        else if (k == CRATERABLE_2_ID) {
                            aint1[j + i * areaWidth] = Crater2[nextInt(Crater2.length)];
                        }
//                        else if (k == CRATERABLE_3_ID) {
//                            aint1[j + i * areaWidth] = Crater3[nextInt(Crater3.length)];
//                        }
//                        else if (k == CRATERABLE_4_ID) {
//                            aint1[j + i * areaWidth] = Crater4[nextInt(Crater4.length)];
//                        }
                        else if (k == CRATERABLE_5_ID) {
                            aint1[j + i * areaWidth] = Crater5[nextInt(Crater5.length)];
                        }
                        else if (k == CRATERABLE_6_ID) {
                            aint1[j + i * areaWidth] = Crater6[nextInt(Crater6.length)];
                        }
                        else if (k == CRATERABLE_7_ID) {
                            aint1[j + i * areaWidth] = Crater1[nextInt(Crater7.length)];
                        }
                        else
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isCraterable(int biomeID) {
        if (biomeID == CRATERABLE_1_ID
                || biomeID == CRATERABLE_2_ID
//                || biomeID == CRATERABLE_3_ID
//                || biomeID == CRATERABLE_4_ID
                || biomeID == CRATERABLE_5_ID
                || biomeID == CRATERABLE_6_ID
                || biomeID == CRATERABLE_7_ID) {
            return true;
        }
        return false;
    }
    
    private final int Crater1[] = new int[] {
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATERABLE_1_ID,
            CRATER_ID
    };

    private final int Crater2[] = new int[] {
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATERABLE_2_ID,
            CRATER_ID
    };

//    private final int Crater3[] = new int[] {
//            CRATERABLE_3_ID,
//            CRATERABLE_3_ID,
//            CRATERABLE_3_ID,
//            CRATERABLE_3_ID,
//            CRATERABLE_3_ID,
//            CRATERABLE_3_ID,
//            CRATERABLE_3_ID,
//            CRATER_ID
//    };
//
//    private final int Crater4[] = new int[] {
//            CRATERABLE_4_ID,
//            CRATERABLE_4_ID,
//            CRATERABLE_4_ID,
//            CRATERABLE_4_ID,
//            CRATERABLE_4_ID,
//            CRATERABLE_4_ID,
//            CRATERABLE_4_ID,
//            CRATER_ID
//    };

    private final int Crater5[] = new int[] {
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATERABLE_5_ID,
            CRATER_ID
    };

    private final int Crater6[] = new int[] {
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATERABLE_6_ID,
            CRATER_ID
    };

    private final int Crater7[] = new int[] {
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATERABLE_7_ID,
            CRATER_ID
    };

}
