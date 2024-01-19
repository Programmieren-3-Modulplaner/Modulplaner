package org.example.DAO;

public class Modul {

    private int anzahlVeranstaltungen = 3;
    private String modulName;
    private String profName;
    private double note;
    private int versuch;
    private String kursURL;
    private boolean belegt;
    private int[] tag = new int[anzahlVeranstaltungen];
    private int[] block = new int[anzahlVeranstaltungen];
    private String[] raum = new String[anzahlVeranstaltungen];

    public Modul() {
    }

    public Modul(String modulName, String profName, double note, int versuch, String kursURL, boolean belegt, int[] tag, int[] block, String[] raum) {
        this.modulName = modulName;
        this.profName = profName;
        this.note = note;
        this.versuch = versuch;
        this.kursURL = kursURL;
        this.belegt = belegt;
        this.tag = tag;
        this.block = block;
        this.raum = raum;
    }
    
    //------------------------------------------
    public String getModulName() {
        return modulName;
    }

    public String getProfName() {
        return profName;
    }

    public double getNote() {
        return note;
    }
    
    public String getNoteString() {
        return String.valueOf(note);
    }

    public int getVersuch() {
        return versuch;
    }
    
    public String getVersuchString() {
        return String.valueOf(versuch);
    }

    public String getKursURL() {
        return kursURL;
    }

    public boolean isBelegt() {
        return belegt;
    }

    public int getTag(int index) {
        return tag[index];
    }

    public int getBlock(int index) {
        return block[index];
    }

    public String getRaum(int index) {
        return raum[index];
    }

    //------------------------------------------
    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setVersuch(int versuch) {
        this.versuch = versuch;
    }

    public void setKursURL(String kursURL) {
        this.kursURL = kursURL;
    }

    public void setBelegt(boolean belegt) {
        this.belegt = belegt;
    }

    public void setTag(int tag, int index) {
        this.tag[index] = tag;
    }

    public void setBlock(int block, int index) {
        this.block[index] = block;
    }

    public void setRaum(String raum, int index) {
        this.raum[index] = raum;
    }

    //------------------------------------------
    
    public String getRaum(int stag, int sblock) {
        for (int i = 0; i < this.tag.length; i++) {
            if (this.tag[i] == stag && this.block[i] == sblock) {
                return this.raum[i];
            }
        }
        return "";
    }

    public static int getAnzahlVeranstaltungen() {
        return new Modul().anzahlVeranstaltungen;
    }

    @Override
    public String toString() {
        return this.modulName + " | " + this.profName;
    }

    public void printTest() {
        System.out.println(this.getModulName());
        System.out.println(this.getProfName());
        System.out.println(this.getNote());
        System.out.println(this.getVersuch());
        System.out.println(this.getKursURL());
        System.out.println(this.isBelegt());
        for (int i = 0; i < anzahlVeranstaltungen; i++) {
            System.out.println("Tag" + i + ":   " + this.getTag(i));
            System.out.println("Block" + i + ": " + this.getBlock(i));
            System.out.println("Raum" + i + ":  " + this.getRaum(i));
        }
        System.out.println("-------");
    }

}
