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
public class MenuItemKursplanItemListner implements ItemListener {

    private Modulplaner parent;

    public MenuItemKursplanItemListner(Modulplaner p) {
        this.parent = p;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Kursplan anzeigen");
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setKursplanIsVisible(selected);
        parent.KursplanAktualisieren();
    }
}
