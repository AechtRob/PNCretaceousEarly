package net.pncretaceousearly.world.dimension.cretaceousearly.GenLayerCretaceousEarly;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerCretaceousEarly {

    private static boolean shouldDraw = false;
    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerCretaceousEarlyBiomesSea(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);

        biomes = new GenLayerCretaceousEarlyBiomes(1543L, biomes);
        biomes = new GenLayerZoom(1032L, biomes);

        biomes = new GenLayerCretaceousEarlyBiomesDiversifyEuropeAfricaAsia(2541L, biomes);
        biomes = new GenLayerZoom(1000L, biomes);

        biomes = new GenLayerSeperateContinents(378L, biomes);
        biomes = new GenLayerAddInlandSeas(3048L, biomes);
        biomes = new GenLayerCretaceousDiversifyAustroAntarctica0(2542L, biomes);
        biomes = new GenLayerCretaceousDiversifyAfricaSAmerica(7572L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerAfricaSavanna(6756L, biomes);
        biomes = new GenLayerAddShallowSea2(1201L, biomes);
        biomes = new GenLayerAddInlandSeas2(3049L, biomes);
        biomes = new GenLayerCretaceousDiversifyAustroAntarctica1(2544L, biomes);
        biomes = new GenLayerCretaceousDiversifyAfricaSAmerica2(562L, biomes);
        biomes = new GenLayerAsiaInlandReplaceBog(579L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);

        biomes = new GenLayerCretaceousDiversifyAustroAntarctica2(2544L, biomes);
        biomes = new GenLayerCretaceousDiversifyAustroAntarctica3(2545L, biomes);
        biomes = new GenLayerAddInlandSeas2(3046L, biomes);
        biomes = new GenLayerAsiaInlandReplaceScrub(679L, biomes);
        biomes = new GenLayerCretaceousDiversifyEuroAmerica(2641L, biomes);
        biomes = new GenLayerEuropeCopse(223L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderRift(98L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianRim(151L, biomes);
        biomes = new GenLayerZoom(109L, biomes);

        biomes = new GenLayerCretaceousDiversifyAustroAntarctica4(2548L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianRim(9151L, biomes);
        biomes = new GenLayerOceanCrags(29L, biomes);
        biomes = new GenLayerCretaceousEarlyRiverBorderRift(99L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);

        biomes = new GenLayerNAmericanCopse(433L, biomes);
        biomes = new GenLayerAfricaPeaks(9875L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianFoothills(44, biomes);
        biomes = new GenLayerYixianDead(549L, biomes);
        biomes = new GenLayerZoom(1884L, biomes);

        biomes = new GenLayerAsiaDroopingIslands(498, biomes);
        biomes = new GenLayerCretaceousDiversifyAustroAntarctica5(2549L, biomes);
        biomes = new GenLayerCretaceousPhryganaLakes(7223L, biomes);
        //biomes = new GenLayerCretaceousEarlyRiverBorderBanks(98L, biomes);
        biomes = new GenLayerAddInlandSeaBorder(8563L, biomes);
        biomes = new GenLayerNorthAmericaMountains0(1551L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);

        biomes = new GenLayerEuropeanSwampLakes(241L, biomes);
        biomes = new GenLayerCretaceousEarlyEuropeIslandify(325L, biomes);
        biomes = new GenLayerAfricaSavannaHoles1(8772L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerNorthAmericaMountains1(2551L, biomes);
        biomes = new GenLayerCretaceousEarlySeperateAsiaHillsBiomes(21L, biomes);

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
        biomes = new GenLayerFuzzyZoom(6001L, biomes);

        biomes = new GenLayerSAmericanDesertSpikes(240L, biomes);
        biomes = new GenLayerCretaceousEarlyYixianRim2(2331L, biomes);
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

        //Additional waterways in Europe:
        GenLayer genlayerdeepcreek = new GenLayerRiverInit(110L, biomes);
        GenLayer genlayerdeepcreek2 = GenLayerZoom.magnify(1100L, genlayerdeepcreek, 2);
        GenLayer genlayerdeepcreek3 = GenLayerZoom.magnify(1100L, genlayerdeepcreek2, 1);
        GenLayer genlayerdeepcreek4 = new GenLayerRiver(11L, genlayerdeepcreek3);
        GenLayer genlayerdeepcreek5 = new GenLayerSmooth(1100L, genlayerdeepcreek4);
        GenLayer genlayerdeepcreekfinal = new GenLayerCretaceousEarlyRiverMixEuropeSpecial(1100L, genlayercreekfinal, genlayerdeepcreek5);
        
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

//        //Additional special, very wide waterways in SAmerica:
//        GenLayer genlayerwidecreek = new GenLayerRiverInit(120L, biomes);
//        genlayerwidecreek = new GenLayerRiverInit(130L, genlayerwidecreek);
//        GenLayer genlayerwidecreek2 = GenLayerZoom.magnify(1200L, genlayerwidecreek, 2);
//        GenLayer genlayerwidecreek3 = GenLayerZoom.magnify(1200L, genlayerwidecreek2, 1);
//        GenLayer genlayerwidecreek4 = GenLayerZoom.magnify(1000L, genlayerwidecreek3, 2);
//        GenLayer genlayerwidecreek5 = new GenLayerRiver(12L, genlayerwidecreek4);
//        GenLayer genlayerwidecreek6 = new GenLayerSmooth(1200L, genlayerwidecreek5);
//        genlayerwidecreek6 = new GenLayerZoom(1676L, genlayerwidecreek6);
//        //Adds riverbanks to the edges of the river:
//        genlayerwidecreek6 = new GenLayerRiverbanksSAmericaRiver(120L, genlayerwidecreek6);
//        genlayerwidecreek6 = new GenLayerZoom(1677L, genlayerwidecreek6);
//        //Digs out a deeper rift in parts of the river:
//        genlayerwidecreek6 = new GenLayerRiverriftSAmericaRiver(121L, genlayerwidecreek6);
//        genlayerwidecreek6 = new GenLayerZoom(1678L, genlayerwidecreek6);
//        genlayerwidecreek6 = new GenLayerZoom(1679L, genlayerwidecreek6);
//        genlayerwidecreek6 = new GenLayerRiverriftSAmericaRiver(122L, genlayerwidecreek6);
//        genlayerwidecreek6 = new GenLayerZoom(1680L, genlayerwidecreek6);
//        genlayerwidecreek6 = new GenLayerSmooth(1681L, genlayerwidecreek6);
//        GenLayer genlayerwidecreekfinal = new GenLayerCretaceousEarlyRiverMixSAmericaAndAusHeadlandsSpecial(1200L, genlayer3widevalleyfinal, genlayerwidecreek6);

        GenLayer genlayerwidevoronoizoom = new GenLayerVoronoiZoom(10L, genlayer3widevalleyfinal);

        genlayer3widevalleyfinal.initWorldGenSeed(seed);
        genlayerwidevoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayerwidevoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayer3widevalleyfinal, genlayerwidevoronoizoom, genlayer3widevalleyfinal });
    }

}