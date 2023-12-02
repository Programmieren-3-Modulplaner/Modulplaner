/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author da2939
 */
public class Plan extends JPanel{
    public Plan(){
        //setSize(500, 500);
        //setLocationRelativeTo(null);
        //JPanel main = new JPanel();
        //String[] kurse = {"Mathe 1", "Mathe 2", "Programmieren 1", "Programmieren 2", "Programmieren 3", "Statistik", "KLR", "Externes Rechnungswesen", "Grundlagen der Informatik", "Mathe 1", "Mathe 2", "Statistik", "KLR", "Grundlagen der Informatik"};
        String[] block = {"1.Block", "2. Block", "3. Block","4. Block","5.Block"};
        String[] tage = {"Montag","Dienstag","Mittwoch","Donnerstag","Freitag"};
        
        GridLayout kursGrid = new GridLayout(6,6);      
        setLayout(kursGrid);
       
        int i = 6;
        int j = 6;
        JPanel[][] panelHolder = new JPanel[i][j];    
        setLayout(new GridLayout(i,j));

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
            panelHolder[m][n] = new JPanel();
            panelHolder[m][n].setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
           
            add(panelHolder[m][n]);
            }
        }
        
        for(int x = 1; x <= tage.length; x++){
            panelHolder[0][x].add(new JLabel(tage[x-1]));
        }
        
        for(int y = 1; y <= block.length; y++){
            panelHolder[y][0].add(new JLabel(block[y-1]));
        }
        panelHolder[1][1].add(new JLabel("Mathe 1"));
        panelHolder[4][4].add(new JLabel("Mathe 1"));
        setVisible(true);
        }
    
}
