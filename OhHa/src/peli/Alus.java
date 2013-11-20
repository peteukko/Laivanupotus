package peli;

import java.util.ArrayList;

public class Alus extends Ruutulista {

    ArrayList<Ruutu> Alus;
    private int pituus;
    private String nimi;

   
    public Alus(int pituus, String nimi) {
        super(nimi);
        this.Alus = super.Ruutulista;
        this.pituus = pituus;
        // Asetetaan "nollaruutu" joten Alus-olio ei ole koskaan tyhjä (voi kenties tulla ongelmia)
        Ruutu existentiaaliRuutu = new Ruutu(0, 0);
        Alus.add(existentiaaliRuutu);
    }

    // Ensimmäinen toteutus: Vain Yhden ruudun aluksia (myöhemmin tulee kysymys, miten aluksen orientaatio toteutetaan)
    public void asetaAlus(int x, int y) {
        super.lisaaRuutu(x, y);

    }
    
    
    // Toinen versio: Alus asetetaan ruutuihin, jonka määrittää ruutujen määrä (aluksen pituus)
    // ja int suunta: 1 = lähtöruudusta itään, 2 = etelään, 3 = länteen, 4 = pohjoiseen
    // metodi palauttaa true jos aluksen asetus onnistuu (alus ei mee laudan ulkopuolelle jne)
    public boolean asetaAlusKunnolla(int x, int y, int suunta, ArrayList<Ruutu> kelvolliset) {
        Ruutu lahtoRuutu = new Ruutu(x, y);
        Ruutulista lisattavat = new Ruutulista();
//        Alus.add(ruutuJohonAlus);

        boolean perusehto = x > 0 && x < 11 && y > 0 && y < 11 && suunta > 0 &&
                suunta < 5;
      //Use onkoRuutuListalla(int x, int y) mutta pitää kattoa KAIKKI ruudut
        //kelvolliset.onkoRuutuListalla
        //for (Ruutu yksruutu:kelvolliset) {
         //   if (lisattavat.onkoRuutuListalla(yksruutu.getX()), yksruutu.getY()) { 
            
        //}
        //}
        boolean kelpaa = true;
        
        
        
        if (perusehto && suunta == 1 && (x + pituus < 11)) {
            for (int i = 0; i < pituus; i++) {
                Ruutu uusiruutu = new Ruutu(x+i,y);
                lisattavat.lisaaRuutuOlio(uusiruutu);
                Alus.add(new Ruutu(x + i, y));
            }
            return true;
            
        } else if (perusehto && suunta == 2 && (y + pituus < 11)) {
            for (int i = 0; i < pituus; i++) {
                Alus.add(new Ruutu(x, y + i));
            }
            return true;

        } else if (perusehto && suunta == 3 && (x - pituus > 0)) {
            for (int i = 0; i < pituus; i--) {
                Alus.add(new Ruutu(x + i, y));
            }
            return true;

        } else if (perusehto && suunta == 4 && (y - pituus > 0)) {
            for (int i = 0; i < pituus; i--) {
                Alus.add(new Ruutu(x + i, y));
            }
            return true;

        } else {
            return false;
        }

    }

    //  if kelvollisetRuudut.includes.laitettavat
    //
    //
    
    
    public void poistaRuutu(Ruutu ruutu) {
        Alus.remove(ruutu);
    }

    public String toString() {
        if (Alus.size() == 1) {
            return nimi + ", koko: " + pituus + ", TUHOUTUNUT!";
        } else {
            String palautettava = "";
            palautettava = palautettava + nimi + ", koko: " + pituus + ", ruutuja jaljella: " + (Alus.size() - 1)
             +"\n Ruutujen koordinaatit: ";
            //for (Ruutu aluksenruutu:Alus) {
            //    palautettava = palautettava + aluksenruutu.toString() + " | ";
            //}
            return palautettava+super.toString();
        }
    }

    public int montakoRuutuaJaljella() {
        return Alus.size();
    }

    public void josAluksellaTamaRuutuTuhoaSe(int x, int y) {

       // ArrayList<Ruutu> tuhottava = new ArrayList<Ruutu>();
        super.poistaRuutu(x, y);
       // for (Ruutu ruutu : Alus) {
//
  //          if (ruutu.matchaakoKoordinaatit(x, y)) {
    //            tuhottava.add(ruutu);

  //          }
//
    //    }
      //  Alus.removeAll(tuhottava);
    }

    public boolean onkoTuhoutunut() {
        if (Alus.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

}
