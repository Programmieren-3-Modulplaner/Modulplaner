/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.MenuBar;

import javax.swing.JMenu;
import org.example.Modulplaner;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Menu extends JMenu {

    private Modulplaner parent;

    Menu(String name, Modulplaner p) {
        super(name);
        this.parent = p;

        if (name.equals(parent.sprache("Datei"))) {
            this.add(new MenuItemNeu(parent));
            this.add(new MenuItemImport(parent));
            this.add(new MenuItemExport(parent));
            this.add(new MenuItemExportCSV(parent));
            this.add(new MenuItemBeenden(parent));
        } else if (name.equals(parent.sprache("Hilfe"))) {
            this.add(new MenuItemHilfe(parent));
            this.add(new MenuItemAbout(parent));
            this.add(new MenuItemSpracheAendern(parent));
        } else if (name.equals(parent.sprache("Anzeige"))) {
            this.add(new MenuItemKursplanVisible(parent,parent.sprache("ToggleKP")));
            this.add(new MenuItemKurslisteVisible(parent, parent.sprache("ToggleKL")));
            this.add(new MenuItemInfoVisible(parent,parent.sprache("ToggleI")));
            this.add(new MenuItemBestandenlisteVisible(parent, parent.sprache("ToggleB")));
        } else {
            System.out.println("Kein Menu Names \"" + name + "\" vorhanden");
        }
    }
}