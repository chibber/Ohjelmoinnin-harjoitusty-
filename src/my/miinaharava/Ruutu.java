package my.miinaharava;

/**
 * Ruudukko koostuu Ruuduista. Ruudulla on attribuutit ominaisuus ja avattu. Ominaisuus
 * on kokonaisluku väliltä -1 - 8, ja se kertoo, onko ruutu tyhjä, miinoitettu vai
 * nuimeroitu. Toinen attribuutti avattu kertoo, onko ruutu avattu (true) vai avaamaton (false).
 * Ruudukko-luokka käyttää ruudukko-muuttujassaan Ruutu[][] -rakennetta.
 */
public class Ruutu {
    
    private int ominaisuus;
    private boolean avattu;
    private int rivi;
    private int sarake;
    private boolean merkitty;
    
    /**
     * Konstruktori luo Ruutu-olion sellaisella ominaisuudella, joka parametrina annetaan.
     * Lisäksi parametreina annetut rivi ja sarake ovat ruudun sijainnin ruudukossa
     * kertovat attribuutit. Ominaisuuksista -1 on miina, 0 tyhjä, ja 1-8 numeroruutu. 
     * Ruutu on alussa avaamaton, joten avattu-attribuutti saa arvon false.
     * 
     * @param ominaisuus Ruudun ominaisuuden määräävä luku
     * @param rivi Ruudun rivin indeksi ruudukossa
     * @param sarake Ruudun sarakkeen indeksi ruudukossa
     */
    public Ruutu(int ominaisuus, int rivi, int sarake) {
        this.ominaisuus = ominaisuus;
        this.avattu = false;
        this.rivi = rivi;
        this.sarake = sarake;
        this.merkitty = false;
    }
    
    /**
     * Metodi avaa ruudun, eli muuttaa avattu-attribuutin arvoon true. Kun ruutu on
     * kerran avattu, sitä ei saa enää kiinni, paitsi kun aloittaa uuden pelin.
     */
    public void avaaRuutu() {
        avattu = true;
    }
    
    /**
     * Merkitsee Ruudun joko miinaksi tai takaisin tavalliseksi ruuduksi.
     */
    public void merkitseRuutu() {
        if (merkitty == false)
            merkitty = true;
        else    merkitty = false;
    }
    
    public boolean getAvattu() {
        return avattu;
    }
    
    public int getOminaisuus() {
        return ominaisuus;
    }
    
    public int getRivi() {
        return rivi;
    }
    
    public int getSarake() {
        return sarake;
    }
    
}