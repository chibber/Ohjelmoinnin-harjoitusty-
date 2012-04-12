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
    
    /**
     * Konstruktori luo Ruutu-olion sellaisella ominaisuudella, joka parametrina annetaan.
     * -1 on miina, 0 tyhjä, ja 1-8 numeroruutu. Ruutu on alussa avaamaton, joten 
     * avattu-attribuutti saa arvon false.
     * 
     * @param ominaisuus Ruudun ominaisuuden määräävä luku.
     */
    public Ruutu(int ominaisuus) {
        this.ominaisuus = ominaisuus;
        this.avattu = false;
    }
    
    /**
     * Metodi avaa ruudun, eli muuttaa avattu-attribuutin arvoon true.
     */
    public void avaaRuutu() {
        this.avattu = true;
    }
    
    public int getOminaisuus() {
        return ominaisuus;
    }
    
    public boolean getAvattu() {
        return avattu;
    }
}