package tetris;

public class Ruutu {
    public static final boolean VARATTU = true;
    public static final boolean VAPAA = false;

    private static boolean ruudunTila;

    public Ruutu() {
        ruudunTila = VAPAA;
    }

    public boolean onkoVapaa() {
        return ruudunTila;
    }

    public void asetaVaratuksi() {
        ruudunTila = VARATTU;
    }

    public void vapauta() {
        ruudunTila = VAPAA;
    }

//    public Ruutu muutaRuudunTilaa(int muutos) {
//        Ruutu ruutu = new Ruutu();
//        if (muutos == 1) {
//            ruutu.ruudunTila = VARATTU;
//            return ruutu;
//        }
//        else {
//            ruutu.ruudunTila = VAPAA;
//            return ruutu;
//        }
//    }
}
