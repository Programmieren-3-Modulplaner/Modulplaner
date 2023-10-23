
package org.example;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import org.example.Listener.AbbruchButtonActionListener;
import org.example.MenuBar.MenuBar;

/**
 *
 * @author Tjark Maasberg
 */
public class New extends JFrame {
    JButton speichernButton = new JButton("Speichern");
    JButton abbrechenButton = new JButton("Abbrechen");

    public New() {
        setSize(200, 250);
        setLocationRelativeTo(null);
        setJMenuBar(new MenuBar("neu"));

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridLayout(8, 1));
        newPanel.setBorder(new LineBorder(Color.BLACK));

        newPanel.add(new JLabel("Modulname", FlowLayout.LEFT));
        newPanel.add(new JTextField("", FlowLayout.LEFT));
        newPanel.add(new JLabel("Uhrzeit", FlowLayout.LEFT));
        newPanel.add(new JTextField("", FlowLayout.LEFT));
        
        newPanel.add(speichernButton);
        newPanel.add(abbrechenButton);
        
        add(newPanel);

        setVisible(true);
        
        abbrechenButton.addActionListener(new AbbruchButtonActionListener(this));
    }
}
