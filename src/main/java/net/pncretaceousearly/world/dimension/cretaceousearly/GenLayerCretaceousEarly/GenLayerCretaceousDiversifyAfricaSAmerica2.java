package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandAfricaSwampFlat;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousLandSAmerica;

public class GenLayerCretaceousDiversifyAfricaSAmerica2 extends GenLayer {

    public Biome CRETACEOUS_EARLY_AFRICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public int CRETACEOUS_EARLY_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AFRICA);
    public Biome CRETACEOUS_EARLY_AFRICA_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp"));
    public int CRETACEOUS_EARLY_AFRICA_SWAMP_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AFRICA_SWAMP);
    public Biome CRETACEOUS_EARLY_AFRICA_SWAMP_OPEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp_open"));
    public int CRETACEOUS_EARLY_AFRICA_SWAMP_OPEN_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AFRICA_SWAMP_OPEN);

    public Biome CRETACEOUS_EARLY_SAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int CRETACEOUS_EARLY_SAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA);
    public Biome CRETACEOUS_EARLY_SAMERICA_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public int CRETACEOUS_EARLY_SAMERICA_FOREST_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA_FOREST);
    public Biome CRETACEOUS_EARLY_SAMERICA_ARID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public int CRETACEOUS_EARLY_SAMERICA_ARID_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA_ARID);
    public Biome CRETACEOUS_EARLY_SAMERICA_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public int CRETACEOUS_EARLY_SAMERICA_DESERT_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA_DESERT);
    public Biome CRETACEOUS_EARLY_SAMERICA_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public int CRETACEOUS_EARLY_SAMERICA_FLAT_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA_FLAT);


    private final int[] AfricaBiomes = new int[] {
            CRETACEOUS_EARLY_AFRICA_SWAMP_ID,
            CRETACEOUS_EARLY_AFRICA_SWAMP_ID,
            CRETACEOUS_EARLY_AFRICA_SWAMP_OPEN_ID
    };

    private final int[] SAmericaBiomes = new int[] {
            CRETACEOUS_EARLY_SAMERICA_ID,
            CRETACEOUS_EARLY_SAMERICA_FOREST_ID,
            CRETACEOUS_EARLY_SAMERICA_ARID_ID,
            CRETACEOUS_EARLY_SAMERICA_DESERT_ID,
            CRETACEOUS_EARLY_SAMERICA_FLAT_ID
    };

    public GenLayerCretaceousDiversifyAfricaSAmerica2(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int[] input = this.parent.getInts(x, z, width, height);
        int[] output = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (Biome.getBiome(center) == BiomeEarlyCretaceousLandAfricaSwampFlat.biome) {
                    output[i] = AfricaBiomes[nextInt(AfricaBiomes.length)];
                }
                else if (Biome.getBiome(center) == BiomeEarlyCretaceousLandSAmerica.biome) {
                    output[i] = SAmericaBiomes[nextInt(SAmericaBiomes.length)];
                }
                else output[i] = center;
            }
        }
        return output;
    }

}