package org.example.DAO;

import java.io.IOException;
import org.example.Modulplaner;

/**
 * Data Access Object für die Klasse Module.
 */
public class ModuleDAO extends DAO {
    
    Modulplaner parent;

    /**
     * Konstruktor um das Data Access Object mit einem Dateinamen zu
     * initialisieren.
     *
     * @param dateiName Dateiname
     * @param openForWrite true wenn geschrieben werden soll
     */
    public ModuleDAO(String dateiName, boolean openForWrite, Modulplaner p) {
        super(dateiName, openForWrite);
        this.parent = p;
    }

    public void write(Object obj) throws IOException {
        if (out != null) {
            out.writeInt(parent.getLanguageInt());
            
            Module mods = (Module) obj;

            // Anzahl Module speichern:
            out.writeInt(mods.size());

            // Nun die einzelnen Module speichern:
            MudulDAO modDAO = new MudulDAO(null, out);

            for (Modul s : mods) {
                modDAO.write(s);
            }
        }
    }

    public void read(Object obj) throws IOException {
        if (in != null) {
            parent.setLanguage(in.readInt());
            
            Module mods = (Module) obj;

            // Anzahl Module lesen:
            int nMods = in.readInt();

            // Nun die einzelnen Module lesen:
            MudulDAO modDAO = new MudulDAO(in, null);
            for (int i = 0; i < nMods; ++i) {
                Modul s = new Modul();
                modDAO.read(s);
                mods.add(s);
            }
        }
    }
}
