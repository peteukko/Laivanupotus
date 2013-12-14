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
public class LaivueTest {

    Laivue teponLaivue;

    public LaivueTest() {
        teponLaivue = new Laivue("Teppo");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
    public void laivuuessaOnViisiEriPituistaAlusta() {
        assertEquals(teponLaivue.montakoAlusta(), 5);
    }

    @Test
    public void ennenAluksienSijoittamistaSallittujaRuutujaOn100() {
        assertEquals(teponLaivue.sallitutRuudut.getRuutujenLkm(), 100);
    }

    @Test
    public void aluksienAsettaminenToimii() {
        teponLaivue.asetaLaivueenAlus(1, 1, 1, 1);
        teponLaivue.asetaLaivueenAlus(2, 5, 5, 1); // -> ruudut (5,5), (6,5)
        assertEquals(teponLaivue.sallitutRuudut.getRuutujenLkm(), 97);
        assertTrue(teponLaivue.getAlus(2).onkoRuutuListalla(6, 5));
    }

    @Test
    public void kokolaivueenVoiAsettaaSatunnaisesti() {
        teponLaivue.asetaLaivueSatunnaisesti();
        assertEquals(teponLaivue.sallitutRuudut.getRuutujenLkm(), 85);

    }
    
    @Test 
    public void tietaakoLaivueJosSillaOnTiettyRuutu() {
        teponLaivue.asetaLaivueenAlus(2, 5, 5, 1);
        assertTrue(teponLaivue.onkoLaivueenJollakinAluksellaTamaRuutu(5, 5));
        assertFalse(teponLaivue.onkoLaivueenJollakinAluksellaTamaRuutu(5, 9));
    }
    
    @Test
    public void laivueTietaaMontakoAlustaOnAsetettu() {
                teponLaivue.asetaLaivueenAlus(1, 1, 1, 1);
        teponLaivue.asetaLaivueenAlus(2, 5, 5, 1);
        assertEquals(teponLaivue.montakoLaivaaAsetettu(), 2);
    }
    
    @Test
    public void laivueTietaaMontakoAlustaOnAsetettuJosEiYhtaan() {
        assertEquals(teponLaivue.montakoLaivaaAsetettu(), 0);
    }

    @Test
    public void ruutuunAmmuttuaAmmututPaivittyy() {
        teponLaivue.asetaLaivueSatunnaisesti();
        assertFalse(teponLaivue.onkoRuutuunJoAmmuttu(3, 3));
        teponLaivue.yritaAmpuaLaivueeseen(3, 3);
        assertTrue(teponLaivue.onkoRuutuunJoAmmuttu(3, 3));
    }
    
   

    @Test
    public void LaivuuenAluksenVoiTuhotaAmpumallaJaKokoLaivueenVoiTuhota() {
        teponLaivue.asetaLaivueenAlus(2, 5, 5, 1); // -> ruudut (5,5), (6,5)
        assertTrue(teponLaivue.onkoAluksiaJaljella());
        teponLaivue.yritaAmpuaLaivueeseen(5, 5);
        teponLaivue.yritaAmpuaLaivueeseen(6, 5);
        assertTrue(teponLaivue.getAlus(2).onkoTuhoutunut());
        assertFalse(teponLaivue.onkoAluksiaJaljella());
    }

}
