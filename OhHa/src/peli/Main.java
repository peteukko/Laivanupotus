package peli;

import java.util.ArrayList;

/**
 *
 * @Laivanupotuksen alfa
 *
 * Ajateltu toteutus: Pelissä on 2 pelaajaa, joilla molemmilla on Laivue.
 * Laivue-olio on Alus-olioista muodostuva ArrayList; eli Alus-kokoelma (esim 5
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
 * Tämän main-luokan Ammu-metodi siirretään myöhemmin Peli-luokkaan
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Laivue pertinLaivue = new Laivue("Pertti");
        // Luo laivueen : kutsuu Laivue-luokan konstruktorin, jossa
        // luodaan 3 eri suuruista Laivaa, ja asetetaan ne Laivuueseen ( joka on 
        // ArrayList aluksista)

       // Laivojen asettaminen laudalle: ensimmäinen versio, jossa laivat ovat
        // vain yhden ruudun pituisia. Myöhemmin alla olevan metodiin tulee 
        //neljänneksi parametriksi orientaatio: esim 1 = pohj-etelä, jolloin
        // alus asetetaan niin, että lähtökohtana on annettu ruutu ja se asetetaan
        // siitä alespäin (eli jos aluksen pituus on 2, niin alla olevan esimerkin
        // mukaan alus menisin ruutuin (4,4) ja (4,3) )
      
       // asettaa aluksen numero 1 koordinatteihin (4,4) kutsumalla
        // Laivueen-luokan asetaLaivueenAlus(int aluksenNumero, int x, int y) - metodia, 
        // joka vuorostaan kutsuu kyseisen aluksen (1 on ensimmäinen alus listassa, eli yhden ruudun pituinen sukellusvene)
        // asetaAlus(int x, int y)- metodia, jossa luodaan uusi Ruutu(x,y),
        // ja lisätään alukseen tämä Ruutu (alus itsessään on ArrayList ruuduista!)

     
 
        Laivue teponLaivue = new Laivue("Teppo");
        teponLaivue.asetaLaivueenAlus(1, 1, 1, 1);
        teponLaivue.asetaLaivueenAlus(2, 5, 5, 1); // -> ruudut (5,5), (6,5)
        System.out.println(teponLaivue);
        

        teponLaivue.yritaAmpuaLaivueeseen(1, 1);
        teponLaivue.yritaAmpuaLaivueeseen(5, 5);
        teponLaivue.yritaAmpuaLaivueeseen(6, 5);
        System.out.println(teponLaivue);
        
        Peli uusipeli = new Peli("Matti","Teppo");
       

    }

    public static void Ammu(Laivue vihollisenLaivue, int x, int y) {
        vihollisenLaivue.yritaAmpuaLaivueeseen(x, y);
    }

}
