/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli.ui;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class napinKuuntelija implements ActionListener {
    
   
    private int x;
    private int y;
    private JButton button;
    
    public napinKuuntelija(int x, int y, JButton button) {
        this.x = x;
        this.y = y;
        this.button = button;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        System.out.println(x+","+y);
        this.button.setText("X");
        this.button.setBackground(Color.red);
        //this.button.setForeground(Color.red);
  
    }
    
    
    
    
    
}