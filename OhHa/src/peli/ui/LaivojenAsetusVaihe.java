/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import peli.Laivue;

/**
 * GUI:n kakkosvaihe / toinen ikkuna jossa asetetaan alukset. Tässä JPaneelissa
 * on itse Ruudukko . Molemmilla pelaajilla on Ruudukko, ja käytetään CardLayoutia
 * siiryttäekseen seuraavan pelaajan ruudukkoon.
 * Itse ruudukon lisäksi on JTextArea laivueenAsetusTilanne, joka kertoo montako
 * alusta on vielä laittamatta ja mikä on seuraava joka tulee asettaa.
 * 
 * @author peter_000
 */
public class LaivojenAsetusVaihe extends JPanel {

    private Peli peli;
    private Laivue pelaaja1Laivue;
    private Laivue pelaaja2Laivue;
    private LaivanAsetusRuudukko pelaaja1Ruudukko;
    private LaivanAsetusRuudukko pelaaja2Ruudukko;
    private CardLayout kortit;
    private JPanel korttiPaneeli;
    private JTextArea laivueen1AsetusTilanne;
    private JTextArea laivueen2AsetusTilanne;

    public LaivojenAsetusVaihe(Peli peli, Laivue pelaaja1Laivue, Laivue pelaaja2Laivue) {

        super(new BorderLayout());
        this.peli = peli;
        this.pelaaja1Laivue = pelaaja1Laivue;
        this.pelaaja2Laivue = pelaaja2Laivue;
        this.laivueen1AsetusTilanne = new JTextArea("Pelaaja 1, aseta alukset! Aloitetaan Sukellusveneestä (pituus 1)"
                + " . Klikkaa ruutua, johon haluat aluksen. \n Sitten siirrytään isompiin aluksiin"
                + ", jolloin paina aina ensin alku ja sitten loppuruutua, joiden väliin alus tulee. \n" + pelaaja1Laivue.tulostaAsetusTila());
        this.laivueen2AsetusTilanne = new JTextArea("Pelaaja 2, aseteta alukset! Aloitetaan Sukellusveneestä (pituus 1)"
                + " . Klikkaa ruutua, johon haluat aluksen. \n Sitten siirrytään isompiin aluksiin"
                + ", jolloin paina aina ensin alku ja sitten loppuruutua, joiden väliin alus tulee. \n" + pelaaja2Laivue.tulostaAsetusTila());
        this.pelaaja1Ruudukko = new LaivanAsetusRuudukko(pelaaja1Laivue, laivueen1AsetusTilanne);
        this.pelaaja2Ruudukko = new LaivanAsetusRuudukko(pelaaja2Laivue, laivueen2AsetusTilanne);
        this.korttiPaneeli = new JPanel();
        this.kortit = new CardLayout();
        korttiPaneeli.setLayout(kortit);

        luoKomponentit();

    }

    private void luoKomponentit() {


        JPanel ylempiPaneeli = ylempiPaneeli();
        add(ylempiPaneeli, BorderLayout.CENTER);
        JButton valmis = new JButton("Valmis");
        valmisNapinKuuntelija kuuntelija = new valmisNapinKuuntelija(this);
        valmis.addActionListener(kuuntelija);
        add(valmis, BorderLayout.SOUTH);

    }

    /**
     * ylempiPaneeli = ruudukko + tilannekatsaus.
     * @return 
     */
    private JPanel ylempiPaneeli() {

;
        JPanel pelaaja1Kortti = new JPanel();
        pelaaja1Kortti.setLayout(new BoxLayout(pelaaja1Kortti, BoxLayout.X_AXIS));

        JPanel pelaaja2Kortti = new JPanel();
        pelaaja2Kortti.setLayout(new BoxLayout(pelaaja2Kortti, BoxLayout.X_AXIS));

        pelaaja1Kortti.add(pelaaja1Ruudukko);
        pelaaja1Kortti.add(laivueen1AsetusTilanne);

        pelaaja2Kortti.add(pelaaja2Ruudukko);
        pelaaja2Kortti.add(laivueen2AsetusTilanne);

        korttiPaneeli.add(pelaaja1Kortti, "Moro");
        korttiPaneeli.add(pelaaja2Kortti, "Poro");
        return korttiPaneeli;
    }

    /** 
     * Kun kaikki laivat on asetettu, tulee kyttäjän painaa Valmis- nappia.
     * Tässä on tapahtumankuuntelija. Jos ensimmäinen pelaaja oli asettanut
     * laivat ja painaa nappia (eli kakkospelaajan laivue on vielä asettamatta)
     * hypätään seuraavaan korttiin cardlayoutissa eli kakkos pelaaja asettaa
     * nyt laivat.
     * Jos molemmat pelaajat olivat asettaneet aluksensa, hypätään itse peliin!
     * 
     */
    public class valmisNapinKuuntelija implements ActionListener {

        JPanel tama; //LaivojenAsetusVaihe

        public valmisNapinKuuntelija(JPanel tama) {
            this.tama = tama;

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            if (pelaaja1Laivue.onkoKokoLaivueAsetettu() && pelaaja2Laivue.onkoKokoLaivueAsetettu()) {
                tama.setVisible(false); 
                peli.paivitaTilanne();
                peli.setVisible(true);
            } else if (!pelaaja1Laivue.onkoKokoLaivueAsetettu()) {
                System.out.println("Pelaajan 1 laivat asettamatta");
            } else if (pelaaja1Laivue.onkoKokoLaivueAsetettu()) {
                kortit.next(korttiPaneeli);
            }

        }

    }
}
