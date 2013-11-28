/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.swing.JTextField;

/**
 * Ei käytössä. Tämä oli suunniteltu omana oliona tilannetaulukoksi, mutta 
 * ei tarpeellinen, ja en saanut toimimaan -  kutsuin tämän repaintia() 
 * actionListenerissä aina kun ruutuun ammutaan ja tuli virheilmiotuksia
 * @author Pepe
 */
public class TilanneTaulukko extends JPanel {
    
    private Laivue laivue;
    
    public TilanneTaulukko(Laivue laivue) {
        super(new BorderLayout());
        this.laivue = laivue;
        luoKomponentit();
    } 
    
    private void luoKomponentit() {
        JTextArea tilanne = new JTextArea(laivue.toString());

        tilanne.setEditable(false);

        add(tilanne, BorderLayout.NORTH);

    }
    
    public void paivita() {
        this.repaint();
    }
    
    
    
 
    
}
