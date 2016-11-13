/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.AdresseDAO;
import Domain.Adresse;
import Helpers.JsonHelper;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

import static Helpers.GeneralHelper.getDateAsString;
import static javax.json.Json.createObjectBuilder;

/**
 * REST Web Service
 *
 * @author mathias
 */
@Path("adresse")
public class AdresseResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdresseResource
     */
    public AdresseResource() {
    }

    /**
     * Retrieves representation of an instance of api.AdresseResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdresser() throws SQLException{
        ArrayList<Adresse> adresser = new AdresseDAO().getAdresser();

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        for(Adresse adresse : adresser){
            JsonObjectBuilder builder = createObjectBuilder()
                    .add("AdresseID", adresse.getAdresseID())
                    .add("Vej", adresse.getVej())
                    .add("Nummer", adresse.getNummer())
                    .add("Postnummer", adresse.getPostnummer())
                    .add("LastUpdated", getDateAsString(adresse.getLastUpdated()));

            jsonArrayBuilder.add(builder);
        }

        JsonHelper helper = new JsonHelper();

        String returnString = helper.jsonArrayToString(jsonArrayBuilder.build());


        return Response.ok(returnString).build();
    }

    /**
     * POST method for updating or creating an instance of AdresseResource
     * @param adresse represents the adress to be created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAdresse(Adresse adresse) throws Exception{
        AdresseDAO dao = new AdresseDAO();
        try{
            adresse = dao.createAdresse(adresse);
        } catch(IllegalArgumentException e){
            throw new WebApplicationException(e.getMessage(), 415);
        }

        JsonObject returnAdresse = createObjectBuilder()
                .add("AdresseID", adresse.getAdresseID())
                .add("Vej", adresse.getVej())
                .add("Nummer", adresse.getNummer())
                .add("Postnummer", adresse.getPostnummer()).build();

        return Response.ok(new JsonHelper().jsonObjectToString(returnAdresse)).build();
    }
}
