package org.example.DAO;

import java.io.IOException;

/**
 * Data Access Object für die Klasse Module.
 */
public class ModuleDAO extends DAO {

    /**
     * Konstruktor um das Data Access Object mit einem Dateinamen zu
     * initialisieren.
     *
     * @param dateiName Dateiname
     * @param openForWrite true wenn geschrieben werden soll
     */
    public ModuleDAO(String dateiName, boolean openForWrite) {
        super(dateiName, openForWrite);
    }

    public void write(Object obj) throws IOException {
        if (out != null) {
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
