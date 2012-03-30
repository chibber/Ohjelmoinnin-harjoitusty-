package tetris;
import java.util.Random;

/**
 * PalikanArpoja -luokka arpoo seitsemästä eri palikasta seuraavaksi tulevan palikan.
 * Palikka tulee olemaan joko I:n, T:n, O:n, L:n, J:n, Z:n tai S:n muotoinen.
 */
public class PalikanArpoja {
    private Palikka arvottu;

    /**
     * Metodi arpoo jonkin palikoista I,T,O,L,J,Z tai S arvoLuku()-metodin avulla
     *
     * @see tetris.PalikanArpoja#arvoLuku() 
     *
     * @return arvottu palikka
     */
    public Palikka arvoPalikka() {
        int arvottuLuku = arvoLuku();
        if (arvottuLuku == 0)
            arvottu = new PalikkaI();
        else if (arvottuLuku == 1)
            arvottu = new PalikkaT();
        else if (arvottuLuku == 2)
            arvottu = new PalikkaO();
        else if (arvottuLuku == 3)
            arvottu = new PalikkaL();
        else if (arvottuLuku == 4)
            arvottu = new PalikkaJ();
        else if (arvottuLuku == 5)
            arvottu = new PalikkaZ();
        else
            arvottu = new PalikkaS();
        return arvottu;
    }

    /**
     * Metodi arpoo luvun väliltä 1-7, josta määräytyy, mikä palikka tulee seuraavaksi
     * @return arvottu luku
     */
    public int arvoLuku() {
        Random r = new Random();
        int random = r.nextInt(7);
        return random;
    }

}