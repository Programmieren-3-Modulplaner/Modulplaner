/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Info extends JPanel{
    public Info(){
       
       setLayout(new BorderLayout(0,15)); 
        
       JPanel mitte = new JPanel(); 
       mitte.setLayout(new GridLayout(4,0,5,10));
       
       //Buttons BEGINN
       JPanel Buttons = new JPanel();
       Buttons.setLayout(new GridLayout(0,3));
       JButton hinzufuegen = new JButton("Belegen");
      
       JButton Loeschen = new JButton("Löschen");
       JButton Bearbeiten = new JButton("Speichern");
       
       Buttons.add(hinzufuegen);
       Buttons.add(Loeschen);
       Buttons.add(Bearbeiten);
       // Buttons END
       
       // Zeile 1 BEGINN
       JPanel zeile1 = new JPanel();
       zeile1.setLayout(new GridLayout(0,2));
       
       JPanel ku= new JPanel();
       ku.setLayout(new GridLayout(2,0));
       JLabel u = new JLabel("Kursname:",2);
       //u.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
       ku.add(u);
       ku.add(new JTextField("Mathe 1",20));
       
       JPanel pro = new JPanel();
       pro.setLayout(new GridLayout(2,0));
       JLabel u2 = new JLabel("Professor:",2);
       pro.add(u2);
       pro.add(new JTextField("Karabek",20));
       
       zeile1.add(ku);
       zeile1.add(pro);
       //Zeile 1 END
       
       //Zeile 2 BEGINN
       JPanel zeile2 = new JPanel();
       zeile2.setLayout(new BorderLayout());
       //zeile2.setBorder(BorderFactory.createLineBorder(Color.black));
       
       JPanel b1 = new JPanel();
       b1.setLayout(new GridLayout(0,3));
       JPanel t = new JPanel();
       t.setLayout(new GridLayout(2,0));
       t.add(new JLabel("Tag:"));
       t.add(new JTextField("Montag",10));
       b1.add(t);
       
       JPanel z = new JPanel();
       z.setLayout(new GridLayout(2,0));
       z.add(new JLabel("Block:"));
       z.add(new JTextField("1",10));
       b1.add(z);
       
       JPanel r = new JPanel();
       r.setLayout(new GridLayout(2,0));
       r.add(new JLabel("Raum:"));
       r.add(new JTextField("S303",10));
       b1.add(r);
       
       zeile2.add(new JLabel("Block 1:"),BorderLayout.PAGE_START);
       zeile2.add(b1,BorderLayout.CENTER);
       //Zeile 2 END
       
       //Zeile 3 BEGINN
       JPanel zeile3 = new JPanel();
       zeile3.setLayout(new BorderLayout());
       //zeile3.setBorder(BorderFactory.createLineBorder(Color.black));
       
       JPanel b2 = new JPanel();
       b2.setLayout(new GridLayout(0,3));
       JPanel t2 = new JPanel();
       t2.setLayout(new GridLayout(2,0));
       t2.add(new JLabel("Tag:"));
       t2.add(new JTextField("Donnerstag",10));
       b2.add(t2);
       
       JPanel z2 = new JPanel();
       z2.setLayout(new GridLayout(2,0));
       z2.add(new JLabel("Block:"));
       z2.add(new JTextField("4",10));
       b2.add(z2);
       
       JPanel r2 = new JPanel();
       r2.setLayout(new GridLayout(2,0));
       r2.add(new JLabel("Raum:"));
       r2.add(new JTextField("S303",10));
       b2.add(r2);
       
       zeile3.add(new JLabel("Block 2:"),BorderLayout.PAGE_START);
       zeile3.add(b2,BorderLayout.CENTER);
       //Zeile 3 END
       
       //n BEGINN    
       JPanel n = new JPanel();
       n.setLayout(new GridLayout(0,3));
       JPanel n1 = new JPanel();
       n1.setLayout(new GridLayout(2,0));
       n1.add(new JLabel("Versuch"));
       n1.add(new JTextField("2",10)); 
       n.add(n1);
       JPanel n2 = new JPanel();
       n2.setLayout(new GridLayout(2,0));
       n2.add(new JLabel("Note:"));
       n2.add(new JTextField(10));  
       n.add(n2);
       JPanel n3 = new JPanel();
       n3.setLayout(new GridLayout(2,0));
       
       JRadioButton auswahl1 = new JRadioButton("Ja");
       JRadioButton auswahl2 = new JRadioButton("Nein");
       JPanel radio = new JPanel();
       ButtonGroup gruppe = new ButtonGroup();
       gruppe.add(auswahl1);
       gruppe.add(auswahl2);
       
       radio.add(auswahl1);
       radio.add(auswahl2);
       n3.add(new JLabel("Bestanden"));
       n3.add(radio);
       
       
       n.add(n3);
       //n END
       
       
       mitte.add(zeile1);
       mitte.add(zeile2);
       mitte.add(zeile3);
       mitte.add(n);
       //mitte END

       
       //Layout erstellen
 
       add(new JLabel("Kursdetails"),BorderLayout.PAGE_START);
       add(mitte,BorderLayout.CENTER);
       add(Buttons, BorderLayout.PAGE_END);
       //Layout 
    }
}
