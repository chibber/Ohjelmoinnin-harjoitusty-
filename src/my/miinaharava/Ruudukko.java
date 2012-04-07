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
    public Ruudukko(int rivit, int sarakkeet, int miinat) {
        // syötteiden suuruuden tarkistus muualla?
        ruudukko = new Ruutu[rivit][sarakkeet];
        alustaRuudukko();
        logiikka = new Pelilogiikka();
        ruudukko = logiikka.asetaMiinatRuudukkoon(ruudukko, miinat);
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
    
    public int getRuudunOminaisuus(int rivi, int sarake) {
        return ruudukko[rivi][sarake].getOminaisuus();
    }
    
    
    //väliaikaiseen toimivuuden testaukseen
    public void tulostaRuudukko() {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[i].length; j++) {
                System.out.print("[");
                if (ruudukko[i][j].getOminaisuus() == -1)
                    System.out.print("*");
                else if (ruudukko[i][j].getOminaisuus() > 0)
                    System.out.print(ruudukko[i][j].getOminaisuus());
                else
                    System.out.print(" ");
                System.out.print("] ");
            }
            System.out.println("");
        }
    }
    
    public static void main (String[] args) {
        Ruudukko ruudukko = new Ruudukko(10, 10, 20);
        ruudukko.tulostaRuudukko();
        
    }
}