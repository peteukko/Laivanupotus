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
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

/**
 *
 * @author peteukko
 */
public class PeliAlusta extends JPanel {

    private Laivue laivue;
    //private RuudunPainallusKuuntelija kuuntelija;

    public PeliAlusta(Laivue laivue) {
        super(new BorderLayout());
        this.laivue = laivue;
      //  this.kuuntelija = kuuntelija;
        luoKomponentit();
        
    }

    private void luoKomponentit() {
        
        
        //container.setLayout(new BorderLayout());
        add(luoKirjainRivi(), BorderLayout.NORTH);
        add(luoNumeroSarake(), BorderLayout.WEST);
        add(luoRuudukko(), BorderLayout.CENTER);

    }

    private JPanel luoRuudukko() {
        JPanel panel = new JPanel(new GridLayout(10, 10));

        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                JButton uusnappi = new JButton("o");
                RuudunPainallusKuuntelija kuuntelija = new RuudunPainallusKuuntelija(x, y, uusnappi, laivue);
                uusnappi.addActionListener(kuuntelija);

                panel.add(uusnappi);

            }
        }
        return panel;

    }

    private JPanel luoKirjainRivi() {
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

    private JPanel luoNumeroSarake() {
        JPanel panel = new JPanel(new GridLayout(10, 1));

        for (int i = 1; i <= 10; i++) {
            String numero = Integer.toString(i);
            JLabel ruutu = new JLabel(numero);
            panel.add(ruutu);
        }

        return panel;
    }
    

}
