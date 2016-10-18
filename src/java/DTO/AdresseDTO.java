package DTO;

import java.util.Date;

/**
 * Created by mathias on 12/10/2016.
 */
public class AdresseDTO {
    private int adresseID;
    private String vej;
    private String nummer;
    private String postnummer;
    private Date lastUpdated;

    public AdresseDTO(String vej, String nummer, String postnummer) {
        this.vej = vej;
        this.nummer = nummer;
        this.postnummer = postnummer;
    }

    public int getAdresseID() {
        return adresseID;
    }

    public void setAdresseID(int adresseID) {
        this.adresseID = adresseID;
    }

    public String getVej() {
        return vej;
    }

    public void setVej(String vej) {
        this.vej = vej;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
