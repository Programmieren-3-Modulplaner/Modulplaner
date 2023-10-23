/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Danie
 */
public class Import extends JFrame{
    
    public Import(){
    JFileChooser chooser = new JFileChooser();
    // Dialog zum Oeffnen von Dateien anzeigen
    chooser.showOpenDialog(null);
    }
}
