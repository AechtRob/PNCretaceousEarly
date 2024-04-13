package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

import java.util.Random;

public class GenLayerCretaceousEarly {

    private static boolean shouldDraw = false;
    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerCretaceousEarlyBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        biomes = new GenLayerFuzzyZoom(2001L, biomes);

        biomes = new GenLayerZoom(1032L, biomes);

        biomes = new GenLayerCretaceousEarlyBiomesDiversifyEuropeAndAfrica(2541L, biomes);
        biomes = new GenLayerCretaceousDiversifyAustroAntarctica(2542L, biomes);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerSeperateContinents(378L, biomes);
        biomes = new GenLayerAddInlandSeas(3048L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerAddShallowSea(4132L, biomes);
        biomes = new GenLayerAddInlandSeas2(3049L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerAddShallowSea2(1201L, biomes);
        biomes = new GenLayerAddInlandSeas2(3046L, biomes);

        biomes = new GenLayerCretaceousDiversifyEuroAmerica(2641L, biomes);

//        biomes = new GenLayerAddHillsToRedwood(1001L, biomes);
//
//        biomes = new GenLayerDiversifyJurassic2(1002L, biomes);
//        biomes = new GenLayerDiversifyJurassicMudflats(1134L, biomes);
//        biomes = new GenLayerJurassicDeepOcean(1100L, biomes);
//        biomes = new GenLayerJurassicShallowOcean(1300L, biomes);
//        biomes = new GenLayerJurassicOutcropHighlands(1075L, biomes);
//
//        biomes = new GenLayerJurassicEstuary2(1000L, biomes);
//
//        biomes = new GenLayerJurassicGlassSpongeReef(1985L, biomes);
//        biomes = new GenLayerDiversifyJurassic2point5(1009L, biomes);
//        biomes = new GenLayerJurassicRafts(1429L, biomes);

        if ((new Random(seed)).nextInt(8) == 0) {
             biomes = new GenLayerZoom(109L, biomes);
        }
//        biomes = new GenLayerAddInlandSeaBorder(8563L, biomes);
//        biomes = new GenLayerAddShallowSea2(1202L, biomes);

//        biomes = new GenLayerJurassicEstuary2(1000L, biomes);
//
//        biomes = new GenLayerJurassicIslands2(1333L, biomes);
//
//        biomes = new GenLayerDiversifyJurassicMudflats(1135L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);
//        biomes = new GenLayerJurassicOutcrop(1088L, biomes);
//        biomes = new GenLayerJurassicCoral(439L, biomes);
//        biomes = new GenLayerJurassicIslandLargeInterior(143L, biomes);
//        biomes = new GenLayerDesertTransitionDesertSide(144L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerAddInlandSeaBorder(8563L, biomes);
        biomes = new GenLayerNorthAmericaMountains0(1551L, biomes);


//        biomes = new GenLayerAddMountainsToRedwoodRare(1001L, biomes);
//        biomes = new GenLayerJurassicIslands2(1333L, biomes);
//
//        biomes = new GenLayerJurassicEstuary2(1000L, biomes);
//
//        biomes = new GenLayerJurassicOutcropBlend(1088L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerCretaceousEarlyEuropeIslandify(325L, biomes);
//        biomes = new GenLayerJurassicBoulders(1066L, biomes);
//        biomes = new GenLayerDiversifyJurassic3(1001L, biomes);
//        biomes = new GenLayerSeperateIslands(1555L, biomes);
//        biomes = new GenLayerJurassicDesertIslands(1563L, biomes);

        biomes = new GenLayerFuzzyZoom(1000L, biomes);
        biomes = new GenLayerNorthAmericaMountains1(2551L, biomes);
        //biomes = new GenLayerAddInlandSeaBorder(8563L, biomes);

//        biomes = new GenLayerAddMountainsToRedwood(1001L, biomes);
//        biomes = new GenLayerRandomiseRedwood(1001L, biomes);
//
//        biomes = new GenLayerJurassicBoulders(1067L, biomes);
        biomes = new GenLayerCretaceousEarlyBeach(1050L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes0(742L, biomes);
//        biomes = new GenLayerJurassicOutcropBlend2(333L, biomes);
//        biomes = new GenLayerDiversifyJurassicMudflats(1136L, biomes);
        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes1(242L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes2(249L, biomes);

        biomes = new GenLayerFuzzyZoom(1001L, biomes);

//        biomes = new GenLayerJurassicDesertRim(1032L, biomes);
//
//        biomes = new GenLayerSeperateIslands(1655L, biomes);
//
//        biomes = new GenLayerDiversifyJurassicMudflats(1137L, biomes);

        biomes = new GenLayerSmooth(706L, biomes);
        //biomes = new GenLayerCretaceousEarlyEuropeIslandify(325L, biomes);
//        biomes = new GenLayerJurassicRiverBanks(225L, biomes);
//        biomes = new GenLayerJurassicLakeShore(625L, biomes);
//        biomes = new GenLayerJoinRiversJurassic(150L, biomes);
//        biomes = new GenLayerJoinRiversJurassic(151L, biomes);
//        biomes = new GenLayerJoinRiversJurassic(152L, biomes);

//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);
//
//        biomes = new GenLayerJurassicTaigaBasalt(1975L, biomes);
//
//        biomes = new GenLayerJurassicDesertRimFromDesert(1302L, biomes);
//        biomes = new GenLayerJurassicDesertRimFromHills(1203L, biomes);
        biomes = new GenLayerFuzzyZoom(1002L, biomes);
        biomes = new GenLayerNorthAmericaMountains2(3551L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes1(642L, biomes);


        //biomes = new GenLayerJurassicDesertRimFromDesert(1302L, biomes);

//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);
//
//        biomes = new GenLayerDiversifyJurassicMudflats(1138L, biomes);
//        biomes = new GenLayerJurassicRiverBorder(326L, biomes);
//        biomes = new GenLayerJurassicRiverBorderMudflats(326L, biomes);
//        biomes = new GenLayerJurassicRiverBorderMire(328L, biomes);

//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);
//
//        biomes = new GenLayerJurassicRiverBanks(226L, biomes);
        biomes = new GenLayerSmooth(719L, biomes); //ADDED THIS
//        biomes = new GenLayerJoinRiversJurassic(153L, biomes);
//        biomes = new GenLayerJoinRiversJurassic(154L, biomes);
//        biomes = new GenLayerJoinRiversJurassic(155L, biomes);
//        biomes = new GenLayerJoinRiversJurassic(156L, biomes);
//        biomes = new GenLayerJurassicRiverBanks(227L, biomes);
//        biomes = new GenLayerJurassicTaigaBasalt(1976L, biomes);
//        biomes = new GenLayerJurassicRoosts(1000L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);

//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
//        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);

        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 2);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 1);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerCretaceousEarlyRiverMix(100L, biomes, genlayercreek7);

        //GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayercreekfinal);

        //Additional waterways in Europe:
        GenLayer genlayerdeepcreek = new GenLayerRiverInit(110L, biomes);
        GenLayer genlayerdeepcreek2 = GenLayerZoom.magnify(1100L, genlayerdeepcreek, 2);
//        GenLayer genlayerdeepcreek3 = GenLayerZoom.magnify(1100L, genlayerdeepcreek2, 2);
//        GenLayer genlayerdeepcreek4 = GenLayerZoom.magnify(1100L, genlayerdeepcreek3, 2);
        GenLayer genlayerdeepcreek5 = GenLayerZoom.magnify(1100L, genlayerdeepcreek2, 1);
        GenLayer genlayerdeepcreek6 = new GenLayerRiver(11L, genlayerdeepcreek5);
        GenLayer genlayerdeepcreek7 = new GenLayerSmooth(1100L, genlayerdeepcreek6);
        GenLayer genlayerdeepcreekfinal = new GenLayerCretaceousEarlyRiverMixEuropeSpecial(1100L, genlayercreekfinal, genlayerdeepcreek7);

        GenLayer genlayerdeepvoronoizoom = new GenLayerVoronoiZoom(11L, genlayerdeepcreekfinal);

        genlayerdeepcreekfinal.initWorldGenSeed(seed);
        genlayerdeepvoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayerdeepvoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayerdeepcreekfinal, genlayerdeepvoronoizoom, genlayerdeepcreekfinal });
    }

}