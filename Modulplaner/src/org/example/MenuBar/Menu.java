/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.MenuBar;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Menu extends JMenu {

    private Modulplaner parent;

    Menu(String name, Modulplaner p) {
        super(name);
        this.parent = p;

        if (name.equals("Datei")) {
            this.add(new MenuItemNeu(parent));
            this.add(new MenuItemImport(parent));
            this.add(new MenuItemExport(parent));
            this.add(new MenuItemBeenden(parent));
            this.add(new MenuItemNew(parent));
        } else if (name.equals("Hilfe")) {
            this.add(new MenuItemHilfe(parent));
            this.add(new MenuItemAbout(parent));
        } else {
            System.out.println("Kein Menu Names \"" + name + "\" vorhanden");
        }
    }
}
