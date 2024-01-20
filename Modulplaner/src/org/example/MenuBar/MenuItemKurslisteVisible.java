/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemKurslisteItemListner;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem zum anzeigen/ausblenden der Kursliste
 * <p>Siehe: {@link org.example.Kursliste}
 * <p>Listener: {@link org.example.Listener.MenuItemKurslisteItemListner}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemKurslisteVisible extends JCheckBoxMenuItem{
    MenuItemKurslisteVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isKurslisteIsVisible());
        this.addItemListener(new MenuItemKurslisteItemListner(p));
        setIcon(null);
    }
}