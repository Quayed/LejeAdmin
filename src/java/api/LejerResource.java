/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.LejerDAO;
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
            JsonObjectBuilder builder = createObjectBuilder()
                    .add("LejerID", lejer.getLejerID())
                    .add("Type", lejer.getType())
                    .add("Fornavn", lejer.getFornavn());

            if (lejer.getEfternavn() == null)
                builder.addNull("Efternavn");
            else
                builder.add("Efternavn", lejer.getEfternavn());


            if(lejer.getAdresseID() == 0)
                builder.addNull("AdresseID");
            else
                builder.add("AdresseID", lejer.getAdresseID());

                    builder.add("Identifikation", lejer.getIdentifikation())
                    .add("Email", lejer.getEmail())
                    .add("TlfNummer", lejer.getTlfNummer())
                    .add("LastUpdated", getDateAsString(lejer.getLastUpdated()));

            jsonArrayBuilder.add(builder);
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

        JsonObjectBuilder objectBuilder = createObjectBuilder()
                .add("LejerID", lejer.getLejerID())
                .add("Type", lejer.getType())
                .add("Fornavn", lejer.getFornavn());

        if (lejer.getEfternavn() == null)
            objectBuilder.addNull("Efternavn");
        else
            objectBuilder.add("Efternavn", lejer.getEfternavn());


        if(lejer.getAdresseID() == 0) {
            objectBuilder.addNull("AdresseID");
            objectBuilder.addNull("Adresse");
        }else {
            objectBuilder.add("AdresseID", lejer.getAdresseID());
            objectBuilder.add("Adresse", createObjectBuilder()
                .add("AdresseID", lejer.getAdresse().getAdresseID())
                .add("Vej", lejer.getAdresse().getVej())
                .add("Nummer", lejer.getAdresse().getNummer())
                .add("Postnumemr", lejer.getAdresse().getPostnummer())
                .add("LastUpdated", getDateAsString(lejer.getAdresse().getLastUpdated())));
        }
        objectBuilder.add("Identifikation", lejer.getIdentifikation())
                .add("Email", lejer.getEmail())
                .add("TlfNummer", lejer.getTlfNummer())
                .add("LastUpdated", getDateAsString(lejer.getLastUpdated()));


        JsonHelper helper = new JsonHelper();

        String returnString = helper.jsonObjectToString(objectBuilder.build());

        // TODO remeber to do some caching
        return Response.ok(returnString).build();
    }

    /**
     * PUT method for updating or creating an instance of LejerResource
     *
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createLejer(LejerDTO customer) {
        LejerDAO dao = new LejerDAO();
        try {
            dao.createLejer(customer);
        } catch (IllegalArgumentException e){
            throw new WebApplicationException(e.getMessage(), 415);
        }

        return Response.ok("The resource was created").build();
    }
}
