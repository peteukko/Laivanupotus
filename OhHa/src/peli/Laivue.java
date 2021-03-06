package peli;

import java.util.ArrayList;
import java.util.Random;

/**
 * Laivue luokka. Laivue on ArrayList Aluksista! Laivueella on kapteeni (String
 * kapteeni) ja lista ruuduista, johon laivueen aluksia voi asettaa. Alunperin
 * koko pelilauta, mutta päivittyy asettamisen mukaan (laivoja ei voi laittaa
 * päällekäin)
 * Pitää lisäksi listaa ruuduista, johon on ammuttu yrittäessä osua tähän laivueeseen.
 *
 * @author Pepe
 */
public class Laivue {

    private ArrayList<Alus> Laivue;
    /**
     * sallituissa ruuduissa alunperin 10 x 10. Kun alus sijoitetaan johonkin
     * ruutuihin, nämä ruudut eivät ole enää salittuja
     */
    Ruutulista sallitutRuudut;
    Ruutulista ammututRuudut;

    private String kapteeni;

    public Laivue() {
        this.Laivue = new ArrayList<Alus>();
        this.sallitutRuudut = new Ruutulista();
        this.ammututRuudut = new Ruutulista();

        Alus sukellusvene = new Alus(1, "Sukellusvene");
        Alus havittaja = new Alus(2, "Hävittäjä");
        Alus risteilija = new Alus(3, "Risteilijä");
        Alus taistelulaiva = new Alus(4, "Taistelulaiva");
        Alus lentotukialus = new Alus(5, "Lentotukialus");
        Laivue.add(sukellusvene);
        Laivue.add(havittaja);
        Laivue.add(risteilija);
        Laivue.add(taistelulaiva);
        Laivue.add(lentotukialus);

        // Alusta pelilauta
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                sallitutRuudut.lisaaRuutu(i, j);
            }
        }
    }

    public Laivue(String kapteeni) {
        this();
        this.kapteeni = kapteeni;

    }

    /**
     * Aseta laivueen aluksenNumero-numeroa vastaava alus (1: ensimmäinen eli
     * sukellusvene) lähtöruudusta (x,y) suuntaan (int suunta = 1:4)
     * määrittämiin ruutuihin. Katso Alus-luokan asetaAlusKunnolla-metodi
     *
     * @param aluksenNumero
     * @param x
     * @param y
     * @param suunta
     * @return onnistuiko aluksen asettaminen
     */
    public boolean asetaLaivueenAlus(int aluksenNumero, int x, int y, int suunta) {
        boolean onnistuiko = Laivue.get(aluksenNumero - 1).asetaAlusKunnolla(x, y, suunta, sallitutRuudut);
        return onnistuiko;
    }

    /**
     * Asettaa laivueen int aluksenNumero-vastaavan aluksen satunnaisesti
     * pelilaudalle. Arpoo (x,y) -koordinaattiparin ja int suunnan ja käyttää
     * sitten metodia asetaLaivueenAlus asettaakseen aluksen näiden mukaisesti.
     * Jos ei onnistu,arpoo uudet ja toistaa, kunnes onnistuu. Tätä metodia voi
     * käyttää testaamiseen ja myöhemmin tekoälyn käytettäväksi
     *
     * @param aluksenNumero
     */
    public void asetaAlusSatunnaisesti(int aluksenNumero) {
        Random arpoja = new Random();

        while (true) {
            int x = 1 + arpoja.nextInt(10);
            int y = 1 + arpoja.nextInt(10);
            int suunta = 1 + arpoja.nextInt(4);;
            boolean onnistuiko = asetaLaivueenAlus(aluksenNumero, x, y, suunta);

            if (onnistuiko) {
                break;
            }
        }

    }

    /**
     * Käyttää metodia asetaAlusSatunnaisesti asettaakseen koko laivueen.
     */
    public void asetaLaivueSatunnaisesti() {
        for (int i = 1; i <= Laivue.size(); i++) {
            //System.out.println(i);
            asetaAlusSatunnaisesti(i);

        }
    }

    public int montakoAlusta() {
        return Laivue.size();
    }

    public void TulostaAluksenTila(int aluksenNumero) {
        System.out.println(Laivue.get(aluksenNumero - 1).toString());
    }

    /**
     * Yrittää ampua ruutuun (x,y). Jos ruutuun on jo ammuttu aiemmin, ei
     * onnistu: palauta boolean osuiko = false. Jos ei ole, Menee läpi laivueen
     * kaikki ruudut ja katsoo jos jonkin aluksen ruutu matchaa koordinaateilla.
     * Jos näin on, tuhoaa tämän ruudun.
     *
     * @param x
     * @param y
     * @return osuiko vihollisen alukseen
     */
    public boolean yritaAmpuaLaivueeseen(int x, int y) {
        boolean osuiko = false;

        if (ammututRuudut.onkoRuutuListalla(x, y)) {
            return osuiko;
        }

        ammututRuudut.lisaaRuutu(x, y);

        for (Alus alus : Laivue) {
            boolean loytyykoruutu = alus.josAluksellaTamaRuutuTuhoaSe(x, y);
            if (loytyykoruutu) {
                osuiko = true;
                //System.out.println("PAM!!!!");
            }
        }
        return osuiko;
    }

    public boolean onkoLaivueenJollakinAluksellaTamaRuutu(int x, int y) {
        boolean matchaako = false;
        for (Alus alus : Laivue) {
            if (alus.onkoRuutuListalla(x, y)) {
                matchaako = true;
            }
        }
        return matchaako;
    }

    /**
     * Menee läpi kaikki laivueen alukset. Jos kaikki ovat tuhoutuneet,
     * palauttaa false
     *
     * @return true, jos edes 1 alus on vielä pystyssä
     */
    public boolean onkoAluksiaJaljella() {
        boolean onkoAluksiaJaljella = false;
        for (Alus alus : Laivue) {
            if (!alus.onkoTuhoutunut()) {
                onkoAluksiaJaljella = true;
            }
        }
        return onkoAluksiaJaljella;
    }

    public String toString() {
        String palautettava = kapteeni + "-pojan laivue: \n";
        for (Alus alus : Laivue) {
            palautettava = palautettava + alus.toString() + "\n";
        }
        return palautettava;
    }

    /**
     * Onko (x-y) koordinaatteja vastaavaan ruutuun jo ammuttu 
     * @param x
     * @param y
     * @return 
     */
    public boolean onkoRuutuunJoAmmuttu(int x, int y) {
        if (ammututRuudut.onkoRuutuListalla(x, y)) {
            return true;
        } else {
            return false;
        }

    }
