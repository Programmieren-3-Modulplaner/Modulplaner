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
        if (name.equals("main")){
            this.add(new Menu("Datei"));
            this.add(new Menu("Dokumentation"));
            this.add(new Menu("Irgendwas"));
        }
        if (name.equals("test")){
            this.add(new Menu("Dokumentation"));
            this.add(new Menu("Datei"));
        }
        //this.add(new FileMenu());
        //this.add(new DokuMenu());
    }

}