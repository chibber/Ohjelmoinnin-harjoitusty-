package tetris;

/**
 * Palikka on abstrakti luokka, josta kaikki eri palikat saavat ominaisuuksia.
 */
public abstract class Palikka {
    private int palikanNytAsentoIndex;

    /**
     *
     */
    public Palikka() {
        this.palikanNytAsentoIndex = 0;
    }

    public abstract boolean[][][] getPalikanAsennot();

    public boolean[][] getTamanHetkinenPalikka() {
        return getPalikanAsennot()[palikanNytAsentoIndex];
    }

    public void kierraPalikkaa() {
        if (palikanNytAsentoIndex + 1 == getPalikanAsennot().length)
            palikanNytAsentoIndex = 0;
        else
            palikanNytAsentoIndex++;
    }

//    public int muutaPalikanAsentoIndexia() {
//        if (palikanNytAsentoIndex + 1 == getPalikanAsennot().length)
//            palikanNytAsentoIndex = 0;
//        else
//            palikanNytAsentoIndex++;
//
//        return palikanNytAsentoIndex;
//    }

//    public int muutaKoordinaattia(String koord, int muutos) {
//        if (koord.equals("x"))
//            return xKoord + muutos;
//        else
//            return yKoord + muutos;
//    }
    
}