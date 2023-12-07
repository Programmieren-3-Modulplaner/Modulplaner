/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.DAO.Modul;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class InfoLoeschenButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private Modul oldModul;
    
    public InfoLoeschenButtonActionListener(Modulplaner p, Modul oldModul) {
        this.parent = p;
        this.oldModul = oldModul;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Löschen Info");
            
            int index = parent.module.getIndexByName(this.oldModul.getModulName());
            parent.module.remove(index);

            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();
            parent.InfoAktualisieren(false, null);
    }
}
