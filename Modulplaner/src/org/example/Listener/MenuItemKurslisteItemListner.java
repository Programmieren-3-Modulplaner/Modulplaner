/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.example.Modulplaner;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemKurslisteItemListner implements ItemListener {

    private Modulplaner parent;

    public MenuItemKurslisteItemListner(Modulplaner p) {
        this.parent = p;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Kursliste anzeigen");
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setKurslisteIsVisible(selected);
        parent.KurslisteAktualisieren();
    }
}
