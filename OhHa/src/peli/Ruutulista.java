/**
 * Ruutulista on Ruuduista muodostuva ArrayList-olio. Ruutuja voi lisätä ja poistaa
 */
package peli;


import java.util.ArrayList;

public class Ruutulista {

    protected String nimi;
    ArrayList<Ruutu> ruutulista;

    public Ruutulista() {
        this.ruutulista = new ArrayList<Ruutu>();
    }
    
    public Ruutulista(String nimi) {
        this.ruutulista = new ArrayList<Ruutu>();
        this.nimi = nimi;
    }

    public void lisaaRuutu(int x, int y) {
        Ruutu uusiRuutu = new Ruutu(x, y);
        ruutulista.add(uusiRuutu);
    }

    public void lisaaRuutuOlio(Ruutu lisattavaRuutu) {
        ruutulista.add(lisattavaRuutu);
    }
    

    public void lisaaRuutulistaTahanRuutuListaan(Ruutulista ruudut) {
        ruutulista.addAll(ruudut.ruutulista);

    }

    public void poistaRuutu(int x, int y) {
        ArrayList<Ruutu> tuhottava = new ArrayList<Ruutu>();
        for (Ruutu ruutu : ruutulista) {
            if (ruutu.matchaakoKoordinaatit(x, y)) {
                tuhottava.add(ruutu);
            }
        }
        ruutulista.removeAll(tuhottava); 
    }
    
    public void poistaRuutuOlio(Ruutu poistettavaRuutu) {
        ruutulista.remove(poistettavaRuutu);
    }

    public void poistaArgumentinRuudutTastaRuutulistasta(Ruutulista ruudut) {
        for (Ruutu ruutu:ruudut.ruutulista) {
            this.poistaRuutu(ruutu.getX(), ruutu.getY());
        }
    }
    
    public int getRuutujenLkm() {
        return ruutulista.size();
    }

    public String getNimi() {
        return nimi;
    }

    public boolean onkoRuutuListalla(int x, int y) {
        boolean onkoListalla = false;
        for (Ruutu yksiruutu : ruutulista) {
            if (yksiruutu.matchaakoKoordinaatit(x, y)) {
                onkoListalla = true;
            }
        }
        return onkoListalla;
    }

    public boolean onkoRuutuOlioListalla(Ruutu ruutu) {
        return ruutulista.contains(ruutu);
    }
    
    public boolean onkoKaikkiRuudutTassaListassaMyosArgumentinListassa(Ruutulista ruudut) {
        boolean totuus = true; 
        for (Ruutu ruutu:ruutulista) {
            if (!ruudut.onkoRuutuListalla(ruutu.getX(), ruutu.getY())) {
                totuus = false; 
            }
        } return totuus;
    }

    public String toString() {

        String palautettava = "";
        for (Ruutu ruutu : ruutulista) {
            palautettava = palautettava + ruutu.toString() + " | ";
        } 
        return palautettava;
    }

}
