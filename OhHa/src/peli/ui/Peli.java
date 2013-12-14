/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.ui;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import peli.Laivue;

/**
 * Tämä luokka vastaa itse pelattavaa osuutta pelistä.
 * Peli on JPaneeli jossa on molempien pelaajien ruudukot sekä keskellä tilanneselostaja.
 * @author peter_000
 */
public class Peli extends JPanel {

    private Laivue pelaaja1Laivue;
    private Laivue pelaaja2Laivue;
    private PelattavaRuudukko pelaajan1Alusta;
    private PelattavaRuudukko pelaajan2Alusta;
    private TilanneSelostaja selostaja;

    public Peli(Laivue pelaaja1Laivue, Laivue pelaaja2Laivue) {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.pelaaja1Laivue = pelaaja1Laivue;
        this.pelaaja2Laivue = pelaaja2Laivue;

        this.selostaja = new TilanneSelostaja(pelaaja1Laivue, pelaaja2Laivue);
        this.pelaajan1Alusta = new PelattavaRuudukko(pelaaja1Laivue, selostaja);
        this.pelaajan2Alusta = new PelattavaRuudukko(pelaaja2Laivue, selostaja);

        luoKomponentit();

    }

    private void luoKomponentit() {

        add(pelaajan1Alusta);
        add(selostaja);
        add(pelaajan2Alusta);
    }
    
    public void paivitaTilanne() {
        selostaja.paivitaTilanne();
    }

}
