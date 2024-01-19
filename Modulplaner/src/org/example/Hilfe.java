package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Hilfe {
    
    private Modulplaner parent;

    public Hilfe(Modulplaner p) {
        this.parent = p;
        
        //Sprachecode für die Unterscheidung der Hilfesprache
        String languageCode = parent.getLanguageString();
        
        //Platzhalter für den Dateipfad
        String pdfFileName="";

        switch (languageCode) {
            case "en":
                pdfFileName = "Hilfe_Modulplaner_EN.pdf";
                break;
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
        java.net.URL helpURL = getClass().getResource("/help/" + pdfFileName);
        
        try {
            //Initzialisierung des Desktop -> so können Actionen des Desktops des Benutzers verwendet werden
            Desktop desktop = Desktop.getDesktop();
            
            //Prüfung ob das System die Methode unterstützt
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                
                //Öffnet den Dateipfad mit dem Standartprogramm des Systems
                desktop.open(new File(helpURL.toURI()));
            } else {
                JOptionPane.showMessageDialog(parent, "Datei kann nicht geöffnet werden");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}

