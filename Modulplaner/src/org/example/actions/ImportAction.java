package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Import;
import org.example.Modulplaner;

/**
 * Klasse für die Action zum aufrufen der Import Funktion
 * <p> Siehe: {@link org.example.Import}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class ImportAction extends AbstractAction{

    private Modulplaner parent;
    
    /**
     * Konstruktor zum initialisieren der Action
     * @param p Modulplaner als Parent
     * @param text Anzeigetext
     * @param icon ImageIcon zur Action
     * @param beschreibung Beschreibung der Action
     * @param key Tastatur Key für die Action
     */
    public ImportAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key){
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }
    
    /**
     * Erzeugt ein neues Objekt der Klasse {@link org.example.Import}
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       new Import(parent);
    }
    
}