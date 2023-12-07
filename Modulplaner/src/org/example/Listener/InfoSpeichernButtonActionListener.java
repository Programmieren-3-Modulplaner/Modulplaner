/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.example.DAO.Modul;
import org.example.Modulplaner;
import org.example.Neu;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class InfoSpeichernButtonActionListener implements ActionListener {

    private Modulplaner parent;
    
    private Modul oldModul;

    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    private JComboBox[] tag = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JComboBox[] block = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JTextField[] raum = new JTextField[Modul.getAnzahlVeranstaltungen()];
    private JRadioButton belegen;

    public InfoSpeichernButtonActionListener(Modulplaner p, Modul oM, JTextField mNT, JTextField pNT, JFormattedTextField nT, JComboBox[] t, JComboBox[] bl, JTextField[] r, JRadioButton be) {
        this.parent = p;
        this.oldModul = oM;
        this.modulNameTextfeld = mNT;
        this.profNameTextfeld = pNT;
        this.noteTextfeld = nT;
        this.tag = t;
        this.block = bl;
        this.raum = r;
        this.belegen = be;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Speichern Info");
        
        double note = Double.parseDouble(noteTextfeld.getText().toString());

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/33.gif"));
        if (modulNameTextfeld.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte zuerst Name eingeben!", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (profNameTextfeld.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte zuerst Profesor eingeben!", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (parent.module.nameIstVorhanden(modulNameTextfeld.getText()) && !modulNameTextfeld.getText().equals(oldModul.getModulName().toString())) {
            JOptionPane.showMessageDialog(null, "Modul bereits vorhanden", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (note < 0 || (note > 0 && note < 1) || (note > 4 && note < 5) || note > 5) {
            JOptionPane.showMessageDialog(null, "Zugelassenen Noten: 0.0 (nicht bestanden) / 1.0 - 4.0 / 5.0", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            boolean isbelegen = false;
            if (belegen.isSelected()){
                isbelegen = true;
            }
            
            int[] nTag = new int[Modul.getAnzahlVeranstaltungen()];
            int[] nBlock = new int[Modul.getAnzahlVeranstaltungen()];
            String[] nRaum = new String[Modul.getAnzahlVeranstaltungen()];
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++){
                nTag[i] = tag[i].getSelectedIndex();
                nBlock[i] = block[i].getSelectedIndex();
                nRaum[i] = raum[i].getText();
            }
            Modul n = new Modul(modulNameTextfeld.getText(), profNameTextfeld.getText(), note, isbelegen, nTag, nBlock, nRaum);
            
            int index = parent.module.getIndexByName(oldModul.getModulName());
            parent.module.set(index, n);

            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();
            parent.InfoAktualisieren(true, n);
            parent.BestandenlisteAktualisieren();
        }
    }
}
