/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.io.File;
import javax.swing.JFileChooser;
import org.example.DAO.ModulManagerCSV;

/**
 * Klasse für das Exportieren der Modulliste als .csv vom ModulManager von Parent
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class ExportCSV{
    
    private Modulplaner parent;

    /**
     * Öffnet einen JFileChooser und speichert die Module mit dem {@link org.example.DAO.ModulManagerCSV}
     * @param p Modulplaner als Parent
     */
    public ExportCSV(Modulplaner p) {
        this.parent = p;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            new ModulManagerCSV(parent, parent.modulManager, selectedFile.getAbsolutePath());
        }

    }
}
