package tetris;

/**
 * PalikkaS on abstraktin Palikka -luokan aliluokka.
 */
public class PalikkaS extends Palikka {

    private static boolean[][] asento1 = {{false, false, false, false},
                                          {false, false, false, false},
                                          {false, true, true, false},
                                          {true, true, false, false}};
    private static boolean[][] asento2 = {{false, false, false, false},
                                          {true, false, false, false},
                                          {true, true, false, false},
                                          {false, true, false, false}};
    private static boolean[][][] asennot = {asento1, asento2};

    public PalikkaS() {

    }

    public boolean[][][] getPalikanAsennot() {
        return asennot;
    }

//    /**
//     * Metodi tallettaa Palikka-tyyppiseen taulukkoon palikan eri asennot. S-palikalla niitä on kaksi.
//     */
//    public PalikkaS[] generoiPalikanAsennotTaulukkoon() {
//        palikka = new PalikkaS();
//        palikka.palikkakehikko[2][1].asetaVaratuksi(); //ensimmäinen S-palikan asento
//        palikka.palikkakehikko[2][2].asetaVaratuksi();
//        palikka.palikkakehikko[3][0].asetaVaratuksi();
//        palikka.palikkakehikko[3][1].asetaVaratuksi();
//        palikanAsennot[0] = palikka;
//
//        palikka = new PalikkaS();
//        palikka.palikkakehikko[1][0].asetaVaratuksi(); //toinen S-palikan asento
//        palikka.palikkakehikko[2][0].asetaVaratuksi();
//        palikka.palikkakehikko[2][1].asetaVaratuksi();
//        palikka.palikkakehikko[3][1].asetaVaratuksi();
//        palikanAsennot[1] = palikka;
//
//        return palikanAsennot;
//    }

}