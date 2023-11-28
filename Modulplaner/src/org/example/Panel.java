/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author da2939
 */
public class Panel extends JPanel{
         public Panel(String kurs){
         
         this.setBorder(BorderFactory.createLineBorder(Color.black));
         JLabel test = new JLabel(kurs);
         test.setSize(20, 20);
         this.add(test);
     }
}
