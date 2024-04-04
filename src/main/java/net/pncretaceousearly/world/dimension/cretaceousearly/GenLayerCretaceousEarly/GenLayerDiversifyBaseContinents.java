package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.lepidodendron.util.EnumBiomeTypeCretaceousEarly;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDiversifyBaseContinents extends GenLayer
{

    public Biome CRETACEOUS_EARLY_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean"));
    public int CRETACEOUS_EARLY_OCEAN_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_OCEAN);

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
    public Biome CRETACEOUS_EARLY_INDIA_MADAGASCAR = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_india_madagascar"));
    public int CRETACEOUS_EARLY_INDIA_MADAGASCAR_ID =  Biome.getIdForBiome(CRETACEOUS_EARLY_INDIA_MADAGASCAR);


    public GenLayerDiversifyBaseContinents(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int CretaceousEarlyBiomes[] = new int[] {
            CRETACEOUS_EARLY_SOUTH_AMERICA_ID,
            CRETACEOUS_EARLY_NORTH_AMERICA_ID,
            CRETACEOUS_EARLY_ASIA_ID,
            CRETACEOUS_EARLY_EUROPE_ID,
            CRETACEOUS_EARLY_AFRICA_ID,
            CRETACEOUS_EARLY_AUSTRALIA_ANTARCTICA_AFRICA_ID,
            CRETACEOUS_EARLY_INDIA_MADAGASCAR_ID
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


                if (k == CRETACEOUS_EARLY_OCEAN_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (
                        l1 == CRETACEOUS_EARLY_OCEAN_ID
                        && k2 == CRETACEOUS_EARLY_OCEAN_ID
                        && j3 == CRETACEOUS_EARLY_OCEAN_ID
                        && i4 == CRETACEOUS_EARLY_OCEAN_ID
                        )
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = CretaceousEarlyBiomes[nextInt(CretaceousEarlyBiomes.length)];
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
