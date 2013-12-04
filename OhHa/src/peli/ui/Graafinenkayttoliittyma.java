package peli.ui;

import peli.Laivue;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.BoxLayout;


public class Graafinenkayttoliittyma implements Runnable {

    private JFrame frame;
    private JFrame frame2;
    private Laivue pelaaja1Laivue;
    private Laivue pelaaja2Laivue;
   

    public Graafinenkayttoliittyma(Laivue laivue1, Laivue laivue2) {
        this.pelaaja1Laivue = laivue1;
        this.pelaaja2Laivue = laivue2;      
    }

    @Override
    public void run() {
        frame = new JFrame("LAIVANUPOTUS V0.5 ");
        frame.setPreferredSize(new Dimension(1200, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Luo graafisen käyttöliittymän komponentit ja settaa ne x-suunnassa
     * (boxlayout) : Vasemmalla Pelaaja 1 sen pelialusta, keskellä
     * tilannekatsaukset (JTextArea), oikealla pelaaja 2:sen pelialusta.
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        TilanneSelostaja selostaja = new TilanneSelostaja(pelaaja1Laivue, pelaaja2Laivue);
        
        container.add(new PeliAlusta(pelaaja1Laivue, selostaja));
        container.add(selostaja);
        container.add(new PeliAlusta(pelaaja2Laivue, selostaja));
    }

    public JFrame getFrame() {
        return frame;
    }

}
