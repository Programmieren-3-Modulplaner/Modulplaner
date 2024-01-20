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
 * Klasse zum aufrufen der {@link org.example.Info} mit dem ausgewählten {@link org.example.DAO.Modul} der {@link org.example.Kursliste}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class KurslisteListSelectionListener implements ListSelectionListener {

    private Modulplaner parent;
    private DefaultListModel liste;
    private DefaultListSelectionModel auswahl;

    /**
     * Konstruktor zum initialisieren des ListSelectionListener
     * @param p Modulplaner als Parent
     * @param l DefaultListModel als Liste
     * @param a DefaultListSelectionModel als Auswahl
     */
    public KurslisteListSelectionListener(Modulplaner p, DefaultListModel l, DefaultListSelectionModel a) {
        this.parent = p;
        this.liste = l;
        this.auswahl = a;
    }

    /**
     * Aktualisiert die {@link org.example.Info} mit dem ausgewählten {@link org.example.DAO.Modul}
     * @param e ListSelectionEvent
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!auswahl.isSelectionEmpty()) {
            Modul m = (Modul) liste.get(auswahl.getAnchorSelectionIndex());
            parent.InfoAktualisieren(true, m);
        }
    }
}
