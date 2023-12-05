/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.example.DAO.ModuleDAO;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Import extends JFrame {
    
    private Modulplaner parent;

    public Import(Modulplaner p) {
        this.parent = p;

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
