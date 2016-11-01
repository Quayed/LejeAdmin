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
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.Random;

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
    @Path("{ID}")
    public Response getLejekontrakt(@PathParam("ID") String ID) throws IOException, SQLException{
        Response response =  Response.ok(new LejekontraktDAO().getLejekontraktFile(ID)).build();
        response.getHeaders().add("Content-Type", "application/pdf");
        return response;
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLejerkontrakt(LejerDTO lejer) throws IOException, SQLException {
        LejekontraktDTO localLejekontrakt = new LejekontraktDTO();
        localLejekontrakt.setLejer(lejer);

        String lejekontraktPath = System.getenv("TEMP_PATH") + "/Formular" + new Random().nextInt(100000) + ".pdf";

        new KontraktGenerator().run(System.getenv("CONTRACT_PATH"), lejekontraktPath, localLejekontrakt);

        int generatedID = new LejekontraktDAO().uploadFile(lejekontraktPath);

        java.nio.file.Path path = FileSystems.getDefault().getPath(lejekontraktPath);

        Files.delete(path);

        return Response.ok(generatedID).build();
    }
}
