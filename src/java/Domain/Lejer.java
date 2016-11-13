/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Helpers.JsonHelper;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Date;

/**
 *
 * @author mathias
 */
public class Lejer {
    private int lejerID;
    private String type;
    private String fornavn;
    private String efternavn;
    private int adresseID;
    private Adresse adresse;
    private String identifikation;
    private String email;
    private String tlfNummer;
    private Date lastUpdated;

    public Lejer(){

    }
    public Lejer(String type, String fornavn, String efternavn, int adresseID, String identifikation, String email, String tlfNummer, Date lastUpdated){
        this.type = type;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresseID = adresseID;
        this.identifikation = identifikation;
        this.email = email;
        this.tlfNummer = tlfNummer;
        this.lastUpdated = lastUpdated;
    }

    public JsonObjectBuilder getAsJsonBuilder(boolean details){
        JsonHelper jsonHelper = new JsonHelper();

        jsonHelper.add("lejerID", lejerID)
                .add("type", type)
                .add("fornavn", fornavn)
                .add("efternavn", efternavn)
                .add("adresseID", adresseID);

        if(adresse != null && details){
            jsonHelper.getObjectBuilder().add("adresse", adresse.getAsJson());
        }

        jsonHelper.add("identifikation", identifikation)
                .add("email", email)
                .add("tlfNummer", tlfNummer)
                .add("lastUpdated", lastUpdated);

        return jsonHelper.getObjectBuilder();
    }

    public JsonObject getAsJson(boolean details){
        return getAsJsonBuilder(details).build();
    }

    //<editor-fold desc="Getters/Setters">
    public int getLejerID() {
        return lejerID;
    }

    public void setLejerID(int lejerID) {
        this.lejerID = lejerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getAdresseID() {
        return adresseID;
    }

    public void setAdresseID(int adresseID) {
        this.adresseID = adresseID;
    }

    public String getIdentifikation() {
        return identifikation;
    }

    public void setIdentifikation(String identifikation) {
        this.identifikation = identifikation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlfNummer() {
        return tlfNummer;
    }

    public void setTlfNummer(String tlfNummer) {
        this.tlfNummer = tlfNummer;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    //</editor-fold>
}
