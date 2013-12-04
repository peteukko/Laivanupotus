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
public class RuutulistaTest {
    
    Ruutulista ekaLista;
    Ruutulista tokaLista;
    Ruutulista kolmasLista;
    
    public RuutulistaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ekaLista = new Ruutulista();
        tokaLista = new Ruutulista();
        tokaLista.lisaaRuutu(2, 2);
        tokaLista.lisaaRuutu(3, 3);
        tokaLista.lisaaRuutu(5, 5);
           
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ruutuListallaAlunPerinNollaRuutua() {
        assertEquals(ekaLista.getRuutujenLkm(),0);
    }
    
    @Test
    public void ruudunLisaaminenToimiiKoordinaateilla() {
        ekaLista.lisaaRuutu(3, 3);
        assertEquals(ekaLista.getRuutujenLkm(),1);
    }
    
    @Test
    public void ruudunLisaaminenToimiiOliolla() {
        ekaLista.lisaaRuutuOlio(new Ruutu(3,3));
        assertEquals(ekaLista.getRuutujenLkm(),1);
    }
    
    @Test
    public void useammanRuudunLisaaminenToimii() {
        ekaLista.lisaaRuutulistaTahanRuutuListaan(tokaLista);
        assertEquals(ekaLista.getRuutujenLkm(),3);
    }
    
    @Test
    public void ruudunPoistaminenKoordinaateillaToimii() {
        ekaLista.lisaaRuutu(3, 4);
        ekaLista.poistaRuutu(3, 4);
        assertEquals(ekaLista.getRuutujenLkm(),0);
    }
    
    @Test
    public void useammanRuudunPoistaminenToimii() {
        ekaLista.lisaaRuutu(2,2);
        ekaLista.lisaaRuutu(3,3);
        tokaLista.poistaArgumentinRuudutTastaRuutulistasta(ekaLista);
        assertEquals(tokaLista.getRuutujenLkm(),1);
        
    }
    
    @Test
    public void onkoRuutuListassaToimii() {
        ekaLista.lisaaRuutu(1,1);
        assertTrue(ekaLista.onkoRuutuListalla(1, 1));
    }
    
    @Test
    public void toimiikoOnkoListanRuudutToisessaListassaJosOn() {
        ekaLista.lisaaRuutu(2, 2);
        ekaLista.lisaaRuutu(3, 3);
        assertTrue(ekaLista.onkoKaikkiRuudutTassaListassaMyosArgumentinListassa(tokaLista));
    }
    
    @Test
    public void toimiikoOnkoListanRuudutToisessaListassaJosPoikkeama() {
        ekaLista.lisaaRuutu(2, 2);
        ekaLista.lisaaRuutu(3, 4);
        assertFalse(ekaLista.onkoKaikkiRuudutTassaListassaMyosArgumentinListassa(tokaLista));
    }
    
    
    
    
}