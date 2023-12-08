/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemKurslisteItemListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemKurslisteVisible extends JCheckBoxMenuItem{
    MenuItemKurslisteVisible (Modulplaner p){
        super();
        this.setText("Toggle Kursliste");
        this.setSelected(p.isKurslisteIsVisible());
        this.addItemListener(new MenuItemKurslisteItemListner(p));
        setIcon(null);
    }
}