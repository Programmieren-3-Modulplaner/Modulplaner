package org.example.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.example.Modulplaner;

/**
 * Klasse zum anzeigen/ausblenden des {@link org.example.Info} Panels
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemInfoItemListner implements ItemListener {

    private Modulplaner parent;

    /**
     * Konstruktor zum initialisieren des ItemListener
     * @param p Modulplaner als Parent
     */
    public MenuItemInfoItemListner(Modulplaner p) {
        this.parent = p;
    }

    /**
     * Setzt die isVisible Variable von Parent und aktualisiert die {@link org.example.Info}
     * @param e ItemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
        
        parent.setInfoIsVisible(selected);
        parent.InfoAktualisieren(false, null);
    }
}
