/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemInfoItemListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemInfoVisible extends JCheckBoxMenuItem{
    MenuItemInfoVisible (Modulplaner p){
        super();
        this.setText("Toggle Info");
        this.setSelected(p.isInfoIsVisible());
        this.addItemListener(new MenuItemInfoItemListner(p));
        setIcon(null);
    }
}