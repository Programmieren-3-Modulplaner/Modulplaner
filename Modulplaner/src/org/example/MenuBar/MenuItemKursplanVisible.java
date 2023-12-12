/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemKursplanItemListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemKursplanVisible extends JCheckBoxMenuItem{
    MenuItemKursplanVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isKursplanIsVisible());
        this.addItemListener(new MenuItemKursplanItemListner(p));
        setIcon(null);
    }
}