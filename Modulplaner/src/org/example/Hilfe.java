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
        
        String languageCode = parent.getLanguageString();
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
    
        java.net.URL helpURL = getClass().getResource("/help/" + pdfFileName);
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
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

