/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuBar extends JMenuBar{

    public MenuBar(String name) {
        super();
        if (name.equals("Modulplaner")){
            this.add(new Menu("Datei"));
            this.add(new Menu("Ansicht"));
            this.add(new Menu("Hilfe"));
        }
        else if (name.equals("About")){
            this.add(new Menu("Hilfe"));
        }
        else if (name.equals("test")){
            this.add(new Menu("Datei"));
            this.add(new Menu("Hilfe"));
            this.add(new Menu("Irgendwas"));
        }
        else System.out.println("Keine MenuBar Names \"" + name + "\" vorhanden");
    }
}