/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.example.Modulplaner;

/**
 * Klasse zum anzeigen/ausblenden des {@link org.example.Kursplan} Panels
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemKursplanItemListner implements ItemListener {

    private Modulplaner parent;

    /**
     * Konstruktor zum initialisieren des ItemListener
     * @param p Modulplaner als Parent
     */
    public MenuItemKursplanItemListner(Modulplaner p) {
        this.parent = p;
    }

    /**
     * Setzt die isVisible Variable von Parent und aktualisiert den {@link org.example.Kursplan}
     * @param e ItemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setKursplanIsVisible(selected);
        parent.KursplanAktualisieren();
    }
}
