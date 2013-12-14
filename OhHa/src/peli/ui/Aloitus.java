/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.ui;

import peli.Laivue;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI: Pelin aloitus: ensimmäinen ikkuna.
 * Tässä kirjoitetaan pelin nimet ja valitaan jos alukset halutaan itse asettaa
 * pelikentälle, tai jos ne asetetaan automaattisesti (hyppää tällöin suoraan peliin)
 * Implementoi actionlistenerin suoraan (ruutuja painettaessa riippuu ruudusta,
 * mitä tapahtuu: actionPerformed käyttää painikkeen getSourcea selvittääkseen
 * mitä nappia painettiin, ja sen mukaan mennään laivan asetusmoodiin tai peliin.
 * @author peter_000
 */
public class Aloitus extends JPanel implements ActionListener {

    private Peli peli;
    private LaivojenAsetusVaihe asetusVaihe;
    private Laivue laivue1;
    private Laivue laivue2;
    private String kapteeni1;
    private String kapteeni2;
    private JButton pelaa1;
    private JButton pelaa2;
    private JTextField nimiKentta1;
    private JTextField nimiKentta2;

    public Aloitus(Peli peli, LaivojenAsetusVaihe asetusVaihe, Laivue laivue1, Laivue laivue2) {
        super(new GridLayout(3, 2));
        this.peli = peli;
        this.asetusVaihe = asetusVaihe;
        this.laivue1 = laivue1;
        this.laivue2 = laivue2;
        this.pelaa1 = new JButton("Haluan asettaa laivat itse!");
        this.pelaa2 = new JButton("Asetetaan laivat satunnaisesti");
        luoKomponentit();

    }

    private void luoKomponentit() {

        JLabel nimiTeksti1 = new JLabel("Pelaajan 1 nimi: ");
        nimiKentta1 = new JTextField();

        JLabel nimiTeksti2 = new JLabel("Pelaajan 2 nimi: ");
        nimiKentta2 = new JTextField();

        pelaa1.addActionListener(this);
        pelaa2.addActionListener(this);

        add(nimiTeksti1);
        add(nimiKentta1);
        add(nimiTeksti2);
        add(nimiKentta2);
        add(pelaa1);
        add(pelaa2);
    }

    /**
     * Molempiin nappeihin on kytketty sama actionlistener: käyttää getsourcea
     * selvittääkseen mitä nappia painettiin. 
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        kapteeni1 = nimiKentta1.getText();
        kapteeni2 = nimiKentta2.getText();
        laivue1.setKapteeni(kapteeni1);
        laivue2.setKapteeni(kapteeni2);


        this.setVisible(false); // Seuraavaan vaiheeseen siirryttäessä tämä piilotetaan

        if (event.getSource() == pelaa1) {
            asetusVaihe.setVisible(true); //Asetusvaihe tulee näkyviin
            asetusVaihe.repaint();
        }

        if (event.getSource() == pelaa2) {
            laivue1.asetaLaivueSatunnaisesti();
            laivue2.asetaLaivueSatunnaisesti();
            peli.paivitaTilanne(); 
            peli.setVisible(true); // Itse peli tulee näkyviin
        }

    }

}
