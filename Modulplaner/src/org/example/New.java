
package org.example;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import org.example.Listener.Button.NewAbbruchButtonActionListener;
import org.example.Listener.Button.NewSpeicherButtonActionListener;
import org.example.Listener.Button.NewDeleteButtonActionListner;
import org.example.MenuBar.MenuBar;


public class New extends JFrame {
    
    Modulplaner parent;
    
    //Initzialisierung der Button bzw. Eingabefelder
    JButton speichernButton = new JButton("Speichern");
    JButton abbrechenButton = new JButton("Abbrechen");
    JButton deleteButton = new JButton("Löschen");
    JTextField modulnameField = new JTextField();
    JTextField timeField = new JTextField();
    
    //Datenliste als arry wird intizialisiert
    private ArrayList<String> datenListe = new ArrayList<>();

    public New(Modulplaner p) {
        this.parent = p;
        
        setSize(200, 250);
        setLocationRelativeTo(null);
        setJMenuBar(new MenuBar("neu",p));

        JPanel newPanel = new JPanel();
        
        //Layout des Fensters wird festgelegt
        newPanel.setLayout(new GridLayout(8, 1));
        newPanel.setBorder(new LineBorder(Color.BLACK));
        
        //Elemente werden demFenster hinzugefügt
        newPanel.add(new JLabel("Modulname", FlowLayout.LEFT));
        newPanel.add(modulnameField);
        newPanel.add(new JLabel("Uhrzeit", FlowLayout.LEFT));
        newPanel.add(timeField);
        
        newPanel.add(speichernButton);
        newPanel.add(deleteButton);
        newPanel.add(abbrechenButton);
        
        add(newPanel);
        
        //Fenster wird sichtbar gemacht
        setVisible(true);
        
     //Button wird ein ActionListner hinzugefügt (Button bekommt funktion)
        speichernButton.addActionListener(new NewSpeicherButtonActionListener(modulnameField, timeField, datenListe));
        deleteButton.addActionListener(new NewDeleteButtonActionListner(datenListe));
        abbrechenButton.addActionListener(new NewAbbruchButtonActionListener(this));
    }
    
    
    public ArrayList<String> getDatenListe() {
        return datenListe;
    }
}
