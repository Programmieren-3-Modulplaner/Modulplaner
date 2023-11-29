/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;
import org.example.Modul;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */


public class Modulplaner extends JFrame{

    //private ArrayList<Modul> module = new ArrayList();

    public Modulplaner() {
        setTitle("Planer");
        addWindowListener(new WindowEventListener());
        setSize(500, 600);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("modulplaner"));

        //datenListe.add(new Modul("Programmieren 3", "Montag", 8, 9));
        //System.out.println(module.get(0).getName());
        
        //Initializierung Variabeln
        //JLabel modulname = new JLabel(module.get(0).getName() + "      ");
        //JLabel modultag = new JLabel(module.get(0).getTag() + "; Beginn: " + module.get(0).getAnfang()+ " Uhr; " + "Ende: " + module.get(0).getEnde() + " Uhr");
        
        
        setLayout(new BorderLayout());

        // Erstelle zwei Panels (links und rechts)
        JPanel leftPanel = new JPanel(new GridLayout(10, 1));
        JPanel rightPanel = new JPanel(new GridLayout(10, 1));
        JPanel centerPanel = new JPanel(new GridLayout(10, 1));
        JPanel southPanel = new JPanel();

        // Erstelle die Buttons
        JButton button1 = new JButton("Speichern");
        JButton button2 = new JButton("Löschen");
        JButton button3 = new JButton("Hinzufügen");
        JLabel space1 = new JLabel("");
        JLabel space2 = new JLabel("");

        // Erstellen Labels
        JLabel kursoverview = new JLabel("Kursübersicht: ");
        JLabel detail = new JLabel("Details: ");

        // Label zu Panel hinzufügen
        leftPanel.add(kursoverview, BorderLayout.NORTH);
        centerPanel.add(detail, BorderLayout.NORTH);

        // Füge die Buttons zu den Panels hinzu
        rightPanel.add(button1);
        rightPanel.add(space1);
        rightPanel.add(button2);
        rightPanel.add(space2);
        rightPanel.add(button3);
        
       
        
        // Füge die Panels (links und rechts) zum Haupt-Panel hinzu
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        
        //Automatische erzeugen der benötigten Datei
        // Prüfe, ob das Verzeichnis existiert, wenn nicht, erstelle es
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
        
        // Prüfe, ob die Datei existiert, wenn nicht, erstelle sie
        File modulListFile = new File("data/ModulList.dat");
        if (!modulListFile.exists()) {
            try {
                modulListFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                // Handle die IOException entsprechend
            }
        }
            new Modulplaner();
        
    }
}
