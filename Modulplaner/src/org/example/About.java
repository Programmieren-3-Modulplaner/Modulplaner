package org.example;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Klasse mit Informationen zu den Autoren und der Version
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class About extends JDialog {
    
    private Modulplaner parent;

    /**
     * Baut einen JDialog mit den Informationen der Autoren und der Version des Modulplaners
     * @param p Modulplaner als Parent
     */
    public About(Modulplaner p) {
        super(p,true);
        this.parent = p;
        setTitle(parent.sprache("Über"));
        setSize(200, 200);
        setLocationRelativeTo(null);

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayout(8, 1));
        aboutPanel.setBorder(new LineBorder(Color.BLACK));

        aboutPanel.add(centerJLable(""));
        aboutPanel.add(centerJLable("Modulplaner"));
        aboutPanel.add(centerJLable("Version 1.0"));
        aboutPanel.add(centerJLable("Copyright:"));
        aboutPanel.add(centerJLable("Niels Fricke"));
        aboutPanel.add(centerJLable("Daniel Grimm"));
        aboutPanel.add(centerJLable("Tjark Maasberg"));
        aboutPanel.add(centerJLable(""));

        add(aboutPanel);

        setVisible(true);
    }

    private JLabel centerJLable(String name) {
        JLabel label = new JLabel(name);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
