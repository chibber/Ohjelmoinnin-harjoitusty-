package my.miinaharava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Pelilogiikka- luokka määrittelee pelin toiminnallisuuden. Se sisältää julkiset metodit
 * asetaMiinatRuudukkoon ja asetaNumerotRuutuihin sekä näiden käyttämiä privaatteja
 * metodeita, tarkasteleRuudunYmparistoa ja KurkistaRuutuun.
 */
public class Pelilogiikka {
    
    private ArrayList<Integer> miinat;
//    private int ruudukonIndeksi = 0;
    private int miinaniIndeksi = 0;
    private int miinanjIndeksi = 0;
    
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
        
        int ruudukonIndeksi = 0;
        int rivienLkm = ruudukko.length;
        int sarakkeidenLkm = ruudukko[rivienLkm - 1].length;    //!!
        miinat = new ArrayList<Integer>(miinojenLkm);   //säilöö indeksit, missä miinoja sijaitsee
        
        Random randomGeneraattori = new Random();
        int random = 0;
        for (int i = miinojenLkm; i > 0; i--) {
            while (true) {  //loopataan niin kauan et listaan ei tuu samoja lukuja
                random = randomGeneraattori.nextInt(rivienLkm * sarakkeidenLkm); //including-> 0 - (riv*sar)<- excluding
                if (!miinat.contains(random)) { 
                    miinat.add(random);
                    break;
                }
            }
        }
        
        //väliaik.
        Collections.sort(miinat);
        System.out.println(miinat.toString());
        
        
        for (int i = 0; i < ruudukko.length; i++) {   //käydään ruudukko läpi ruutu ruudulta ja sijoitetaan miinat 'kartalle'
            for (int j = 0; j < ruudukko[ruudukko.length - 1].length; j++) {        //!!
                if (miinat.contains(ruudukonIndeksi))
                    ruudukko[i][j] = new Ruutu(-1); //miina = -1
                ruudukonIndeksi++;
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi tarkistaa ruudukossa olevien miinojen perusteella, mikä numero 
     * ruutuun kuuluu, vai tuleeko ruudusta tyhjä. Miinojen olinpaikat tarkistetaan
     * miinat-ArrayListin avulla, ja jos miina löytyy, ruudukon saman indeksin
     * kohdassa kutsutaan asetaNumerotMiinanYmparille-metodia, joka tekee varsinaisen 
     * työn tarkastellessaan ruudun ympärillä olevia ruutuja yksi kerrallaan.
     * 
     * @param ruudukko
     * @return numeroitu ruudukko
     */
    public Ruutu[][] asetaNumerotRuudukkoon(Ruutu[][] ruudukko) {
        
        int ruudukonIndeksi = 0;
        int rivienLkm = ruudukko.length;
        int sarakkeidenLkm = ruudukko[rivienLkm - 1].length; //!!
        
        for (miinaniIndeksi = 0; miinaniIndeksi < rivienLkm; miinaniIndeksi++) {
            for (miinanjIndeksi = 0; miinanjIndeksi < sarakkeidenLkm; miinanjIndeksi++) {
                if (miinat.contains(ruudukonIndeksi)) {
                    tarkasteleMiinaRuudunYmparistoa(ruudukko);//, miinaniIndeksi, miinanjIndeksi);
                }
                ruudukonIndeksi++;
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi tarkistaa, sijaitseeko miina kentän reunassa. Jos on, metodi asettaa
     * oikeat indeksit läpikäytäville ruuduille.
     * 
     * @param ruudukko
     * @param miinaniIndeksi
     * @param miinanjIndeksi
     * @return 
     */
    public void tarkasteleMiinaRuudunYmparistoa(Ruutu[][] ruudukko) {//, int miinaniIndeksi, int miinanjIndeksi) {
        
        int muutosiIndeksiinAlussa = -1; //jos miina ei ole reunassa, alkuindeksit == -1
        int muutosjIndeksiinAlussa = -1;
        int maxMuutosiIndeksiin = 1; // jos miina ei ole reunassa, loppuindeksit == 1
        int maxmuutosjIndeksiin = 1;
        
        if (miinaniIndeksi - 1 < 0) {
            muutosiIndeksiinAlussa = 0;
        }
        
        else if (miinaniIndeksi + 1 > ruudukko.length - 1) {
            maxMuutosiIndeksiin = 0;
        }
        
        if (miinanjIndeksi - 1 < 0) {
            muutosjIndeksiinAlussa = 0;
        }
        
        else if (miinanjIndeksi + 1 > ruudukko[ruudukko.length - 1].length - 1) {
            maxmuutosjIndeksiin = 0;
        }
        
        asetaNumerot(ruudukko, muutosiIndeksiinAlussa, muutosjIndeksiinAlussa, maxMuutosiIndeksiin, maxmuutosjIndeksiin);
    }

    /**
     * 
     * 
     * @param alkuI
     * @param alkuJ 
     */
    private void asetaNumerot(Ruutu[][] ruudukko, int alkuI, int alkuJ, int maxI, int maxJ) {    //i ja j määräävät, miten leveä rivi on vai onko sitä ollenkaan(?)
        
        for (int k = alkuI; k <= maxI; k++) {
            for (int l = alkuJ; l <= maxJ; l++) {
                int nykyinenNumero = ruudukko[miinaniIndeksi + k][miinanjIndeksi + l].getOminaisuus();
                
                if (ruudukko[miinaniIndeksi + k][miinanjIndeksi + l].getOminaisuus() != -1) {  //jos ei miina
                    ruudukko[miinaniIndeksi + k][miinanjIndeksi + l] = new Ruutu(nykyinenNumero + 1);
                }
            }
        }
    }
    
    
}