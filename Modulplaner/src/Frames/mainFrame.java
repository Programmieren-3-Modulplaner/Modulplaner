/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import org.example.Info;
//import org.example.Listener;
//import org.example.Plan2;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.example.Listener.MenuItemKursActionListener;
import org.example.Plan;


public class mainFrame extends JFrame{
    public mainFrame(){
        this.setTitle("Kursplaner der Jade Hochschule");
        this.setSize(700,600);
        //this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] items = {"Import","Export","Beenden"};
        
        JMenuBar menuBar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        
        for (String item : items) {
            datei.add(new JMenuItem(item));
        }
        JMenu ansicht = new JMenu("Ansicht");
        JMenuItem kursView = new JMenuItem("Kursplaner");
        kursView.addActionListener(new MenuItemKursActionListener());
        JMenu hilfe = new JMenu("Hilfe");
        ansicht.add(kursView);
        menuBar.add(datei);
        menuBar.add(ansicht);
        menuBar.add(hilfe);
        this.setJMenuBar(menuBar);
        
        //BEGINN JPanel 
        JPanel ui = new JPanel();
        ui.setLayout(new BorderLayout(10,10));
        //ui.setBackground(Color.BLACK);
        //JPanel links = new JPanel();
        String[] kurse = {"Mathe 1", "Mathe 2", "Programmieren 1", "Programmieren 2", "Programmieren 3", "Statistik", "KLR"};
        //String[] block = {"1.Block", "2. Block", "3. Block","4. Block","5.Block"};
        //String[] tage = {"Montage","Dienstag","Mittwoch","Donnerstag","Freitag"};
        JList liste = new JList(kurse);
        
        JPanel links = new JPanel();
        JLabel u = new JLabel("Kurse",2);
        //u.setBorder(BorderFactory.createLineBorder(Color.black));
        links.setLayout(new BoxLayout(links,BoxLayout.Y_AXIS));
        //links.setBorder(BorderFactory.createLineBorder(Color.black));
        links.add(u);
        
        links.add(liste);
                    
        //
                    
        ui.add(links, BorderLayout.WEST);
        ui.add(new Info(), BorderLayout.CENTER);
        ui.add(new Plan(), BorderLayout.PAGE_END);
        ui.add(new JLabel("Kursplaner der Jade Hochschule",0), BorderLayout.NORTH);
        this.add(ui);
        setVisible(true);
    }
    
}
