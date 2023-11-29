package org.example;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.example.Listener.Button.NewAbbruchButtonActionListener;
import org.example.Listener.Button.NewDeleteButtonActionListner;
import org.example.Listener.Button.NewSpeicherButtonActionListener;


public class New extends JDialog {

    // Initialisierung der Button bzw. Eingabefelder
    JButton speichernButton = new JButton("Speichern");
    JButton abbrechenButton = new JButton("Abbrechen");
    JButton deleteButton = new JButton("Liste Löschen");
    
    JTextField modulnameField = new JTextField();
    
    //Dropdown-Menü für Tage erstellen -> IntWert für weitere Möglichkeiten
    //IntWert beginnt bei 0 = "Bitte Wählen"
    String tag[]={"Bitte auswählen",
        "Montag",
        "Dienstag",
        "Mittwoch",
        "Donnertsag",
        "Freitag"};
    JComboBox tagBox = new JComboBox(tag);
    
    //Dropodown-Menü für den Block
    //IntWert 0 beginnt bei = "Bitte wählen"
    String block[]={"Bitte auswählen",
        "1. Block: 08:15Uhr - 09:45Uhr",
        "2. Block: 10:15 Uhr - 11:45 Uhr",
        "3. Block: 12:15 Uhr - 13:45 Uhr",
        "4. Block: 14:15 Uhr - 15:45 Uhr",
        "5. Block: 16:00 Uhr - 17:30 Uhr"};
    
    JComboBox blockBox = new JComboBox(block);

    // Datenliste als Array wird initialisiert
    private ArrayList<Modul> datenListe = new ArrayList<>();
    
    
    //Konstruktor wird initalisiert
    public New() {
        
        //true = sperrt Hauptfenster,
        super((JDialog) null, "Neues Modul", true);
        
        //Hilfmethoden
        NewUI();
        setupActions();
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //Hilfsmethode zur Aufsetzung des Fensters
    private void NewUI() {
        // Layout des Dialogfensters wird festgelegt
        setLayout(new GridLayout(8, 1));

        // Elemente dem Fenster hinzufügen
        add(new JLabel("Modulname: "));
        add(modulnameField);
        add(new JLabel("Wochentag: "));
        add(tagBox);
        add(new JLabel("Welcher Block? "));
        add(blockBox);
        

        add(speichernButton);
        add(deleteButton);
        add(abbrechenButton);
    }
    
    //Hilfsmethode für die Buttons
    private void setupActions() {
        // Button wird ein ActionListener hinzugefügt (Button bekommt Funktion)
        speichernButton.addActionListener(new NewSpeicherButtonActionListener(modulnameField, tagBox, blockBox));
        deleteButton.addActionListener(new NewDeleteButtonActionListner(datenListe));
        abbrechenButton.addActionListener(new NewAbbruchButtonActionListener (this));
    }

    // Main methode zur Aufrfung des Konstruktors und dmait mit dem Aufbau des Dialogfensters
    public static void main(String[] args) {
        new New();
    }

    

    /*public ArrayList<Modul> getDatenListe() {
        return datenListe;
    }*/
}