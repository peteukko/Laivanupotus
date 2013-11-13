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
   }
   
   // Ensimmäinen toteutus: Vain Yhden ruudun aluksia (myöhemmin tulee ongelma, miten aluksen orientaatio toteutetaan)
   public void asetaAlus(Ruutu lahtoRuutu) {
       //Ruutu lahtoRuutu = new Ruutu(x, y);
       Alus.add(lahtoRuutu);
       lahtoRuutu.alusRuutuun();
   }
   
   public void tuhoaRuutu(Ruutu ruutu) {
       Alus.remove(ruutu);
   }
   
   public String toString() {
       if (Alus.isEmpty()) {
           return nimi + ", koko: " +suuruus + ", TUHOUTUNUT!";
       } else {
            return nimi + ", koko: " +suuruus + ", ruutuja jaljella: " +Alus.size();
       }
   }
   
   public int montakoRuutuaJaljella() {
       return Alus.size();
   }
   
   public boolean onkoTuhoutunut() {
       if (Alus.isEmpty()) {
           return true;
       } else {
           return false;
       }
   }

}
