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

    /**
     * Ruudukko toimii pelilaudan tapaan koostuen Ruutu-oliosta, jotka sisältävät
     * omat ominaisuutensa.
     */
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
     * @param aloitusRivi Pelaajan ensimmäisen siirron rivi-indeksi
     * @param aloitusSarake Pelaajan ensimmäisen siirron sarake-indeksi
     * 
     */
    public Ruudukko(int rivit, int sarakkeet, int miinat, int aloitusRivi, int aloitusSarake) {
        ruudukko = new Ruutu[rivit][sarakkeet];
        alustaRuudukko();
        logiikka = new Pelilogiikka();
        ruudukko = logiikka.asetaMiinatRuudukkoon(ruudukko, miinat, aloitusRivi, aloitusSarake);
        ruudukko = logiikka.asetaNumerotRuudukkoon(ruudukko, aloitusRivi, aloitusSarake); 
    }
    
    /**
     * Metodi alustaa ruudukon. Jokaisen ruudun arvo on alussa null, joten niihin
     * pitää luoda Ruutu -luokan ilmentymät erikseen, aluksi arvolla 0. Jokainen
     * Ruutu saa myös attribuuteikseen ominaisen sijaintinsa tiedot indekseinä.
     */
    public void alustaRuudukko() {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[i].length; j++) {
                ruudukko[i][j] = new Ruutu(0, i, j); 
            }
        }
    }
    
    /**
     * Metodi avaa riippuen avattavan ruudun ominaisuudesta joko yhden ruudun tai sitten
     * kaikki ensimmäistä avattavaa ruutua ympäröivät miinattomat ruudut tiettyyn 
     * pisteeseen asti. Jos eka avattava ruutu on numeroruutu tai miina, metodi kutsuu
     * vain Ruutu-luokan metodia avaaRuutu(). Jos eka avattava ruutu taas on tyhjä, 
     * niin ruutuja avataan niin monta kuin tarvitsee, jolloin metodi kutsuu
     * Pelilogiikka-luokan metodia avaaMiinattomatRuudut().
     * 
     * @param aloitusRivi aluksi avattavan ruudun indeksi
     * @param aloitusSarake aluksi avattavan ruudun indeksi
     */
    public void avaaRuudut(int aloitusRivi, int aloitusSarake) {
        
        if (ruudukko[aloitusRivi][aloitusSarake].getOminaisuus() == 0) {        //tyhjä -> avataan kaikki sen ympärille jne miinattomat ruudut
            logiikka.avaaMiinattomatRuudut(ruudukko, aloitusRivi, aloitusSarake);
        }
        else {
            ruudukko[aloitusRivi][aloitusSarake].avaaRuutu();
        }
    }
    
    /**
     * Metodi merkitsee halutun ruudun miinaksi, mutta ei avaa sitä. Ensimmäisellä
     * kerralla ruutu merkitään jollain kuviolla miinaksi, ja toisella kerralla
     * taas perusruuduksi jne.
     * 
     * @param rivi
     * @param sarake 
     */
    public void merkitseRuutu(int rivi, int sarake) {
        ruudukko[rivi][sarake].merkitseRuutu();
    }
    
    public int getRuudunOminaisuus(int rivi, int sarake) {
        return ruudukko[rivi][sarake].getOminaisuus();
    }
    
    public boolean getRuudunAvattu(int rivi, int sarake) {
        return ruudukko[rivi][sarake].getAvattu();
    }
}