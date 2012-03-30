package my.miinaharava;

import java.util.ArrayList;
import java.util.Random;

/**
 * Pelilogiikka- luokka määrittelee pelin toiminnallisuuden. Se sisältää julkiset metodit
 * asetaMiinatRuudukkoon ja asetaNumerotRuutuihin sekä näiden käyttämiä privaatteja
 * metodeita, tarkasteleRuudunYmparistoa ja KurkistaRuutuun.
 */
public class Pelilogiikka {
    
    private ArrayList<Integer> miinat;
//    private int rivit;
//    private int sarakkeet;
//    private int miinojenLkm;
//    
    
    /**
     * Metodi arpoo annetun miinojen määrän ruudukkoon. Metodi käyttää arpomiseen 
     * Random-luokasta luotua pseudorandom-muuttujaa. Miinojen paikkojen indeksit
     * arvotaan ArrayListiin. Tämän jälkeen käydään ruudukko läpi verraten samalla
     * ArrayListissä olevia indeksejä ja jos indeksit ovat samat, luodaan ruutuun
     * -1 -arvoinen Ruutu -olio eli miina.
     * 
     * @param ruudukko
     * @param miinojenLkm Haluttu miinojen lukumäärä
     * @return miinattu ruudukko
     */
    public Ruutu[][] asetaMiinatRuudukkoon(Ruutu[][] ruudukko, int miinojenLkm) {
        
        int rivit = ruudukko.length - 1;
        int sarakkeet = ruudukko[rivit].length - 1;
        miinat = new ArrayList<Integer>(miinojenLkm);   //säilöö indeksit, missä miinoja sijaitsee
        
        Random randomGeneraattori = new Random();
        for (int i = miinojenLkm; i > 0; i--) {
            while (true) {  //loopataan niin kauan et listaan ei tuu samoja lukuja
                int random = randomGeneraattori.nextInt(rivit * sarakkeet); //including-> 0 - (riv*sar)<- excluding
                if (!miinat.contains(random)) { 
                    miinat.add(random);
                    break;
                }
            }
        }
        
        int luku = 0;
        for (int i = 0; i < rivit; i++) {   //käydään ruudukko läpi ruutu ruudulta ja sijoitetaan miinat 'kartalle'
            for (int j = 0; j < sarakkeet; j++) {
                if (miinat.contains(luku))
                    ruudukko[i][j] = new Ruutu(-1); //miina = -1
                luku++;
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi tarkistaa ruudukossa olevien miinojen perusteella, mikä numero 
     * ruutuun kuuluu, vai tuleeko ruudusta tyhjä. Miinojen olinpaikat tarkistetaan
     * miinat-ArrayListin avulla, ja jos miina löytyy, ruudukon saman indeksin
     * kohdassa kutsutaan asetaNumero-metodia, joka tekee varsinaisen työn tarkastellessaan
     * ruudun ympärillä olevia ruutuja yksi kerrallaan.
     * 
     * @param ruudukko
     * @return numeroitu ruudukko
     */
    public Ruutu[][] asetaNumerotRuutuihin(Ruutu[][] ruudukko) {
        
        int ruudukonIndeksi = 0;
        
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[i].length; j++) {
                if (miinat.contains(ruudukonIndeksi)) {
                    asetaNumero(ruudukko, i, j);
                }
                ruudukonIndeksi++;
            }
        }
        return ruudukko;
    }
    
    /**
     * 
     * 
     * @param ruudukko
     * @param miinaniIndeksi
     * @param miinanjIndeksi 
     */
    private void asetaNumero(Ruutu[][] ruudukko, int miinaniIndeksi, int miinanjIndeksi) {
        
        int numero = 1; //ruutuun tuleva luku, tällä hetkellä vaan 1
        int luku = 0;
        for (int k = 0; k < ruudukko.length; k++) {
            for (int l = 0; l < ruudukko.length; l++) {
                
                for (int m = -1; m <= 1; m++) { //miinaa ympäröivä alue 3 x 3 ruutua, indekseistä katsoen -1 -> 1
                    for (int n = -1; n <= 1; n++) {   
                        if (kurkistaRuutuun(ruudukko, miinaniIndeksi + m, miinanjIndeksi + n)) { //katsotaan miinan ympärille
                            ruudukko[k][l] = new Ruutu(numero);
                        }
                        
                    }
                    
                }
                luku++;
            }
        }
        
        
    }
    
    /**
     * Palauttaa true, jos annettu ruutu on olemassa.
     * 
     * @param ruudukko
     * @param i
     * @param j
     * @return 
     */
    private boolean kurkistaRuutuun(Ruutu[][] ruudukko, int i, int j) {
        if (ruudukko[i][j] == null || ruudukko[i][j].getOminaisuus() == -1) {   //jos null tai jos miina
            return false;
        }
        return true;
    }
}