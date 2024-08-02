package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeDictionary;

public class GenLayerAsiaInlandReplaceScrub extends GenLayer
{

    public static Biome ASIA_DROOPING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_drooping_swamp"));
    public static int ASIA_DROOPING_ID =  Biome.getIdForBiome(ASIA_DROOPING);
    public static Biome ASIA_CENTRAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_barren_hills"));
    public static int ASIA_CENTRAL_ID =  Biome.getIdForBiome(ASIA_CENTRAL);

    public static Biome ASIA_SHRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_shrubland"));
    public static int ASIA_SHRUBLAND_ID =  Biome.getIdForBiome(ASIA_SHRUBLAND);
    public static Biome ASIA_BANDED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_banded_desert"));
    public static int ASIA_BANDED_ID =  Biome.getIdForBiome(ASIA_BANDED);

    public static Biome PHRYGANA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana"));
    public static int PHRYGANA_ID =  Biome.getIdForBiome(PHRYGANA);
    public static Biome PHRYGANA_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana_lake"));
    public static int PHRYGANA_LAKES_ID =  Biome.getIdForBiome(PHRYGANA_LAKES);

    public static Biome ASIA_REFUGIUM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_refugium"));
    public static int ASIA_REFUGIUM_ID =  Biome.getIdForBiome(ASIA_REFUGIUM);


    public GenLayerAsiaInlandReplaceScrub(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int AsiaInlandBiomes[] = new int[] {
            ASIA_DROOPING_ID,
            ASIA_CENTRAL_ID
    };

    private final int AsiaInlandBiomes2[] = new int[] {
            ASIA_SHRUBLAND_ID,
            ASIA_BANDED_ID,
            ASIA_SHRUBLAND_ID,
            ASIA_BANDED_ID,
            ASIA_REFUGIUM_ID
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

                if (toReplace(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        !(
                                isCoastal(l1)
                                || isCoastal(k2)
                                || isCoastal(j3)
                                || isCoastal(i4)
                        )
                    );
                    if (flag)
                    {
                        int b = AsiaInlandBiomes[nextInt(AsiaInlandBiomes.length)];
                        if (b == ASIA_CENTRAL_ID) {
                            aint1[j + i * areaWidth] = AsiaInlandBiomes2[nextInt(AsiaInlandBiomes2.length)];
                        }
                        else {
                            aint1[j + i * areaWidth] = b;
                        }
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
        return i == PHRYGANA_ID
                || i == PHRYGANA_LAKES_ID;
    }

    public static boolean isCoastal(int i) {
        Biome biome = Biome.getBiome(i);
        return (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN));
    }
    
}
