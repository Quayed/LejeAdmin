/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.AdresseDAO;
import DAO.LejerDAO;
import DTO.AdresseDTO;
import DTO.LejerDTO;
import Helpers.JsonHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.json.*;

import static Helpers.GeneralHelper.getDateAsString;
import static javax.json.Json.createObjectBuilder;

/**
 * REST Web Service
 *
 * @author mathias
 */
@Path("lejer")
public class LejerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LejerResource
     */
    public LejerResource() {
    }

    /**
     * Retrieves all of the customers
     *
     * @return Response object
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLejere(@Context Request request) throws SQLException{
        LejerDAO dao = new LejerDAO();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        ArrayList<LejerDTO> lejere = dao.getLejere();

        // If lejere is null either there is no internet or something is completely off
        if (lejere == null)
            throw new WebApplicationException(500);

        for (LejerDTO lejer : lejere) {
            jsonArrayBuilder.add(lejer.getAsJsonBuilder(false));
        }

        JsonArray jsonArray = jsonArrayBuilder.build();

        JsonHelper helper = new JsonHelper();

        String returnString = helper.jsonArrayToString(jsonArray);

        // TODO remeber to do some caching
        return Response.ok(returnString).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getLejer(@Context Request request, @PathParam("id") int id) throws SQLException{
        LejerDAO dao = new LejerDAO();
        LejerDTO lejer = dao.getLejer(id);

        // If lejer is null either there is no internet or something is completely off
        if (lejer == null)
            throw new WebApplicationException(500);


        // TODO remeber to do some caching
        return Response.ok(new JsonHelper().jsonObjectToString(lejer.getAsJson(true))).build();
    }

    /**
     * POST method for creating an instance of LejerResource
     *
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createLejer(LejerDTO lejer) throws Exception{
        // Make sure that adresse is in the object
        if (lejer.getAdresse() == null && lejer.getAdresseID() == 0){
            throw new WebApplicationException("Der skal enten være adresse eller adresseID");
        }

        if (lejer.getAdresse() != null && lejer.getAdresseID() == 0){
            AdresseDTO adresse = new AdresseDAO().createAdresse(lejer.getAdresse());
            lejer.setAdresseID(adresse.getAdresseID());
        }

        LejerDAO dao = new LejerDAO();

        try {
            lejer = dao.createLejer(lejer);
        } catch (IllegalArgumentException e){
            throw new WebApplicationException(e.getMessage(), 415);
        }

        if (lejer.getLejerID() == 0)
            return Response.serverError().build();

        return Response.ok(new JsonHelper().jsonObjectToString(lejer.getAsJson(true))).build();
    }


}
