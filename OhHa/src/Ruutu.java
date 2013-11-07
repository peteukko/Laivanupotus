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
    private boolean onkoAlusta;
    private boolean onkoAmmuttu;
    
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        onkoAlusta = false;
        onkoAmmuttu = false;
    }
    
    public void alusRuutuun() {
        onkoAlusta = true;   
    }
            
    public void ammuRuutuun() {
        onkoAmmuttu = true; 
    }
    
    public boolean onkoTassaAlusta() {
        return onkoAlusta;
    }
    
    public boolean onkoTahanAmmuttu() {
        return onkoAmmuttu;
    }
    
    
    public String toString() {
        if (onkoAlusta) {
            return "Ruudussa " +x+","+y+  " on alus!";
        } else {
            return "Ruudussa " +x+","+y+  " ei ole alusta!";
        }
    }
}
