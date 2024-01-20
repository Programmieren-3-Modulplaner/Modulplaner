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
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class KurslisteListSelectionListener implements ListSelectionListener {

    private Modulplaner parent;
    private DefaultListModel liste;
    private DefaultListSelectionModel auswahl;

    public KurslisteListSelectionListener(Modulplaner p, DefaultListModel l, DefaultListSelectionModel a) {
        this.parent = p;
        this.liste = l;
        this.auswahl = a;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!auswahl.isSelectionEmpty()) {
            Modul m = (Modul) liste.get(auswahl.getAnchorSelectionIndex());
            parent.InfoAktualisieren(true, m);
        }
    }
}
