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
    
    @Before
    public void setUp() {
        ruudukko = new Ruudukko(10, 10, 10);
    }
    
    /**
     * 
     */
    @Test
    public void toimiihanAlustus() {
        ruudukko.alustaRuudukko();
        assertEquals(ruudukko.getRuudunOminaisuus(1, 2), 0);
        assertEquals(ruudukko.getRuudunOminaisuus(5, 4), 0);
    }
    
   
    
    
}
