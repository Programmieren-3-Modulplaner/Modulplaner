/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import org.example.DAO.Modul;
import org.example.Listener.InfoLoeschenButtonActionListener;
import org.example.Listener.InfoSpeichernButtonActionListener;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class Info extends JPanel{
    private Modulplaner parent;
    private boolean isEnable;
    private Modul modul;
    
    private JPanel allgemeinPanel;
    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    
    private JPanel belegungenPanel;
    private JComboBox[] tag = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JComboBox[] block = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JTextField[] raum = new JTextField[Modul.getAnzahlVeranstaltungen()];

    private JButton speichernButton;
    private JButton loeschenButton;
    private JRadioButton belegen;
    private JRadioButton nichtBelegen;
    private ButtonGroup radioGroupBelegen;
    
    public Info(Modulplaner p, boolean iE, Modul m) {
        this.parent = p;
        this.isEnable = iE;
        this.modul = m;
        
        setBorder(BorderFactory.createTitledBorder("Info: "));
        setLayout(new BorderLayout(10, 10));
        
        //-------------------------------------------------------
        
        allgemeinPanel = new JPanel();
        allgemeinPanel.setBorder(BorderFactory.createTitledBorder("Allgemein: ")); 
        allgemeinPanel.setLayout(new GridLayout(5,2,5,5));
        modulNameTextfeld = new JTextField();
        profNameTextfeld = new JTextField();
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("#.#");
        } catch (java.text.ParseException exc) {
            System.exit(-1);
        }
        noteTextfeld = new JFormattedTextField(formatter);
        noteTextfeld.setValue(0.0);
        modulNameTextfeld.setEnabled(false);
        profNameTextfeld.setEnabled(false);
        noteTextfeld.setEnabled(false);
        
        belegen = new JRadioButton("Belegen");
        belegen.setSelected(false);
        belegen.setEnabled(false);
        nichtBelegen = new JRadioButton("Nicht Belegen");
        nichtBelegen.setSelected(false);
        nichtBelegen.setEnabled(false);
        radioGroupBelegen = new ButtonGroup();
        radioGroupBelegen.add(belegen);
        radioGroupBelegen.add(nichtBelegen);
        
        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new InfoSpeichernButtonActionListener(parent, modul, modulNameTextfeld, profNameTextfeld, noteTextfeld, tag, block, raum, belegen));
        speichernButton.setEnabled(false);
        loeschenButton = new JButton("Löschen");
        loeschenButton.addActionListener(new InfoLoeschenButtonActionListener(parent, modul));
        loeschenButton.setEnabled(false);
        
        allgemeinPanel.add(new JLabel("Name:"));
        allgemeinPanel.add(modulNameTextfeld);
        allgemeinPanel.add(new JLabel("Professor:"));
        allgemeinPanel.add(profNameTextfeld);
        allgemeinPanel.add(new JLabel("Note:"));
        allgemeinPanel.add(noteTextfeld);
        allgemeinPanel.add(belegen);
        allgemeinPanel.add(nichtBelegen);
        allgemeinPanel.add(speichernButton);
        allgemeinPanel.add(loeschenButton);

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
            tag[i].setEnabled(false);
            block[i].setEnabled(false);
            raum[i].setEnabled(false);
            belegungenPanel.add(tag[i]);
            belegungenPanel.add(block[i]);
            belegungenPanel.add(raum[i]);
        }
        
        //-------------------------------------------------------
        
        allgemeinPanel.setPreferredSize(new Dimension(260, 0));
        add(allgemeinPanel, BorderLayout.WEST);
        add(belegungenPanel, BorderLayout.CENTER);
        
        //-------------------------------------------------------
        
        if(this.isEnable && modul != null){
            modulNameTextfeld.setText(this.modul.getModulName());
            profNameTextfeld.setText(this.modul.getProfName());
            noteTextfeld.setText(this.modul.getNoteString());
            for(int i = 0; i<Modul.getAnzahlVeranstaltungen(); i++){
                tag[i].setSelectedIndex(this.modul.getTag(i));
                block[i].setSelectedIndex(this.modul.getBlock(i));
                raum[i].setText(this.modul.getRaum(i));
            }
            if(this.modul.isBelegt()){
                belegen.setSelected(true);
            } else {
                nichtBelegen.setSelected(true);
            }
            modulNameTextfeld.setEnabled(true);
            profNameTextfeld.setEnabled(true);
            noteTextfeld.setEnabled(true);
            speichernButton.setEnabled(true);
            loeschenButton.setEnabled(true);
            belegen.setEnabled(true);
            nichtBelegen.setEnabled(true);
            for(int i = 0; i<Modul.getAnzahlVeranstaltungen(); i++){
                tag[i].setEnabled(true);
                block[i].setEnabled(true);
                raum[i].setEnabled(true);
            }
        }
    }
}