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
    public Ruutu[][] asetaMiinatRuudukkoon(Ruutu[][] ruudukko, int miinojenLkm, int aloitusRivi, int aloitusSarake) {
        
        int ruudukonIndeksi = 0;
        int rivienLkm = ruudukko.length;
        int sarakkeidenLkm = ruudukko[rivienLkm - 1].length;    //!!
        miinat = new ArrayList<Integer>(miinojenLkm);   //säilöö indeksit, missä miinoja sijaitsee
        int aloitusRuutu = laskeKokonaisIndeksi(ruudukko, aloitusRivi, aloitusSarake);
        ArrayList<Integer> aloitusRuudunVierukset = etsiAloitusRuudunVierukset(ruudukko, aloitusRivi, aloitusSarake);
        
        Random randomGeneraattori = new Random();
        int random;
        for (int i = miinojenLkm; i > 0; i--) {
            while (true) {  //loopataan niin kauan et listaan ei tuu samoja lukuja
                random = randomGeneraattori.nextInt(rivienLkm * sarakkeidenLkm); //including-> 0 - (riv*sar)<- excluding
                if (!miinat.contains(random) && random != aloitusRuutu && !aloitusRuudunVierukset.contains(random)) { 
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
                    ruudukko[i][j] = new Ruutu(-1, i, j); //miina = -1
                ruudukonIndeksi++;
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi laskee aloitusruudulle indeksin, jota voi verrata miinat -listan indekseihin,
     * jotta ensimmäinen pelaajan painama ruutu ei olisi heti miinaruutu.
     * 
     * @param ruudukko
     * @param rivi
     * @param sarake
     * @return aloitusruudun lukuarvo
     */
    public int laskeKokonaisIndeksi(Ruutu[][] ruudukko, int rivi, int sarake) {
        int indeksi = 0;
        boolean loytyi = false;
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[ruudukko.length - 1].length; j++) {  //lasketaan aloitusruudun indeksi
                if (i == rivi && j == sarake) {
                    loytyi = true;      break;
                }
                indeksi++;
            }
            if (loytyi)    break;
        }
        return indeksi;
    }
    
    /**
     * 
     * 
     * @param ruudukko
     * @param rivi
     * @param sarake
     * @return 
     */
    public ArrayList<Integer> etsiAloitusRuudunVierukset(Ruutu[][]ruudukko, int rivi, int sarake) {
        ArrayList<Integer> vierukset = new ArrayList<Integer>();
        
        for (int i = 0; i < 8; i++) {
            try {
                Ruutu vierus = getVierusSolmu(ruudukko, rivi, sarake, i);
                vierukset.add(laskeKokonaisIndeksi(ruudukko, vierus.getRivi(), vierus.getSarake()));
            }
            catch (NullPointerException e) { }
        }
        return vierukset;
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
    public Ruutu[][] asetaNumerotRuudukkoon(Ruutu[][] ruudukko, int rivit, int sarakkeet) {
        
        int ruudukonIndeksi = 0;
        int rivienLkm = ruudukko.length;
        int sarakkeidenLkm = ruudukko[rivienLkm - 1].length; //!!
        
        for (miinaniIndeksi = 0; miinaniIndeksi < rivienLkm; miinaniIndeksi++) {
            for (miinanjIndeksi = 0; miinanjIndeksi < sarakkeidenLkm; miinanjIndeksi++) {
                if (miinat.contains(ruudukonIndeksi)) {
                    tarkasteleMiinaRuudunYmparistoa(ruudukko);
                }
                ruudukonIndeksi++;
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi tarkistaa, sijaitseeko miina kentän reunassa. Jos on, metodi asettaa
     * oikeat indeksit läpikäytäville ruuduille. Lopuksi metodi kutsuu asetaNumerot()
     * -metodia oikeilla parametreilla, joka varsinaisesti asettaa itse numerot ruutuihin.
     * 
     * @param ruudukko
     * @param miinaniIndeksi
     * @param miinanjIndeksi
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
     * Metodi saa parametreinaan miinaruutua ympäröivien ruutujen tiedot, ja niiden perusteella
     * numeroi oikeat ruudut oikealla tavalla.
     * 
     * @param ruudukko 
     * @param alkuI
     * @param alkuJ 
     * @param maxI 
     * @param maxJ 
     */
    private void asetaNumerot(Ruutu[][] ruudukko, int alkuI, int alkuJ, int maxI, int maxJ) {    //i ja j määräävät, miten leveä rivi on vai onko sitä ollenkaan(?)
        
        for (int k = alkuI; k <= maxI; k++) {
            for (int l = alkuJ; l <= maxJ; l++) {
                int nykyinenNumero = ruudukko[miinaniIndeksi + k][miinanjIndeksi + l].getOminaisuus();
                
                if (ruudukko[miinaniIndeksi + k][miinanjIndeksi + l].getOminaisuus() != -1) {  //jos ei miina
                    ruudukko[miinaniIndeksi + k][miinanjIndeksi + l] = new Ruutu(nykyinenNumero + 1, miinaniIndeksi + k, miinanjIndeksi + l);
                }
            }
        }
    }
    
    /**
     * Jos pelaaja osuu arvatessan tyhjään ruutuun, niin tämä metodi avaa kaikki
     * tyhjää ruutua ja sen vierekkäiset ja niiden vierekkäiset (jne) ruudut. Metodi 
     * ei avaa vain tyhjiä ruutuja, sillä myös tyhjää aluetta ympäröivä 
     * numeroruutujen ketju täytyy avata. Ruudun avauksessa metodi kutsuu Ruutu-luokan
     * metodia avaaRuutu(). Metodi käyttää avattavien ruutujen etsinnässä apunaan 
     * Jono-luokkaa. Menettely liittyy rakenteellisesti verkkoihin, joten 
     * ruuduista käytetään osittain myös solmu-termiä. Tietyn ruudun vierekkäisiä
     * ruutuja tarkastellessa metodi käyttää getVierusSolmu() -metodia.
     * 
     * @param ruudukko 
     * @param ekanRuudunRivi Avatun ruudun rivi-indeksi 
     * @param ekanRuudunSarake Avatun ruudun sarake-indeksi
     */
    public void avaaMiinattomatRuudut(Ruutu[][] ruudukko, int ekanRuudunRivi, int ekanRuudunSarake) { 
        
        Jono jono = new Jono();
        ruudukko[ekanRuudunRivi][ekanRuudunSarake].avaaRuutu();
        jono.enqueue(ruudukko[ekanRuudunRivi][ekanRuudunSarake]); //jonoon
        
        while (jono.getSize() != 0) {
            Ruutu jononEkaSolmu = jono.dequeue(); 
            ekanRuudunRivi = jononEkaSolmu.getRivi();
            ekanRuudunSarake = jononEkaSolmu.getSarake();
            
            for (int i = 0; i < 8; i++) {       //solmua ympäröiviä ruutuja 8
                
                try {
                    Ruutu ekanSolmunVierusSolmu = getVierusSolmu(ruudukko, ekanRuudunRivi, ekanRuudunSarake, i);
                    
                    if (!ekanSolmunVierusSolmu.getAvattu()) {
                        ekanSolmunVierusSolmu.avaaRuutu(); 
                        
                        if (ekanSolmunVierusSolmu.getOminaisuus() > 0) {
                            continue;
                        }
                        jono.enqueue(ekanSolmunVierusSolmu);
                    }
                } catch (NullPointerException e) { }
            }
        }
    }
    
    /**
     * Metodi tarkistaa, onko tietystä paikasta etsitty solmu ruudukon ulkopuolella
     * ja mitkä indeksit se tarvitsee ollakseen haluttu solmu.
     * 
     * @param ruudukko
     * @param rivi solmun, jonka ympäriltä vierussolmuja etsitään, rivi
     * @param sarake solmun, jonka ympäriltä vierussolmuja etsitään, sarake
     * @param i ympäröivien ruutujen 'järjestysnumeroa' kuvaava parametri
     * @return vierussolmu
     */
    public Ruutu getVierusSolmu(Ruutu[][] ruudukko, int rivi, int sarake, int i) {
        
        int iMuutos;
        int jMuutos;
        
        if (i == 0) {
            if (rivi - 1 < 0 || sarake - 1 < 0)
                return null;
            iMuutos = -1;   jMuutos = -1;
        }
        else if (i == 1) {
            if (rivi - 1 < 0)
                return null;
            iMuutos = -1;    jMuutos = 0;
        }
        else if (i == 2) {
            if (rivi - 1 < 0 || sarake + 1 > ruudukko[rivi ].length - 1)     //..
                return null;
            iMuutos = -1;    jMuutos = 1;
        }
        else if (i == 3) {
            if (sarake - 1 < 0)
                return null;
            iMuutos = 0;    jMuutos = -1;
        }
        else if (i == 4) {
            if (sarake + 1 > ruudukko[rivi ].length - 1)
                return null;
            iMuutos = 0;    jMuutos = 1;
        }
        else if (i == 5) {
            if (rivi + 1 > ruudukko.length - 1 || sarake - 1 < 0)
                return null;
            iMuutos = 1;    jMuutos = -1;
        }
        else if (i == 6) {
            if (rivi + 1 > ruudukko.length - 1)
                return null;
            iMuutos = 1;    jMuutos = 0;
        }
        else {
            if (rivi + 1 > ruudukko.length - 1 || sarake + 1 > ruudukko[rivi ].length - 1)
                return null;
            iMuutos = 1;    jMuutos = 1;
        }
        
        Ruutu solmu = ruudukko[rivi + iMuutos][sarake + jMuutos];
        
        return solmu;
    }
    
}