package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.example.DAO.ModulComparator;

/**
 * Klasse für die Liste der Bestandenen Module
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Bestandenliste extends JPanel {
    
    private Modulplaner parent;
    
    /**
     * Baut ein JPanel mit einer liste von bestandenen Modulen und dem Durchschnitt aus den {@link org.example.DAO.ModulManager} von Parent
     * @param p Modulplaner als Parent
     */
    public Bestandenliste(Modulplaner p) {
        this.parent = p;
        
        setBorder(BorderFactory.createTitledBorder(parent.sprache("TitelBestanden")+":"));
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(200, 0));

        Collections.sort(parent.modulManager, new ModulComparator());
        add(new JScrollPane(new JList(parent.modulManager.bestadeneModule())), BorderLayout.CENTER);
        add(new JLabel(parent.sprache("Durchschnitt")+": " + parent.modulManager.durchschnitt()), BorderLayout.SOUTH);
    }
}