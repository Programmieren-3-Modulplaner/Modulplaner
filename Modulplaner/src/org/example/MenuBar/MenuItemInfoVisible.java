/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemInfoItemListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */

public class MenuItemInfoVisible extends JCheckBoxMenuItem{
    MenuItemInfoVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isInfoIsVisible());
        this.addItemListener(new MenuItemInfoItemListner(p));
        setIcon(null);
    }
}