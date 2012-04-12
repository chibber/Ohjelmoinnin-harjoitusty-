package my.miinaharava;

import java.util.Scanner;

/**
 * Luokka on mahdollisesti vain väliaikaiseen ohjelman suorittamiseen tekstipohjaisesti?
 * @author Vilma
 */
public class Main {
    
    static Ruudukko ruudukko;
    static int rivit, sarakkeet, miinat;
    private static Scanner lukija;
    
    public static void main(String[] args) {
        
        lukija = new Scanner(System.in);
        rivit = 10;
        sarakkeet = 10;
        miinat = 15;
        
        int annettuRivi = 0;
        int annettuSarake = 0;
        ruudukko = new Ruudukko(rivit, sarakkeet, miinat, annettuRivi, annettuSarake);
        tulostaRuudukko();
        
        while (true) {
            
            System.out.println("Anna ruudun koordinaatit enterillä erotettuna. Ensin korkeus-, sitten leveyssuunnassa: ");
            annettuRivi = lukija.nextInt();
            annettuSarake = lukija.nextInt();

            ruudukko.avaaRuutu(annettuRivi, annettuSarake);
            tulostaRuudukko();
            if (ruudukko.getRuudunOminaisuus(annettuRivi, annettuSarake) == -1) {   //miina
                System.out.println("Oho, osuit miinaan! Peli loppui!");
                break;
            }
            else if (ruudukko.getRuudunOminaisuus(annettuRivi, annettuSarake) == 0) {
                /*jos osuu tyhjään ruutuun, pitää avata kaikki miinattomat ruudut ko. ruudun ympäriltä
                 ja lisäksi niiden ympäriltä miinattomat ruudut jne.
                 */
            }
        }
        
     
    }
    
    public static void tulostaRuudukko() {
        for (int i = 0; i < rivit; i++) {
            for (int j = 0; j < sarakkeet; j++) {
                System.out.print("[");
                if (!ruudukko.getRuudunAvattu(i, j))    //jos ruutu ei avattu
                    System.out.print(" ");
                else if (ruudukko.getRuudunOminaisuus(i, j) == -1)
                    System.out.print("*");
                else if (ruudukko.getRuudunOminaisuus(i, j) > 0)
                    System.out.print(ruudukko.getRuudunOminaisuus(i, j));
                else    //jos ruutu tyhjä
                    System.out.print("-");
                System.out.print("] ");
            }
            System.out.println("");
        }
    }
        
}