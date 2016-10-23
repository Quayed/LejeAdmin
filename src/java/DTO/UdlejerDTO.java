package DTO;

/**
 * Created by mathias on 21/10/2016.
 */
public class UdlejerDTO {
    private int udlejerID;
    private String navn;
    private String CVR;
    private int adresseID;
    private AdresseDTO adresse;

    // Empty constructor to allow for automatic JSON parsing
    public UdlejerDTO(){

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

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }
    //</editor-fold>
}
