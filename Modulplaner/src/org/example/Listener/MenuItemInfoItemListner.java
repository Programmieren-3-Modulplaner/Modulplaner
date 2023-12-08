/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class MenuItemInfoItemListner implements ItemListener {

    private Modulplaner parent;

    public MenuItemInfoItemListner(Modulplaner p) {
        this.parent = p;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Info anzeigen");
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setInfoIsVisible(selected);
        parent.InfoAktualisieren(false, null);
    }
}
