/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import org.example.Listener.MenuItemBeendenActionListener;
import javax.swing.JMenuItem;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemBeenden extends JMenuItem {

    public MenuItemBeenden() {
        super("Beenden");
        this.addActionListener(new MenuItemBeendenActionListener());
    }
}