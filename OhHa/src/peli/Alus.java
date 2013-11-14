package peli;


import java.util.ArrayList;

public class Alus {
    
   ArrayList<Ruutu> Alus;
   private int suuruus;
   private String nimi;
    
   public Alus(int suuruus, String nimi) {
       this.Alus = new ArrayList<Ruutu>();
       this.suuruus = suuruus;
       this.nimi = nimi;
       // Asetetaan "nollaruutu" joten Alus-olio ei ole koskaan tyhjä (voi kenties tulla ongelmia)
       Ruutu existentiaaliRuutu = new Ruutu(0,0);
       Alus.add(existentiaaliRuutu);
   }
   
   // Ensimmäinen toteutus: Vain Yhden ruudun aluksia (myöhemmin tulee kysymys, miten aluksen orientaatio toteutetaan)
   public void asetaAlus(int x, int y) {
       Ruutu ruutuJohonAlus = new Ruutu(x,y);
       Alus.add(ruutuJohonAlus);
       
       // Laivan asetus useampaan ruutuun
       //for(int i = 0; i < suuruus; i++) {
       //    
       //}
   }
   
   public void poistaRuutu(Ruutu ruutu) {
       Alus.remove(ruutu);
   }
   
   public String toString() {
       if (Alus.size() == 1) {
           return nimi + ", koko: " +suuruus + ", TUHOUTUNUT!";
       } else {
           String palautettava = "";
           palautettava = palautettava + nimi + ", koko: " +suuruus + ", ruutuja jaljella: " +(Alus.size()-1);
           // +"\n Ruutujen koordinaatit: ";
           //for (Ruutu aluksenruutu:Alus) {
           //    palautettava = palautettava + aluksenruutu.toString() + " | ";
           //}
           return palautettava;
       }
   }
   
   public int montakoRuutuaJaljella() {
       return Alus.size();
   }
   
   public void josAluksellaTamaRuutuTuhoaSe(int x, int y) {
       
       ArrayList<Ruutu> tuhottava = new ArrayList<Ruutu>();
       
       for(Ruutu ruutu:Alus) {
           
           if (ruutu.matchaakoKoordinaatit(x, y)) {     
               tuhottava.add(ruutu);
         
       }
     
     }
       Alus.removeAll(tuhottava);
   }
   
   
   public boolean onkoTuhoutunut() {
       if (Alus.size() == 1) {
           return true;
       } else {
           return false;
       }
   }

}
