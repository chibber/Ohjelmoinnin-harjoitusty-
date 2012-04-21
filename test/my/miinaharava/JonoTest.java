/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.miinaharava;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vilma
 */
public class JonoTest {
    
    private Jono jono;
    
    /**
     * Testaa jonon metodeja enqueue() ja dequeue(). Enqueue lisää jonon viimeiseksi
     * alkioksi Ruutu-olion, ja dequeue poistaa jonon ensimmäisen Ruutu-olion.
     */
    @Test
    public void testaaEnqueueJaDequeue() {
        jono = new Jono();
        jono.enqueue(new Ruutu(1, 0, 0));
        jono.enqueue(new Ruutu(2, 0, 0));
        jono.enqueue(new Ruutu(3, 0, 0));
        assertEquals(jono.getEkaSolmu().getOminaisuus(), 1);
        assertEquals(jono.dequeue().getOminaisuus(), 1);
        assertEquals(jono.dequeue().getOminaisuus(), 2);
        assertEquals(jono.getEkaSolmu().getOminaisuus(), 3);
    }
    
    /**
     * Testaa jonon geSize() -metodia. Metodi palauttaa jonon koon as in kuinka
     * monta alkiota jonossa sillä hetkellä on.
     */
    @Test
    public void jononSizeTesti() {
        jono = new Jono();
        assertEquals(jono.getSize(), 0);
        jono.enqueue(new Ruutu(1, 0, 0));
        jono.enqueue(new Ruutu(2, 0, 0));
        assertEquals(jono.getSize(), 2);
        jono.enqueue(new Ruutu(3, 0, 0));
        assertEquals(jono.getSize(), 3);
    }
    
}
