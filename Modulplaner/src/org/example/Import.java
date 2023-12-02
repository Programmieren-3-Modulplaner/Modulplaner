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
public class Import extends JFrame {
    
    private Modulplaner parent;

    public Import(Modulplaner p) {
        this.parent = p;
        
        //JFileChooser chooser = new JFileChooser();
        // Dialog zum Oeffnen von Dateien anzeigen
        //chooser.showOpenDialog(null);


        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            // Module einlesen aus Datei
            org.example.DAO.Module lesen = new org.example.DAO.Module();
            ModuleDAO daoInitialRead = new ModuleDAO(selectedFile.getAbsolutePath(), false); // Lesen
            try {
                daoInitialRead.read(lesen);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            daoInitialRead.close();
            parent.module = lesen;
            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();

        }

    }
}
