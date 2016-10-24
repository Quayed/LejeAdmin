/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.LejekontraktDAO;
import DTO.LejekontraktDTO;
import DTO.LejerDTO;
import PDFgeneration.KontraktGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;

/**
 * REST Web Service
 *
 * @author mathias
 */
@Path("lejekontrakt")
public class LejeKontraktResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LejeKontraktResource
     */
    public LejeKontraktResource() {
    }

    /**
     * Retrieves representation of an instance of api.LejeKontraktResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return null;
    }


    /**
     * PUT method for updating or creating an instance of LejeKontraktResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLejerkontrakt(LejerDTO lejer) throws IOException, SQLException {
        LejekontraktDTO localLejekontrakt = new LejekontraktDTO();
        localLejekontrakt.setLejer(lejer);

        String lejekontraktPath = "/Users/mathias/Desktop/Formular1.pdf";

        new KontraktGenerator().run("/Users/mathias/Desktop/Formular.pdf", lejekontraktPath, localLejekontrakt);

        new LejekontraktDAO().uploadFile(lejekontraktPath);

        return Response.ok("all good").build();
    }
}
