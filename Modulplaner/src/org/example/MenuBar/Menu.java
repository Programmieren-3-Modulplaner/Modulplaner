/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.MenuBar;

import javax.swing.JMenu;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Menu extends JMenu {

    Menu(String name) {
        super(name);
        if (name.equals("Datei")) {
            this.add(new MenuItemNeu());
            this.add(new MenuItemImport());
            this.add(new MenuItemExport());
            this.add(new MenuItemBeenden());
        }
        if (name.equals("Hilfe")) {
            this.add(new MenuItemHilfedialog());
            this.add(new MenuItemAbout());
        }
    }
}
