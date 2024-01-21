package org.example;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import org.example.Listener.SpracheAendernAbrechenButtonActionListener;
import org.example.Listener.SpracheAendernSpeichernButtonActionListener;

/**
 * Klasse zum ändern der Sprache des Modulplaners
 * <p>Listener: {@link org.example.Listener.SpracheAendernAbrechenButtonActionListener} {@link org.example.Listener.SpracheAendernSpeichernButtonActionListener}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class SpracheAendern extends JDialog{
    
    private Modulplaner parent;
    
    private JComboBox sprache;
    private JButton speichern, abbrechen;
    
    /**
     * Baut einen JDialog zum ändern der Sprache von Parent
     * @param p Modulplaner als Parent
     */
    public SpracheAendern(Modulplaner p){
        super(p,true);
        this.parent = p;
        
        setTitle(parent.sprache("TitelSprache"));
        setLayout((new GridLayout(1, 3, 5, 5))); 
        
        String[] sprachenUebersetzt = new String[parent.getAvailableLanguages().length];
        for (int i = 0; i < parent.getAvailableLanguages().length; i ++){
            sprachenUebersetzt[i] = parent.sprache(parent.getAvailableLanguages()[i]);
        }
        sprache = new JComboBox(sprachenUebersetzt);
        sprache.setSelectedIndex(parent.getLanguageInt());
        
        speichern = new JButton(parent.sprache("Speichern"));
        speichern.addActionListener(new SpracheAendernSpeichernButtonActionListener(parent, this, sprache));
        
        abbrechen = new JButton(parent.sprache("Abbrechen"));
        abbrechen.addActionListener(new SpracheAendernAbrechenButtonActionListener(parent, this));
        
        add(sprache);
        add(speichern);
        add(abbrechen);
        
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }
}