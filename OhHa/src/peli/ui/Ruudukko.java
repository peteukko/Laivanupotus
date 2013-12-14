/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.ui;

import peli.Laivue;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

/**
 * PeliAlusta JPanel - ilmentymä, joka koostuu 10x10 ruudukosta (GridLayout) ja
 * lisäksi kirjainrivistä ja numerosarakkeesta.Käyttää borderlayoutia.
 *
 * @author peteukko
 */
public class Ruudukko extends JPanel {

    protected Laivue laivue;
    protected JTextArea tilanne;
    //protected TilanneSelostaja selostaja;
    protected JPanel ruudut;

    /**
     * luokka tarvitsee tilanne-JTextArean konstruktorissa, koska itse ruutuihin
     * liitetään ruudunPainallusKuuntelija
     *
     * @param laivue Tämän pelialustan laivue (laivue, joka on tässä
     * pelialustassa)
     * @param tilanne Tämän laivueen tilanne, eli aluksien kunto
     */
    public Ruudukko(Laivue laivue) {
        super(new BorderLayout());
        this.laivue = laivue;
        //this.selostaja = selostaja;
        luoKomponentit();

    }


    protected void luoKomponentit() {

        add(luoKirjainRivi(), BorderLayout.NORTH);
        add(luoNumeroSarake(), BorderLayout.WEST);
        add(luoRuudukko(), BorderLayout.CENTER);

    }

    /**
     *
     * @return
     */
    protected JPanel luoRuudukko() {
        ruudut = new JPanel(new GridLayout(10, 10));

        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                Ruutu ruutu = new Ruutu(x, y);
                ruudut.add(ruutu);
            }
        }
        return ruudut;

    }
    

    protected JPanel luoKirjainRivi() {
        JPanel panel = new JPanel(new GridLayout(1, 11));
        JLabel tyhja = new JLabel("");
        panel.add(tyhja);
        String kirjaimet = "ABCDEFGHIJ";
        for (int i = 0; i <= 9; i++) {
            String kirjain = Character.toString(kirjaimet.charAt(i));
            JLabel ruutu = new JLabel(kirjain);
            panel.add(ruutu);
        }
        return panel;
    }

    protected JPanel luoNumeroSarake() {
        JPanel panel = new JPanel(new GridLayout(10, 1));

        for (int i = 1; i <= 10; i++) {
            String numero = Integer.toString(i);
            JLabel ruutu = new JLabel(numero);
            panel.add(ruutu);
        }

        return panel;
    }

}
