/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peteukko
 */
import java.util.ArrayList;

public class Alus {
    
   ArrayList<Ruutu> aluksenRuudut;
   ArrayList<Ruutu> ammututRuudut;
   
   private int aluksenTyyppi;
    
   public Alus(ArrayList<Ruutu> ruutuLista) {
       
       this.aluksenRuudut = ruutuLista;
       
       aluksenTyyppi = aluksenRuudut.size();

   }
   
   public void tuhoaRuutu(Ruutu ruutu) {
       ammututRuudut.add(ruutu);
   }

}
