/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;
import java.util.ArrayList;
/**
 *
 * @author Pepe
 */
public class Laivue {
    
   ArrayList<Alus> Laivue;
    
    
   private String kapteeni;
    
   public Laivue(String kapteeni) {
       this.Laivue = new ArrayList<Alus>();
       this.kapteeni = kapteeni;
       
       Alus sukellusvene = new Alus(1,"Sukellusvene");
       Alus havittaja = new Alus(2,"Hävittäjä");
       Alus risteilija = new Alus(3,"Risteilijä");
       Laivue.add(sukellusvene);
       Laivue.add(havittaja);
       Laivue.add(risteilija);
         
   }
   
   
   public void asetaLaivueenAlus(int aluksenNumero, int x, int y) {
       if (aluksenNumero <= Laivue.size() && aluksenNumero > 0 && x > 0 && y > 0) {
       Laivue.get(aluksenNumero-1).asetaAlus(x, y);    
       } else {
           System.out.println("Ei kelpaa, asettaessa laivaa laudalle laivan numeron on oltava väliltä 1..."+
                   Laivue.size()+" ja x, y-koordinaatit väliltä 1...10");
       }
   }
   
   public int montakoAlusta() {
       return Laivue.size();
   }
   
   public void TulostaAluksenTila(int aluksenNumero) {
       System.out.println(Laivue.get(aluksenNumero-1).toString());
   }
   
   public void yritaAmpuaLaivueeseen(int x, int y) {
       for(Alus alus:Laivue) {
           alus.josAluksellaTamaRuutuTuhoaSe(x, y);
       }
   }
   
   public String toString() {
       String palautettava = kapteeni+"-pojan laivue: \n";
       for(Alus alus:Laivue) {
           palautettava = palautettava +alus.toString() +"\n";
       }
       return palautettava;
   }
   
   public Alus getAlus(int aluksenNumero) {
       return Laivue.get(aluksenNumero);
   }
   
    
}
