
package peli;

import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class Laivue {

    ArrayList<Alus> Laivue;

    /**
     * sallituissa ruuduissa alunperin 10 x 10. Kun alus sijoitetaan johonkin 
     * ruutuihin, nämä ruudut eivät ole enää salittuja
     */
    Ruutulista sallitutRuudut;

    private String kapteeni;

    public Laivue(String kapteeni) {
        this.Laivue = new ArrayList<Alus>();
        this.kapteeni = kapteeni;
        this.sallitutRuudut = new Ruutulista();

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

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                sallitutRuudut.lisaaRuutu(i, j);
            }
        }

    }

   /**
    * Aseta laivueen aluksenNumero-numeroa vastaava alus (1: ensimmäinen eli 
    * sukellusvene) lähtöruudusta (x,y) suuntaan (int suunta = 1:4) määrittämiin
    * ruutuihin
    * @param aluksenNumero
    * @param x
    * @param y
    * @param suunta
    * @return onnistuiko aluksen asettaminen 
    */
    public boolean asetaLaivueenAlus(int aluksenNumero, int x, int y, int suunta) {
        boolean onnistuiko = Laivue.get(aluksenNumero-1).asetaAlusKunnolla(x, y, suunta, sallitutRuudut);
        return onnistuiko;
    }

    public int montakoAlusta() {
        return Laivue.size();
    }

    public void TulostaAluksenTila(int aluksenNumero) {
        System.out.println(Laivue.get(aluksenNumero - 1).toString());
    }

    /**
     * Ammu ruutuun (x,y)
     * @param x
     * @param y
     * @return osuiko vihollisen alukseen
     */
    public boolean yritaAmpuaLaivueeseen(int x, int y) {
        boolean osuiko = false;
        for (Alus alus : Laivue) {
            boolean loytyykoruutu = alus.josAluksellaTamaRuutuTuhoaSe(x, y);
            if (loytyykoruutu) {
                osuiko = true;
                System.out.println("PAM!!!!");
            }
        } return osuiko;
    }
    
    public boolean onkoAluksiaJaljella() {
        boolean onkoAluksiaJaljella = false; 
        for (Alus alus: Laivue) {
            if (!alus.onkoTuhoutunut()) {
                onkoAluksiaJaljella = true;
            }
        } return onkoAluksiaJaljella;
    }

    public String toString() {
        String palautettava = kapteeni + "-pojan laivue: \n";
        for (Alus alus : Laivue) {
            palautettava = palautettava + alus.toString() + "\n";
        }
        return palautettava;
    }

    public Alus getAlus(int aluksenNumero) {
        return Laivue.get(aluksenNumero-1);
    }

}
