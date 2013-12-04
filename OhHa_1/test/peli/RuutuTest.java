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
public class RuutuTest {

    public RuutuTest() {
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

    @Test
    public void matchaakoKoordinaatitToimiiJosSamat() {
        Ruutu ekaRuutu = new Ruutu(4, 5);
        Ruutu tokaRuutu = new Ruutu(4, 5);
        assertTrue(ekaRuutu.matchaakoKoordinaatit(tokaRuutu.getX(), tokaRuutu.getY()));
    }

    @Test
    public void matchaakoKoordinaatitToimiiJosEri() {
        Ruutu ekaRuutu = new Ruutu(4, 5);
        Ruutu tokaRuutu = new Ruutu(2, 2);
        assertFalse(ekaRuutu.matchaakoKoordinaatit(tokaRuutu.getX(), tokaRuutu.getY()));
    }
}