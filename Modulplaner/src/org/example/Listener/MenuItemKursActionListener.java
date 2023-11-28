/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.example.Import;
import org.example.Plan;

/**
 *
 * @author Daniel
 */
public class MenuItemKursActionListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        
        frame.add(new Plan());
        frame.setVisible(true);
    }
}
    

