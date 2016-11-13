package Domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mathias on 12/10/2016.
 */
public class Lejemål {
    private int lejemålID;
    private int adresseID;
    private Adresse adresse;
    private int lejemålTypeID;
    private String lejemålTypeNavn;
    private int udlejerID;
    private Udlejer udlejer;
    private double bruttoAreal;
    private int antalVærelser;
    private double erhvervsLokalerAreal;
    private boolean fællesVaskeri;
    private boolean fællesGårdanlæg;
    private String loftKælderrumNr;
    private boolean cykelParkering;
    private String garageNr;
    private ArrayList<String> andenBrugsret;
    private String benyttelse;
    private String betalingDen;
    private String betalingMåned;
    private double månedligLeje;
    private double varmebidrag;
    private double vandbidrag;
    private double elbidrag;
    private double kølingsbidrag;
    private double antennebidrag;
    private double beboerrepræsentation;
    private ArrayList<AndreBidrag> andreBidrag;
    private Date skatterOgAfgifterPr;
    private boolean udlejerLevereFjernvarme;
    private boolean udlejerLevereCentralvarme;
    private boolean udlejerLevereElOpvarmining;
    private String udlejerLevereAndenOpvarmning;
    private String udlejerVarmeregnskabsårStartDato;
    private boolean lejerOpvarmerVedEl;
    private boolean lejerOpvarmerVedGas;
    private boolean lejerOpvarmerVedOlie;
    private String lejerOpvarmerVedAndet;
    private boolean udlejerLevereVand;
    private boolean vandFordelesEfterForbrug;
    private boolean udlejreLevereElIkVarme;
    private boolean udlejerLevereKøling;
    private boolean kølingFordelesEfterForbrug;
    private boolean udlejerLevereFællesAntenne;
    private boolean antenneforeningLevere;
    private boolean udlejerLevereInternet;
    private boolean lejemålStandKontrolleretIndflytning;
    private boolean indvendigVedligeholdelsePåhvilerLejer;
    private boolean komfurTilhørerUdlejer;
    private boolean køleskabTilhørerUdlejer;
    private boolean fryserTilhørerUdlejer;
    private boolean opvaskemaskineTilhørerUdlejer;
    private boolean vaskemaskineTilhørerUdlejer;
    private boolean tørretumblerTilhørerUdlejer;
    private boolean emhætteTilhørerUdlejer;
    private int elpanelerTihørerUdlejer;
    private int vandvarmereTilhørerUdlejer;
    private String andetEtTilhørerUdlejer;
    private String andetToTilhørerUdlejer;
    private String andetTreTilhørerUdlejer;
    private boolean etableretBeboerRepræsentation;
    private boolean husdyrTilladt;
    private boolean husordenForeligger;

    public Lejemål(){
        // Constructor without parameters for automatic json parsing
    }

    public int getLejemålID() {
        return lejemålID;
    }

