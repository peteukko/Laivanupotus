/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import peli.Laivue;

/**
 * Ruudukko - luokan ilmentymä. Tämä on kuin ruudukko, mutta ruutuihin on
 * laivanAsetusRuudukon tapaan liitetty tapahtumankuuntelija, joka on oma 
 * nested luokkansa. Ruutua painettaessa siihen ammutaan.
 * Lisäksi PelattavaRuudukolla on Tilanneselostaja. Tämä kertoo , mikä on pelin
 * tilanne: montako alusta pelaajilla on jäljellä ja paljonko aluksilla on elämiä
 * jäljellä, ja kumman pelaajan vuoro on.
 * @author peter_000
 */
public class PelattavaRuudukko extends Ruudukko {

    private TilanneSelostaja selostaja;
    
    public PelattavaRuudukko(Laivue laivue, TilanneSelostaja selostaja) {
        super(laivue);
        this.selostaja = selostaja;
        
        /**
         * Käydään läpi kaikki JPanelin komponentit eli Ruudut ja liitetään näihin
         * RuudunPainallusKuuntelija
         */
        for (Component c : super.ruudut.getComponents()) {
            if (c instanceof Ruutu) {
                int x = ((Ruutu) c).getXkord();
                int y = ((Ruutu) c).getYkord();

                RuudunPainallusKuuntelija kuuntelija = new RuudunPainallusKuuntelija(x, y, ((Ruutu) c), laivue, selostaja);
                ((Ruutu) c).addActionListener(kuuntelija);
            }
        }

    }
    

    public class RuudunPainallusKuuntelija implements ActionListener {

        private Laivue vihollisenLaivue;
        private int x;
        private int y;
        private JButton button;
        private TilanneSelostaja selostaja;

        public RuudunPainallusKuuntelija(int x, int y, JButton button, Laivue vihollisenLaivue, TilanneSelostaja selostaja) {
            this.x = x;
            this.y = y;
            this.button = button;
            this.vihollisenLaivue = vihollisenLaivue;
            this.selostaja = selostaja;
        }

        /**
         * Kun ruutua klikataan, sihen ammutaan. Tällöin kutsutaan Laivue-luokan
         * yritaAmpuaLaivueeseen-metodia. Jos ruudussa on alus, osa aluksesta
         * tuhoutuu ja ruutu muuttuu vihreäksi ja siihen piirretään ympyrä. Jos
         * ruudussa ei ole alusta, ruutu muuttuu punaiseksi ja siihen piirretään
         * rasti.
         *
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {       
            
            // Kumman vuoron selvittäminen tapahtuu ensin, jos pelaaja kenen 
            // vuoro ei ollut yritti ampua niin tuleee tästä ilmoitus
            if (vihollisenLaivue.getKapteeni().equals(selostaja.palautaKapteeniJonkaVuoroAmpua())) {
                selostaja.eiSinunVuorosi();
                return;
            }

            // Jos ruutuun on jo ammuttu niin tulee tästä ilmoitus
            if (vihollisenLaivue.onkoRuutuunJoAmmuttu(this.x, this.y)) {
                selostaja.joAmmuttu();
                return;
            }

            // Ammutaan ruutuun.
            boolean osuiko = vihollisenLaivue.yritaAmpuaLaivueeseen(x, y);
            
            if (osuiko) {
                this.button.setBackground(Color.GREEN);
                this.button.setText("O");

            } else {
                selostaja.vaihdaVuoroa();
                this.button.setBackground(Color.RED);
                this.button.setText("X");
            }

            selostaja.paivitaTilanne();
            
            if (osuiko) {
                selostaja.osuma(); // PAM!
            }

        }

    }
}
