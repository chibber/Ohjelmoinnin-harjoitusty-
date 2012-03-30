package my.miinaharava;

/**
 * Ruudukko koostuu Ruuduista. Ruudulla on attribuutti ominaisuus, joka määrää,
 * millainen ruutu on ominaisuuksiltaan: tyhjä, numeroruutu vai miina. Ruudukko-luokka 
 * käyttää ruudukko-muuttujassaan Ruutu[][] -rakennetta.
 * 
 */
public class Ruutu {
    
    private int ominaisuus;
    
    /**
     * Konstruktori luo Ruutu-olion sellaisella ominaisuudella, joka parametrina annetaan.
     * 
     * @param ominaisuus Ruudun ominaisuuden määräävä luku.
     */
    public Ruutu(int ominaisuus) {
        this.ominaisuus = ominaisuus;
    }
    
    public int getOminaisuus() {
        return ominaisuus;
    }
}