/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peteukko
 */
public class AlusTest {
    
    Alus pertinAlus;
    Alus matinAlus;
    
    public AlusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pertinAlus = new Alus(1,"Pertti");
        matinAlus = new Alus(3,"Matti");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void aluksellaAlunPerinYksiRuutu() {
        assertEquals(pertinAlus.getRuutujenLkm(),1);
        
    }
    
 
    @Test
    public void yhdenRuudunAluksenAsetusOnnistuu() {
        pertinAlus.asetaAlus(4, 4);
        assertEquals(pertinAlus.getRuutujenLkm(),2);
        
    }
    
    
    
    @Test
    public void ruudunPoistaminenEliAluksenVahingoittaminenToimii() {
        pertinAlus.asetaAlus(4, 4);
        pertinAlus.poistaRuutu(4, 4);
        assertEquals(pertinAlus.getRuutujenLkm(),1);
    }
    
    @Test
    public void alusTietaaJosSeOnTuhoutunut() {
        pertinAlus.asetaAlus(4, 4);
        pertinAlus.poistaRuutu(4, 4);
        assertTrue(pertinAlus.onkoTuhoutunut());
    }
    
    @Test
    public void monenRuudunAluksenAsetusOnnistuuJaRuudutVahentyvatSallituista(){
        Ruutulista sallitut = new Ruutulista();
        sallitut.lisaaRuutu(2, 2);
        sallitut.lisaaRuutu(3, 2);
        sallitut.lisaaRuutu(4, 2);
        assertEquals(sallitut.getRuutujenLkm(),3);
        boolean onnistuiko = matinAlus.asetaAlusKunnolla(2, 2, 1, sallitut);
        assertEquals(matinAlus.getRuutujenLkm(),4);
        assertEquals(sallitut.getRuutujenLkm(),0);
        assertTrue(onnistuiko);
    }
    
    @Test
    public void monenRuudunAluksenAsetusEiOnnistuJosJokuRuuduistaEiKelpaa() {
        Ruutulista sallitut = new Ruutulista();
        sallitut.lisaaRuutu(2, 2);
        sallitut.lisaaRuutu(3, 2);
        boolean onnistuiko = matinAlus.asetaAlusKunnolla(2, 2, 1, sallitut); 
        //aluksen pituus on 3 ja se tulisi ruutuihin (2,2),(3,2),(4,2) 
        //mutta (4,2) ei ole sallituissa
        assertEquals(matinAlus.getRuutujenLkm(),1);
        assertEquals(sallitut.getRuutujenLkm(),2);
        assertFalse(onnistuiko);        
    } 
    
    @Test
    public void alustaEiVoiAsettaaToisenAluksenPaalle() {
       Ruutulista sallitut = new Ruutulista();
       sallitut.lisaaRuutu(2,2);
       sallitut.lisaaRuutu(3,2);
       sallitut.lisaaRuutu(4,2);
       boolean onnistuiko1 = matinAlus.asetaAlusKunnolla(2,2,1, sallitut);
       boolean onnistuiko2 = pertinAlus.asetaAlusKunnolla(2,2,1,sallitut);
       assertTrue(onnistuiko1);
       assertFalse(onnistuiko2); 
    }
    
    @Test
    public void alukseenAmpuminenToimii() {
        Ruutulista salli = new Ruutulista();
        salli.lisaaRuutu(1, 1);
        salli.lisaaRuutu(2, 1);
        salli.lisaaRuutu(3, 1);
        boolean onnistuiko = matinAlus.asetaAlusKunnolla(1,1,1,salli);
        assertTrue(onnistuiko);
        assertEquals(matinAlus.getRuutujenLkm(),4);
        boolean osuiko = matinAlus.josAluksellaTamaRuutuTuhoaSe(3, 1);
        assertEquals(matinAlus.getRuutujenLkm(),3);
        assertTrue(osuiko);
    }
}