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
        frame = new JFrame("LAIVANUPOTUS V0.1 ");
        frame.setPreferredSize(new Dimension(1000, 500));
        //frame.setLocation(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
        //frame2 = new JFrame("Pelaaja 2:n territorio");
        //frame2.setPreferredSize(new Dimension(600, 600));
        //frame2.setLocation(1200,300);
        //frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //luoKomponentit(frame2.getContentPane(), Laivue p);
        //frame2.pack();
        //frame2.setVisible(true);

    }
    
    public void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(new PeliAlusta(pelaaja1Laivue));
        container.add(new PeliAlusta(pelaaja2Laivue));
    }


    public JFrame getFrame() {
        return frame;
    }

}
