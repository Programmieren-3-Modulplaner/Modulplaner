/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.example.About;
import org.example.DAO.Modul;
import org.example.Modulplaner;
import org.example.Neu;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class NeuSpeichernButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private Neu neu;

    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    private JComboBox[] tag = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JComboBox[] block = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JTextField[] raum = new JTextField[Modul.getAnzahlVeranstaltungen()];
    private JRadioButton belegen;
    //private JRadioButton nichtBelegen;

    public NeuSpeichernButtonActionListener(Modulplaner p, Neu n, JTextField modulNameTextfeld, JTextField profNameTextfeld, JFormattedTextField noteTextfeld, JComboBox[] tag, JComboBox[] block, JTextField[] raum, JRadioButton belegen, JRadioButton nichtBelegen) {
        this.parent = p;
        this.neu = n;
        this.modulNameTextfeld = modulNameTextfeld;
        this.profNameTextfeld = profNameTextfeld;
        this.noteTextfeld = noteTextfeld;
        this.tag = tag;
        this.block = block;
        this.raum = raum;
        this.belegen = belegen;
        //this.nichtBelegen = nichtBelegen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Speichern");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/33.gif"));
        if (modulNameTextfeld.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bitte zuerst Name eingeben!", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (profNameTextfeld.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Bitte zuerst Profesor eingeben!", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (parent.module.nameIstVorhanden(modulNameTextfeld.getText())) {
            JOptionPane.showMessageDialog(null, "Modul bereits vorhanden", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (Double.parseDouble(noteTextfeld.getText().toString()) < 0 || 
                (Double.parseDouble(noteTextfeld.getText().toString()) > 0 && 
                Double.parseDouble(noteTextfeld.getText().toString()) < 1)|| 
                Double.parseDouble(noteTextfeld.getText().toString()) > 5) {
            JOptionPane.showMessageDialog(null, "Zugelassenen Noten: 0.0 (nicht bestanden) / 1.0 - 5.0", "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            boolean isbelegen = false;
            if (belegen.isSelected()){
                isbelegen = true;
            }
            
            Modul n = new Modul(
                    modulNameTextfeld.getText(),
                    profNameTextfeld.getText(),
                    Double.parseDouble(noteTextfeld.getText().toString()), isbelegen,
                    tag[0].getSelectedIndex(), block[0].getSelectedIndex(), raum[0].getText(),
                    tag[1].getSelectedIndex(), block[1].getSelectedIndex(), raum[1].getText(),
                    tag[2].getSelectedIndex(), block[2].getSelectedIndex(), raum[2].getText(),
                    tag[3].getSelectedIndex(), block[3].getSelectedIndex(), raum[3].getText(),
                    tag[4].getSelectedIndex(), block[4].getSelectedIndex(), raum[4].getText());
            System.out.println(tag[0].getSelectedIndex());
            parent.module.add(n);
            neu.setVisible(false);
            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();
        }
    }
}
