/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import org.example.Listener.MenuItemNewActionListner;
import javax.swing.JMenuItem;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemNeu extends JMenuItem {

    public MenuItemNeu() {
        super("Neu");
        this.addActionListener(new MenuItemNewActionListner());
    }
}