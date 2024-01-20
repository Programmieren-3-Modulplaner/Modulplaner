/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Collections;
import javax.swing.Action;
import javax.swing.BorderFactory;
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
import org.example.DAO.ModulComparator;
import org.example.Listener.KurslisteListSelectionListener;
import org.example.actions.KurslisteModulSuchAction;

/**
 * Klasse für die Liste aller Kurse mit Suchfunktion
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Kursliste extends JPanel {
    
    private Modulplaner parent;
    
    private Action kurslisteModulSuchAction;
    private DefaultListModel suchErgebnisListModel = new DefaultListModel();
    private DefaultListSelectionModel suchErgebnisAuswahlModel = new DefaultListSelectionModel();
    private Document suchEingabe = new PlainDocument();
    
    /**
     * Baut das JPanel fur die Kursliste mit der Suchfuktion {@link org.example.actions.KurslisteModulSuchAction}
     * <p> Es wird der ModulManager von Parent übernommen
     * <p> Listener: {@link org.example.Listener.KurslisteListSelectionListener}
     * @param p Modulplaner als Parent 
     */
    public Kursliste(Modulplaner p) {
        this.parent = p;

        setBorder(BorderFactory.createTitledBorder(parent.sprache("Kursliste")+": "));
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(200, 0));
        
        Collections.sort(parent.modulManager, new ModulComparator());
        
        kurslisteModulSuchAction = new KurslisteModulSuchAction(suchEingabe, suchErgebnisListModel, parent.modulManager);
        kurslisteModulSuchAction.actionPerformed(null);
        

        JPanel suchEingabePanel = new JPanel();
        suchEingabePanel.setLayout(new BorderLayout());
        
        JTextField suchFeld = new JTextField(suchEingabe, null, 0);
        suchEingabePanel.add(suchFeld, BorderLayout.CENTER);
        suchFeld.addActionListener(kurslisteModulSuchAction);
        
        JButton suchButton = new JButton(kurslisteModulSuchAction);
        suchButton.setText(parent.sprache("Suchen"));
        suchButton.setFocusPainted(false);
        suchEingabePanel.add(suchButton, BorderLayout.EAST);
        

        JList suchAusgabeListe = new JList();
        suchAusgabeListe.setModel(suchErgebnisListModel);
        suchErgebnisAuswahlModel.setSelectionMode(SINGLE_SELECTION);
        suchErgebnisAuswahlModel.addListSelectionListener(new KurslisteListSelectionListener(parent, suchErgebnisListModel, suchErgebnisAuswahlModel));
        suchAusgabeListe.setSelectionModel(suchErgebnisAuswahlModel);
        

        JPanel suchAusgabePanel = new JPanel();
        suchAusgabePanel.setLayout(new BorderLayout());
        JScrollPane suchAusgabeSrollListe = new JScrollPane(suchAusgabeListe);
        suchAusgabePanel.add(suchAusgabeSrollListe, BorderLayout.CENTER);

        add(suchAusgabePanel, BorderLayout.CENTER);
        add(suchEingabePanel, BorderLayout.NORTH);

    }

}
