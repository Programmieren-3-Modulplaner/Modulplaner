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
 * Klasse zum Speichern des {@link org.example.DAO.Modul}s des {@link org.example.Neu} Dialog
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class NeuSpeichernButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private Neu neu;

    private JTextField modulNameTextfeld;
    private JTextField profNameTextfeld;
    private JFormattedTextField noteTextfeld;
    private JFormattedTextField versuchTextfeld;
    private JTextField kursURLTextfeld;
    private JComboBox[] tag = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JComboBox[] block = new JComboBox[Modul.getAnzahlVeranstaltungen()];
    private JTextField[] raum = new JTextField[Modul.getAnzahlVeranstaltungen()];
    private JRadioButton belegen;

    /**
     * Konstruktor zum initialisieren des ActionListener
     * @param p Modulplaner als Parent
     * @param n Neu Dialog als Parent
     * @param mNT Modul Name Textfeld
     * @param pNT Prof Name Textfeld
     * @param nT Note Textfeld
     * @param v Versuch Textfeld
     * @param k Kurs URL Textfeld
     * @param t Tag ComboBox Array
     * @param bl Block ComboBox Array
     * @param r Raum Textfeld Array
     * @param be Belegen RadioButton
     */
    public NeuSpeichernButtonActionListener(Modulplaner p, Neu n, JTextField mNT, JTextField pNT, JFormattedTextField nT, JFormattedTextField v, JTextField k, JComboBox[] t, JComboBox[] bl, JTextField[] r, JRadioButton be) {
        this.parent = p;
        this.neu = n;
        this.modulNameTextfeld = mNT;
        this.profNameTextfeld = pNT;
        this.noteTextfeld = nT;
        this.versuchTextfeld = v;
        this.kursURLTextfeld = k;
        this.tag = t;
        this.block = bl;
        this.raum = r;
        this.belegen = be;
    }

    /**
     * Speichert das neue {@link org.example.DAO.Modul} in dem {@link org.example.DAO.ModulManager} von Parent,
     * aktualisiert diesen und schließt den {@link org.example.Neu} Dialog
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        double note = Double.parseDouble(noteTextfeld.getText().toString());
        int versuch = Integer.parseInt(versuchTextfeld.getText().toString());

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/33.gif"));
        if (modulNameTextfeld.getText().length() == 0) {
            JOptionPane.showMessageDialog(neu, parent.sprache("NName"), "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (profNameTextfeld.getText().length() == 0){
            JOptionPane.showMessageDialog(neu, parent.sprache("NProf"), "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (parent.modulManager.nameIstVorhanden(modulNameTextfeld.getText())) {
            JOptionPane.showMessageDialog(neu, parent.sprache("TModul"), "", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (note < 0 || (note > 0 && note < 1)|| (note > 4 && note < 5)|| note > 5) {
            JOptionPane.showMessageDialog(neu, parent.sprache("ZNote") +":" + "0.0" + " (" + parent.sprache("NBE")+ ") " + "/ 1.0 - 4.0 / 5.0", "", JOptionPane.INFORMATION_MESSAGE, icon);
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
            Modul n = new Modul(modulNameTextfeld.getText(), profNameTextfeld.getText(), note, versuch, kursURLTextfeld.getText(), isbelegen, nTag, nBlock, nRaum);          
            parent.modulManager.add(n);
            neu.setVisible(false);
            parent.KurslisteAktualisieren();
            parent.KursplanAktualisieren();
            parent.BestandenlisteAktualisieren();
        }
    }
}
