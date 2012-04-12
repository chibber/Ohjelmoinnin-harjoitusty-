package my.miinaharava;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vilma
 */
public class PelilogiikkaTest {
    
    Pelilogiikka logiikka;
    Ruutu[][] ruudukko;
    int rivit;
    int sarakkeet;
    int miinojenLkm;
    
    
    @Before
    public void setUp() {
        logiikka = new Pelilogiikka();
    }
    
    /**
     * Testi varmistaa, että ruudukkoon menee yhtä paljon miinoja kuin parametreina
     * annetaan.
     */
    @Test 
    public void oikeaMaaraMiinoja() {
        miinojenLkm = 13;
        rivit = 10;
        sarakkeet = 10;
        ruudukko = new Ruutu[rivit][sarakkeet];
        alustaRuudukko(ruudukko);
        
        assertEquals(laskeMiinat(), 0);
        logiikka.asetaMiinatRuudukkoon(ruudukko, miinojenLkm, 0, 0);
        assertEquals(laskeMiinat(), miinojenLkm);
    }
    
    /**
     * Testin oiekaMaaraMiinoja käyttämä metodi miinojen laskemiseen.
     * @return miinojen lukumäärä
     */
    private int laskeMiinat() {
        int miinat = 0;
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[i].length; j++) {
                if (ruudukko[i][j].getOminaisuus() == -1)
                    miinat++;
            }
        }
        return miinat;
    }
    
    /**
     * Testiluokan oma alustusmetodi ruudukolle. Asettaa jokaisen ruudukon ruudun arvoksi 0.
     */
    private void alustaRuudukko(Ruutu[][] ruudukko) {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[i].length; j++) {
                ruudukko[i][j] = new Ruutu(0);
            }
        }
    }
}