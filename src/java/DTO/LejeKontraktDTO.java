package DTO;

import java.util.Date;

/**
 * Created by mathias on 12/10/2016.
 */
public class LejeKontraktDTO {
    private int lejekontraktID;
    private int lejerID;
    private LejerDTO lejer;
    private int lejemålID;
    private LejemålDTO lejemål;
    private Date overtagelsesDato;
    private Date udflytningsDato;
    private Date lastUpdated;
}
