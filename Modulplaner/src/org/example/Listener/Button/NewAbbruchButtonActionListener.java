
package org.example.Listener.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class NewAbbruchButtonActionListener implements ActionListener {
    private JDialog frame;

    public NewAbbruchButtonActionListener(JDialog frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Fenster schließen...");
        frame.dispose();
    }
}
