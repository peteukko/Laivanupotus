package peli.ui;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import peli.Laivue;

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

    public void paivitaTilanne() {
        pelaaja1tilanne.setText(laivue1.toString());
        pelaaja2tilanne.setText(laivue2.toString());
        if (onkoPelaajan1Vuoro) {
            vuoronKertoja.setText(laivue1.getKapteeni() + " , ON SINUN VUOROSI AMPUA!");
        } else {
            vuoronKertoja.setText(laivue2.getKapteeni() + " , ON SINUN VUOROSI AMPUA!");
        }

    }

    public void vaihdaVuoroa() {
        onkoPelaajan1Vuoro = !onkoPelaajan1Vuoro;
    }

    public void osuma() {
        vuoronKertoja.setText("PAM!!!! Sait lisävuoron! \n" + vuoronKertoja.getText());
    }

    public void eiSinunVuorosi() {
        if (onkoPelaajan1Vuoro) {
            vuoronKertoja.setText("Eipäs fuskailla! on "+laivue1.getKapteeni() + " vuoro ampua!!");
        } else {
            vuoronKertoja.setText("Eipäs fuskailla! on "+laivue2.getKapteeni() + " vuoro ampua!!");
        }
    }
    
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
