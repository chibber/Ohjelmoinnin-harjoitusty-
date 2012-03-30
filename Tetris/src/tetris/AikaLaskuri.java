package tetris;

/**
 * AikaLaskuri -luokka laskee, kuinka kauan pelaajan peli kestää.
 */
public class AikaLaskuri {
    private long alkuAika;
    private long loppuAika;
    private long aika;

    public void aloita() {
        this.alkuAika = System.currentTimeMillis();
    }

    public void lopeta() {
        this.loppuAika = System.currentTimeMillis();
        this.aika = loppuAika - alkuAika;
    }

    public void resetAika() {
        this.aika = 0;
    }

}