/**
 * Onko kaikki laivueen alukset asetettu pelikentälle
 * @return boolean
 */
    public boolean onkoKokoLaivueAsetettu() {
        boolean onkoKaikkiAsetettu = true;
        for (Alus alus : Laivue) {
            if (!alus.onkoAsetettu()) {
                onkoKaikkiAsetettu = false;
            }
        }
        return onkoKaikkiAsetettu;
    }

    public int montakoLaivaaAsetettu() {
        int montakoLaivaaAsetettu = 0;
        for (Alus alus : Laivue) {
            if (alus.onkoAsetettu()) {
                montakoLaivaaAsetettu = montakoLaivaaAsetettu + 1;
            }
        }

        return montakoLaivaaAsetettu;
    }

    public String tulostaAsetusTila() {
        String palautettava = "";
        for (Alus alus : Laivue) {
            palautettava = palautettava + alus.tulostaOnkoAsetettu() + "\n";
        }
        return palautettava;
    }

    public Alus getAlus(int aluksenNumero) {
        return Laivue.get(aluksenNumero - 1);
    }

    public String getKapteeni() {
        return kapteeni;
    }

    public void setKapteeni(String nimi) {
        this.kapteeni = nimi;
    }

    public Ruutulista getSallitut() {
        return sallitutRuudut;

    }
    
    public String tulostaLaivueenRuudut() {
        return super.toString();
    }

}
