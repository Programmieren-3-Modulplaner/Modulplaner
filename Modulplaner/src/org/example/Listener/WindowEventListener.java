/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import org.example.DAO.ModulManagerDAO;
import org.example.Modulplaner;

/**
 * Klasse für den WindowListener von {@link org.example.Modulplaner}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class WindowEventListener implements WindowListener {

    private Modulplaner parent;

    /**
     * Konsruktor zum initialisieren des WindowListener
     * @param p Modulplaner als Parent
     */
    public WindowEventListener(Modulplaner p) {
        this.parent = p;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    /**
     * Speichert die aktuellen {@link org.example.DAO.Modul}e des {@link org.example.DAO.ModulManager} von Parent und schließt das Programm
     * @param e WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent e) {
        ModulManagerDAO dao = new ModulManagerDAO(parent.getDateiName(), true, parent);
        try {
            dao.write(parent.modulManager);
        } catch (IOException r) {
            System.out.println(r.getMessage());
        }
        dao.close();
        
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}