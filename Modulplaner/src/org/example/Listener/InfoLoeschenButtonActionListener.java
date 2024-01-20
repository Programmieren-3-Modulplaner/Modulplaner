/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.DAO.Modul;
import org.example.Modulplaner;

/**
 * Klasse zum Löschen von Modulen der {@link org.example.Info}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class InfoLoeschenButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private Modul oldModul;
    
    /**
     * Konstruktor zum initialisieren des ActionListener
     * @param p Modulplaner als Parent
     * @param oM Das zu löschende Modul
     */
    public InfoLoeschenButtonActionListener(Modulplaner p, Modul oM) {
        this.parent = p;
        this.oldModul = oM;
    }

    /**
     * Löscht das entsprechende Modul aus dem {@link org.example.DAO.ModulManager} von Parent
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
            
            int index = parent.modulManager.getIndexByName(oldModul.getModulName());
            parent.modulManager.remove(index);

            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();
            parent.InfoAktualisieren(false, null);
            parent.BestandenlisteAktualisieren();
    }
}