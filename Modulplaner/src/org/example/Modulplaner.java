/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Modulplaner extends JFrame {

    /**
     * @param args the command line arguments
     */
    //public static Modulplaner app;
    private ArrayList<Modul> module = new ArrayList();
    private JPanel anzeigePanel;
    private JPanel anzeigePanelDayMontag;
    private JPanel anzeigePanelDayDienstag;
    private JPanel anzeigePanelDayMittwoch;
    private JPanel anzeigePanelDayDonnerstag;
    private JPanel anzeigePanelDayFreitag;
    
    
    private JTextField nameField;
    private JComboBox<String> tagComboBox;
    private JTextField anfangField;
    private JTextField endeField;


    public Modulplaner() {
        setTitle("Modulplaner");
        addWindowListener(new WindowEventListener());
        setSize(500, 300);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("modulplaner"));

        module.add(new Modul("P1", "Montag", 8, 9));
        module.add(new Modul("P2", "Montag", 8, 9));
        module.add(new Modul("P3", "Montag", 8, 9));
        module.add(new Modul("P4", "Montag", 8, 9));
        module.add(new Modul("P5", "Dienstag", 8, 9));
        module.add(new Modul("P6", "Mittwoch", 8, 9));
        module.add(new Modul("P7", "Donnerstag", 8, 9));
        module.add(new Modul("P8", "Freitag", 8, 9));

        
        setLayout(new BorderLayout());
        
        
        // Erstellen des Panels und Hinzufügen zum Frame
        anzeigePanel = new JPanel(new GridLayout(2, 5));
        anzeigePanel.add(new JLabel("Montag"));
        anzeigePanel.add(new JLabel("Dienstag"));
        anzeigePanel.add(new JLabel("Mittwoch"));
        anzeigePanel.add(new JLabel("Donnerstag"));
        anzeigePanel.add(new JLabel("Freitag"));
        
        anzeigePanelDayMontag = createSrollTage("Montag");
        JScrollPane scrollPanelMontag = new JScrollPane(anzeigePanelDayMontag);
        anzeigePanel.add(scrollPanelMontag);
        
        anzeigePanelDayDienstag = createSrollTage("Dienstag");
        JScrollPane scrollPanelDienstag = new JScrollPane(anzeigePanelDayDienstag);
        anzeigePanel.add(scrollPanelDienstag);
        
        anzeigePanelDayMittwoch = createSrollTage("Mittwoch");
        JScrollPane scrollPanelMittwoch = new JScrollPane(anzeigePanelDayMittwoch);
        anzeigePanel.add(scrollPanelMittwoch);
        
        anzeigePanelDayDonnerstag = createSrollTage("Donnerstag");
        JScrollPane scrollPanelDonnerstag = new JScrollPane(anzeigePanelDayDonnerstag);
        anzeigePanel.add(scrollPanelDonnerstag);
        
        anzeigePanelDayFreitag = createSrollTage("Freitag");
        JScrollPane scrollPanelFreitag = new JScrollPane(anzeigePanelDayFreitag);
        anzeigePanel.add(scrollPanelFreitag);
        
        add(anzeigePanel, BorderLayout.CENTER);
        
        
        JPanel controlPanel = new JPanel(new GridLayout(5, 2));
        controlPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        controlPanel.add(nameField);
        controlPanel.add(new JLabel("Tag:"));
        String[] days = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"};
        tagComboBox = new JComboBox<>(days);
        controlPanel.add(tagComboBox);
        controlPanel.add(new JLabel("Anfang:"));
        anfangField = new JTextField();
        controlPanel.add(anfangField);
        controlPanel.add(new JLabel("Ende:"));
        endeField = new JTextField();
        controlPanel.add(endeField);

        JButton addButton = new JButton("Hinzufügen");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addModule();
            }
        });
        controlPanel.add(addButton);

        add(controlPanel, BorderLayout.NORTH);
        

        setVisible(true);
    }
    
    private void addModule() {
        String name = nameField.getText();
        String tag = (String) tagComboBox.getSelectedItem();
        int anfang = Integer.parseInt(anfangField.getText());
        int ende = Integer.parseInt(endeField.getText());

        Modul newModule = new Modul(name, tag, anfang, ende);
        module.add(newModule);
        // Aktualisieren Sie die Ansicht
        //refreshView();
    }
    
    /*private void refreshView() {
        anzeigePanel.removeAll();
        for (int i = 0; i < 5; i++) {
            JPanel dayPanel = new JPanel(new GridLayout(0, 2));
            for (Modul modul : module) {
                if (i == getDayint(modul.getTag())) {
                    dayPanel.add(new JLabel(modul.getName()));
                    dayPanel.add(new JLabel(modul.getAnfangtoString()));
                }
            }
            JScrollPane scrollPane = new JScrollPane(dayPanel);
            anzeigePanel.add(scrollPane);
        }
    }*/
    
    private int getDayint(String day) {
    int result;
    switch (day) {
        case "Montag":
            result = 0;
            break;
        case "Dienstag":
            result = 1;
            break;
        case "Mittwoch":
            result = 2;
            break;
        case "Donnerstag":
            result = 3;
            break;
        case "Freitag":
            result = 4;
            break;
        default:
            result = 10;
            break;
    }
    return result;
}

    public static void main(String[] args) {

        /*
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }*/
        //app = new Modulplaner();
        new Modulplaner();
        
        //new About();
    }

    private JPanel createSrollTage(String tag) {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        for (Modul modul : module) {
                if (tag.equals(modul.getTag())){
                    panel.add(new JLabel(modul.getName()));
                    panel.add(new JLabel(modul.getAnfangtoString()));
                }
            }
        return panel;
    }
}
