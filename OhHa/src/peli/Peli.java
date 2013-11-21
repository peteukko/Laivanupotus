package peli;

import java.util.ArrayList;

/**
 *
 * @Laivanupotuksen alfa 0.3
 *
 * Ajateltu toteutus: Pelissä on 2 pelaajaa, joilla molemmilla on Laivue.
 * Laivue-olio on Alus-olioista muodostuva ArrayList; eli Alus-kokoelma (esim 3
 * eri pituista alusta). Alus vuorostaan on Ruutu-olioista muodostuva ArrayList,
 * eli Ruutu-kokoelma. Ruudulla on x ja y koordinaatti. (x,y) koordinatteihin
 * ammutaan vuorotelleen, jolloin peli tarkistaa onko siinnä alus. Jos on, niin
 * kyseisen alus täämä Ruutu tuhotaan (poistetaan Ruutu aluksesta) Pelaaja, joka
 * tuhoaa ensin kaikki vastustajan alukset, voittaa pelin.
 *
 *
 * 14.11 : Laivue-luokka ja uusi idea toteutukselle, jossa ei tarvitse luoda
 * niin ikään pelilautaa. Uusia ruutu-olioita luodaan sen mukaan kun jokin alus
 * asetetaan kyseiseen ruutuun. Ammuttaessa ruutuun, tarvitsee tarkistaa että 1)
 * onko tähän ammuttu aiemmin ( pidetään esim int[][] ArrayList ruuduista) ja 2)
 * onko siinnä Alusta (onko ruutua olemassa).
 *
 * 
 */

public class Peli {

    public String pelaaja1;
    public String pelaaja2;
    public Laivue pelaaja1Laivue;
    public Laivue pelaaja2Laivue;
    
    public Peli(String pelaaja1nimi, String pelaaja2nimi) {
        this.pelaaja1 = pelaaja1nimi;
        this.pelaaja2 = pelaaja2nimi;
        pelaaja1Laivue = new Laivue(pelaaja1);
        pelaaja2Laivue = new Laivue(pelaaja2);
    }
    
    /**
     * tarkistaako jos peliä tulee pitää vielä käynnissä. Jos jomman kumman laivue 
     * on kokonaan tuhoutunut, peli on ratkennut.
     * @return boolean onkoKaynnissa
     */
    public boolean onkoKaynnissa() {
        boolean onkoKaynnissa = true;
        if (!pelaaja1Laivue.onkoAluksiaJaljella() && !pelaaja2Laivue.onkoAluksiaJaljella()) {
            onkoKaynnissa = false;
        }
        return onkoKaynnissa;
        
    }

/**
 * Ammu maaritettyn laivueen pelilaudan ruutuun (x,y)
 * @param vihollisenLaivue
 * @param x
 * @param y 
 */
    public static void Ammu(Laivue vihollisenLaivue, int x, int y) {
        vihollisenLaivue.yritaAmpuaLaivueeseen(x, y);
    }
}
