package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;


public class Hilfe extends JFrame {
    
    private Modulplaner parent;

    public Hilfe(Modulplaner p) {
        this.parent = p;
        
        File pdfPfad = new File("docs/Hilfe_Modulplaner.pdf");
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
