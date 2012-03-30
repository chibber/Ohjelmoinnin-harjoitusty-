package tetris;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class PalikkaTest {
    PalikkaI palikkaI;
    PalikkaJ palikkaJ;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() {
        palikkaI = new PalikkaI();
        palikkaJ = new PalikkaJ();
    }

    @Test
    public void yksiKaannos() {
        boolean[][] odotettu = palikkaI.getPalikanAsennot()[1];
        palikkaI.kierraPalikkaa();
        assertEquals(odotettu, palikkaI.getTamanHetkinenPalikka());
    }

    @Test
    public void kaksiKaannosta() {
        boolean[][] odotettu = palikkaI.getPalikanAsennot()[0];
        palikkaI.kierraPalikkaa();
        palikkaI.kierraPalikkaa();
        assertEquals(odotettu, palikkaI.getTamanHetkinenPalikka());
    }

//    @Test
//    public void JkaksiKaannosta() {
//        Palikka odotettu = palikkaJ.getHaluttuPalikka(0);
//        palikkaJ.kierraPalikkaa();
//        palikkaJ.kierraPalikkaa();
//        assertEquals(odotettu, palikkaJ.getTamanHetkinenPalikka());
//    }
//
//    @Test
//    public void kolmeKaannosta() {
//        Palikka odotettu = palikkaJ.getHaluttuPalikka(1);
//        palikkaJ.kierraPalikkaa();
//        palikkaJ.kierraPalikkaa();
//        palikkaJ.kierraPalikkaa();
//        assertEquals(odotettu, palikkaJ.getTamanHetkinenPalikka());
//    }

//    @Test
//    public void liikuOikealle() {
//        int odotettuY = 6;
//        assertEquals(odotettuY, palikkaJ.muutaKoordinaattia("y", 1));
//    }
//
//    @Test
//    public void liikuVasemmalle() {
//        int odotettuY = 4;
//        assertEquals(odotettuY, palikkaJ.muutaKoordinaattia("y", -1));
//    }
//
//    @Test
//    public void liikuAlas() {
//        int odotettuX = 1;
//        assertEquals(odotettuX, palikkaJ.muutaKoordinaattia("x", 1));
//    }

}