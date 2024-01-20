/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.example.DAO.ModulManager;
import org.example.DAO.ModulManagerDAO;

/**
 * Klasse für das Importieren (überschreiben) der Modulliste in den {@link org.example.DAO.ModulManager} von Parent als .dat
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Import {
    
    private Modulplaner parent;

    /**
     * Öffnet einen JFileChooser und liest die Module mit dem {@link org.example.DAO.ModulManagerDAO} in den 
     * {@link org.example.DAO.ModulManager} von Parent ein
     * @param p Modulplaner als Parent
     */
    public Import(Modulplaner p) {
        this.parent = p;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            ModulManager lesen = new ModulManager();
            ModulManagerDAO daoInitialRead = new ModulManagerDAO(selectedFile.getAbsolutePath(), false, parent);
            try {
                daoInitialRead.read(lesen);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            daoInitialRead.close();
            parent.modulManager = lesen;
            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();
            parent.InfoAktualisieren(false, null);
            parent.BestandenlisteAktualisieren();

        }

    }
}