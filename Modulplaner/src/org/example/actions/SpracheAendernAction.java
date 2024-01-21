package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Modulplaner;
import org.example.SpracheAendern;

/**
 * Klasse für die Action zum aufrufen der Funktion zum ändern der Sprache
 * <p> Siehe: {@link org.example.SpracheAendern}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class SpracheAendernAction extends AbstractAction{

    private Modulplaner parent;
    
    /**
     * Konstruktor zum initialisieren der Action
     * @param p Modulplaner als Parent
     * @param text Anzeigetext
     * @param icon ImageIcon zur Action
     * @param beschreibung Beschreibung der Action
     * @param key Tastatur Key für die Action
     */
    public SpracheAendernAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key){
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }
    
    /**
     * Erzeugt ein neues Objekt der Klasse {@link org.example.SpracheAendern}
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       new SpracheAendern(parent);
    }
    
}