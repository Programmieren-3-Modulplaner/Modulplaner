
package org.example.Listener.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class NewAbbruchButtonActionListener implements ActionListener {
    private JFrame frame;

    public NewAbbruchButtonActionListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Fenster schließen...");
        frame.dispose();
    }
}
