/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import org.example.Listener.MenuItemClosActionListener;
import javax.swing.JMenuItem;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemClose extends JMenuItem {

    public MenuItemClose() {
        super("Beenden");
        this.addActionListener(new MenuItemClosActionListener());
    }
}