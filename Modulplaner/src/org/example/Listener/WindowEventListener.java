/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.Listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import org.example.DAO.ModuleDAO;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class WindowEventListener implements WindowListener{
    
    private org.example.DAO.Module module;
    private String dateiName;
    
    public WindowEventListener(org.example.DAO.Module module, String dateiName) {
        this.module = module;
        this.dateiName = dateiName;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Fenster öfnen");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Module speichern
        ModuleDAO dao = new ModuleDAO(dateiName, true); // Schreiben
        try {
            dao.write(module);
        } catch (IOException r) {
            System.out.println(r.getMessage());
        }
        dao.close();
        System.out.println("Fenster schliessen");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Fenster geschlossen");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Fenster klein");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Fenster groß");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Fenster aktiv");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Fenster nicht aktiv");
    }
}