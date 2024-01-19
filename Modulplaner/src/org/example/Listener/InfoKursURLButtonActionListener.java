/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class InfoKursURLButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private String kursURL;


    public InfoKursURLButtonActionListener(Modulplaner p, String kursURL) {
        this.parent = p;
        this.kursURL = kursURL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Kurs URL Öffnen: " + kursURL);
        if (kursURL.length() > 0) {
            URL url = null;
            try {
                url = new URL(kursURL);
            } catch (MalformedURLException ex) {
                System.out.println(ex.getMessage());
            }
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(url.toURI());
                } catch (URISyntaxException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        
    }
}
