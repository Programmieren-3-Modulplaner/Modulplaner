/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import org.example.DAO.Modul;
import org.example.Listener.NeuAbrechenButtonActionListener;
import org.example.Listener.NeuSpeichernButtonActionListener;
import org.example.MenuBar.MenuBar;

/**
 * Klasse zum Hinzufügen eines neuen Moduls
 * <p>Listener: {@link org.example.Listener.NeuAbrechenButtonActionListener} {@link org.example.Listener.NeuSpeichernButtonActionListener}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Neu extends JDialog{

    private Modulplaner parent;
    
    private JPanel allgemeinPanel;
    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    private JFormattedTextField versuchTextfeld;
    private JTextField kursURLTextfeld;
    
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
    
    /**
     * Baut einen JDialog zum Hinzufügen eines neuen Moduls in den ModulManager von Parent
     * @param p Modulplaner als Parent
     */
    public Neu(Modulplaner p) {
        super(p,true);
        this.parent = p;
        
        setJMenuBar(new MenuBar("Neu", p));
        
        setTitle(parent.sprache("ModulTitel"));
        
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
        
        allgemeinPanel.add(new JLabel(parent.sprache("Name")+":"));
        allgemeinPanel.add(modulNameTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("Professor")+":"));
        allgemeinPanel.add(profNameTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("Note")+":"));
        allgemeinPanel.add(noteTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("Versuch")+":"));
        allgemeinPanel.add(versuchTextfeld);
        allgemeinPanel.add(new JLabel(parent.sprache("URL")+":"));
        allgemeinPanel.add(kursURLTextfeld);

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
            belegungenPanel.add(tag[i]);
            belegungenPanel.add(block[i]);
            belegungenPanel.add(raum[i]);
        }
        
        //-------------------------------------------------------
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout((new GridLayout(2, 2, 5, 5)));
        belegen = new JRadioButton(parent.sprache("TBelegen"));
        belegen.setSelected(true);
        nichtBelegen = new JRadioButton(parent.sprache("FBelegen"));
        nichtBelegen.setSelected(false);
        radioGroupBelegen = new ButtonGroup();
        radioGroupBelegen.add(belegen);
        radioGroupBelegen.add(nichtBelegen);
        speichernButton = new JButton(parent.sprache("Speichern"));
        speichernButton.addActionListener(new NeuSpeichernButtonActionListener(parent, this, modulNameTextfeld, profNameTextfeld, noteTextfeld, versuchTextfeld, kursURLTextfeld, tag, block, raum, belegen));
        abbrechenButton = new JButton(parent.sprache("Abbrechen"));
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
