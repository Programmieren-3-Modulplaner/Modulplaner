package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;


public class Hilfe extends JFrame {
    
    private Modulplaner parent;

    public Hilfe(Modulplaner p) {
        this.parent = p;
        
        //Sprachecode für die Unterscheidung der Hilfesprache
        String languageCode = parent.getLanguageString();
        System.out.println(languageCode);
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

    File pdfPfad = new File("docs/" + pdfFileName);
    try {
        Desktop desktop = Desktop.getDesktop();
        if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
            //Öffnet den Dateipfad mit dem Standartprogramm des Systems
            desktop.open(pdfPfad); 
        } 
    }catch (IOException e) {
        System.out.println(e.getMessage());
    }
        
    }
}

