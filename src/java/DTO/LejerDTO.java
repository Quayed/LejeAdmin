/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author mathias
 */
public class LejerDTO {
    private int lejerID;
    private String type;
    private String fornavn;
    private String efternavn;
    private int adresseID;
    private AdresseDTO adresse;
    private String identifikation;
    private String email;
    private String tlfNummer;
    private Date lastUpdated;


    public LejerDTO(String type, String fornavn, String efternavn, int adresseID, String identifikation, String email, String tlfNummer, Date lastUpdated){
        this.type = type;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresseID = adresseID;
        this.identifikation = identifikation;
        this.email = email;
        this.tlfNummer = tlfNummer;
        this.lastUpdated = lastUpdated;
    }
    public LejerDTO(){

    }

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

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }
}
