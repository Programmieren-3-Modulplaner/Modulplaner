/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.example.DAO.ModuleDAO;

/**
 *
 * @author Danie
 */
public class Export extends JFrame {
    
    private Modulplaner parent;

    public Export(Modulplaner p) {
        this.parent = p;
        
        //JFileChooser chooser = new JFileChooser();
        // Dialog zum Oeffnen von Dateien anzeigen
        //chooser.showOpenDialog(null);


        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            // Module schreiben in Datei
            ModuleDAO dao = new ModuleDAO(selectedFile.getAbsolutePath(), true); 
            try {
                dao.write(parent.module);
            } catch (IOException r) {
                System.out.println(r.getMessage());
            }
            dao.close();
        }

    }
}
