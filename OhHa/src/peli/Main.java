package peli;

import java.util.ArrayList;

import peli.ui.Graafinenkayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @Laivanupotuksen beta
 * Main - luokassa ajetaan itse peli
 * 
 * 28.11 päivitys:
 * Toimii: Graafinen käyttöliittymä, ampuminen ruutua klikkaamalla, tilanteen 
 * päivittyminen...
 * 
 * Vielä puuttuu:
 * 1) Aluksien asettaminen graafisen käyttöliittymän kautta (Tähän ei tulisi 
 * mennä kauan. Klikataan ensimmäistä ja viimeistä ruutua, ja kutsutaan 
 * asetaAlusKunnolla - metodia). Suunta määrittyy helposti näistä kahdesta ruudusta.
 * 
 * 2) VUOROT - peliä pelataan vuorottain. Jos pelaaja osuu vastustajan
 * laivan, saa hän lisävuoron. Logiikka PELI-Luokkaan?
 * 
 * 3) (Jo ammuttuun ruutuun ei voi ampua?) 
 * 
 * 4) Jos ehdin: mahdollisuus pelata tietokonetta vastaan (+yksinkertainen tekoäly)
 * 
 *--------------------------------
 * Ajateltu toteutus: Pelissä on 2 pelaajaa, joilla molemmilla on Laivue.
 * Laivue-olio on Alus-olioista muodostuva ArrayList; eli Alus-kokoelma (esim 5
 * eri pituista alusta). Alus vuorostaan on Ruutu-olioista muodostuva ArrayList,
 * eli Ruutu-kokoelma. Ruudulla on x ja y koordinaatti. (x,y) koordinatteihin
 * ammutaan vuorotelleen, jolloin peli tarkistaa onko siinnä alus. Jos on, niin
 * kyseisen alus täämä Ruutu tuhotaan (poistetaan Ruutu aluksesta) Pelaaja, joka
 * tuhoaa ensin kaikki vastustajan alukset, voittaa pelin.
 *-------------------------
 *
 * 14.11 : Laivue-luokka ja uusi idea toteutukselle, jossa ei tarvitse luoda
 * niin ikään pelilautaa. Uusia ruutu-olioita luodaan sen mukaan kun jokin alus
 * asetetaan kyseiseen ruutuun. Ammuttaessa ruutuun, tarvitsee tarkistaa että 1)
 * onko tähän ammuttu aiemmin ( pidetään esim int[][] ArrayList ruuduista) ja 2)
 * onko siinnä Alusta (onko ruutua olemassa).
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {



        Laivue laivue1 = new Laivue();
        Laivue laivue2 = new Laivue();

        Graafinenkayttoliittyma graafinen = new Graafinenkayttoliittyma(laivue1, laivue2);
        SwingUtilities.invokeLater(graafinen);

    }

}
