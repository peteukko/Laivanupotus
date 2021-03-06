package peli.ui;

import peli.Laivue;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
/**
 * Laivanupotuksen GUI: 3 vaihetta (pelin intro, jossa kysytään nimet, laivojen
 * asettaminen, jolloin pelaajat asettavat vuorotellen aluksensa pelilaudalle,
 * sekä itse peli), joita vastaa luokat Aloitus , LaivojenAsetusVaihe, sekä Peli.
 * Pelivaiheesta hyppy toiseen tapahtuu aina JPaneelien setVisiblen kanssa, 
 * ainoastaan LaivojenAsetusVaiheessakäytetään sisäisesti CardLayoutia 
 * vaihtaessa pelaajaa. 
 * @author peter_000
 */
public class Graafinenkayttoliittyma implements Runnable {

    private JFrame frame;
    private Laivue pelaaja1Laivue;
    private Laivue pelaaja2Laivue;
    private Peli peli;
    private Aloitus pelinAloitusPaneeli;
    private LaivojenAsetusVaihe asetusVaihe;

    public Graafinenkayttoliittyma(Laivue laivue1, Laivue laivue2) {
        this.pelaaja1Laivue = laivue1;
        this.pelaaja2Laivue = laivue2;
        this.peli = new Peli(pelaaja1Laivue, pelaaja2Laivue);
        this.asetusVaihe = new LaivojenAsetusVaihe(peli, pelaaja1Laivue, pelaaja2Laivue);
        this.pelinAloitusPaneeli = new Aloitus(peli, asetusVaihe, pelaaja1Laivue, pelaaja2Laivue);

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
        container.add(pelinAloitusPaneeli);
        asetusVaihe.setVisible(false);
        container.add(asetusVaihe);
        peli.setVisible(false);
        container.add(peli);
    }

    public JFrame getFrame() {
        return frame;
    }

}