    public void setLejemålID(int lejemålID) {
        this.lejemålID = lejemålID;
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

    public int getLejemålTypeID() {
        return lejemålTypeID;
    }

    public void setLejemålTypeID(int lejemålTypeID) {
        this.lejemålTypeID = lejemålTypeID;
    }

    public String getLejemålTypeNavn() {
        return lejemålTypeNavn;
    }

    public void setLejemålTypeNavn(String lejemålTypeNavn) {
        this.lejemålTypeNavn = lejemålTypeNavn;
    }

    public int getUdlejerID() {
        return udlejerID;
    }

    public void setUdlejerID(int udlejerID) {
        this.udlejerID = udlejerID;
    }

    public Udlejer getUdlejer() {
        return udlejer;
    }

    public void setUdlejer(Udlejer udlejer) {
        this.udlejer = udlejer;
    }

    public double getBruttoAreal() {
        return bruttoAreal;
    }

    public void setBruttoAreal(double bruttoAreal) {
        this.bruttoAreal = bruttoAreal;
    }

    public int getAntalVærelser() {
        return antalVærelser;
    }

    public void setAntalVærelser(int antalVærelser) {
        this.antalVærelser = antalVærelser;
    }

    public double getErhvervsLokalerAreal() {
        return erhvervsLokalerAreal;
    }

    public void setErhvervsLokalerAreal(double erhvervsLokalerAreal) {
        this.erhvervsLokalerAreal = erhvervsLokalerAreal;
    }

    public boolean isFællesVaskeri() {
        return fællesVaskeri;
    }

    public void setFællesVaskeri(boolean fællesVaskeri) {
        this.fællesVaskeri = fællesVaskeri;
    }

    public boolean isFællesGårdanlæg() {
        return fællesGårdanlæg;
    }

    public void setFællesGårdanlæg(boolean fællesGårdanlæg) {
        this.fællesGårdanlæg = fællesGårdanlæg;
    }

    public String getLoftKælderrumNr() {
        return loftKælderrumNr;
    }

    public void setLoftKælderrumNr(String loftKælderrumNr) {
        this.loftKælderrumNr = loftKælderrumNr;
    }

    public boolean isCykelParkering() {
        return cykelParkering;
    }

    public void setCykelParkering(boolean cykelParkering) {
        this.cykelParkering = cykelParkering;
    }

    public String getGarageNr() {
        return garageNr;
    }

    public void setGarageNr(String garageNr) {
        this.garageNr = garageNr;
    }

    public ArrayList<String> getAndenBrugsret() {
        return andenBrugsret;
    }

    public void setAndenBrugsret(ArrayList<String> andenBrugsret) {
        this.andenBrugsret = andenBrugsret;
    }

    public String getBenyttelse() {
        return benyttelse;
    }

    public void setBenyttelse(String benyttelse) {
        this.benyttelse = benyttelse;
    }

    public String getBetalingDen() {
        return betalingDen;
    }

    public void setBetalingDen(String betalingDen) {
        this.betalingDen = betalingDen;
    }

    public String getBetalingMåned() {
        return betalingMåned;
    }

    public void setBetalingMåned(String betalingMåned) {
        this.betalingMåned = betalingMåned;
    }

    public double getMånedligLeje() {
        return månedligLeje;
    }

    public void setMånedligLeje(double månedligLeje) {
        this.månedligLeje = månedligLeje;
    }

    public double getVarmebidrag() {
        return varmebidrag;
    }

    public void setVarmebidrag(double varmebidrag) {
        this.varmebidrag = varmebidrag;
    }

    public double getVandbidrag() {
        return vandbidrag;
    }

    public void setVandbidrag(double vandbidrag) {
        this.vandbidrag = vandbidrag;
    }

    public double getElbidrag() {
        return elbidrag;
    }

    public void setElbidrag(double elbidrag) {
        this.elbidrag = elbidrag;
    }

    public double getKølingsbidrag() {
        return kølingsbidrag;
    }

    public void setKølingsbidrag(double kølingsbidrag) {
        this.kølingsbidrag = kølingsbidrag;
    }

    public double getAntennebidrag() {
        return antennebidrag;
    }

    public void setAntennebidrag(double antennebidrag) {
        this.antennebidrag = antennebidrag;
    }

    public double getBeboerrepræsentation() {
        return beboerrepræsentation;
    }

    public void setBeboerrepræsentation(double beboerrepræsentation) {
        this.beboerrepræsentation = beboerrepræsentation;
    }

    public Date getSkatterOgAfgifterPr() {
        return skatterOgAfgifterPr;
    }

    public void setSkatterOgAfgifterPr(Date skatterOgAfgifterPr) {
        this.skatterOgAfgifterPr = skatterOgAfgifterPr;
    }

    public boolean isUdlejerLevereFjernvarme() {
        return udlejerLevereFjernvarme;
    }

    public void setUdlejerLevereFjernvarme(boolean udlejerLevereFjernvarme) {
        this.udlejerLevereFjernvarme = udlejerLevereFjernvarme;
    }

    public boolean isUdlejerLevereCentralvarme() {
        return udlejerLevereCentralvarme;
    }

    public void setUdlejerLevereCentralvarme(boolean udlejerLevereCentralvarme) {
        this.udlejerLevereCentralvarme = udlejerLevereCentralvarme;
    }

    public boolean isUdlejerLevereElOpvarmining() {
        return udlejerLevereElOpvarmining;
    }

    public void setUdlejerLevereElOpvarmining(boolean udlejerLevereElOpvarmining) {
        this.udlejerLevereElOpvarmining = udlejerLevereElOpvarmining;
    }

    public String getUdlejerLevereAndenOpvarmning() {
        return udlejerLevereAndenOpvarmning;
    }

    public void setUdlejerLevereAndenOpvarmning(String udlejerLevereAndenOpvarmning) {
        this.udlejerLevereAndenOpvarmning = udlejerLevereAndenOpvarmning;
    }

    public String getUdlejerVarmeregnskabsårStartDato() {
        return udlejerVarmeregnskabsårStartDato;
    }

    public void setUdlejerVarmeregnskabsårStartDato(String udlejerVarmeregnskabsårStartDato) {
        this.udlejerVarmeregnskabsårStartDato = udlejerVarmeregnskabsårStartDato;
    }

    public boolean isLejerOpvarmerVedEl() {
        return lejerOpvarmerVedEl;
    }

    public void setLejerOpvarmerVedEl(boolean lejerOpvarmerVedEl) {
        this.lejerOpvarmerVedEl = lejerOpvarmerVedEl;
    }

    public boolean isLejerOpvarmerVedGas() {
        return lejerOpvarmerVedGas;
    }

    public void setLejerOpvarmerVedGas(boolean lejerOpvarmerVedGas) {
        this.lejerOpvarmerVedGas = lejerOpvarmerVedGas;
    }

    public boolean isLejerOpvarmerVedOlie() {
        return lejerOpvarmerVedOlie;
    }

    public void setLejerOpvarmerVedOlie(boolean lejerOpvarmerVedOlie) {
        this.lejerOpvarmerVedOlie = lejerOpvarmerVedOlie;
    }

    public String getLejerOpvarmerVedAndet() {
        return lejerOpvarmerVedAndet;
    }

    public void setLejerOpvarmerVedAndet(String lejerOpvarmerVedAndet) {
        this.lejerOpvarmerVedAndet = lejerOpvarmerVedAndet;
    }

    public boolean isUdlejerLevereVand() {
        return udlejerLevereVand;
    }

    public void setUdlejerLevereVand(boolean udlejerLevereVand) {
        this.udlejerLevereVand = udlejerLevereVand;
    }

    public boolean isVandFordelesEfterForbrug() {
        return vandFordelesEfterForbrug;
    }

    public void setVandFordelesEfterForbrug(boolean vandFordelesEfterForbrug) {
        this.vandFordelesEfterForbrug = vandFordelesEfterForbrug;
    }

    public boolean isUdlejreLevereElIkVarme() {
        return udlejreLevereElIkVarme;
    }

    public void setUdlejreLevereElIkVarme(boolean udlejreLevereElIkVarme) {
        this.udlejreLevereElIkVarme = udlejreLevereElIkVarme;
    }

    public boolean isUdlejerLevereKøling() {
        return udlejerLevereKøling;
    }

    public void setUdlejerLevereKøling(boolean udlejerLevereKøling) {
        this.udlejerLevereKøling = udlejerLevereKøling;
    }

    public boolean isKølingFordelesEfterForbrug() {
        return kølingFordelesEfterForbrug;
    }

    public void setKølingFordelesEfterForbrug(boolean kølingFordelesEfterForbrug) {
        this.kølingFordelesEfterForbrug = kølingFordelesEfterForbrug;
    }

    public boolean isUdlejerLevereFællesAntenne() {
        return udlejerLevereFællesAntenne;
    }

    public void setUdlejerLevereFællesAntenne(boolean udlejerLevereFællesAntenne) {
        this.udlejerLevereFællesAntenne = udlejerLevereFællesAntenne;
    }

    public boolean isAntenneforeningLevere() {
        return antenneforeningLevere;
    }

    public void setAntenneforeningLevere(boolean antenneforeningLevere) {
        this.antenneforeningLevere = antenneforeningLevere;
    }

    public boolean isUdlejerLevereInternet() {
        return udlejerLevereInternet;
    }

    public void setUdlejerLevereInternet(boolean udlejerLevereInternet) {
        this.udlejerLevereInternet = udlejerLevereInternet;
    }

    public boolean isLejemålStandKontrolleretIndflytning() {
        return lejemålStandKontrolleretIndflytning;
    }

    public void setLejemålStandKontrolleretIndflytning(boolean lejemålStandKontrolleretIndflytning) {
        this.lejemålStandKontrolleretIndflytning = lejemålStandKontrolleretIndflytning;
    }

    public boolean isIndvendigVedligeholdelsePåhvilerLejer() {
        return indvendigVedligeholdelsePåhvilerLejer;
    }

    public void setIndvendigVedligeholdelsePåhvilerLejer(boolean indvendigVedligeholdelsePåhvilerLejer) {
        this.indvendigVedligeholdelsePåhvilerLejer = indvendigVedligeholdelsePåhvilerLejer;
    }

    public boolean isKomfurTilhørerUdlejer() {
        return komfurTilhørerUdlejer;
    }

    public void setKomfurTilhørerUdlejer(boolean komfurTilhørerUdlejer) {
        this.komfurTilhørerUdlejer = komfurTilhørerUdlejer;
    }

    public boolean isKøleskabTilhørerUdlejer() {
        return køleskabTilhørerUdlejer;
    }

    public void setKøleskabTilhørerUdlejer(boolean køleskabTilhørerUdlejer) {
        this.køleskabTilhørerUdlejer = køleskabTilhørerUdlejer;
    }

    public boolean isFryserTilhørerUdlejer() {
        return fryserTilhørerUdlejer;
    }

    public void setFryserTilhørerUdlejer(boolean fryserTilhørerUdlejer) {
        this.fryserTilhørerUdlejer = fryserTilhørerUdlejer;
    }

    public boolean isOpvaskemaskineTilhørerUdlejer() {
        return opvaskemaskineTilhørerUdlejer;
    }

    public void setOpvaskemaskineTilhørerUdlejer(boolean opvaskemaskineTilhørerUdlejer) {
        this.opvaskemaskineTilhørerUdlejer = opvaskemaskineTilhørerUdlejer;
    }

    public boolean isVaskemaskineTilhørerUdlejer() {
        return vaskemaskineTilhørerUdlejer;
    }

    public void setVaskemaskineTilhørerUdlejer(boolean vaskemaskineTilhørerUdlejer) {
        this.vaskemaskineTilhørerUdlejer = vaskemaskineTilhørerUdlejer;
    }

    public boolean isTørretumblerTilhørerUdlejer() {
        return tørretumblerTilhørerUdlejer;
    }

    public void setTørretumblerTilhørerUdlejer(boolean tørretumblerTilhørerUdlejer) {
        this.tørretumblerTilhørerUdlejer = tørretumblerTilhørerUdlejer;
    }

    public boolean isEmhætteTilhørerUdlejer() {
        return emhætteTilhørerUdlejer;
    }

    public void setEmhætteTilhørerUdlejer(boolean emhætteTilhørerUdlejer) {
        this.emhætteTilhørerUdlejer = emhætteTilhørerUdlejer;
    }

    public int getElpanelerTihørerUdlejer() {
        return elpanelerTihørerUdlejer;
    }

    public void setElpanelerTihørerUdlejer(int elpanelerTihørerUdlejer) {
        this.elpanelerTihørerUdlejer = elpanelerTihørerUdlejer;
    }

    public int getVandvarmereTilhørerUdlejer() {
        return vandvarmereTilhørerUdlejer;
    }

    public void setVandvarmereTilhørerUdlejer(int vandvarmereTilhørerUdlejer) {
        this.vandvarmereTilhørerUdlejer = vandvarmereTilhørerUdlejer;
    }

    public String getAndetEtTilhørerUdlejer() {
        return andetEtTilhørerUdlejer;
    }

    public void setAndetEtTilhørerUdlejer(String andetEtTilhørerUdlejer) {
        this.andetEtTilhørerUdlejer = andetEtTilhørerUdlejer;
    }

    public String getAndetToTilhørerUdlejer() {
        return andetToTilhørerUdlejer;
    }

    public void setAndetToTilhørerUdlejer(String andetToTilhørerUdlejer) {
        this.andetToTilhørerUdlejer = andetToTilhørerUdlejer;
    }

    public String getAndetTreTilhørerUdlejer() {
        return andetTreTilhørerUdlejer;
    }

    public void setAndetTreTilhørerUdlejer(String andetTreTilhørerUdlejer) {
        this.andetTreTilhørerUdlejer = andetTreTilhørerUdlejer;
    }

    public boolean isEtableretBeboerRepræsentation() {
        return etableretBeboerRepræsentation;
    }

    public void setEtableretBeboerRepræsentation(boolean etableretBeboerRepræsentation) {
        this.etableretBeboerRepræsentation = etableretBeboerRepræsentation;
    }

    public boolean isHusdyrTilladt() {
        return husdyrTilladt;
    }

    public void setHusdyrTilladt(boolean husdyrTilladt) {
        this.husdyrTilladt = husdyrTilladt;
    }

    public boolean isHusordenForeligger() {
        return husordenForeligger;
    }

    public void setHusordenForeligger(boolean husordenForeligger) {
        this.husordenForeligger = husordenForeligger;
    }

    public ArrayList<AndreBidrag> getAndreBidrag() {
        return andreBidrag;
    }

    public void setAndreBidrag(ArrayList<AndreBidrag> andreBidrag) {
        this.andreBidrag = andreBidrag;
    }
}
