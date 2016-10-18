package DTO;

import java.util.Date;

/**
 * Created by mathias on 12/10/2016.
 */
public class LejemålDTO {
    private int lejemålID;
    private int adresseID;
    private AdresseDTO adresse;
    private int status;
    private double leje;
    private double kvadratmeter;
    private Date lastUpdated;
}
