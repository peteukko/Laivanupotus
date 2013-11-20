/*
 * Ruutulista on Ruuduista muodostuva ArrayList-olio. Ruutuja voi lisätä ja poistaa
 */
package peli;


import java.util.ArrayList;

public class Ruutulista {

    public String nimi;
    ArrayList<Ruutu> Ruutulista;

    public Ruutulista() {
        this.Ruutulista = new ArrayList<Ruutu>();
    }
    
    public Ruutulista(String nimi) {
        this.Ruutulista = new ArrayList<Ruutu>();
        this.nimi = nimi;
        
        //Ruutu existentiaaliRuutu = new Ruutu(0, 0);
        //Ruutulista.add(existentiaaliRuutu);
    }

    public void lisaaRuutu(int x, int y) {
        Ruutu uusiRuutu = new Ruutu(x, y);
        Ruutulista.add(uusiRuutu);
    }

    public void lisaaRuutuOlio(Ruutu lisattavaRuutu) {
        Ruutulista.add(lisattavaRuutu);
    }

    public void poistaRuutu(int x, int y) {
        ArrayList<Ruutu> tuhottava = new ArrayList<Ruutu>();
        for (Ruutu ruutu : Ruutulista) {
            if (ruutu.matchaakoKoordinaatit(x, y)) {
                tuhottava.add(ruutu);
            }
        }
        Ruutulista.removeAll(tuhottava); 
    }
    
    public void poistaRuutuOlio(Ruutu poistettavaRuutu) {
        Ruutulista.remove(poistettavaRuutu);
    }

    public int getRuutujenLkm() {
        return Ruutulista.size();
    }

    public String getNimi() {
        return nimi;
    }

    public boolean onkoRuutuListalla(int x, int y) {
        boolean onkoListalla = false;
        for (Ruutu yksiruutu : Ruutulista) {
            if (yksiruutu.matchaakoKoordinaatit(x, y)) {
                onkoListalla = true;
            }
        }
        return onkoListalla;
    }

    public boolean onkoRuutuOlioListalla(Ruutu ruutu) {
        return Ruutulista.contains(ruutu);
    }
    
    //public boolean onkoKaikkiRuudutTassaListassaMyosArgumentinListassa(ArrayList<Ruutu> ruudut) {
     //   boolean totuus = true; 
     //   for (Ruutu ruutu:ruudut) {
     //       if R
     //   }
    //}

    public String toString() {

        String palautettava = "";
        for (Ruutu ruutu : Ruutulista) {
            palautettava = palautettava + ruutu.toString() + " | ";
        }
        return palautettava;
    }

}
