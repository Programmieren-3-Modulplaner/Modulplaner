/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.MenuBar;

import org.example.Listener.MenuItemExportActionListener;
import javax.swing.JMenuItem;
import org.example.Listener.MenuItemAboutActionListener;
import org.example.Listener.MenuItemBeendenActionListener;
import org.example.Listener.MenuItemImportActionListener;
import org.example.Listener.MenuItemNewActionListner;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class MenuItem extends JMenuItem {

    private Modulplaner parent;

    MenuItem(String name, Modulplaner p) {
        super(name);
        this.parent = p;

        if (name.equals("About")) {
            this.addActionListener(new MenuItemAboutActionListener(parent));
        } else if (name.equals("Beenden")) {
            this.addActionListener(new MenuItemBeendenActionListener(parent));
        } else if (name.equals("Export")) {
            this.addActionListener(new MenuItemExportActionListener(parent));
        } else if (name.equals("Import")) {
            this.addActionListener(new MenuItemImportActionListener(parent));
        } else if (name.equals("Hilfe")) {
        } else if (name.equals("Neu")) {
            this.addActionListener(parent.menuItemNewAction);
        } else if (name.equals("Neu2")) {
            this.addActionListener(new MenuItemNewActionListner(parent));
        } else {
            System.out.println("Kein MenuItem Names \"" + name + "\" vorhanden");
        }
    }
}
