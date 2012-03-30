package my.miinaharava;

import java.util.*;

/**
 * Ruudukko-luokka toimii kehikkona Ruutu-luokalle.
 * 
 */
public class Ruudukko {

    private Ruutu[][] ruudukko;
    private Pelilogiikka logiikka;
//    private int rivit;
//    private int sarakkeet;
    
    /**
     * 
     * @param riv
     * @param sar 
     */
    public Ruudukko(int rivit, int sarakkeet, int miinat) {
        ruudukko = new Ruutu[rivit][sarakkeet];
        alustaRuudukko();
        logiikka = new Pelilogiikka();
        ruudukko = logiikka.asetaMiinatRuudukkoon(ruudukko, miinat);
        ruudukko = logiikka.asetaNumerotRuutuihin(ruudukko);
    }
    
    /**
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
                else
                    System.out.print(" ");
                System.out.print("] ");
            }
            System.out.println("");
        }
    }
    
    public static void main (String[] args) {
        Ruudukko ruudukko = new Ruudukko(10, 10, 30);
        ruudukko.tulostaRuudukko();
        
    }
    
}