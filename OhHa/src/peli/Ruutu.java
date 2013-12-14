package peli;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
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
   
    public boolean matchaakoKoordinaatit(int x2, int y2) {
        return (x2 == x && y2 == y);
        
    }
    
    public boolean matchaakoKoordinaatit(Ruutu verrattava) {
        return (this.x == verrattava.x && this.y == verrattava.y);
        
    }
    
   
    
    public String toString() {
        return x+","+y;
     //   if (onkoAlusta) {
     //       return "Ruudussa " +x+","+y+  " on alus!";
     //   } else {
     //       return "Ruudussa " +x+","+y+  " ei ole alusta!";
     //   }
    }
}
