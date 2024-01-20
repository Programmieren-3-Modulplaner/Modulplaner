package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;


public class Hilfe extends JFrame {
    
    private Modulplaner parent;

    public Hilfe(Modulplaner p) {
        this.parent = p;
        
        String languageCode = parent.getLanguageString();
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
    
        if (Desktop.isDesktopSupported())   
        {   
            InputStream jarPdf = getClass().getResourceAsStream("/help/" + pdfFileName);
            try {
                File pdfTemp = new File("Modulplaner_temp.pdf");
                FileOutputStream fos = new FileOutputStream(pdfTemp);
                while (jarPdf.available() > 0) {
                      fos.write(jarPdf.read());
                }
                fos.close();
                Desktop.getDesktop().open(pdfTemp);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        
        /*
        //Zusammensetzung des Dateipfades
        File pdfPfad = new File("../src/help/" + pdfFileName);
        
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
        }*/
        
    }
}

