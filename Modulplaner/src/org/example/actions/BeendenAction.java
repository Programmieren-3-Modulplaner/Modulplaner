package org.example.actions;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.DAO.ModulManagerDAO;
import org.example.Modulplaner;

/**
 * Klasse für die Action zum Beenden des Programms
 * <p> vor dem Beenden werden alle Module des ModulManagers von Parent gespeichert
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class BeendenAction extends AbstractAction {

    private Modulplaner parent;

    /**
     * Konstruktor zum initialisieren der Action
     * @param p Modulplaner als Parent
     * @param text Anzeigetext
     * @param icon ImageIcon zur Action
     * @param beschreibung Beschreibung der Action
     * @param key Tastatur Key für die Action
     */
    public BeendenAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key) {
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }

    /**
     * Speichert die Module von Parent und Beendet das Programm
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ModulManagerDAO dao = new ModulManagerDAO(parent.getDateiName(), true, parent);
        try {
            dao.write(parent.modulManager);
        } catch (IOException r) {
            System.out.println(r.getMessage());
        }
        dao.close();
        
        System.exit(0);
    }

}
