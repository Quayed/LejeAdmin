package DTO;

/**
 * Created by mathias on 21/10/2016.
 */
public class AndreBidragDTO {
    private int AndreBidragID;
    private String tekst;
    private double værdi;
    private int lejemålID; // denne værdi er udelukkende interresant i databasen.

    // Empty constructor for automatic JSON parsing
    public AndreBidragDTO(){

    }

    //<editor-fold desc="Getters/Setters">
    public int getLejemålID() {
        return lejemålID;
    }

    public void setLejemålID(int lejemålID) {
        this.lejemålID = lejemålID;
    }

    public double getVærdi() {
        return værdi;
    }

    public void setVærdi(double værdi) {
        this.værdi = værdi;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getAndreBidragID() {
        return AndreBidragID;
    }

    public void setAndreBidragID(int andreBidragID) {
        AndreBidragID = andreBidragID;
    }
    //</editor-fold>
}
