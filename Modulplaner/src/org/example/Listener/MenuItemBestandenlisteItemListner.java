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
public class MenuItemBestandenlisteItemListner implements ItemListener {

    private Modulplaner parent;

    public MenuItemBestandenlisteItemListner(Modulplaner p) {
        this.parent = p;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Bestandenliste anzeigen");
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setBestandenlisteIsVisible(selected);
        parent.BestandenlisteAktualisieren();
    }
}
