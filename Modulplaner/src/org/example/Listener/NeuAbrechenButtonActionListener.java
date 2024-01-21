package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Modulplaner;
import org.example.Neu;

/**
 * Klasse zum Abbrechen des {@link org.example.Neu} Dialog
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class NeuAbrechenButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private Neu neu;

    /**
     * Konstruktor zum initialisieren des ActionListener
     * @param p Modulplaner als Parent
     * @param n Neu Dialog als Parent
     */
    public NeuAbrechenButtonActionListener(Modulplaner p, Neu n) {
        this.parent = p;
        this.neu = n;
    }
    
    /**
     * Schließt den {@link org.example.Neu} Dialog
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        neu.setVisible(false);
    }
}
