/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        
        //luodaan ruutuja
        ekaRuutu = new Ruutu(2,3);
        tokaRuutu = new Ruutu(5,7);
    }
    
    @After
    public void tearDown() {
    }

    
   @Test
   public void ruutuTyhjaEnnenAsetusta() {
      assertFalse(ekaRuutu.onkoTassaAlusta());
   }
   
   @Test
   public void ruutuEiTyhjaAsetuksenJalkeen() {
      testialus.asetaAlus(ekaRuutu);
      assertTrue(ekaRuutu.onkoTassaAlusta());
   }
   
   @Test
   public void ruutuTietaaJosSiihenAmmuttuEnnenAmpumista() {
      assertFalse(ekaRuutu.onkoTahanAmmuttu());
   }
   
   @Test
   public void ruutuTietaaJosSiihenAmmuttuAmpumisenJalkeen() {
      ekaRuutu.ammuRuutuun();
      assertTrue(ekaRuutu.onkoTahanAmmuttu());
   }
   
   @Test
   public void aluksellaYksiRuutuAlunPerin() {
       testialus.asetaAlus(ekaRuutu);
       assertEquals(testialus.montakoRuutuaJaljella(),1);
   }
   
   @Test
   public void alusVoiHyvinAlunPerin() {
       testialus.asetaAlus(ekaRuutu);
       assertFalse(testialus.onkoTuhoutunut());
   }
   
   @Test
   public void alusTuhoutuuJosSenRuutuunAmmutaan() {
      testialus.asetaAlus(ekaRuutu);
      testialus.tuhoaRuutu(ekaRuutu);
      assertTrue(testialus.onkoTuhoutunut());
   }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
