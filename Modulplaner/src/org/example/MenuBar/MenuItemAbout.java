/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import org.example.Listener.MenuItemAboutActionListener;
import javax.swing.JMenuItem;
import org.example.Listener.MenuItemBeendenActionListener;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemAbout extends JMenuItem{

    public MenuItemAbout() {
        super("About");
        this.addActionListener(new MenuItemAboutActionListener());
        
    }
}