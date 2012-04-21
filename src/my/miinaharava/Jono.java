package my.miinaharava;

import java.util.ArrayList;

/**
 * Jono on tietorakenne, joka nimensä mukaisesti toimii kuin jono. Ruutu-oliot lisätään
 * jonon alkuun ja otetaan jonon alusta. Jonoa käytetään avuksi Pelilogiikka-luokan metodissa 
 * avaaMiinattomatRuudut(), kun avatun tyhjän ruudun ympäriltä pitää löytää loput
 * miinattomat ruudut.
 */
public class Jono {
    
    private ArrayList<Ruutu> jono;
    
    /**
     * Konstrukstori luo Ruutu-tyyppisen ArrayListin jonossa olevia Ruutuja säilömään.
     */
    public Jono() {
        jono = new ArrayList<Ruutu>();
    }
    
    /**
     * Metodi lisää jonon loppuun annetun Ruutu-olion.
     * 
     * @param ruutu 
     */
    public void enqueue(Ruutu ruutu) {
        jono.add(ruutu);
    }
    
    /**
     * Metodi poistaa jonon ensimmäisen Ruutu-olion.
     * 
     * @return 
     */
    public Ruutu dequeue() {
        return jono.remove(0);
    }
    
    public Ruutu getEkaSolmu() {
        return jono.get(0);
    }
    
    public int getSize() {
        return jono.size();
    }
    
}