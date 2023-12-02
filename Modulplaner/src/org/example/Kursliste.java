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
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import org.example.actions.ModulSuchAction;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Kursliste extends JPanel {
    
    private Modulplaner parent;
    
    Action modulSuchAction;
    DefaultListModel suchErgebnisListModel = new DefaultListModel();
    DefaultListSelectionModel suchErgebnisAuswahlModel = new DefaultListSelectionModel();
    Document suchEingabe = new PlainDocument();
    
    public Kursliste(Modulplaner p) {
        this.parent = p;

        setLayout(new BorderLayout());

        modulSuchAction = new ModulSuchAction(suchEingabe, suchErgebnisListModel, parent.module);
        modulSuchAction.actionPerformed(null);
        
        // Such Eingabe Panel erstellen
        JPanel suchEingabePanel = new JPanel();
        suchEingabePanel.setLayout(new BorderLayout());
        
        JTextField suchFeld = new JTextField(suchEingabe, null, 0);
        suchEingabePanel.add(suchFeld, BorderLayout.CENTER);
        suchFeld.addActionListener(modulSuchAction);
        
        JButton suchButton = new JButton(modulSuchAction);
        suchButton.setFocusPainted(false);
        suchEingabePanel.add(suchButton, BorderLayout.EAST);
        
        // Such ergebnis Liste erstellen
        JList suchAusgabeListe = new JList();
        suchAusgabeListe.setModel(suchErgebnisListModel);
        suchAusgabeListe.setSelectionModel(suchErgebnisAuswahlModel);
        
        // Such ergebnis Anzeige erstellen
        JPanel suchAusgabe = new JPanel();
        suchAusgabe.setLayout(new BorderLayout());
        JScrollPane suchAusgabeSrollListe = new JScrollPane(suchAusgabeListe);
        suchAusgabe.add(suchAusgabeSrollListe, BorderLayout.CENTER);

        add(suchAusgabe, BorderLayout.CENTER);
        add(suchEingabePanel, BorderLayout.NORTH);

    }

}
