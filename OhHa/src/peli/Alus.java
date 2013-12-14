package peli;

import java.util.ArrayList;
/**
 * Alus on Ruutulistan aliluokka. Sillä on Ruutulistan ominaisuuksien lisäksi
 * int pituus (1-5) joka merkkaa minkä pituisesta aluksesta on kyse, sekä nimi:
 * esim taistelulaiva on 4 ruudun pituinen alus.
 * @author peter_000
 */
public class Alus extends Ruutulista {

    //Onko alus asetettu laudalle: false, ennen kuin se asetetaan
    private boolean onkoAsetettu;
    private int pituus;
    private String nimi;

    public Alus(int pituus, String nimi) {
        super();
        onkoAsetettu = false;
        this.pituus = pituus;
        this.nimi = nimi;

        // Asetetaan "nollaruutu" joten Alus-olio ei ole koskaan tyhjä (voi kenties tulla ongelmia)
        Ruutu existentiaaliRuutu = new Ruutu(0, 0);
        this.lisaaRuutuOlio(existentiaaliRuutu);
    }

  

    /**
     * Aluksen Asettaminen kunnolla: Alus asetetaan ruutuihin, jotka määriytyy
     * "lähtöruudusta", ruutujen määrästä (aluksen pituus) ja suunnasta. Alus
     * voidaan vain asettaa ruutuihin, jossa ei jo ole alusta, ja joka on
     * pelilaudan sisällä. // Pidetään listaa kevollisista ruuduista :
     * Ruutulista sallitut otetaan argumenttina metodiin.
     *
     * @param x x-koordinaatti
     * @param y y-kordinaatti
     * @param suunta 1 = lähtöruudusta itään, 2 = etelään, 3 = länteen, 4 =
     * pohjoiseen.
     * @param sallitut Pidetään listaa kevollisista ruuduista, jota muokataan
     * metodissa
     * @return onnistuuko oliko kaikki ruudut kelvollisia, onnistuiko aluksen
     * sijoitus.
     */
    public boolean asetaAlusKunnolla(int x, int y, int suunta, Ruutulista sallitut) {
        //Ruutu lahtoRuutu = new Ruutu(x, y);
        Ruutulista lisattavat = new Ruutulista();

        if (pituus == 1) {
            lisattavat.lisaaRuutuOlio(new Ruutu(x,y));
        }
        else if (suunta == 1) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu((x + i), y));
                System.out.println("| x"+Integer.toString(x+i)+"| y "+Integer.toString(y));
            }
        } else if (suunta == 2) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu(x, (y + i)));
            }
        } else if (suunta == 3) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu((x - i), y));
            }
        } else if (suunta == 4) {
            for (int i = 0; i < pituus; i++) {
                lisattavat.lisaaRuutuOlio(new Ruutu(x, (y - i)));
            }
        }

        boolean onnistuuko = lisattavat.onkoKaikkiRuudutTassaListassaMyosArgumentinListassa(sallitut);
        if (onnistuuko) {
            super.lisaaRuutulistaTahanRuutuListaan(lisattavat);
            sallitut.poistaArgumentinRuudutTastaRuutulistasta(lisattavat);
            onkoAsetettu = true;

        }
        
        System.out.println("Yritit asettaa laivueen ruutuihin"+lisattavat.toString());
        return onnistuuko;

    }

    public void poistaRuutu(Ruutu ruutu) {
        super.poistaRuutuOlio(ruutu);
    }

    
    /**
     * kertoo aluksen tilan - kuinka monta ruutua sillä on jäljellä, tai jos 
     * se on tuhoutunut.
     * @return String 
     */
    public String toString() {
        String palautettava = nimi + ": " + aluksenTila();
        if (this.onkoTuhoutunut()) {
            return palautettava + "\n TUHOUTUNUT!";
        } else {
            return palautettava;
        }
    }

    /**
     * Palauttaa stringin, jossa aluksen "hit pointit" näkyy ruutuina. esim [ ]
     * [ ] [x] = 3 ruudun alus, joka on ottanut yhden osuman.
     *
     * @return
     */
    public String aluksenTila() {
        String tila = "";

        int tuhoutuneetRuudut = pituus - (super.getRuutujenLkm() - 1);
        for (int i = 1; i <= (pituus - tuhoutuneetRuudut); i++) {
            tila = tila + "[ ]  ";
        }
        for (int i = 1; i <= tuhoutuneetRuudut; i++) {
            tila = tila + "[x]  ";
        }
        return tila;
    }

    /**
     * Metodi poistaa syotteen koordinaatteja vastaavan ruudun jos Alus oliolla
     * sellainen on
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     *
     * @return boolean loytyiko eli poistettiinko ruutu
     */
    public boolean josAluksellaTamaRuutuTuhoaSe(int x, int y) {

        boolean osuiko = super.onkoRuutuListalla(x, y);
        super.poistaRuutu(x, y);
        return osuiko;
    }

    /**
     * Kertoo jos alus on tuhoutunut eli ruutuja 1 kpl (existentiaaliruutu)
     *
     * @return true = tuhoutunut
     */
    public boolean onkoTuhoutunut() {
        if (super.getRuutujenLkm() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onkoAsetettu() {
        return onkoAsetettu;
    }

    
    /**
     * Palauttaa stringin joka kertoo yksinkertaisesti onko alus asetettu.
     * @return String
     */
    public String tulostaOnkoAsetettu() {
        String alus = nimi + " , pituus: " + Integer.toString(pituus) + ", : ";
        if (onkoAsetettu) {
            return (alus + "ASETETTU!");
        } else {
            return (alus + "EI ASETETTU!");
        }
    }

   public String getNimi() {
       return nimi;
   }
   

   public String getNimiJaPituus() {
       String suuruus = Integer.toString(pituus);
       return nimi+" , pituus "+suuruus;
   }



    

}
