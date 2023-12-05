/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Listener.MenuItemNewActionListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemNew extends JMenuItem{
    public MenuItemNew (Modulplaner p){
        super();
        this.setText("Neu anders");
        this.addActionListener(new MenuItemNewActionListner(p));
        setIcon(null);
    }
}