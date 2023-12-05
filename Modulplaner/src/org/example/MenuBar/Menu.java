/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.MenuBar;

import javax.swing.JMenu;
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
            this.add(new MenuItem("Neu", parent));
            //this.add(new MenuItem("Neu2", parent));
            this.add(new MenuItem("Import", parent));
            this.add(new MenuItem("Export", parent));
            this.add(new MenuItem("Beenden", parent));
            //this.add(new Menu("Hilfe"));
        } else if (name.equals("Hilfe")) {
            this.add(new MenuItem("Hilfe", parent));
            this.add(new MenuItem("About", parent));
        } else {
            System.out.println("Kein Menu Names \"" + name + "\" vorhanden");
        }
    }
}
