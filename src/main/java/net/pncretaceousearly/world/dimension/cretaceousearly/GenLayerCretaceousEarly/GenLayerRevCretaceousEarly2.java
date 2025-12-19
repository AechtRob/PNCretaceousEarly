package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerRevCretaceousEarly2 {

    private static boolean shouldDraw = false;
    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        //Place down shallow seas:
        GenLayer biomes = new GenLayerRevSeedContinents(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);

        biomes = new GenLayerAustroAntarcticContinent(654L, biomes);

        biomes = new GenLayerFuzzyZoom(2001L, biomes);

        biomes = new GenLayerRevSplitAfroAmerica(1975L, biomes);
        biomes = new GenLayerRevSeperateContinents(378L, biomes);
        //biomes = new GenLayerCretaceousEarlyBiomesDiversifyEuropeAfricaAsia(2541L, biomes);
        biomes = new GenLayerDeepOcean(2665L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerRevAddInlandSeas(3048L, biomes);
        biomes = new GenLayerCretaceousDiversifyNAmerica(7531L, biomes); //edited
        biomes = new GenLayerCretaceousDiversifyAfricaSAmerica2(562L, biomes);
        biomes = new GenLayerAsiaInlandReplaceBog(579L, biomes);
        //biomes = new GenLayerDeepOcean(2665L, biomes);
        biomes = new GenLayerAfricaSavanna(6756L, biomes); //MOVED HERE
        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerSmooth(301L, biomes);

        biomes = new GenLayerAddInlandSeas2(3046L, biomes);
        //biomes = new GenLayerAfricaSavanna(6756L, biomes); //MOVED FROM HERE
        biomes = new GenLayerAsiaInlandReplaceScrub(679L, biomes);
        biomes = new GenLayerCretaceousDiversifyEuroAmerica(2641L, biomes);
        biomes = new GenLayerEuropeCopse(223L, biomes);
        biomes = new GenLayerRevDiversifyAus(63L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderRift(97L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianRim(151L, biomes);
        biomes = new GenLayerOceanReefs(3879L, biomes);
        biomes = new GenLayerZoom(109L, biomes);

        biomes = new GenLayerAddNAmericaForest(2671L, biomes);
        biomes = new GenLayerEuropeCopse(223L, biomes);
        biomes = new GenLayerAsiaInlandReplaceBog2(879L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianRim(9151L, biomes);
        biomes = new GenLayerOceanCrags(29L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderRift(99L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderBanks(98L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);

        biomes = new GenLayerCretaceousDiversifyAustroAntarctica4(2548L, biomes);
        biomes = new GenLayerNAmericanCopse(433L, biomes);
        biomes = new GenLayerAfricaPeaks(9875L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianFoothills(44, biomes);
        biomes = new GenLayerYixianDead(549L, biomes);
        biomes = new GenLayerZoom(1884L, biomes);

        biomes = new GenLayerAsiaDroopingIslands(498, biomes);
        biomes = new GenLayerCretaceousDiversifyAustroAntarctica5(2549L, biomes);
        biomes = new GenLayerCretaceousPhryganaLakes(7223L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderBanks(99L, biomes);
        biomes = new GenLayerAddInlandSeaBorder(8563L, biomes);
        biomes = new GenLayerNorthAmericaMountains0(1551L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);

        biomes = new GenLayerEuropeanSwampLakes(241L, biomes);
        biomes = new GenLayerCretaceousEarlyEuropeIslandify(325L, biomes);
        biomes = new GenLayerAfricaSavannaHoles1(8772L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerNorthAmericaMountains1(2551L, biomes);
        biomes = new GenLayerCretaceousEarlySeperateAsiaHillsBiomes(21L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderBanks(99L, biomes);
        biomes = new GenLayerAsiaShrublands1(6971L, biomes);
        biomes = new GenLayerCretaceousEarlyBeach(1050L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes0(742L, biomes);
        biomes = new GenLayerEuropeanSwampLakes(242L, biomes);
        biomes = new GenLayerSmooth(705L, biomes);

        biomes = new GenLayerAustroAntarcticHighLakes1(242L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes2(249L, biomes);
        biomes = new GenLayerSAmericanDesertLows(244L, biomes);
        biomes = new GenLayerAfricaPinnacles(1875L, biomes);
        biomes = new GenLayerAfricaSavannaHoles2(8772L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderRiftMagma(221L, biomes);
        biomes = new GenLayerDeepOceanTransition(235L, biomes);
        biomes = new GenLayerFuzzyZoom(6001L, biomes);

        biomes = new GenLayerSAmericanDesertSpikes(240L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianRim2(2331L, biomes);
        biomes = new GenLayerCretaceousDiversifyOceanCrags(643L, biomes);
        biomes = new GenLayerSmooth(706L, biomes);

        biomes = new GenLayerSandyDesertPeaks(23L, biomes);
        biomes = new GenLayerAsiaShrublands2(979L, biomes);
        biomes = new GenLayerCretaceousEarlyPodocarpLakeEdge(9L, biomes);
        biomes = new GenLayerFuzzyZoom(6002L, biomes);

        biomes = new GenLayerNorthAmericaMountains2(3551L, biomes);
        biomes = new GenLayerAustroAntarcticHighLakes1(642L, biomes);
        biomes = new GenLayerCretaceousEarlyAusColdGravelSeperator(218L, biomes);
        biomes = new GenLayerSmooth(719L, biomes); //ADDED THIS
        biomes = new GenLayerZoom(6006L, biomes);

        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 2);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 1);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerCretaceousEarlyRiverMix(100L, biomes, genlayercreek7);

        //Build and superimpose Atlantic Ravines:
        GenLayer genlayerravine = new GenLayerRiverInit(170L, biomes);
        GenLayer genlayerravine2 = GenLayerZoom.magnify(1070L, genlayerravine, 2);
        GenLayer genlayerravine3 = GenLayerZoom.magnify(1070L, genlayerravine2, 2);
        GenLayer genlayerravine4 = GenLayerZoom.magnify(1070L, genlayerravine3, 2);
        GenLayer genlayerravine5 = GenLayerZoom.magnify(1070L, genlayerravine4, 1);
        GenLayer genlayerravine6 = new GenLayerRiver(7L, genlayerravine5);
        GenLayer genlayerravine7 = new GenLayerSmooth(1070L, genlayerravine6);
        GenLayer genlayerravinefinal = new GenLayerCretaceousEarlyAtlanticRavine(107L, genlayercreekfinal, genlayerravine7);

        //Additional waterways in Europe:
        GenLayer genlayerdeepcreek = new GenLayerRiverInit(110L, biomes);
        GenLayer genlayerdeepcreek2 = GenLayerZoom.magnify(1100L, genlayerdeepcreek, 2);
        GenLayer genlayerdeepcreek3 = GenLayerZoom.magnify(1100L, genlayerdeepcreek2, 1);
        GenLayer genlayerdeepcreek4 = new GenLayerRiver(11L, genlayerdeepcreek3);
        GenLayer genlayerdeepcreek5 = new GenLayerSmooth(1100L, genlayerdeepcreek4);
        GenLayer genlayerdeepcreekfinal = new GenLayerCretaceousEarlyRiverMixEuropeSpecial(1100L, genlayerravinefinal, genlayerdeepcreek5);
        
        //Additional waterways in America:
        GenLayer genlayercratocreek = new GenLayerRiverInit(115L, biomes);
        GenLayer genlayercratocreek2 = GenLayerZoom.magnify(1105L, genlayercratocreek, 2);
        GenLayer genlayercratocreek3 = GenLayerZoom.magnify(1109L, genlayercratocreek2, 1);
        GenLayer genlayercratocreek4 = GenLayerZoom.magnify(1002L, genlayercratocreek3, 2);
        GenLayer genlayercratocreek5 = new GenLayerRiver(158L, genlayercratocreek4);
        GenLayer genlayercratocreek6 = new GenLayerSmooth(1105L, genlayercratocreek5);
        GenLayer genlayercratocreekfinal = new GenLayerCretaceousEarlyRiverMixCratoAusCoastSpecial(1178L, genlayerdeepcreekfinal, genlayercratocreek6);

        //Additional streams in SAmerica Flats:
        GenLayer genlayerstream = new GenLayerRiverInit(110L, biomes);
        GenLayer genlayerstream2 = GenLayerZoom.magnify(1100L, genlayerstream, 2);
        GenLayer genlayerstream4 = new GenLayerRiver(11L, genlayerstream2);
        GenLayer genlayerstream5 = new GenLayerSmooth(1100L, genlayerstream4);
        GenLayer genlayerstreamfinal = new GenLayerCretaceousEarlyRiverMixAfricaFlatsSpecial(1100L, genlayercratocreekfinal, genlayerstream5);

        //Additional valleys in African mountains:
        GenLayer genlayerwidevalley = new GenLayerRiverInit(120L, biomes);
        genlayerwidevalley = new GenLayerRiverInit(140L, genlayerwidevalley);
        GenLayer genlayerwidevalley2 = GenLayerZoom.magnify(1201L, genlayerwidevalley, 2);
        GenLayer genlayerwidevalley3 = GenLayerZoom.magnify(1201L, genlayerwidevalley2, 1);
        GenLayer genlayerwidevalley4 = GenLayerZoom.magnify(1001L, genlayerwidevalley3, 2);
        GenLayer genlayerwidevalley5 = new GenLayerRiver(12L, genlayerwidevalley4);
        GenLayer genlayerwidevalley6 = new GenLayerSmooth(1200L, genlayerwidevalley5);
        genlayerwidevalley6 = new GenLayerZoom(1676L, genlayerwidevalley6);
        genlayerwidevalley6 = new GenLayerZoom(1677L, genlayerwidevalley6);
        genlayerwidevalley6 = new GenLayerZoom(1678L, genlayerwidevalley6);
        genlayerwidevalley6 = new GenLayerZoom(1680L, genlayerwidevalley6);
        genlayerwidevalley6 = new GenLayerSmooth(1681L, genlayerwidevalley6);
        GenLayer genlayerwidevalleyfinal = new GenLayerCretaceousEarlyRiverMixAfricaSpecial(1200L, genlayerstreamfinal, genlayerwidevalley6);

        GenLayer genlayer2widevalley = new GenLayerRiverInit(130L, biomes);
        genlayer2widevalley = new GenLayerRiverInit(150L, genlayer2widevalley);
        GenLayer genlayer2widevalley2 = GenLayerZoom.magnify(1202L, genlayer2widevalley, 2);
        GenLayer genlayer2widevalley3 = GenLayerZoom.magnify(1202L, genlayer2widevalley2, 1);
        GenLayer genlayer2widevalley4 = GenLayerZoom.magnify(1002L, genlayer2widevalley3, 2);
        GenLayer genlayer2widevalley5 = new GenLayerRiver(12L, genlayer2widevalley4);
        GenLayer genlayer2widevalley6 = new GenLayerSmooth(1200L, genlayer2widevalley5);
        genlayer2widevalley6 = new GenLayerZoom(1676L, genlayer2widevalley6);
        genlayer2widevalley6 = new GenLayerZoom(1677L, genlayer2widevalley6);
        genlayer2widevalley6 = new GenLayerZoom(1678L, genlayer2widevalley6);
        genlayer2widevalley6 = new GenLayerZoom(1680L, genlayer2widevalley6);
        genlayer2widevalley6 = new GenLayerSmooth(1681L, genlayer2widevalley6);
        GenLayer genlayer2widevalleyfinal = new GenLayerCretaceousEarlyRiverMixAfricaSpecial(1200L, genlayerwidevalleyfinal, genlayer2widevalley6);

        GenLayer genlayer3widevalley = new GenLayerRiverInit(5430L, biomes);
        genlayer3widevalley = new GenLayerRiverInit(5431, genlayer3widevalley);
        GenLayer genlayer3widevalley2 = GenLayerZoom.magnify(1203L, genlayer3widevalley, 2);
        GenLayer genlayer3widevalley3 = GenLayerZoom.magnify(1203L, genlayer3widevalley2, 1);
        GenLayer genlayer3widevalley4 = GenLayerZoom.magnify(1003L, genlayer3widevalley3, 2);
        GenLayer genlayer3widevalley5 = new GenLayerRiver(12L, genlayer3widevalley4);
        GenLayer genlayer3widevalley6 = new GenLayerSmooth(1200L, genlayer3widevalley5);
        genlayer3widevalley6 = new GenLayerZoom(1676L, genlayer3widevalley6);
        genlayer3widevalley6 = new GenLayerZoom(1677L, genlayer3widevalley6);
        genlayer3widevalley6 = new GenLayerZoom(1678L, genlayer3widevalley6);
        genlayer3widevalley6 = new GenLayerZoom(1680L, genlayer3widevalley6);
        genlayer3widevalley6 = new GenLayerSmooth(1681L, genlayer3widevalley6);
        GenLayer genlayer3widevalleyfinal = new GenLayerCretaceousEarlyRiverMixAfricaSpecial(1200L, genlayer2widevalleyfinal, genlayer3widevalley6);

        //Aus cliffs
        GenLayer genlayercliffs = new GenLayerRiverInit(200L, biomes);
        GenLayer genlayercliffs2 = GenLayerZoom.magnify(2000L, genlayercliffs, 1);
        GenLayer genlayercliffs3 = GenLayerZoom.magnify(2000L, genlayercliffs2, 2);
        GenLayer genlayercliffs4 = GenLayerZoom.magnify(2000L, genlayercliffs3, 2);
        GenLayer genlayercliffs5 = GenLayerZoom.magnify(2000L, genlayercliffs4, 2);
        GenLayer genlayercliffs6 = GenLayerZoom.magnify(2000L, genlayercliffs5, 2);
        GenLayer genlayercliffs7 = new GenLayerRiver(2L, genlayercliffs6);
        GenLayer genlayercliffs8 = new GenLayerSmooth(2000L, genlayercliffs7);
        GenLayer genlayercliffs9 = new GenLayerZoom(2076L, genlayercliffs8);
        GenLayer genlayercliffs10 = new GenLayerZoom(3076L, genlayercliffs9);
        GenLayer genlayercliffs11 = new GenLayerZoom(4076L, genlayercliffs10);
        GenLayer genlayercliffsfinal = new GenLayerCretaceousEarlyRiverMixAusHeadlandsSpecial(200L, genlayer3widevalleyfinal, genlayercliffs11);

        GenLayer genlayercliffsB = new GenLayerRiverInit(300L, biomes);
        GenLayer genlayercliffsB2 = GenLayerZoom.magnify(3000L, genlayercliffsB, 1);
        GenLayer genlayercliffsB3 = GenLayerZoom.magnify(3000L, genlayercliffsB2, 2);
        GenLayer genlayercliffsB4 = GenLayerZoom.magnify(3000L, genlayercliffsB3, 2);
        GenLayer genlayercliffsB5 = GenLayerZoom.magnify(3000L, genlayercliffsB4, 2);
        GenLayer genlayercliffsB6 = GenLayerZoom.magnify(3000L, genlayercliffsB5, 2);
        GenLayer genlayercliffsB7 = new GenLayerRiver(3L, genlayercliffsB6);
        GenLayer genlayercliffsB8 = new GenLayerSmooth(3000L, genlayercliffsB7);
        GenLayer genlayercliffsB9 = new GenLayerZoom(3076L, genlayercliffsB8);
        GenLayer genlayercliffsB10 = new GenLayerZoom(4076L, genlayercliffsB9);
        GenLayer genlayercliffsB11 = new GenLayerZoom(5076L, genlayercliffsB10);
        GenLayer genlayercliffsBfinal = new GenLayerCretaceousEarlyRiverMixAusHeadlandsSpecial(300L, genlayercliffsfinal, genlayercliffsB11);

        GenLayer genlayercliffsC = new GenLayerRiverInit(400L, biomes);
        GenLayer genlayercliffsC2 = GenLayerZoom.magnify(4000L, genlayercliffsC, 1);
        GenLayer genlayercliffsC3 = GenLayerZoom.magnify(4000L, genlayercliffsC2, 2);
        GenLayer genlayercliffsC4 = GenLayerZoom.magnify(4000L, genlayercliffsC3, 2);
        GenLayer genlayercliffsC5 = GenLayerZoom.magnify(4000, genlayercliffsC4, 2);
        GenLayer genlayercliffsC6 = GenLayerZoom.magnify(4000L, genlayercliffsC5, 2);
        GenLayer genlayercliffsC7 = new GenLayerRiver(4L, genlayercliffsC6);
        GenLayer genlayercliffsC8 = new GenLayerSmooth(4000L, genlayercliffsC7);
        GenLayer genlayercliffsC9 = new GenLayerZoom(4076L, genlayercliffsC8);
        GenLayer genlayercliffsC10 = new GenLayerZoom(5076L, genlayercliffsC9);
        GenLayer genlayercliffsC11 = new GenLayerZoom(6076L, genlayercliffsC10);
        GenLayer genlayercliffsCfinal = new GenLayerCretaceousEarlyRiverMixAusHeadlandsSpecial(400L, genlayercliffsBfinal, genlayercliffsC11);


        GenLayer genlayerwidevoronoizoom = new GenLayerVoronoiZoom(10L, genlayercliffsCfinal);

        genlayercliffsCfinal.initWorldGenSeed(seed);
        genlayerwidevoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayerwidevoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayercliffsCfinal, genlayerwidevoronoizoom, genlayercliffsCfinal });
    }

}