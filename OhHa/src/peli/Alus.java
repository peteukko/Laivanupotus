package peli;

import java.util.ArrayList;

public class Alus extends Ruutulista {
 

    private int pituus;
    //private String nimi;

    public Alus(int pituus, String nimi) {
        super(nimi);
        this.pituus = pituus;
        
        // Asetetaan "nollaruutu" joten Alus-olio ei ole koskaan tyhjä (voi kenties tulla ongelmia)
        Ruutu existentiaaliRuutu = new Ruutu(0, 0);
        this.lisaaRuutuOlio(existentiaaliRuutu); 

    }

    // Ensimmäinen toteutus: Vain Yhden ruudun aluksia (myöhemmin tulee kysymys, miten aluksen orientaatio toteutetaan)
    public void asetaAlus(int x, int y) {
        super.lisaaRuutu(x, y);
    }

    // Toinen versio: Alus asetetaan ruutuihin, jonka määrittää ruutujen määrä (aluksen pituus)
    // ja int suunta: 1 = lähtöruudusta itään, 2 = etelään, 3 = länteen, 4 = pohjoiseen
    // metodi palauttaa true jos aluksen asetus onnistuu (alus ei mee laudan ulkopuolelle jne)
    // Alus voidaan vain asettaa ruutuihin, jossa ei jo ole alusta, ja joka on pelilaudan sisällä.
    // Pidetään listaa kevollisista ruuduista : Ruutulista sallitut otetaan argumenttina metodiin.
    public Ruutulista asetaAlusKunnolla(int x, int y, int suunta, Ruutulista sallitut) {
        //Ruutu lahtoRuutu = new Ruutu(x, y);
        Ruutulista lisattavat = new Ruutulista();

        if (suunta == 1) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu(x + i, y));
            }
        } else if (suunta == 2) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu(x, y + i));
            }
        } else if (suunta == 3) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu(x - i, y));
            }
        } else if (suunta == 4) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu(x, y - i));
            }
        }

        boolean onnistuuko = lisattavat.onkoKaikkiRuudutTassaListassaMyosArgumentinListassa(sallitut);
        if (onnistuuko) {
            super.lisaaRuutulistaTahanRuutuListaan(lisattavat);
            sallitut.poistaArgumentinRuudutTastaRuutulistasta(lisattavat);

        }
        return sallitut;

    }

    //  if kelvollisetRuudut.includes.laitettavat
    //
    //
    public void poistaRuutu(Ruutu ruutu) {
        //Alus.remove(ruutu);
        super.poistaRuutuOlio(ruutu);
    }

    public String toString() {
        if (super.getRuutujenLkm() == 1) {
            return nimi + ", koko: " + pituus + ", TUHOUTUNUT!";
        } else {
            String palautettava = "";
            palautettava = palautettava + nimi + ", koko: " + pituus + ", ruutuja jaljella: " + (super.getRuutujenLkm() - 1)
                    + "\n Ruutujen koordinaatit: ";
            //for (Ruutu aluksenruutu:Alus) {
            //    palautettava = palautettava + aluksenruutu.toString() + " | ";
            //}
            return palautettava + super.toString();
        }
    }

    //public int montakoRuutuaJaljella() {
    //  super.getRuutujenLkm();
    //return Alus.size();
    //}
    public void josAluksellaTamaRuutuTuhoaSe(int x, int y) {

        // ArrayList<Ruutu> tuhottava = new ArrayList<Ruutu>();
        super.poistaRuutu(x, y);
        // for (Ruutu ruutu : Alus) {
//
        //          if (ruutu.matchaakoKoordinaatit(x, y)) {
        //            tuhottava.add(ruutu);

        //          }
//
        //    }
        //  Alus.removeAll(tuhottava);
    }

    public boolean onkoTuhoutunut() {
        if (super.getRuutujenLkm() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
