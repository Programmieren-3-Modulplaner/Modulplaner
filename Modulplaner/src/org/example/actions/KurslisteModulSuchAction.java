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

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class KurslisteModulSuchAction extends AbstractAction{

    private Document suchEingabe;
    private DefaultListModel suchErgebnis;
    private org.example.DAO.Module module;
    
    public KurslisteModulSuchAction(Document suchEingabe, DefaultListModel suchErgebnis, org.example.DAO.Module module){
        super("Suche");
        this.suchEingabe = suchEingabe;
        this.suchErgebnis = suchErgebnis;
        this.module = module;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       try {
            org.example.DAO.Module gefundeneModule = module.suchModule(suchEingabe.getText(0, suchEingabe.getLength()));
            
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