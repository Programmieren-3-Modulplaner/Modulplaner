/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.example.DAO.Modul;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class KurslisteListSelectionListener implements ListSelectionListener {

    private Modulplaner parent;
    private DefaultListModel liste;
    private DefaultListSelectionModel auswahl;

    public KurslisteListSelectionListener(Modulplaner p, DefaultListModel liste, DefaultListSelectionModel auswahl) {
        this.parent = p;
        this.liste = liste;
        this.auswahl = auswahl;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!auswahl.isSelectionEmpty()) {
            Modul m = (Modul) liste.get(auswahl.getAnchorSelectionIndex());
            parent.InfoAktualisieren(true, m);
        }
    }
}
