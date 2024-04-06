package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyBiomes extends GenLayer {

    public Biome CRETACEOUS_EARLY_SOUTH_AMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america"));
    public int CRETACEOUS_EARLY_SOUTH_AMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_SOUTH_AMERICA);
    public Biome CRETACEOUS_EARLY_NORTH_AMERICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_north_america"));
    public int CRETACEOUS_EARLY_NORTH_AMERICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_NORTH_AMERICA);
    public Biome CRETACEOUS_EARLY_ASIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia"));
    public int CRETACEOUS_EARLY_ASIA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_ASIA);
    public Biome CRETACEOUS_EARLY_EUROPE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe"));
    public int CRETACEOUS_EARLY_EUROPE_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_EUROPE);
    public Biome CRETACEOUS_EARLY_AFRICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa"));
    public int CRETACEOUS_EARLY_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AFRICA);
    public Biome CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica"));
    public int CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA);

    private final int CretaceousEarlyBiomes[] = new int[] {
           CRETACEOUS_EARLY_SOUTH_AMERICA_ID,
            CRETACEOUS_EARLY_NORTH_AMERICA_ID,
            CRETACEOUS_EARLY_ASIA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            CRETACEOUS_EARLY_AFRICA_ID,
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID
    };

    public GenLayerCretaceousEarlyBiomes(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        int dest[] = IntCache.getIntCache(width * height);
        for (int dz = 0; dz < height; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = CretaceousEarlyBiomes[nextInt(CretaceousEarlyBiomes.length)];
            }
        }
        return dest;
    }
}