package tetris;

/**
 * PisteLaskuri -luokka laskee pelaajan pisteet. Mitä enemmän rivejä pelaaja onnistuu
 * poistamaan kerrallaan, sitä enemmän saa pisteitä.
 */
public class PisteLaskuri {
    /**
     * Poistetuista riveistä annetaan pisteitä, jotka lisätään tähän muuttujaan.
     */
    private int pisteet;

    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * PisteetRivistä -metodi antaa nykyisen vaikeustason mukaisen pisteannoksen.
     */
    public void lisaaPisteita(int rivienMaara) {
        this.pisteet += rivienMaara * 100;
    }

}