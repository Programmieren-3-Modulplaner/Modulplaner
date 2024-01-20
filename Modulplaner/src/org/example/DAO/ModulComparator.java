/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.DAO;

import java.util.Comparator;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */

public class ModulComparator implements Comparator<Modul>{

    @Override
    public int compare(Modul o1, Modul o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}