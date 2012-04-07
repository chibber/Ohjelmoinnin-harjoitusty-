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
    
    /**
     * 
     */
    @Test
    public void alustusIsollaSyotteella() {
       ruudukko = new Ruudukko(35, 50, 1670);
       ruudukko.alustaRuudukko();
       assertEquals(ruudukko.getRuudunOminaisuus(23, 49), 0);
       assertEquals(ruudukko.getRuudunOminaisuus(0, 3), 0);
    }
    
    /**
     * 
     */
    @Test
    public void alustusPienellaSyotteella() {
        ruudukko = new Ruudukko(10, 10, 1);
        ruudukko.alustaRuudukko();
        assertEquals(ruudukko.getRuudunOminaisuus(1, 3), 0);
        assertEquals(ruudukko.getRuudunOminaisuus(9, 8), 0);
    }
    
    
}
