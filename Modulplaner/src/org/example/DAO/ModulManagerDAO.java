package org.example.DAO;

import java.io.IOException;
import org.example.Modulplaner;

/**
 * Data Access Object für die Klasse {@link org.example.DAO.ModulManager}
 */
public class ModulManagerDAO extends DAO {
    
    Modulplaner parent;

    /**
     * Konstruktor um das Data Access Object mit einem Dateinamen zu
     * initialisieren.
     * @param dateiName Dateiname
     * @param openForWrite true wenn geschrieben werden soll
     */
    public ModulManagerDAO(String dateiName, boolean openForWrite, Modulplaner p) {
        super(dateiName, openForWrite);
        this.parent = p;
    }

    /**
     * Methode zum schreiben der Module und des Sprachcods in eine Datei
     * @param obj {@link org.example.DAO.ModulManager} der geschrieben werden soll
     * @throws IOException 
     */
    public void write(Object obj) throws IOException {
        if (out != null) {
            out.writeInt(parent.getLanguageInt());
            
            ModulManager mods = (ModulManager) obj;

            // Anzahl ModulManager speichern:
            out.writeInt(mods.size());

            // Nun die einzelnen ModulManager speichern:
            MudulDAO modDAO = new MudulDAO(null, out);

            for (Modul s : mods) {
                modDAO.write(s);
            }
        }
    }

    /**
     * Methode zum lesen der Module und des Sprachcods aus einer Datei
     * @param obj {@link org.example.DAO.ModulManager} in den geschrieben werden soll
     * @throws IOException 
     */
    public void read(Object obj) throws IOException {
        if (in != null) {
            
            int language = in.readInt();
            if (parent.getLanguageInt() == -1) {
                parent.setLanguage(language);
            }

            ModulManager mods = (ModulManager) obj;

            // Anzahl ModulManager lesen:
            int nMods = in.readInt();

            // Nun die einzelnen ModulManager lesen:
            MudulDAO modDAO = new MudulDAO(in, null);
            for (int i = 0; i < nMods; ++i) {
                Modul s = new Modul();
                modDAO.read(s);
                mods.add(s);
            }
        }
    }
}
