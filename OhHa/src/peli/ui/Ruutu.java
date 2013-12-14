package peli.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import peli.*;

/**
 * Graafinen ruutu: JButton, jolla on koordinaatit x ja y
 */
public class Ruutu extends JButton {

    private int x;
    private int y;

    public Ruutu(int x, int y) {
        super("o");
        this.x = x;
        this.y = y;

    }



    public int getXkord() {
        return x;
   }

    public int getYkord() {
        return y;
    }

}
