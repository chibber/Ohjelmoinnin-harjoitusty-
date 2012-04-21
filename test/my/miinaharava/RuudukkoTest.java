package my.miinaharava;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testaa Ruudukko-luokkaa.
 * 
 */
public class RuudukkoTest {
    
    Ruudukko ruudukko;
    Ruutu[][] ruutuRuudukko;
    int rivit;
    int sarakkeet;
    int miinat;
    int annettuRivi = 0;
    int annettuSarake = 0;
    
    /**
     * Testaa avaaRuudut-metodin toimivuutta.
     */
    @Test
    public void testaaAvattuGetteria() {
        rivit = 10;
        sarakkeet = 10;
        miinat = 10;
        annettuRivi = 3;
        annettuSarake = 4;
        ruudukko = new Ruudukko(rivit, sarakkeet, miinat, annettuRivi, annettuSarake);
        
        assertEquals(ruudukko.getRuudunAvattu(annettuRivi, annettuSarake), false);
        ruudukko.avaaRuudut(annettuRivi, annettuSarake);
        assertEquals(ruudukko.getRuudunAvattu(annettuRivi, annettuSarake), true);
    }
    
    /**
     * Testaa alustaRuudukko-metodia (ennalta määrätyllä) maksimisyötteellä.
     */
    @Test
    public void alustusIsollaSyotteella() {
       ruudukko = new Ruudukko(35, 50, 1670, annettuRivi, annettuSarake);
       ruudukko.alustaRuudukko();
       assertEquals(ruudukko.getRuudunOminaisuus(23, 49), 0);
       assertEquals(ruudukko.getRuudunOminaisuus(0, 3), 0);
    }
    
    /**
     * Testaa alustaRuudukko-metodia (ennalta määrätyllä) minimisyötteellä.
     */
    @Test
    public void alustusPienellaSyotteella() {
        ruudukko = new Ruudukko(10, 10, 1, annettuRivi, annettuSarake);
        ruudukko.alustaRuudukko();
        assertEquals(ruudukko.getRuudunOminaisuus(1, 3), 0);
        assertEquals(ruudukko.getRuudunOminaisuus(9, 8), 0);
    }
    
    
}
