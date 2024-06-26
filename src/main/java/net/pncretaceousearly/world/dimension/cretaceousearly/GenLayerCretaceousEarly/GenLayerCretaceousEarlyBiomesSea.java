package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyBiomesSea extends GenLayer {

    public Biome CRETACEOUS_EARLY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_EARLY_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY);

    public GenLayerCretaceousEarlyBiomesSea(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        int dest[] = IntCache.getIntCache(width * height);
        for (int dz = 0; dz < height; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = CRETACEOUS_EARLY_ID;
            }
        }
        return dest;
    }
}