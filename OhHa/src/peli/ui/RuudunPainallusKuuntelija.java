/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli.ui;


import java.awt.Color;
import peli.Laivue;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuudunPainallusKuuntelija implements ActionListener {
    
    private Laivue vihollisenLaivue;
    private int x;
    private int y;
    private JButton button;
    
    public RuudunPainallusKuuntelija(int x, int y, JButton button, Laivue vihollisenLaivue) {
        this.x = x;
        this.y = y;
        this.button = button;
        this.vihollisenLaivue = vihollisenLaivue;
    }
    
    /**
     * Kun ruutua klikataan, sihen ammutaan. Tällöin kutsutaan Laivue-luokan
     * yritaAmpuaLaivueeseen-metodia. Jos ruudussa on alus, osa aluksesta 
     * tuhoutuu ja ruutu muuttuu vihreäksi ja siihen piirretään ympyrä.
     * Jos ruudussa ei ole alusta, ruutu muuttuu punaiseksi ja siihen piirretään
     * rasti. 
     * @param ae 
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //System.out.println(x+","+y);
        
        boolean osuiko = vihollisenLaivue.yritaAmpuaLaivueeseen(x, y);
        if (osuiko) {
            this.button.setBackground(Color.GREEN);
            this.button.setText("O");
            System.out.println(vihollisenLaivue);
        } else {
            this.button.setBackground(Color.RED);
            this.button.setText("X");
        }
        
        
        
  
    }
    
    
    
    
    
}