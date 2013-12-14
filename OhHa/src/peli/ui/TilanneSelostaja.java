package peli.ui;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import peli.Laivue;

/**
 * TilanneSelostaja - luokkaa pitää selvillä kenen pelaajan vuoro on ampua,
 * mitkä laivat on tuhottu, ja kuinka paljon laivoilla on ruutuja jäljellä
 * Ilmoittaa lisäksi jos tuli osuma ja jos jompi kumpi pelaajista yritti fuskata
 * (ampua vaikkei ollu oma vuoro)
 *
 * @author peter_000
 */
public class TilanneSelostaja extends JPanel {

    private Laivue laivue1;
    private Laivue laivue2;
    private JTextArea pelaaja1tilanne;
    private JTextArea pelaaja2tilanne;
    private boolean onkoPelaajan1Vuoro;
    private JTextArea vuoronKertoja;

    public TilanneSelostaja(Laivue laivue1, Laivue laivue2) {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.laivue1 = laivue1;
        this.laivue2 = laivue2;
        this.pelaaja1tilanne = new JTextArea(laivue1.toString());
        this.pelaaja2tilanne = new JTextArea(laivue2.toString());
        /**
         * onkoPelaajan1Vuoro pitää selvillä kumman vuoro on! yksinkertainen
         * boolean
         */
        this.onkoPelaajan1Vuoro = false;
        this.vuoronKertoja = new JTextArea(laivue2.getKapteeni() + " , ON SINUN VUOROSI AMPUA!");
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(pelaaja1tilanne);
        add(vuoronKertoja);
        add(pelaaja2tilanne);
        pelaaja1tilanne.setEditable(false);
        pelaaja2tilanne.setEditable(false);
        vuoronKertoja.setEditable(false);
    }

    /**
     * Tmä metodi päivittä tilanteen (ruutujen tapahtumankuuntelijoissa
     * kutsutaan tätä metodia). Kutsuu kummankin laivueen toStringiä josta
     * ilmenee paljonko on "hit pointseja" jäljellä eli paljonko ruutuja, vai
     * jos alus on kokonaan tuhoutunut.
     */
    public void paivitaTilanne() {
        pelaaja1tilanne.setText(laivue1.toString());
        pelaaja2tilanne.setText(laivue2.toString());
        // Kertoo myös kumman vuoro on ampua
        if (onkoPelaajan1Vuoro) {
            vuoronKertoja.setText(laivue1.getKapteeni() + " , ON SINUN VUOROSI AMPUA!");
        } else {
            vuoronKertoja.setText(laivue2.getKapteeni() + " , ON SINUN VUOROSI AMPUA!");
        }

    }

    /**
     * vaihtaa vuoroa
     */
    public void vaihdaVuoroa() {
        onkoPelaajan1Vuoro = !onkoPelaajan1Vuoro;
    }

    /**
     * Kertoo osumasta
     */
    public void osuma() {
        vuoronKertoja.setText("PAM!!!! Sait lisävuoron! \n" + vuoronKertoja.getText());
    }

    /**
     * Ilmoittaa fusku yrityksestä
     */
    public void eiSinunVuorosi() {
        if (onkoPelaajan1Vuoro) {
            vuoronKertoja.setText("Eipäs fuskailla! on " + laivue1.getKapteeni() + " vuoro ampua!!");
        } else {
            vuoronKertoja.setText("Eipäs fuskailla! on " + laivue2.getKapteeni() + " vuoro ampua!!");
        }
    }

    /**
     * Kertoo jos pelaaja on vähä-älyinen
     */
    public void joAmmuttu() {
        vuoronKertoja.setText("Olet jo ampunut tähän ruutuun pöllöpää!");
    }

    public String palautaKapteeniJonkaVuoroAmpua() {
        if (onkoPelaajan1Vuoro) {
            return laivue1.getKapteeni();
        } else {
            return laivue2.getKapteeni();
        }
    }
}
