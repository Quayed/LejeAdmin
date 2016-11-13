package Domain;

import java.util.Date;

/**
 * Created by mathias on 21/10/2016.
 */
public class Udlejer {
    private int udlejerID;
    private String navn;
    private String CVR;
    private int adresseID;
    private Adresse adresse;
    private Date lastUpdated;
    private boolean isDeleted;

    // Empty constructor to allow for automatic JSON parsing
    public Udlejer(){

    }

    //<editor-fold desc="Getters/Setters">
    public int getUdlejerID() {
        return udlejerID;
    }

    public void setUdlejerID(int udlejerID) {
        this.udlejerID = udlejerID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    public int getAdresseID() {
        return adresseID;
    }

    public void setAdresseID(int adresseID) {
        this.adresseID = adresseID;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    //</editor-fold>
}
