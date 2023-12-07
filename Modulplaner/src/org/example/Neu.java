/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import org.example.DAO.Modul;
import org.example.Listener.NeuAbrechenButtonActionListener;
import org.example.Listener.NeuSpeichernButtonActionListener;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Neu extends JFrame{

    private Modulplaner parent;
    
    private JPanel allgemeinPanel;
    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    
    private JPanel belegungenPanel;
    private JComboBox[] tag = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JComboBox[] block = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JTextField[] raum = new JTextField[Modul.getAnzahlVeranstaltungen()];

    private JPanel buttonsPanel;
    private JButton speichernButton;
    private JButton abbrechenButton;
    private JRadioButton belegen;
    private JRadioButton nichtBelegen;
    private ButtonGroup radioGroupBelegen;
    
    public Neu(Modulplaner p) {
        this.parent = p;
        //setSize(600, 500);
        //setLayout(new GridLayout(3,1,10,10));
        //setLayout(new BorderLayout(20,20));
        setLocationRelativeTo(null);
        setTitle("Neues Modul anlegen");
        
        //-------------------------------------------------------
        
        allgemeinPanel = new JPanel();
        allgemeinPanel.setBorder(BorderFactory.createTitledBorder("Allgemein: ")); 
        allgemeinPanel.setLayout(new GridLayout(2,3,5,5));
        allgemeinPanel.add(new JLabel("Name:"));
        allgemeinPanel.add(new JLabel("Professor:"));
        allgemeinPanel.add(new JLabel("Note:"));
        modulNameTextfeld = new JTextField();
        profNameTextfeld = new JTextField();
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("#.#");
        } catch (java.text.ParseException exc) {
            System.exit(-1);
        }
        noteTextfeld = new JFormattedTextField(formatter);
        noteTextfeld.setValue(new Double(0.0));
        allgemeinPanel.add(modulNameTextfeld);
        allgemeinPanel.add(profNameTextfeld);
        allgemeinPanel.add(noteTextfeld);

        //-------------------------------------------------------

        String[] tagComboxArray = new String[Modulplaner.tage.values().length+1];
        tagComboxArray[0] = "";
        for (int i = 1; i<tagComboxArray.length; i++){
            tagComboxArray[i] = Modulplaner.tage.values()[i-1].toString();
        }
        String[] blockCombockArray = new String[parent.getAnzahlBloecke()+1];
        blockCombockArray[0] = "";
        for (int i = 1; i<parent.getAnzahlBloecke()+1; i++){
            blockCombockArray[i] = i + ". Block";
        }
        
        belegungenPanel = new JPanel();
        belegungenPanel.setLayout((new GridLayout(Modul.getAnzahlVeranstaltungen()*2, 3, 5, 5)));        
        belegungenPanel.setBorder(BorderFactory.createTitledBorder("Veranstaltungen: ")); 
        for(int i = 0; i<Modul.getAnzahlVeranstaltungen(); i++){
            belegungenPanel.add(new JLabel("Tag:"));
            belegungenPanel.add(new JLabel("Block:"));
            belegungenPanel.add(new JLabel("Raum:"));
            tag[i] = new JComboBox(tagComboxArray);
            block[i] = new JComboBox(blockCombockArray);
            raum[i] = new JTextField();
            belegungenPanel.add(tag[i]);
            belegungenPanel.add(block[i]);
            belegungenPanel.add(raum[i]);
        }
        
        //-------------------------------------------------------
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout((new GridLayout(2, 2, 5, 5)));
        belegen = new JRadioButton("Belegen");
        belegen.setSelected(true);
        nichtBelegen = new JRadioButton("Nicht Belegen");
        nichtBelegen.setSelected(false);
        radioGroupBelegen = new ButtonGroup();
        radioGroupBelegen.add(belegen);
        radioGroupBelegen.add(nichtBelegen);
        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new NeuSpeichernButtonActionListener(parent, this, modulNameTextfeld, profNameTextfeld, noteTextfeld, tag, block, raum, belegen));
        abbrechenButton = new JButton("Abbrechen");
        abbrechenButton.addActionListener(new NeuAbrechenButtonActionListener(parent, this));
        buttonsPanel.add(belegen);
        buttonsPanel.add(speichernButton);
        buttonsPanel.add(nichtBelegen);
        buttonsPanel.add(abbrechenButton);
        
        //-------------------------------------------------------
        
        add(allgemeinPanel, BorderLayout.NORTH);
        add(belegungenPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }
}
