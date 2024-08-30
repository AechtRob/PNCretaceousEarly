package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCretaceousEarlyRiverBorderRift extends GenLayer
{

    public Biome RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_centre"));
    public int RIVER_ID = Biome.getIdForBiome(RIVER);

    public Biome SAMERICA_ARID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid"));
    public int SAMERICA_ARID_ID =  Biome.getIdForBiome(SAMERICA_ARID);
    public Biome SAMERICA_ARID_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid_spikes"));
    public int SAMERICA_ARID_SPIKES_ID =  Biome.getIdForBiome(SAMERICA_ARID_SPIKES);
    public Biome SAMERICA_DESERT_LOW = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low"));
    public int SAMERICA_DESERT_LOW_ID =  Biome.getIdForBiome(SAMERICA_DESERT_LOW);
    public Biome SAMERICA_DESERT_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_spikes"));
    public int SAMERICA_DESERT_SPIKES_ID =  Biome.getIdForBiome(SAMERICA_DESERT_SPIKES);
    public Biome SAMERICA_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats"));
    public int SAMERICA_FLATS_ID =  Biome.getIdForBiome(SAMERICA_FLATS);
    public Biome SAMERICA_PATAGONIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia"));
    public int SAMERICA_PATAGONIA_ID =  Biome.getIdForBiome(SAMERICA_PATAGONIA);
    public Biome SAMERICA_DESERT_SAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert"));
    public int SAMERICA_DESERT_SAND_ID =  Biome.getIdForBiome(SAMERICA_DESERT_SAND);
    public Biome SAMERICA_DESERT_SAND_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert_spikes"));
    public int SAMERICA_DESERT_SAND_SPIKES_ID =  Biome.getIdForBiome(SAMERICA_DESERT_SAND_SPIKES);
    public Biome SAMERICA_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica"));
    public int SAMERICA_DESERT_ID =  Biome.getIdForBiome(SAMERICA_DESERT);

    public GenLayerCretaceousEarlyRiverBorderRift(long seed, GenLayer genLayer)
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

                if (isAfrican(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((isSouthAmerican(l1))
                        || (isSouthAmerican(k2))
                        || (isSouthAmerican(j3))
                        || (isSouthAmerican(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = RIVER_ID;
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

    private boolean isAfrican(int biomeID) {
        Biome biome = Biome.getBiome(biomeID);
        if (biome instanceof BiomeCretaceousEarly) {
            BiomeCretaceousEarly biomeC = (BiomeCretaceousEarly) biome;
            return (!isSouthAmerican(biomeID)) && biomeC.getBiomeType() == EnumBiomeTypeCretaceousEarly.Early_Cretaceous_Afro_America;
        }
        return false;
    }

    private boolean isSouthAmerican(int biomeID) {
        if (biomeID == SAMERICA_ARID_ID
                || biomeID == SAMERICA_PATAGONIA_ID
                || biomeID == SAMERICA_ARID_SPIKES_ID
                || biomeID == SAMERICA_DESERT_LOW_ID
                || biomeID == SAMERICA_DESERT_SAND_ID
                || biomeID == SAMERICA_DESERT_SPIKES_ID
                || biomeID == SAMERICA_DESERT_SAND_SPIKES_ID
                || biomeID == SAMERICA_FLATS_ID
                || biomeID == SAMERICA_DESERT_ID) {
            return true;
        }
        return false;
    }

}
