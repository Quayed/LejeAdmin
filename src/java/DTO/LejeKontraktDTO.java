package DTO;

import java.util.Date;

/**
 * Created by mathias on 12/10/2016.
 */
public class LejekontraktDTO {
    private int lejekontraktID;
    private int lejerID;
    private LejerDTO lejer;
    private int lejemålID;
    private LejemålDTO lejemål;
    private Date begyndelse;
    private Date udflytningsDato;
    private int betalingsstedID;
    private String betalingRegNr;
    private String betalingKontoNr;
    private String betalingPengeinstitut;
    private String depositumDato;
    private double depositumBeløb;
    private String forudbetaltLejeDato;
    private double forudbetaltLejeBeløb;
    private String indbetalingDato;
    private String forudbetaltlejeStartDato;
    private String forudbetaltlejeSlutDato;
    private String førstHusleje;
    private String vandregnskabsÅrBegynderDato;
    private String elregnskabsÅrBeygnderDato;
    private double vedligeholdeskonto;
    private String særligeVilkår;
    private Date underskriftUdlejerDato;
    private Date underskriftLejerDato;
    private String lejekontraktNavn;

    public LejekontraktDTO(){
        // Costructor without parameters for automatic JSON parsing.
    }

    public int getLejekontraktID() {
        return lejekontraktID;
    }

    public void setLejekontraktID(int lejekontraktID) {
        this.lejekontraktID = lejekontraktID;
    }

    public int getLejerID() {
        return lejerID;
    }

    public void setLejerID(int lejerID) {
        this.lejerID = lejerID;
    }

    public LejerDTO getLejer() {
        return lejer;
    }

    public void setLejer(LejerDTO lejer) {
        this.lejer = lejer;
    }

    public int getLejemålID() {
        return lejemålID;
    }

    public void setLejemålID(int lejemålID) {
        this.lejemålID = lejemålID;
    }

    public LejemålDTO getLejemål() {
        return lejemål;
    }

    public void setLejemål(LejemålDTO lejemål) {
        this.lejemål = lejemål;
    }

    public Date getBegyndelse() {
        return begyndelse;
    }

    public void setBegyndelse(Date begyndelse) {
        this.begyndelse = begyndelse;
    }

    public Date getUdflytningsDato() {
        return udflytningsDato;
    }

    public void setUdflytningsDato(Date udflytningsDato) {
        this.udflytningsDato = udflytningsDato;
    }

    public int getBetalingsstedID() {
        return betalingsstedID;
    }

    public void setBetalingsstedID(int betalingsstedID) {
        this.betalingsstedID = betalingsstedID;
    }

    public String getBetalingRegNr() {
        return betalingRegNr;
    }

    public void setBetalingRegNr(String betalingRegNr) {
        this.betalingRegNr = betalingRegNr;
    }

    public String getBetalingKontoNr() {
        return betalingKontoNr;
    }

    public void setBetalingKontoNr(String betalingKontoNr) {
        this.betalingKontoNr = betalingKontoNr;
    }

    public String getBetalingPengeinstitut() {
        return betalingPengeinstitut;
    }

    public void setBetalingPengeinstitut(String betalingPengeinstitut) {
        this.betalingPengeinstitut = betalingPengeinstitut;
    }

    public String getDepositumDato() {
        return depositumDato;
    }

    public void setDepositumDato(String depositumDato) {
        this.depositumDato = depositumDato;
    }

    public double getDepositumBeløb() {
        return depositumBeløb;
    }

    public void setDepositumBeløb(double depositumBeløb) {
        this.depositumBeløb = depositumBeløb;
    }

    public String getForudbetaltLejeDato() {
        return forudbetaltLejeDato;
    }

    public void setForudbetaltLejeDato(String forudbetaltLejeDato) {
        this.forudbetaltLejeDato = forudbetaltLejeDato;
    }

    public double getForudbetaltLejeBeløb() {
        return forudbetaltLejeBeløb;
    }

    public void setForudbetaltLejeBeløb(double forudbetaltLejeBeløb) {
        this.forudbetaltLejeBeløb = forudbetaltLejeBeløb;
    }

    public String getIndbetalingDato() {
        return indbetalingDato;
    }

    public void setIndbetalingDato(String indbetalingDato) {
        this.indbetalingDato = indbetalingDato;
    }

    public String getForudbetaltlejeStartDato() {
        return forudbetaltlejeStartDato;
    }

    public void setForudbetaltlejeStartDato(String forudbetaltlejeStartDato) {
        this.forudbetaltlejeStartDato = forudbetaltlejeStartDato;
    }

    public String getForudbetaltlejeSlutDato() {
        return forudbetaltlejeSlutDato;
    }

    public void setForudbetaltlejeSlutDato(String forudbetaltlejeSlutDato) {
        this.forudbetaltlejeSlutDato = forudbetaltlejeSlutDato;
    }

    public String getFørstHusleje() {
        return førstHusleje;
    }

    public void setFørstHusleje(String førstHusleje) {
        this.førstHusleje = førstHusleje;
    }

    public String getVandregnskabsÅrBegynderDato() {
        return vandregnskabsÅrBegynderDato;
    }

    public void setVandregnskabsÅrBegynderDato(String vandregnskabsÅrBegynderDato) {
        this.vandregnskabsÅrBegynderDato = vandregnskabsÅrBegynderDato;
    }

    public String getElregnskabsÅrBeygnderDato() {
        return elregnskabsÅrBeygnderDato;
    }

    public void setElregnskabsÅrBeygnderDato(String elregnskabsÅrBeygnderDato) {
        this.elregnskabsÅrBeygnderDato = elregnskabsÅrBeygnderDato;
    }

    public double getVedligeholdeskonto() {
        return vedligeholdeskonto;
    }

    public void setVedligeholdeskonto(double vedligeholdeskonto) {
        this.vedligeholdeskonto = vedligeholdeskonto;
    }

    public String getSærligeVilkår() {
        return særligeVilkår;
    }

    public void setSærligeVilkår(String særligeVilkår) {
        this.særligeVilkår = særligeVilkår;
    }

    public Date getUnderskriftUdlejerDato() {
        return underskriftUdlejerDato;
    }

    public void setUnderskriftUdlejerDato(Date underskriftUdlejerDato) {
        this.underskriftUdlejerDato = underskriftUdlejerDato;
    }

    public Date getUnderskriftLejerDato() {
        return underskriftLejerDato;
    }

    public void setUnderskriftLejerDato(Date underskriftLejerDato) {
        this.underskriftLejerDato = underskriftLejerDato;
    }

    public String getLejekontraktNavn() {
        return lejekontraktNavn;
    }

    public void setLejekontraktNavn(String lejekontraktNavn) {
        this.lejekontraktNavn = lejekontraktNavn;
    }
}
