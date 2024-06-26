package org.example;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.example.DAO.ModulManagerDAO;

/**
 * Klasse für das Exportieren der Modulliste als .dat vom {@link org.example.DAO.ModulManager} von Parent
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Export{
    
    private Modulplaner parent;

    /**
     * Öffnet einen JFileChooser und speichert die Module vom {@link org.example.DAO.ModulManager} mit dem {@link org.example.DAO.ModulManagerDAO}
     * @param p Modulplaner als Parent
     */
    public Export(Modulplaner p) {
        this.parent = p;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            ModulManagerDAO dao = new ModulManagerDAO(selectedFile.getAbsolutePath(), true, parent); 
            try {
                dao.write(parent.modulManager);
            } catch (IOException r) {
                System.out.println(r.getMessage());
            }
            dao.close();
        }

    }
}
