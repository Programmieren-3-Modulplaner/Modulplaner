/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.example.Modulplaner;

/**
 * Klasse zum anzeigen/ausblenden des {@link org.example.Kursliste} Panels
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemKurslisteItemListner implements ItemListener {

    private Modulplaner parent;

    /**
     * Konstruktor zum initialisieren des ItemListener
     * @param p Modulplaner als Parent
     */
    public MenuItemKurslisteItemListner(Modulplaner p) {
        this.parent = p;
    }

    /**
     * Setzt die isVisible Variable von Parent und aktualisiert die {@link org.example.Kursliste}
     * @param e ItemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Kursliste anzeigen");
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setKurslisteIsVisible(selected);
        parent.KurslisteAktualisieren();
    }
}
