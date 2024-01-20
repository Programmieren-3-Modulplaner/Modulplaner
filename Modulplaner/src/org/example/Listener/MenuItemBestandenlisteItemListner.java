/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.example.Modulplaner;

/**
 * Klasse zum anzeigen/ausblenden des {@link org.example.Bestandenliste} Panels
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemBestandenlisteItemListner implements ItemListener {

    private Modulplaner parent;

    /**
     * Konstruktor zum initialisieren des ItemListener
     * @param p Modulplaner als Parent
     */
    public MenuItemBestandenlisteItemListner(Modulplaner p) {
        this.parent = p;
    }

    /**
     * Setzt die isVisible Variable von Parent und aktualisiert die {@link org.example.Bestandenliste}
     * @param e ItemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setBestandenlisteIsVisible(selected);
        parent.BestandenlisteAktualisieren();
    }
}
