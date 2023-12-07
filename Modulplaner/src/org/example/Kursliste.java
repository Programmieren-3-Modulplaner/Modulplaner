/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import org.example.Listener.KurslisteListSelectionListener;
import org.example.actions.KurslisteModulSuchAction;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Kursliste extends JPanel {
    
    private Modulplaner parent;
    
    private Action kurslisteModulSuchAction;
    private DefaultListModel suchErgebnisListModel = new DefaultListModel();
    private DefaultListSelectionModel suchErgebnisAuswahlModel = new DefaultListSelectionModel();
    private Document suchEingabe = new PlainDocument();
    
    public Kursliste(Modulplaner p) {
        this.parent = p;

        setLayout(new BorderLayout());

        kurslisteModulSuchAction = new KurslisteModulSuchAction(suchEingabe, suchErgebnisListModel, parent.module);
        kurslisteModulSuchAction.actionPerformed(null);
        
        // Such Eingabe Panel erstellen
        JPanel suchEingabePanel = new JPanel();
        suchEingabePanel.setLayout(new BorderLayout());
        
        JTextField suchFeld = new JTextField(suchEingabe, null, 0);
        suchEingabePanel.add(suchFeld, BorderLayout.CENTER);
        suchFeld.addActionListener(kurslisteModulSuchAction);
        
        JButton suchButton = new JButton(kurslisteModulSuchAction);
        suchButton.setFocusPainted(false);
        suchEingabePanel.add(suchButton, BorderLayout.EAST);
        
        // Such ergebnis Liste erstellen
        JList suchAusgabeListe = new JList();
        suchAusgabeListe.setModel(suchErgebnisListModel);
        suchErgebnisAuswahlModel.setSelectionMode(SINGLE_SELECTION);
        suchErgebnisAuswahlModel.addListSelectionListener(new KurslisteListSelectionListener(parent, suchErgebnisListModel, suchErgebnisAuswahlModel));
        suchAusgabeListe.setSelectionModel(suchErgebnisAuswahlModel);
        
        // Such ergebnis Anzeige erstellen
        JPanel suchAusgabePanel = new JPanel();
        suchAusgabePanel.setLayout(new BorderLayout());
        JScrollPane suchAusgabeSrollListe = new JScrollPane(suchAusgabeListe);
        suchAusgabePanel.add(suchAusgabeSrollListe, BorderLayout.CENTER);

        add(suchAusgabePanel, BorderLayout.CENTER);
        add(suchEingabePanel, BorderLayout.NORTH);

    }

}
