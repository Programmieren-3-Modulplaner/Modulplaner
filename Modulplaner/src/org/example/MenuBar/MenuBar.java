/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuBar;
import org.example.Modulplaner;

/**
 * Klasse für die generierung der JMenuBar's
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuBar extends JMenuBar{

    private Modulplaner parent;
    
    /**
     * Baut die ensprechende JMenuBar anhand des Namens
     * @param name zum alswählen der JMenuBar
     * @param p Modulplaner als Parent
     */
    public MenuBar(String name, Modulplaner p) {
        super();
        this.parent = p;
        
        if (name.equals("Modulplaner")){
            this.add(new Menu(parent.sprache("Datei"), parent));
            this.add(new Menu(parent.sprache("Anzeige"), parent));
            this.add(new Menu(parent.sprache("Hilfe"), parent));
        }
        else if (name.equals("Neu")){
            this.add(new Menu(parent.sprache("Hilfe"), parent));
        }
        else if (name.equals("test")){
            this.add(new Menu("Datei", parent));
            this.add(new Menu("Hilfe", parent));
            this.add(new Menu("Irgendwas", parent));
        }
        else System.out.println("Keine MenuBar Names \"" + name + "\" vorhanden");
    }
}