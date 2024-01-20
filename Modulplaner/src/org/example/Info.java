/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.NumberFormat;
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
import javax.swing.text.NumberFormatter;
import org.example.DAO.Modul;
import org.example.Listener.InfoKursURLButtonActionListener;
import org.example.Listener.InfoLoeschenButtonActionListener;
import org.example.Listener.InfoSpeichernButtonActionListener;

/**
 * Klasse für die Anzeige der Informationen zu den Modulen und zum bearbeiten der Module
 * <p>Listener: {@link org.example.Listener.InfoKursURLButtonActionListener} {@link org.example.Listener.InfoLoeschenButtonActionListener} {@link org.example.Listener.InfoSpeichernButtonActionListener}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Info extends JPanel{
    private Modulplaner parent;
    private boolean isEnable;
    private Modul modul;
    
    private JPanel allgemeinPanel;
    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    private JFormattedTextField versuchTextfeld;
    private JTextField kursURLTextfeld;
    private JButton kursURLButton;
    
    private JButton speichernButton;
    private JButton loeschenButton;
    private JRadioButton belegen;
    private JRadioButton nichtBelegen;
    private ButtonGroup radioGroupBelegen;
    
    private JPanel belegungenPanel;
    private JComboBox[] tag = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JComboBox[] block = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JTextField[] raum = new JTextField[Modul.getAnzahlVeranstaltungen()];

    /**
     * Baut das JPanel für die Modul Info und zum bearbeiten der Module
     * <p>Sollte kein Modul übergeben werden werden die funktionen disabled
     * @param p Modulplaner als Parent
     * @param iE true wenn ein Modul angezeigt werden soll
     * @param m Das anzuzeigende Modul zum bearbeiten
     */
    public Info(Modulplaner p, boolean iE, Modul m) {
        this.parent = p;
        this.isEnable = iE;
        this.modul = m;
        
        setBorder(BorderFactory.createTitledBorder(parent.sprache("Info")+": "));
        setLayout(new BorderLayout(10, 10));
        
        //-------------------------------------------------------
        
        allgemeinPanel = new JPanel();
        allgemeinPanel.setBorder(BorderFactory.createTitledBorder(parent.sprache("Allgemein")+": ")); 
        allgemeinPanel.setLayout(new GridLayout(0,2,5,5));
        modulNameTextfeld = new JTextField();
        profNameTextfeld = new JTextField();
        MaskFormatter noteFormatter = null;
        try {
            noteFormatter = new MaskFormatter("#.#");
        } catch (java.text.ParseException exc) {
            System.exit(-1);
        }
        noteTextfeld = new JFormattedTextField(noteFormatter);
        noteTextfeld.setValue(0.0);
        NumberFormatter versuchFormatter = new NumberFormatter(NumberFormat.getInstance());
        versuchFormatter.setValueClass(Integer.class);
        versuchFormatter.setMinimum(1);
        versuchFormatter.setMaximum(parent.getMaxAnzahlVersucheInt());
        versuchFormatter.setAllowsInvalid(false);
        versuchTextfeld = new JFormattedTextField(versuchFormatter);
        versuchTextfeld.setValue(1);
        kursURLTextfeld = new JTextField();
        kursURLButton = new JButton(parent.sprache("URL"));
        //kursURLButton.setHorizontalAlignment(SwingConstants.LEFT);
        
        modulNameTextfeld.setEnabled(false);
        profNameTextfeld.setEnabled(false);
        noteTextfeld.setEnabled(false);
        versuchTextfeld.setEnabled(false);
        kursURLButton.setEnabled(false);
        kursURLTextfeld.setEnabled(false);
        
        belegen = new JRadioButton(parent.sprache("TBelegen"));
        belegen.setSelected(false);
        belegen.setEnabled(false);
        nichtBelegen = new JRadioButton(parent.sprache("FBelegen"));
        nichtBelegen.setSelected(false);
        nichtBelegen.setEnabled(false);
        radioGroupBelegen = new ButtonGroup();
        radioGroupBelegen.add(belegen);
        radioGroupBelegen.add(nichtBelegen);
        
        speichernButton = new JButton(parent.sprache("Speichern"));
        speichernButton.addActionListener(new InfoSpeichernButtonActionListener(parent, modul, modulNameTextfeld, profNameTextfeld, noteTextfeld, versuchTextfeld, kursURLTextfeld, tag, block, raum, belegen));
        speichernButton.setEnabled(false);
        loeschenButton = new JButton(parent.sprache("Löschen"));
        loeschenButton.addActionListener(new InfoLoeschenButtonActionListener(parent, modul));
        loeschenButton.setEnabled(false);
        
        allgemeinPanel.add(new JLabel(parent.sprache("Name")+":"));
        allgemeinPanel.add(modulNameTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("Professor")+":"));
        allgemeinPanel.add(profNameTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("Note")+":"));
        allgemeinPanel.add(noteTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("Versuch")+":"));
        allgemeinPanel.add(versuchTextfeld);
        allgemeinPanel.add(kursURLButton);
        allgemeinPanel.add(kursURLTextfeld);
        allgemeinPanel.add(belegen);
        allgemeinPanel.add(nichtBelegen);
        allgemeinPanel.add(speichernButton);
        allgemeinPanel.add(loeschenButton);

        //-------------------------------------------------------

        String[] tagComboxArray = new String[Modulplaner.tage.values().length+1];
        tagComboxArray[0] = "";
        for (int i = 1; i<tagComboxArray.length; i++){
            tagComboxArray[i] = parent.sprache(Modulplaner.tage.values()[i-1].toString());
        }
        String[] blockCombockArray = new String[parent.getAnzahlBloecke()+1];
        blockCombockArray[0] = "";
        for (int i = 1; i<parent.getAnzahlBloecke()+1; i++){
            blockCombockArray[i] = i + ". "+ parent.sprache("Block");
        }
        
        belegungenPanel = new JPanel();
        belegungenPanel.setLayout((new GridLayout(Modul.getAnzahlVeranstaltungen()*2, 3, 5, 5)));        
        belegungenPanel.setBorder(BorderFactory.createTitledBorder(parent.sprache("Veranstaltungen")+": ")); 
        for(int i = 0; i<Modul.getAnzahlVeranstaltungen(); i++){
            belegungenPanel.add(new JLabel(parent.sprache("Tag")+":"));
            belegungenPanel.add(new JLabel(parent.sprache("Block")+":"));
            belegungenPanel.add(new JLabel(parent.sprache("Raum")+":"));
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
            versuchTextfeld.setText(this.modul.getVersuchString());
            kursURLTextfeld.setText(this.modul.getKursURL());
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                if (this.modul.getTag(i) >= 0 && this.modul.getTag(i) <= Modulplaner.tage.values().length) {
                    tag[i].setSelectedIndex( this.modul.getTag(i));
                    }
                if (this.modul.getBlock(i) >= 0 && this.modul.getBlock(i) <= parent.getAnzahlBloecke()) {
                    block[i].setSelectedIndex(this.modul.getBlock(i));
                }
                raum[i].setText(this.modul.getRaum(i));
            }
            if (this.modul.isBelegt()) {
                belegen.setSelected(true);
            } else {
                nichtBelegen.setSelected(true);
            }
            modulNameTextfeld.setEnabled(true);
            profNameTextfeld.setEnabled(true);
            noteTextfeld.setEnabled(true);
            versuchTextfeld.setEnabled(true);
            kursURLButton.setEnabled(true);
            kursURLButton.addActionListener(new InfoKursURLButtonActionListener(parent, modul.getKursURL()));
            kursURLTextfeld.setEnabled(true);
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

    /**
     * Gibt das aktuell angezeigt Modul zurück
     * @return Modul
     */
    public Modul getModul() {
        return modul;
    }
    
}