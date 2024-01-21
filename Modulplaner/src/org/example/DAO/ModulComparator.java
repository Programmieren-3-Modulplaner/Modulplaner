package org.example.DAO;

import java.util.Comparator;

/**
 * Comporator zum vergleichen von {@link org.example.DAO.Modul}en
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class ModulComparator implements Comparator<Modul>{

    /**
     * Verglicht zwei Module anhand der toString Methode (nicht case sensitive)
     * @param o1 Modul 1
     * @param o2 Modul 2
     * @return -1 / 0 / 1
     */
    @Override
    public int compare(Modul o1, Modul o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}