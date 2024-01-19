/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.example.DAO.ModulManagerCSV;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class ExportCSV extends JFrame {
    
    private Modulplaner parent;

    public ExportCSV(Modulplaner p) {
        this.parent = p;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            new ModulManagerCSV(parent, parent.modulManager, selectedFile.getAbsolutePath());
        }

    }
}
