/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zz_proyecto1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Juan Jimenez
 */


public class A_imagen extends JPanel{
    private BufferedImage imagendeFondo;
    public A_imagen(BufferedImage backgroundImage){
        this.imagendeFondo = backgroundImage; //ImageIO.read(new File("menu.jpg"));
    }
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(imagendeFondo, 0, 0, getWidth(), getHeight(), this);
    }        
}
