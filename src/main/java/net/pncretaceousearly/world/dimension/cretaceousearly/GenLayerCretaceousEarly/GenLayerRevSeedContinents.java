package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRevSeedContinents extends GenLayer {

    public Biome CRETACEOUS_EARLY_ASIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public int CRETACEOUS_EARLY_ASIA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ASIA);
    public Biome CRETACEOUS_EARLY_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int CRETACEOUS_EARLY_EUROPE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_EUROPE);
    public Biome CRETACEOUS_EARLY_SAMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int CRETACEOUS_EARLY_SAMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SAMERICA);
    public Biome CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal"));
    public int CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA);


    private final int[] SeedBiomes = new int[] {
            CRETACEOUS_EARLY_ASIA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            CRETACEOUS_EARLY_SAMERICA_ID,
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_COASTAL_ID
    };

    public GenLayerRevSeedContinents(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        int dest[] = IntCache.getIntCache(width * height);
        for (int dz = 0; dz < height; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = SeedBiomes[nextInt(SeedBiomes.length)];
            }
        }
        return dest;
    }
}