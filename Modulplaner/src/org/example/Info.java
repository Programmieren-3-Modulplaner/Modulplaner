/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Info extends JPanel{
    public Info(){
       this.setLayout(new BorderLayout(5,5));
       JPanel Buttons = new JPanel();
       JButton hinzufuegen = new JButton("Hinzufügen");
       JButton Loeschen = new JButton("Löschen");
       JButton Bearbeiten = new JButton("Bearbeiten");
       
       JPanel Inhalt = new JPanel();
       Inhalt.setLayout(new BoxLayout(Inhalt,BoxLayout.Y_AXIS));
       JPanel Zeile1 = new JPanel();
       JPanel Zeile2 = new JPanel();
       JPanel Zeile3 = new JPanel();
       
       JLabel Semester = new JLabel("Semester");
       JLabel Kurs = new JLabel("Kurs");
       JLabel Block = new JLabel("Block");
       
       Zeile1.add(Semester);
       Zeile3.add(Block);
       Zeile2.add(Kurs);
       
       Inhalt.add(Zeile1);
       Inhalt.add(Zeile2);
       Inhalt.add(Zeile3);
       
       
       JTextField SemesterTextfield = new JTextField("Wintersemester 2023", 15);
       JTextField KursTextfeld = new JTextField("Mathe 1",15);
       JTextField BlockTextField = new JTextField("1. Block", 15);
       Buttons.add(hinzufuegen);
       Buttons.add(Loeschen);
       Buttons.add(Bearbeiten);
       
       Zeile1.add(SemesterTextfield);
       Zeile2.add(KursTextfeld);
       Zeile3.add(BlockTextField);
       
       this.add(Buttons, BorderLayout.PAGE_END);
       this.add(Inhalt, BorderLayout.CENTER);
    }
}
