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
        rivit = 20;
        sarakkeet = 20;
        miinat = 100;
        
        System.out.println("Pelilaudan koko: " + rivit + " x " + sarakkeet);
        System.out.println("Anna ruudun koordinaatit enterillä erotettuna. Ensin korkeus-, sitten leveyssuunnassa: ");
        int annettuRivi = lukija.nextInt();
        int annettuSarake = lukija.nextInt();
        
        ruudukko = new Ruudukko(rivit, sarakkeet, miinat, annettuRivi, annettuSarake);
        
        ruudukko.avaaRuudut(annettuRivi, annettuSarake);
        
//        for (int i = 0; i < rivit; i++) {
//            for (int j = 0; j < sarakkeet; j++) {
//                System.out.print("[");
//                if (ruudukko.getRuudunOminaisuus(i, j) == -1)
//                    System.out.print("*");
//                else if (ruudukko.getRuudunOminaisuus(i, j) > 0)
//                    System.out.print(ruudukko.getRuudunOminaisuus(i, j));
//                else    //jos ruutu tyhjä
//                    System.out.print("-");
//                System.out.print("] ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        
        tulostaRuudukko();
        
        while (true) {
            
            System.out.println("Anna ruudun koordinaatit enterillä erotettuna. Ensin korkeus-, sitten leveyssuunnassa: ");
            annettuRivi = lukija.nextInt();
            annettuSarake = lukija.nextInt();

            ruudukko.avaaRuudut(annettuRivi, annettuSarake);
            tulostaRuudukko(); 
            if (ruudukko.getRuudunOminaisuus(annettuRivi, annettuSarake) == -1) {  //miina
                System.out.println("Oho, osuit miinaan! Peli loppui!");
                break;
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