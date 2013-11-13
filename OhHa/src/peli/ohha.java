package peli;
import java.util.ArrayList;


/**
 *
 * @Laivanupotuksen mega-pre-alfa
 * Myöhemmin toiminnallisuus lisätään Peli-luokkaan
 */

// HUOM! 7.11 palautus hieman myöhässä koska sairastuin tänään (ihan oikeasti)
// lievää kuumetta pukkaa mutta päätin levon jälkeen tehdä mitä kerkiän.
public class ohha {

    
    public static void main(String[] args) {
        
        Alus sukellusvene = new Alus(1,"Sukellusvene");
        Alus havittaja = new Alus(2,"Hävittäjä");
        Alus risteilija = new Alus(3,"Risteilijä");
        
         ArrayList<Alus> alukset = new ArrayList<Alus>();
         alukset.add(sukellusvene);
         alukset.add(havittaja);
         alukset.add(risteilija);

        // luodaan ruutuja
        Ruutu ekaRuutu = new Ruutu(2,3);
        Ruutu tokaRuutu = new Ruutu(5,7);
        
        // asetetaan sukellusvene ekaan ruutuun
        sukellusvene.asetaAlus(ekaRuutu);
        
        for(Alus laiva:alukset) {
            
        }
        
        
      
    }
    
    
    
    public void alustaPeliLauta() {     
        for ( int i = 1; i < 10 ; i++) {
            for ( int j = 1; j < 10; j++) {
                
            } 
        } 
    }
    
    public void Ammu(int x, int y) {
       
   }
}
