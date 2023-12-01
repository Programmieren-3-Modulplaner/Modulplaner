package org.example.DAO;

public class Modul {

    private String modulName;
    private String profName;
    private double note;
    private boolean belegt;
    private int[] tag = new int[5];
    private int[] block = new int[5];
    private String[] raum = new String[5];

    /**
     * Standardkonstruktor, macht gar nichts.
     */
    public Modul() {
    }

    /*public Modul(String modulName, String profName, double note, boolean belegt, int[] tag, int[] block, String[] raum) {
        this.modulName = modulName;
        this.profName = profName;
        this.note = note;
        this.belegt = belegt;
        this.tag = tag;
        this.block = block;
        this.raum = raum;
    }*/
    public Modul(String modulName, String profName, double note, boolean belegt, int tag0, int block0, String raum0, int tag1, int block1, String raum1,
            int tag2, int block2, String raum2, int tag3, int block3, String raum3, int tag4, int block4, String raum4) {
        this.modulName = modulName;
        this.profName = profName;
        this.note = note;
        this.belegt = belegt;
        this.tag[0] = tag0;
        this.tag[1] = tag1;
        this.tag[2] = tag2;
        this.tag[3] = tag3;
        this.tag[4] = tag4;
        this.block[0] = block0;
        this.block[1] = block1;
        this.block[2] = block2;
        this.block[3] = block3;
        this.block[4] = block4;
        this.raum[0] = raum0;
        this.raum[1] = raum1;
        this.raum[2] = raum2;
        this.raum[3] = raum3;
        this.raum[4] = raum4;
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

    public int getArraySize() {
        return this.tag.length;
    }

}
