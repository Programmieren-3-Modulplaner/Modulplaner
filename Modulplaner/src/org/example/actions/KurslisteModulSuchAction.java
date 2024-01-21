package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.example.DAO.Modul;
import org.example.DAO.ModulManager;

/**
 * Klasse für die Action zum zum Filtern von Modulen der Kursliste
 * <p> Siehe: {@link org.example.Kursliste}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class KurslisteModulSuchAction extends AbstractAction{

    private Document suchEingabe;
    private DefaultListModel suchErgebnis;
    private ModulManager modulManager;
    
    /**
     * Konstruktor zum initialisieren der Action
     * @param sEi Such Eingabe
     * @param sEr Such Ergebnis
     * @param m ModulManager
     */
    public KurslisteModulSuchAction(Document sEi, DefaultListModel sEr, ModulManager m){
        this.suchEingabe = sEi;
        this.suchErgebnis = sEr;
        this.modulManager = m;
    }
    
    /**
     * Aktualisiert das Such Ergebnis Model anhand der Such Eingabe
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       try {
            ModulManager gefundeneModule = modulManager.suchModule(suchEingabe.getText(0, suchEingabe.getLength()));
            
            suchErgebnis.clear();
            for (Modul m : gefundeneModule) {
                Object elementModel = m;
                suchErgebnis.addElement(elementModel);
            }
        } catch (BadLocationException ex) {
            System.err.println("BadLocationException: " + ex.getMessage());
        }
    }
    
}