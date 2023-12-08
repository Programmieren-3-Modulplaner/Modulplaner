/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuBar;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuBar extends JMenuBar{

    private Modulplaner parent;
    
    public MenuBar(String name, Modulplaner p) {
        super();
        this.parent = p;
        
        if (name.equals("Modulplaner")){
            this.add(new Menu("Datei", parent));
            this.add(new Menu("Anzeige", parent));
            this.add(new Menu("Hilfe", parent));
        }
        else if (name.equals("Neu")){
            this.add(new Menu("Hilfe", parent));
        }
        else if (name.equals("test")){
            this.add(new Menu("Datei", parent));
            this.add(new Menu("Hilfe", parent));
            this.add(new Menu("Irgendwas", parent));
        }
        else System.out.println("Keine MenuBar Names \"" + name + "\" vorhanden");
    }
}