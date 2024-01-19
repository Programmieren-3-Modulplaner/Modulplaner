package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Hilfe extends JFrame {
    
    private Modulplaner parent;

    public Hilfe(Modulplaner p) {
        this.parent = p;
        
        //Sprachecode für die Unterscheidung der Hilfesprache
        String languageCode = parent.getLanguageString();
        
        //Platzhalter für den Dateipfad
        String pdfFileName="";

        switch (languageCode) {
            case "de":
                pdfFileName = "Hilfe_Modulplaner_DE.pdf";
                break;
            case "fr":
                pdfFileName = "Hilfe_Modulplaner_FR.pdf";
                break;
            default: 
                pdfFileName = "Hilfe_Modulplaner_EN.pdf";
                break;
        }
    
        //Zusammensetzung des Dateipfades
        File pdfPfad = new File("../docs/" + pdfFileName);
        
        try {
            //Initzialisierung des Desktop -> so können Actionen des Desktops des Benutzers verwendet werden
            Desktop desktop = Desktop.getDesktop();
            
            //Prüfung ob das System die Methode unterstützt
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                
                //Öffnet den Dateipfad mit dem Standartprogramm des Systems
                desktop.open(pdfPfad); 
            } else {
                JOptionPane.showMessageDialog(parent, "Datei kann nicht geöffnet werden");
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}

