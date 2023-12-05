/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Listener.MenuItemAboutActionListener;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemAbout extends JMenuItem{
    public MenuItemAbout (Modulplaner p){
        super();
        this.setText("About");
        this.addActionListener(new MenuItemAboutActionListener(p));
        setIcon(null);
    }
}