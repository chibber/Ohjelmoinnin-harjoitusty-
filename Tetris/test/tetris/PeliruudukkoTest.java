package tetris;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliruudukkoTest {
    private Peliruudukko ruudukko;

    @Before
    public void setUp() {
        ruudukko = new Peliruudukko();
    }

    @Test
    public void uudenPalikanLisaysRuudukkoon() {
        ruudukko.uusiPalikkaRuudukkoon();
        assertTrue(!ruudukko.getRuudukko()[18][10].onkoVapaa());
//        assertTrue(ruudukko.getRuudukko()[1][6].onkoVapaa() || ruudukko.getRuudukko()[2][6].onkoVapaa());
//        assertTrue(!ruudukko.getRuudukko()[0][2].onkoVapaa());
    }

    @Test
    public void asd() {
        ruudukko.getRuudukko()[1][1].asetaVaratuksi();
        assertTrue(ruudukko.getRuudukko()[6][10].onkoVapaa());
    }

}