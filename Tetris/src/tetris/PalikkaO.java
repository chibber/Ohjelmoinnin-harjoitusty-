package tetris;

/**
 * PalikkaO on abstraktin Palikka -luokan aliluokka.
 */
public class PalikkaO extends Palikka {

    private static boolean[][] asento1 = {{false, false, false, false},
                                          {false, true, true, false},
                                          {false, true, true, false},
                                          {false, false, false, false}};
    private static boolean[][][] asennot = { asento1 };

    public PalikkaO() {

    }

    public boolean[][][] getPalikanAsennot() {
        return asennot;
    }


//    /**
//     * Metodi tallettaa Palikka-tyyppiseen taulukkoon palikan eri asennot. O-palikalla niitä on vain yksi.
//     */
//    public PalikkaO[] generoiPalikanAsennotTaulukkoon() {
//        palikka = new PalikkaO();
//        palikka.palikkakehikko[2][0].asetaVaratuksi();
//        palikka.palikkakehikko[2][1].asetaVaratuksi();
//        palikka.palikkakehikko[3][0].asetaVaratuksi();
//        palikka.palikkakehikko[3][1].asetaVaratuksi();
//        palikanAsennot[0] = palikka;                //Yksi ja ainoa O-palikan asento.
//        return palikanAsennot;
//    }
   
}