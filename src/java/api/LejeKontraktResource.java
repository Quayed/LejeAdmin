/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.LejekontraktDAO;
import Domain.Lejekontrakt;
import Domain.Lejer;
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


    @GET
    @Path("{ID}")
    public Response getLejekontrakt(@PathParam("ID") String ID) throws IOException, SQLException{
        Response response =  Response.ok(new LejekontraktDAO().getLejekontraktFile(ID)).build();
        response.getHeaders().add("Content-Type", "application/pdf");
        return response;
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLejerkontrakt(Lejer lejer) throws IOException, SQLException {
        Lejekontrakt localLejekontrakt = new Lejekontrakt();
        localLejekontrakt.setLejer(lejer);

        String lejekontraktPath = System.getenv("TEMP_PATH") + "/Formular" + new Random().nextInt(100000) + ".pdf";
        //String lejekontraktPath = "/home/tomcat/uploads/Formular" + new Random().nextInt(100000) + ".pdf";

        new KontraktGenerator().run(System.getenv("CONTRACT_PATH"), lejekontraktPath, localLejekontrakt);
        //new KontraktGenerator().run("/home/tomcat/uploads/lejekontrakt.pdf", lejekontraktPath, localLejekontrakt);
        int generatedID =  new LejekontraktDAO().uploadFile(lejekontraktPath);

        java.nio.file.Path path = FileSystems.getDefault().getPath(lejekontraktPath);

        Files.delete(path);

        //return Response.ok("/" + generatedID).build();
        return Response.ok(generatedID).build();
    }
}
