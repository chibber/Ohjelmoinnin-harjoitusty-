package tetris;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PalikkaITest testaa PalikkaI-luokan toimintaa.
 */
public class PalikkaITest {

    PalikkaI palikkaI;

    @Before
    public void setUp() {
        palikkaI = new PalikkaI();
    }

    @Test
    public void ekanPalikanTestaus() {
        assertTrue(palikkaI.getPalikanAsennot()[0][1][1]);
        assertTrue(!palikkaI.getPalikanAsennot()[0][1][2]);
    }

    @Test
    public void tokanPalikanTestaus() {
        assertTrue(palikkaI.getPalikanAsennot()[1][2][2]);
        assertTrue(!palikkaI.getPalikanAsennot()[1][3][3]);
    }

}