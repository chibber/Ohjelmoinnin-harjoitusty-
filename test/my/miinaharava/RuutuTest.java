package my.miinaharava;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vilma
 */
public class RuutuTest {
    
    private Ruutu[][] ruudukko;
    
    /**
     * Testaa, että uutta ruutua luodessa annettu numero menee kohdilleen. Lisäksi
     * getOminaisuus-metodi tulee samalla testatuksi.
     */
    @Test
    public void numeronAsettaminenToimii() {
        assertEquals(new Ruutu(1, 0, 0).getOminaisuus(), 1);
        assertEquals(new Ruutu(5, 1, 1).getOminaisuus(), 5);
    }

    /**
     * Testaa, että ruudun avaaminen toimii. Ensin varmistetaan, että uuden ruudun
     * avattu-attribuutti on false eli ruutu on avaamaton. Sitten käytetään avaaRuutu()
     * -metodia ja tarkistetaan, että avattu on true.
     */
    @Test
    public void ruudunAvaamisTesti() {
        Ruutu ruutu = new Ruutu(3, 2, 2);
        assertFalse(ruutu.getAvattu());
        
        ruutu.avaaRuutu();
        assertTrue(ruutu.getAvattu());
    }
    
    /**
     * Testaa, että rivien ja sarakkeiden asettaminen toimii Ruudun luomisessa. GetRivi()
     * ja getSarake() -metodeilla pääsee tarkasetelemaan tarvittuja indeksiarvoja.
     */
    @Test
    public void testaaRuudunSijaintiIndeksejä() {
        int rivi = 5;
        int sarake = 6;
        ruudukko = new Ruutu[10][10];
        ruudukko[rivi][sarake] = new Ruutu(-1, rivi, sarake);
        assertEquals(ruudukko[rivi][sarake].getRivi(), rivi);
        assertEquals(ruudukko[rivi][sarake].getSarake(), sarake);
    }
    
}