package tetris;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PalikkaJTest testaa PalikkaJ-luokan toimintaa.
 */
public class PalikkaJTest {
    PalikkaJ palikkaJ;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() {
        palikkaJ = new PalikkaJ();
    }

    @Test
    public void ekanPalikanTestaus() {
        assertTrue(palikkaJ.getPalikanAsennot()[0][3][1]);
        assertTrue(!palikkaJ.getPalikanAsennot()[0][2][2]);
    }

    @Test
    public void kolmannenPalikanTestaus() {
        assertTrue(palikkaJ.getPalikanAsennot()[2][2][1]);
        assertTrue(!palikkaJ.getPalikanAsennot()[2][0][1]);
    }

}