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
            this.add(new MenuItem("Neu"));
            this.add(new MenuItem("Import"));
            this.add(new MenuItem("Export"));
            this.add(new MenuItem("Beenden"));
            //this.add(new Menu("Hilfe"));
        } else if (name.equals("Hilfe")) {
            this.add(new MenuItem("Hilfe"));
            this.add(new MenuItem("About"));
        } else {
            System.out.println("Keine Menu Names \"" + name + "\" vorhanden");
        }
    }
}
