/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import peli.Ruutu;
import peli.Alus;
import peli.Laivue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pepe
 */
public class LaivaTest {
    
    Laivue testilaivue;
    Alus testialus;
    Ruutu ekaRuutu;
    Ruutu tokaRuutu;
    
    
    public LaivaTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testialus = new Alus(3,"Testialus");
        testilaivue = new Laivue("Kapteeni Koukku");
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void LaivuuellaOnKolmeAlusta() {
       assertEquals(testilaivue.montakoAlusta(),3);   
   }
   

   @Test
   public void alusOliollaAlunPerinYksiRuutu() {
       assertEquals(testialus.montakoRuutuaJaljella(),1);
   }
   
   @Test
   public void aluksenVoiAsettaaRuutuunJolloinSillaKaksiRuutua() {
       testialus.asetaAlus(3, 3);
       assertEquals(testialus.montakoRuutuaJaljella(),2);
   }
   
   
   @Test
   public void alusVoiHyvinKunSeOnAsetettuLaudalle() {
       testialus.asetaAlus(3, 3);
       assertFalse(testialus.onkoTuhoutunut());
   }
   
   @Test
   public void alusTuhoutuuKunSenRuutuihinOnAmmuttu() {
       testialus.asetaAlus(4, 4);
       testialus.josAluksellaTamaRuutuTuhoaSe(4, 4);
       assertTrue(testialus.onkoTuhoutunut());
       
   }
   
  

   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
