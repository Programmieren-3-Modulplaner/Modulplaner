package org.example;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
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
    JButton deleteButton = new JButton("Löschen");
    
    JTextField modulnameField = new JTextField();
    JTextField tagField = new JTextField();
    JTextField anfangField = new JTextField();
    JTextField endeField = new JTextField();

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
        add(tagField);
        add(new JLabel("Anfang (Uhrzeit, int): "));
        add(anfangField);
        add(new JLabel("Ende (Uhrzeit, int): "));
        add(endeField);

        add(speichernButton);
        add(deleteButton);
        add(abbrechenButton);
    }
    
    //Hilfsmethode für die Buttons
    private void setupActions() {
        // Button wird ein ActionListener hinzugefügt (Button bekommt Funktion)
        speichernButton.addActionListener(new NewSpeicherButtonActionListener(modulnameField, tagField, anfangField, endeField));
        deleteButton.addActionListener(new NewDeleteButtonActionListner(datenListe));
        abbrechenButton.addActionListener(new NewAbbruchButtonActionListener (this));
    }

    // Main methode zur Aufrfung des Konstruktors und dmait mit dem Aufbau des Dialogfensters
    public static void main(String[] args) {
        new New();
    }

    

    public ArrayList<Modul> getDatenListe() {
        return datenListe;
    }
}