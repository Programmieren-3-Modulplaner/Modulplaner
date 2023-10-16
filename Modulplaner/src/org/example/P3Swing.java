package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P3Swing extends JFrame {

    private ArrayList<String> musikListe;
    private DefaultListModel<String> listModel;
    private JList<String> musikJList;
    private JTextField titelTextField;
    private JTextField interpretTextField;
    private JComboBox<String> genreComboBox;
    private JButton hinzufuegenButton;
    private JButton loeschenButton;
    private JButton filternButton;
    private Map<String, String> genreBeispiele;

    public P3Swing() {
        musikListe = new ArrayList<>();
        listModel = new DefaultListModel<>();
        musikJList = new JList<>(listModel);

        titelTextField = new JTextField(20);
        interpretTextField = new JTextField(20);

        genreBeispiele = new HashMap<>();
        genreBeispiele.put("Alle", "");
        genreBeispiele.put("Pop", "Beispiel: 'Shape of You - Ed Sheeran'");
        genreBeispiele.put("Rock", "Beispiel: 'Stairway to Heaven - Led Zeppelin'");
        genreBeispiele.put("Hip-Hop", "Beispiel: 'Sicko Mode - Travis Scott'");
        genreBeispiele.put("Klassik", "Beispiel: 'Eine kleine Nachtmusik - Mozart'");
        genreBeispiele.put("Andere", "Beispiel: 'Bohemian Rhapsody - Queen'");

        String[] genreOptionen = {"Alle", "Pop", "Rock", "Hip-Hop", "Klassik", "Andere"};
        genreComboBox = new JComboBox<>(genreOptionen);

        hinzufuegenButton = new JButton("Hinzufügen");
        loeschenButton = new JButton("Löschen");
        filternButton = new JButton("Nach Genre filtern");

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGenre = (String) genreComboBox.getSelectedItem();
                if (!selectedGenre.equals("Alle")) {
                    String titel = titelTextField.getText();
                    String interpret = interpretTextField.getText();
                    if (!titel.isEmpty() && !interpret.isEmpty()) {
                        String eintrag = titel + " - " + interpret + " (" + selectedGenre + ")";
                        musikListe.add(eintrag);
                        listModel.addElement(eintrag);
                        titelTextField.setText("");
                        interpretTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(P3Swing.this, "Bitte füllen Sie Titel und Interpret aus.");
                    }
                }
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = musikJList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    musikListe.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });

        filternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGenre = (String) genreComboBox.getSelectedItem();
                listModel.clear();
                for (String eintrag : musikListe) {
                    if (selectedGenre.equals("Alle") || eintrag.contains(selectedGenre)) {
                        listModel.addElement(eintrag);
                    }
                }
            }
        });

        // Hier werden die Beispiele in die musikListe aufgenommen
        musikListe.add("Shape of You - Ed Sheeran (Pop)");
        musikListe.add("Stairway to Heaven - Led Zeppelin (Rock)");
        musikListe.add("Sicko Mode - Travis Scott (Hip-Hop)");
        musikListe.add("Eine kleine Nachtmusik - Mozart (Klassik)");
        musikListe.add("Bohemian Rhapsody - Queen (Andere)");

        JPanel eingabePanel = new JPanel(new GridLayout(4, 2));
        eingabePanel.add(new JLabel("Titel: "));
        eingabePanel.add(titelTextField);
        eingabePanel.add(new JLabel("Interpret: "));
        eingabePanel.add(interpretTextField);
        eingabePanel.add(new JLabel("Genre: "));
        eingabePanel.add(genreComboBox);
        eingabePanel.add(hinzufuegenButton);
        eingabePanel.add(loeschenButton);

        JPanel filterPanel = new JPanel(new FlowLayout());
        filterPanel.add(filternButton);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(new JScrollPane(musikJList), BorderLayout.CENTER);
        this.getContentPane().add(eingabePanel, BorderLayout.NORTH);
        this.getContentPane().add(filterPanel, BorderLayout.SOUTH);

        setTitle("Musik Katalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Beim Start der Anwendung die Einträge aus musikListe verwenden
        listModel.clear();
        for (String eintrag : musikListe) {
            listModel.addElement(eintrag);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                P3Swing katalog = new P3Swing();
                katalog.setVisible(true);
            }
        });
    }
}
