/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mathias
 */
public class CustomerDTO {
    private int id;
    private String navn;
    private String vejNavn;
    private String husNr;
    private String byNavn;
    private String postNr;
    private String cprNr;
    private String email;
    private String tlfNr;

    public CustomerDTO(){

    }

    public CustomerDTO(int id, String navn, String vejNavn, String husNr, String byNavn, String postNr, String cprNr, String email, String tlfNr){
        this.id = id;
        this.navn = navn;
        this.vejNavn = vejNavn;
        this.husNr = husNr;
        this.byNavn = byNavn;
        this.postNr = postNr;
        this.cprNr = cprNr;
        this.email = email;
        this.tlfNr = tlfNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getVejNavn() {
        return vejNavn;
    }

    public void setVejNavn(String vejNavn) {
        this.vejNavn = vejNavn;
    }

    public String getHusNr() {
        return husNr;
    }

    public void setHusNr(String husNr) {
        this.husNr = husNr;
    }

    public String getByNavn() {
        return byNavn;
    }

    public void setByNavn(String byNavn) {
        this.byNavn = byNavn;
    }

    public String getPostNr() {
        return postNr;
    }

    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }

    public String getCprNr() {
        return cprNr;
    }

    public void setCprNr(String cprNr) {
        this.cprNr = cprNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }
}
