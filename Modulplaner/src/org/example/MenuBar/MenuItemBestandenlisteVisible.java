/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemBestandenlisteItemListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemBestandenlisteVisible extends JCheckBoxMenuItem{
    MenuItemBestandenlisteVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isBestandenlisteIsVisible());
        this.addItemListener(new MenuItemBestandenlisteItemListner(p));
        setIcon(null);
    }
}