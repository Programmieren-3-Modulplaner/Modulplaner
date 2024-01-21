package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Hilfe;
import org.example.Modulplaner;

/**
 * Klasse für die Action zum aufrufen der Hilfe Funktion
 * <p> Siehe: {@link org.example.Hilfe}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class HilfeAction extends AbstractAction {

    private Modulplaner parent;

    /**
     * Konstruktor zum initialisieren der Action
     * @param p Modulplaner als Parent
     * @param text Anzeigetext
     * @param icon ImageIcon zur Action
     * @param beschreibung Beschreibung der Action
     * @param key Tastatur Key für die Action
     */
    public HilfeAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key) {
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }

    /**
     * Erzeugt ein neues Objekt der Klasse {@link org.example.Hilfe}
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new Hilfe(parent);
    }

}