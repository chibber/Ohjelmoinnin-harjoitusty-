package tetris;

/**
 * Peliruudukko -luokka sisältää pudonneista palikoista muodostuneen ruudukon toiminnot
 * eli palikan lisäämisen tai poistamisen ruudukkoon.
 */
public class Peliruudukko {
    public static int KORKEUS = 20;
    public static int LEVEYS = 10;

    private Ruutu[][] ruudukko;
    private PalikanArpoja palikanarpoja;
    private PisteLaskuri pistelaskuri;
    private Palikka palikka;

    private int xKoord = 0;
    private int yKoord = 0;
    
    /**
     * Luodaan pelialueen kokoinen ruudukko, jossa palikat liikuskelevat.
     */
    public Peliruudukko() {
        ruudukko = new Ruutu[KORKEUS + 2][LEVEYS + 4];
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                ruudukko[i][j] = new Ruutu();
            }
        }
        palikanarpoja = new PalikanArpoja();
        pistelaskuri = new PisteLaskuri();
    }

    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }

    /**
     * Metodi kutsuu palikanarpoja-luokkaa ja arpoo ruudukolle ilmestyvän uuden palikan.
     */
    public void uusiPalikkaRuudukkoon() {
        palikka = palikanarpoja.arvoPalikka();
        int palikanRuudut = 4;
        int j = 0;
        for (int i = 5; i < 9; i++) {       //uusi palikka lisätään ruudukkoon
            for (int k = 0; k < palikanRuudut; k++) {
                if (palikka.getPalikanAsennot()[0][k][j])
                    ruudukko[k][i].asetaVaratuksi();
            }
            j++;
        }
    }

    /**
     * Metodi lisää arvotun palikan palikkaruudukkoon kun se ei pääse putoamaan enää alaspäin.
     *
     */
    public void lisaaPalikkaAlas() {

    }

    /**
     * Metodi poistaa ruudukkoon palikoista muodostuneet ehjat rivit (1-4 kappaletta)
     * sekä lisää pistesaldoon ansaitun summan.
     */
    public void poistaRiveja() {
        int rivienMaara = 0;
        pistelaskuri.lisaaPisteita(rivienMaara);

    }

    public boolean voikoKiertya() {

        return true;
    }

    public boolean voikoLiikkuaOikealle() {
        
        
        return true;
    }
        
    public boolean voikoLiikkuaVasemmalle() {

        return true;
    }
    
    public boolean voikoLiikkuaAlas() {

        return true;
    }

    /**
     * Metodi kiertää palikkaa oikealle 90 astetta
     */
    public void kierraPalikkaa() {
        if (voikoKiertya())
            palikka.kierraPalikkaa();
    }

    /**
     * 
     */
    public void liikuOikealle() {
        if (voikoLiikkuaOikealle()) xKoord++;
    }

    /**
     * .
     */
    public void liikuVasemmalle() {
        if (voikoLiikkuaVasemmalle()) xKoord--;
    }

    /**
     * 
     */
    public void liikuAlas() {
        if (voikoLiikkuaAlas()) yKoord++;
    }

    /**
     * Metodi pudottaa palikan suoraan alas.
     */
    public void pudotaAlas() {

    }

}