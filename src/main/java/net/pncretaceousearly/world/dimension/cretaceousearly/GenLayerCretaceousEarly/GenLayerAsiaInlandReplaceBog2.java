package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeDictionary;

public class GenLayerAsiaInlandReplaceBog2 extends GenLayer
{

    public static Biome ASIA_DROOPING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_drooping_swamp"));
    public static int ASIA_DROOPING_ID =  Biome.getIdForBiome(ASIA_DROOPING);
    public static Biome ASIA_CENTRAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_barren_hills"));
    public static int ASIA_CENTRAL_ID =  Biome.getIdForBiome(ASIA_CENTRAL);
    public static Biome ASIA_YIXIAN_HIGHLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_highland"));
    public static int ASIA_YIXIAN_HIGHLAND_ID =  Biome.getIdForBiome(ASIA_YIXIAN_HIGHLAND);

    public static Biome ASIA_SHRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland"));
    public static int ASIA_SHRUBLAND_ID =  Biome.getIdForBiome(ASIA_SHRUBLAND);
    public static Biome ASIA_BANDED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_banded_desert"));
    public static int ASIA_BANDED_ID =  Biome.getIdForBiome(ASIA_BANDED);

    public static Biome BOG = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public static int BOG_ID =  Biome.getIdForBiome(BOG);

    public static Biome ASIA_REFUGIUM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_refugium"));
    public static int ASIA_REFUGIUM_ID =  Biome.getIdForBiome(ASIA_REFUGIUM);

    public static Biome ASIA_YIXIAN_LAKES_A = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_a"));
    public static int ASIA_YIXIAN_LAKES_A_ID =  Biome.getIdForBiome(ASIA_YIXIAN_LAKES_A);
    public static Biome ASIA_YIXIAN_LAKES_B = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_yixian_lakes_b"));
    public static int ASIA_YIXIAN_LAKES_B_ID =  Biome.getIdForBiome(ASIA_YIXIAN_LAKES_B);

    public GenLayerAsiaInlandReplaceBog2(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AsiaInlandBiomes[] = new int[] {
//            ASIA_DROOPING_ID,
//            ASIA_CENTRAL_ID,
            BOG_ID//,
//            ASIA_YIXIAN_HIGHLAND_ID
    };

//    private final int AsiaInlandBiomes2[] = new int[] {
//            ASIA_SHRUBLAND_ID,
//            ASIA_BANDED_ID,
//            ASIA_SHRUBLAND_ID,
//            ASIA_BANDED_ID,
//            ASIA_REFUGIUM_ID
//    };
//
//    private final int AsiaInlandBiomes3[] = new int[] {
//            ASIA_YIXIAN_LAKES_A_ID,
//            ASIA_YIXIAN_LAKES_B_ID
//    };

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

                if (isCoastal(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = ((
                            toReplace(l1)
                                || toReplace(k2)
                                || toReplace(j3)
                                || toReplace(i4)
                        )
                    );
                    if (flag)
                    {
//                        int b = AsiaInlandBiomes[nextInt(AsiaInlandBiomes.length)];
//                        if (b == ASIA_CENTRAL_ID) {
//                            aint1[j + i * areaWidth] = AsiaInlandBiomes2[nextInt(AsiaInlandBiomes2.length)];
//                        }
//                        else if (b == ASIA_YIXIAN_HIGHLAND_ID) {
//                            aint1[j + i * areaWidth] = AsiaInlandBiomes3[nextInt(AsiaInlandBiomes3.length)];
//                        }
//                        else {
                            aint1[j + i * areaWidth] = BOG_ID;
//                        }
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

    public static boolean toReplace(int i) {

        return i == ASIA_DROOPING_ID
                || i == ASIA_CENTRAL_ID
                || i == ASIA_SHRUBLAND_ID
                || i == ASIA_BANDED_ID
                || i == ASIA_REFUGIUM_ID;
    }

    public static boolean isCoastal(int i) {
        Biome biome = Biome.getBiome(i);
        return (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN));
    }
    
}
