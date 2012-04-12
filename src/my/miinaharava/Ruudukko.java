package my.miinaharava;

import java.util.*;

/**
 * Ruudukko-luokka toimii kehikkona Ruutu-luokalle. Se luo konstrukstorissaan Ruutu[][]
 *  -tyyppisen taulukon, johon ruutujen numeroarvoja tallennetaan. Ruudukko -luokka
 * ei sisällä pelin toimivuuden osalta oleellista koodia, joka taasen löytyy Pelilogiikka
 * -luokasta.
 * 
 */
public class Ruudukko {

    private Ruutu[][] ruudukko;
    private Pelilogiikka logiikka;
    
    /**
     * Konstrukstori luo Ruutu[][] -tyyppisen taulukon ja kutsuu taulukon alustusmetodia.
     * Lisäksi luodaan pelilogiikkaolio, jolla kutsutaan miinojen ja numeroiden taulukkoon
     * asettamismetodeita.
     * 
     * @param rivit Ruudukon rivien määrä
     * @param sarakkeet Ruudukon sarakkeiden määrä
     * @param miinat Haluttu miinojen määrä
     */
    public Ruudukko(int rivit, int sarakkeet, int miinat, int aloitusRivi, int aloitusSarake) {
        // syötteiden suuruuden tarkistus muualla?
        ruudukko = new Ruutu[rivit][sarakkeet];
        alustaRuudukko();
        logiikka = new Pelilogiikka();
        ruudukko = logiikka.asetaMiinatRuudukkoon(ruudukko, miinat,aloitusRivi, aloitusSarake);
        ruudukko = logiikka.asetaNumerotRuudukkoon(ruudukko);
    }
    
    /**
     * Metodi alustaa ruudukon. Jokaisen ruudun arvo on alussa null, joten niihin
     * pitää luoda Ruutu -luokan ilmentymät erikseen, aluksi arvolla 0.
     * 
     */
    public void alustaRuudukko() {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[i].length; j++) {
                ruudukko[i][j] = new Ruutu(0);
            }
        }
    }
    
    /**
     * Metodi kutsuu Ruutu-luokan avaa-metodia, joka asettaa ruudun 'avatuksi'.
     * @param rivi
     * @param sarake 
     */
    public void avaaRuutu(int rivi, int sarake) {
        ruudukko[rivi][sarake].avaaRuutu();
    }
    
    public int getRuudunOminaisuus(int rivi, int sarake) {
        return ruudukko[rivi][sarake].getOminaisuus();
    }
    
    public boolean getRuudunAvattu(int rivi, int sarake) {
        return ruudukko[rivi][sarake].getAvattu();
    }
}