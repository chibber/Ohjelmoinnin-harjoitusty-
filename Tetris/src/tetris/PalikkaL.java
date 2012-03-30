package tetris;

/**
 * PalikkaL on abstraktin Palikka -luokan aliluokka.
 */
public class PalikkaL extends Palikka {

    private static boolean[][] asento1 = {{false, false, false, false},
                                          {false, true, false, false},
                                          {false, true, false, false},
                                          {false, true, true, false}};
    private static boolean[][] asento2 = {{false, false, false, false},
                                          {false, false, false, false},
                                          {true, true, true, false},
                                          {true, false, false, false}};
    private static boolean[][] asento3 = {{false, false, false, false},
                                          {true, true, false, false},
                                          {false, true, false, false},
                                          {false, true, false, false}};
    private static boolean[][] asento4 = {{false, false, false, false},
                                          {false, false, true, false},
                                          {true, true, true, false},
                                          {false, false, false, false}};
    private static boolean[][][] asennot = {asento1, asento2, asento3, asento4};

    public PalikkaL() {        

    }

    public boolean[][][] getPalikanAsennot() {
        return asennot;
    }

//    /**
//     * Metodi tallettaa Palikka-tyyppiseen taulukkoon palikan eri asennot. L-palikalla niitä on neljä.
//     */
//    public PalikkaL[] generoiPalikanAsennotTaulukkoon() {
//        palikka = new PalikkaL();
//        for (int i = 1; i < palikka.palikkakehikko.length; i++) {
//            palikka.palikkakehikko[i][1].asetaVaratuksi();
//        }                                           //ensimmäinen L-palikan asento
//        palikka.palikkakehikko[3][2].asetaVaratuksi();
//        palikanAsennot[0] = palikka;
//
//        palikka = new PalikkaL();
//        for (int i = 0; i < palikka.palikkakehikko.length-1; i++) {
//            palikka.palikkakehikko[2][i].asetaVaratuksi();
//        }                                           //toinen L-palikan asento
//        palikka.palikkakehikko[3][0].asetaVaratuksi();
//        palikanAsennot[1] = palikka;
//
//        palikka = new PalikkaL();
//        for (int i = 1; i < palikka.palikkakehikko.length; i++) {
//            palikka.palikkakehikko[i][1].asetaVaratuksi();
//        }                                           //kolmas L-palikan asento
//        palikka.palikkakehikko[1][0].asetaVaratuksi();
//        palikanAsennot[2] = palikka;
//
//        palikka = new PalikkaL();
//        for (int i = 0; i < palikka.palikkakehikko.length-1; i++) {
//            palikka.palikkakehikko[2][i].asetaVaratuksi();
//        }                                           //neljäs L-palikan asento
//        palikka.palikkakehikko[1][2].asetaVaratuksi();
//        palikanAsennot[3] = palikka;
//
//        return palikanAsennot;
//    }

}