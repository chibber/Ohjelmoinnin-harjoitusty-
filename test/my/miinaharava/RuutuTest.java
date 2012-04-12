package my.miinaharava;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vilma
 */
public class RuutuTest {
    
    /**
     * Testaa, että uutta ruutua luodessa annettu numero menee kohdilleen. Lisäksi
     * getOminaisuus-metodi tulee samalla testatuksi.
     */
    @Test
    public void numeronAsettaminenToimii() {
        assertEquals(new Ruutu(1).getOminaisuus(), 1);
        assertEquals(new Ruutu(5).getOminaisuus(), 5);
    }

    /**
     * Testaa, että ruudun avaaminen toimii. Ensin varmistetaan, että uuden ruudun
     * avattu-attribuutti on false eli ruutu on avaamaton. Sitten käytetään avaaRuutu()
     * -metodia ja tarkistetaan, että avattu on true.
     */
    @Test
    public void ruudunAvaamisTesti() {
        Ruutu ruutu = new Ruutu(3);
        assertFalse(ruutu.getAvattu());
        
        ruutu.avaaRuutu();
        assertTrue(ruutu.getAvattu());
    }
    
}
