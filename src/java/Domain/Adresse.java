package Domain;

import Helpers.JsonHelper;

import javax.json.JsonObject;
import java.util.Date;

/**
 * Created by mathias on 12/10/2016.
 */
public class Adresse {
    private Integer adresseID;
    private String vej;
    private String nummer;
    private String postnummer;
    private Date lastUpdated;

    public Adresse() {

    }

    public Adresse(String vej, String nummer, String postnummer) {
        this.vej = vej;
        this.nummer = nummer;
        this.postnummer = postnummer;
    }

    public JsonObject getAsJson() {
        JsonHelper jsonHelper = new JsonHelper();

        jsonHelper.add("adresseID", adresseID)
                .add("vej", vej)
                .add("nummer", nummer)
                .add("postnummer", postnummer)
                .add("lastUpdated", lastUpdated);

        return jsonHelper.getJsonObject();
    }

    public String getAsString(){
        StringBuilder sb = new StringBuilder();

        sb.append(vej);
        sb.append(" ");
        sb.append(nummer);
        sb.append(" ");
        sb.append(postnummer);

        return sb.toString();
    }

    //<editor-fold desc="Getters/Setters">
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
    //</editor-fold>
}
