/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author da2939
 */
public class Plan extends JPanel{
    public Plan(){
        //setSize(500, 500);
        //setLocationRelativeTo(null);
        JPanel main = new JPanel();
        //String[] kurse = {"Mathe 1", "Mathe 2", "Programmieren 1", "Programmieren 2", "Programmieren 3", "Statistik", "KLR", "Externes Rechnungswesen", "Grundlagen der Informatik", "Mathe 1", "Mathe 2", "Statistik", "KLR", "Grundlagen der Informatik"};
        String[] block = {"1.Block", "2. Block", "3. Block","4. Block","5.Block"};
        String[] tage = {"Montag","Dienstag","Mittwoch","Donnerstag","Freitag"};
        
        GridLayout kursGrid = new GridLayout(6,6);      
        main.setLayout(kursGrid);
        
        JPanel leer = new JPanel();
        leer.setBackground(Color.black);
        main.add(leer);
        
        for(int x = 0; x < tage.length; x++){
            main.add(new Panel(tage[x]));
        }
        for(int i = 0; i < block.length; i++){
           
           main.add(new Panel(block[i]));
           
           for(int a = 0; a < 5; a++){
               Random rn = new Random();
               int randInt = rn.nextInt(4);
               if(a == randInt){
                   JPanel temp = new JPanel();
                   temp.setBackground(Color.GRAY);
                   main.add(temp);
               }else{
               main.add(new Panel(""+a));
               }
           }
        }
        this.add(main);
        setVisible(true);
        }
    
}
