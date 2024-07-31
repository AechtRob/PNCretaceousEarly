package net.pncretaceousearly.world.dimension.cretaceousearly;

import com.google.common.collect.Lists;
import net.lepidodendron.world.biome.cretaceous.BiomeCretaceousEarly;
import net.lepidodendron.world.biome.devonian.BiomeDevonian;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.storage.WorldInfo;
import net.pncretaceousearly.world.biome.cretaceousearly.BiomeEarlyCretaceousOcean;
import net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly.GenLayerCretaceousEarly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BiomeProviderCretaceousEarly extends BiomeProvider {
    public static List<Biome> allowedBiomes = Lists.newArrayList(
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_rainforest")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna_hole")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_flats")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_africa_savanna")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_transition")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_rainforest")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_maquis")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats_stream")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_flats")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_outer")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_sandy_desert")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal_cliffs")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_field_copse")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_namerica_shrubland")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_patagonia")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_pinnacles")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_patagonia")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_samerica_arid")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_europe_maquis")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_peaks")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_austro_antarctic_coastal")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_peaks")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_sandy_desert")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_coastal")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_mountains")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_valley")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes_edge")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_shrubland_copse")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_creek")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_arid_spikes")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_europe_swamp_lakes")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_low")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica_desert_spikes")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_samerica")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_shrubland")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_winter")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_austro_antarctic_subalpine_lakes_rim_inner")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_savanna_hole_centre")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_river")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_south_america_creek_wide_centre")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_namerica_foothills")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_australia_antarctica_paddock_winter")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp_open")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_north_america_braided")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_africa")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_beach_australia_antarctica_inland_sea")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_pacific")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_south_america_desert")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_inland_sea_australia")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_atlantic")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_africa_swamp")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_europe")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_africa_swamp")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_southern")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_australia_antarctica_inland_sea")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean_shore_tethys_europe")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_beach_asia_craggy")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_banded_desert")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_boggy_glades")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_creek_asia_phyrgana")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_banded_desert")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana")),
            Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_asia_phyrgana_lake"))
        );
    public GenLayer genBiomes;
    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    public GenLayer biomeIndexLayer;
    /** The biome list. */
    public final BiomeCache biomeCache;
    public final List<Biome> biomesToSpawnIn;

    protected BiomeProviderCretaceousEarly() {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = Lists.newArrayList(allowedBiomes);
    }

    public BiomeProviderCretaceousEarly(long seed, WorldType worldType, String options) {
        this();
        GenLayer[] agenlayer = GenLayerCretaceousEarly.initializeAllBiomeGenerators(seed, worldType, options);
        agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    public BiomeProviderCretaceousEarly(long seed, WorldInfo info) {
        this(seed, info.getTerrainType(), info.getGeneratorOptions());
    }

    @Override
    public List<Biome> getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }

    @Override
    public Biome getBiome(BlockPos pos, Biome defaultBiome) {
        return this.biomeCache.getBiome(pos.getX(), pos.getZ(), BiomeEarlyCretaceousOcean.biome);
    }

    @Override
    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height)
    {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < width * height)
        {
            biomes = new Biome[width * height];
        }

        int[] aint = this.genBiomes.getInts(x, z, width, height);

        try
        {
            for (int i = 0; i < width * height; ++i)
            {
                biomes[i] = Biome.getBiome(aint[i], Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean")));
            }

            return biomes;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("w", Integer.valueOf(width));
            crashreportcategory.addCrashSection("h", Integer.valueOf(height));
            throw new ReportedException(crashreport);
        }
    }

    @Override
    public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
    {
        IntCache.resetIntCache();

        if (listToReuse == null || listToReuse.length < width * length)
        {
            listToReuse = new Biome[width * length];
        }

        if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0)
        {
            Biome[] abiome = this.biomeCache.getCachedBiomes(x, z);
            System.arraycopy(abiome, 0, listToReuse, 0, width * length);
            return listToReuse;
        }
        else
        {
            int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);

            for (int i = 0; i < width * length; ++i)
            {
                listToReuse[i] = Biome.getBiome(aint[i], Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:cretaceous_early_ocean")));
            }

            return listToReuse;
        }
    }

    @Override
    public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed) {
        IntCache.resetIntCache();
        int i = x - radius >> 2;
        int j = z - radius >> 2;
        int k = x + radius >> 2;
        int l = z + radius >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        try {
            for (int k1 = 0; k1 < i1 * j1; ++k1) {
                Biome biome = Biome.getBiome(aint[k1]);

                if (!allowed.contains(biome)) {
                    return false;
                }
                if (!(biome instanceof BiomeCretaceousEarly)) {
                    return false;
                }
            }

            return true;
        }
        catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    }

    @Override
    @Nullable
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        IntCache.resetIntCache();
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        BlockPos blockpos = null;
        int k1 = 0;
        for (int l1 = 0; l1 < i1 * j1; ++l1) {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            Biome biome = Biome.getBiome(aint[l1]);
            if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0)) {
                blockpos = new BlockPos(i2, 0, j2);
                ++k1;
            }
        }
        return blockpos;
    }

    @Override
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
}