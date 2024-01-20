/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.example.DAO.Modul;
import org.example.DAO.ModulManager;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */

public class KurslisteModulSuchAction extends AbstractAction{

    private Document suchEingabe;
    private DefaultListModel suchErgebnis;
    private ModulManager modulManager;
    
    public KurslisteModulSuchAction(Document sEi, DefaultListModel sEr, ModulManager m){
        
        //super("Suche");
        this.suchEingabe = sEi;
        this.suchErgebnis = sEr;
        this.modulManager = m;
    }
    
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