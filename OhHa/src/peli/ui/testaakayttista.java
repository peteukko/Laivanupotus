/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli.ui;

import peli.Laivue;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pepe
 */
public class testaakayttista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Laivue laivue1 = new Laivue("USS Enterprise");
        Laivue laivue2 = new Laivue("Kapteeni Koukku");
        //System.out.println(laivue.montakoAlusta());
        //System.out.println(laivue);
        //laivue.asetaLaivueenAlus(1, 3, 3, 1);
        //System.out.println(laivue);
      
        //laivue.asetaAlusSatunnaisesti(3);
        laivue1.asetaLaivueSatunnaisesti();
        laivue2.asetaLaivueSatunnaisesti();
        
        //System.out.println(laivue);
        
        Graafinenkayttoliittyma graafinen = new Graafinenkayttoliittyma(laivue1, laivue2);
        SwingUtilities.invokeLater(graafinen);
    }
    
}
