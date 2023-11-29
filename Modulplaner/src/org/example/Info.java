/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Info extends JPanel{
    public Info(){
       setLayout(new BorderLayout());
       
       JPanel Buttons = new JPanel();
       JButton hinzufuegen = new JButton("Hinzufügen");
       JButton Loeschen = new JButton("Löschen");
       JButton Bearbeiten = new JButton("Bearbeiten");
       
       Buttons.add(hinzufuegen);
       Buttons.add(Loeschen);
       Buttons.add(Bearbeiten);
       
       JPanel oben = new JPanel();
       oben.add(new JLabel("Kursdetails"));
       
       JPanel Inhalt = new JPanel();
       
       int i = 5;
       int j = 2;
       JPanel[][] holderInhalt = new JPanel[i][j];    
       Inhalt.setLayout(new GridLayout(i,j));
       for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
            holderInhalt[m][n] = new JPanel();
            holderInhalt[m][n].setSize(20,20);
            holderInhalt[m][n].setBorder(BorderFactory.createLineBorder(Color.black));
            Inhalt.add(holderInhalt[m][n]);
            }
        }
       
      
       add(oben,BorderLayout.NORTH);
       add(Buttons, BorderLayout.PAGE_END);
       add(Inhalt, BorderLayout.CENTER);
    }
}
