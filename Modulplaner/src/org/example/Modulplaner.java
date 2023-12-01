/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.example.DAO.ModuleDAO;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Modulplaner extends JFrame {

    /**
     * @param args the command line arguments
     */
    //public static Modulplaner app;
    //private ArrayList<Modul> module = new ArrayList();
    //public org.example.DAO.Module module;

    public Modulplaner() {
        
        String dateiName = "src/org/example/DAO/module.dat";
        org.example.DAO.Module module = new org.example.DAO.Module();
        
        // Module Initial einlesen aus Datei
        ModuleDAO daoInitialRead = new ModuleDAO(dateiName, false); // Lesen
        try {
            daoInitialRead.read(module);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        daoInitialRead.close();
        
        //Initial Window Config's
        setTitle("Planer");
        addWindowListener(new WindowEventListener(module, dateiName));
        setSize(500, 300);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("Modulplaner"));

        setLayout(new BorderLayout());
        
        setVisible(true);
    }

    public static void main(String[] args) {

        /*
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }*/
        //Modulplaner app = new Modulplaner();
        new Modulplaner();

        //new About();
    }
}
