package tetris;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class PalikanArpojaTest {
    PalikanArpoja palikanarpoja;

    @Before
    public void setUp() {
        palikanarpoja = new PalikanArpoja();
    }

    /**
     * ArvoLuku -metodin testi, luokkana PalikanArpoja
     */
    @Test
    public void onkoOikeanKokoinenLuku() {
        int tulos = palikanarpoja.arvoLuku();
        assertTrue(tulos < 7 && tulos >= 0);
    }

//    @Test
//    public void josArpooPalikkaInMeneekoOikein() {
//        Palikka I = new PalikkaI();
//        Palikka arvottu = palikanarpoja.arvoPalikka();
//        while (arvottu != I)
//            palikanarpoja.arvoPalikka();
//        assertEquals(I, arvottu);
//    }

}