
package org.example.Listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AbbruchButtonActionListener implements ActionListener {
    private JFrame frame;

    public AbbruchButtonActionListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Fenster schließen...");
        frame.dispose();
    }
}
