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
    private Laivue laivue;
    
    public Graafinenkayttoliittyma(Laivue laivue) {
        this.laivue = laivue;
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {

        container.setLayout(new BorderLayout());
        container.add(luoKirjainRivi(), BorderLayout.NORTH);
        container.add(luoNumeroSarake(), BorderLayout.WEST);
        container.add(luoRuudukko(), BorderLayout.CENTER);

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

    public JFrame getFrame() {
        return frame;
    }

}