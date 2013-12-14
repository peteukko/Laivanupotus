package peli;



/**
 * Laivanupotuksen "alin luokka" ja yksinkertaisin: ruudulla on int x ja int y.
 * Lisäksi sillä on muutama kätevä apumetodi.
 * @author peteukko
 */
public class Ruutu {
    
    private int x;
    private int y;

    
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        //onkoAlusta = false;
        //onkoAmmuttu = false;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Ruutu getRuutu() {
        return this;
    }
   
    
    /**
     * Kertoo jos inputin koordinaatit vastaavat tämän ruudun koordinaatteja.
     * @param x2
     * @param y2
     * @return boolean true, jos vastaa
     */
    public boolean matchaakoKoordinaatit(int x2, int y2) {
        return (x2 == x && y2 == y);
        
    }
    
    /**
     * Kertoo jos inputin Ruutu vastaa tätä ruutua koordinaateiltaan.
     * @param verrattava Ruutu-olio
     * @return boolean true, jos vastaa
     */
    public boolean matchaakoKoordinaatit(Ruutu verrattava) {
        return (this.x == verrattava.x && this.y == verrattava.y);
        
    }
    
   
    
    public String toString() {
        return x+","+y;
    }
}
