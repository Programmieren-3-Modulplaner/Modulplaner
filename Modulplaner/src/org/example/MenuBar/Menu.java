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
            this.add(new MenuItemOpen());
            this.addSeparator();
            this.add(new MenuItemClose());
        }
        if (name.equals("Dokumentation")){
            this.add(new MenuItemDokumetnation());
        }
    }
}
