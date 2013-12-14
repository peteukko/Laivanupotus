/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import peli.Alus;
import peli.Laivue;

/**
 * Ruudukko - luokan aliluokka. Tämä näyttää identtiseltä Ruudukon kanssa, mutta
 * ruutuihin on kytketty ActionListeneria implementoivan
 * RuudunPainallusKuuntelija, joka on nested luokka tässä luokassa.
 *
 * @author peter_000
 */
public class LaivanAsetusRuudukko extends Ruudukko {

    private boolean ekaRuutuValittu;
    private boolean tokaRuutuValittu;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private String selostaja;
    private JTextArea laivueenAsetusTilanne;

    /**
     * Konstruktorissa liitetään tapahtuman kuuntelijat jokaiseen ruutuun.
     *
     * @param laivue
     * @param laivueenAsetusTilanne
     */
    public LaivanAsetusRuudukko(Laivue laivue, JTextArea laivueenAsetusTilanne) {
        super(laivue);
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
        this.laivueenAsetusTilanne = laivueenAsetusTilanne;

        ekaRuutuValittu = false;
        tokaRuutuValittu = false;

        /**
         * Mennään läpi kaikki JPanelin komponentit (ruudut) ja liitetään
         * jokaiseen ruudunPainallusKuuntelija.
         */
        for (Component c : super.ruudut.getComponents()) {
            if (c instanceof Ruutu) {
                int x = ((Ruutu) c).getXkord();
                int y = ((Ruutu) c).getYkord();

                RuudunPainallusKuuntelija kuuntelija = new RuudunPainallusKuuntelija(x, y, ((Ruutu) c), laivue);
                ((Ruutu) c).addActionListener(kuuntelija);
            }
        }

    }

    /**
     * Tämä metodi käy läpi kaikki ruudut ja tarkistaa, jos alus on kyseisessä
     * ruudussa. Tällöin se maalataan vihreäksi. Näin pelaaja näkee laivoja
     * asettaessa kokonaistilanteen.
     */
    public void merkitseRuudutJoissaAlus() {
        for (Component c : super.ruudut.getComponents()) {
            if (c instanceof Ruutu) {
                int x = ((Ruutu) c).getXkord();
                int y = ((Ruutu) c).getYkord();

                if (super.laivue.onkoLaivueenJollakinAluksellaTamaRuutu(x, y)) {

                    c.setBackground(Color.GREEN);

                }

            }
        }
        ruudut.repaint();
        ruudut.validate();
    }

    public class RuudunPainallusKuuntelija implements ActionListener {

        private Laivue vihollisenLaivue;
        private int x;
        private int y;
        private JButton button;

        public RuudunPainallusKuuntelija(int x, int y, JButton button, Laivue vihollisenLaivue) {
            this.x = x;
            this.y = y;
            this.button = button;
            this.vihollisenLaivue = vihollisenLaivue;

        }

        /**
         * Laivojen asettaminen: Aloitetaan pienimmästä laivasta (pituus 1),
         * jolloin klikataan yksinkertaisesti ruutua johon se tulee. Isommat
         * laivat: Klikataan lähtö ja loppuruutua, jotka määrrittävät ääripäät
         * joiden väliin alus tulee.
         *
         * Alku- ja loppuruudusta lasketaan int suunta (1 = alkuruudusta itään,
         * 2 = etelään, 3 = länteen, 4 = pohjoiseen), jota käytetään metodissa
         * boolean asetaAlusKunnolla(int x, int y, int suunta, Ruutulista
         * sallitut) laivan asettamiseen. Palauttaa false jos ei onnistu (menisi
         * toisen laivan päälle) ja true jos asettaminen onnistuu.
         *
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {

            boolean onnistuiko = false;
            int suunta = 1;

            //Ruutua klikattaessa voi olla että pelaaja klikkasi "lähtöruutua"
            // tai "päätyruutua". Boolean ekaRuutuValittu pitää tästä laskua.
            if (x1 == 0) { //Jos tämä oli ensimmäinen klikkaus koko sessiossa
                onnistuiko = laivue.asetaLaivueenAlus(1, x, y, 1); //Asetetaan 1-alus (sukellusvene, pituus 1)
                selostaja = "Aseta " + laivue.getAlus(2).getNimiJaPituus(); // Päivitetään selostajaa: aseta nyt alus 2.
                x1 = 1;
            } else if (!ekaRuutuValittu) { // Jos tämä oli ensimmäinen klikkaus: ekaRuutuValittu muuttuu nyt trueksi            
                x1 = x;
                y1 = y;
                ekaRuutuValittu = true;
            } else {
                x2 = x;
                y2 = y;
                // jos ekaRuutuvalittu = true, oli tama toisen ruudun klikkaus,
                // yritetään Asettaa laiva. Onnistuu tai ei, niin ekaRuutuValittu
                // pitää muttua falseksi : jos onnistui, niin siirrytään seuraavan
                // laivan asettamiseen. Jos ei onnistunut, niin molemmat ruudut
                // pitää valita uudestaan.
                // Käytetään metodia asetaAlusKunnolla, joka tarvitsee int suunnan (1..4)
                // lasketaan se lähtö- ja päätykoordinaattien perusteella:
                if (x2 > x1 && y1 == y2) {
                    suunta = 1;
                } else if (x1 == x2 && y2 > y1) {
                    suunta = 2;
                } else if (x2 < x1 && y1 == y2) {;
                    suunta = 3;
                } else if (x1 == x2 && y1 > y2) {
                    suunta = 4;
                }

                if (laivue.montakoLaivaaAsetettu() == 1) {

                    onnistuiko = laivue.asetaLaivueenAlus(2, x1, y1, suunta);
                    if (onnistuiko) {
                        selostaja = "Aseta " + laivue.getAlus(3).getNimiJaPituus();
                    }

                } else if (laivue.montakoLaivaaAsetettu() == 2) {

                    onnistuiko = laivue.asetaLaivueenAlus(3, x1, y1, suunta);

                    if (onnistuiko) {
                        selostaja = "Aseta " + laivue.getAlus(4).getNimiJaPituus();
                    }

                } else if (laivue.montakoLaivaaAsetettu() == 3) {

                    onnistuiko = laivue.asetaLaivueenAlus(4, x1, y1, suunta);
                    if (onnistuiko) {
                        selostaja = "Aseta " + laivue.getAlus(5).getNimiJaPituus();
                    }

                } else if (laivue.montakoLaivaaAsetettu() == 4) {

                    onnistuiko = laivue.asetaLaivueenAlus(5, x1, y1, suunta);
                    if (onnistuiko) {
                        selostaja = "Olet asettanut kaikki laivat. Voit painaa VALMIS-nappia";
                    }
                }

                if (onnistuiko) {
                    suunta = 0; //resetoidaan suunta
                } else {
                    selostaja = "Ei onnannut. koitappas uudestaan";
                }

                ekaRuutuValittu = false;

            }
            // Maalataan ruudut joissa on alus metodilla merkitseRuudutjoissaAlus
            merkitseRuudutJoissaAlus();


            // Ja päivitettään JTextArea Laivueenasetustilanne
            laivueenAsetusTilanne.setText(laivue.tulostaAsetusTila() + "\n" + selostaja);;
        }

    }
}
