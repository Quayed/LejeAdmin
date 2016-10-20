/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AdresseDTO;
import DTO.LejerDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Helpers.GeneralHelper.isNullOrEmpty;

/**
 *
 * @author mathias
 */
public class LejerDAO {

    public LejerDAO(){

    }

    public LejerDTO createLejer(LejerDTO lejer) throws IllegalArgumentException{
        // validate all of the customer information
        if (isNullOrEmpty(lejer.getType()) || isNullOrEmpty(lejer.getFornavn()) || isNullOrEmpty(lejer.getIdentifikation()) ||
            isNullOrEmpty(lejer.getEmail()) || isNullOrEmpty(lejer.getTlfNummer())){
            throw new IllegalArgumentException("One or more of the required fields has not been set!");
        }


        // TODO do more validation on the incoming data

        String queryFields = "Type, Fornavn ";
        String queryParameters = "?, ?";
        int paramCounter = 1;

        if (!isNullOrEmpty(lejer.getEfternavn())){
            queryFields += ", Efternavn ";
            queryParameters += ", ?";
        }

        if (lejer.getAdresseID() != 0){
            queryFields += ", AdresseID";
            queryParameters += ", ?";
        }

        queryFields += ", Identifikation, Email, TlfNummer";
        queryParameters += ", ?, ?, ?";

        String query = "INSERT INTO Lejer (" + queryFields + ") VALUES(" + queryParameters + ");";

        try {
            PreparedStatement stm = ConnectionHelper.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(paramCounter++, lejer.getType());
            stm.setString(paramCounter++, lejer.getFornavn());
            if(!isNullOrEmpty(lejer.getEfternavn()))
                stm.setString(paramCounter++, lejer.getEfternavn());
            if(lejer.getAdresseID() != 0)
                stm.setInt(paramCounter++, lejer.getAdresseID());
            stm.setString(paramCounter++, lejer.getIdentifikation());
            stm.setString(paramCounter++, lejer.getEmail());
            stm.setString(paramCounter, lejer.getTlfNummer());

            stm.execute();

            ResultSet generatedKeys = stm.getGeneratedKeys();

            if (generatedKeys.next())
                lejer.setLejerID(generatedKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lejer;
    }

    // Method for getting all of the customers.
    public ArrayList<LejerDTO> getLejere() {
        String query = "SELECT * FROM Lejer";
        ArrayList<LejerDTO> lejere = null;
        //try {
        ResultSet result = null;
        try {
            lejere = new ArrayList<>();

            result = ConnectionHelper.getConnection().prepareStatement(query).executeQuery();

        while(result.next()){
                LejerDTO nuværendeLejer = new LejerDTO(
                        result.getString("Type"),
                        result.getString("Fornavn"),
                        result.getString("Efternavn"),
                        result.getInt("AdresseID"),
                        result.getString("Identifikation"),
                        result.getString("Email"),
                        result.getString("TlfNummer"),
                        result.getTimestamp("LastUpdated")
                );
                nuværendeLejer.setLejerID(result.getInt("LejerID"));
                lejere.add(nuværendeLejer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lejere;
    }

    public LejerDTO getLejer(int lejerID) throws IllegalArgumentException{
        // Check that the id is actually possible
        if (lejerID <= 0){
            throw new IllegalArgumentException("The id can't be less than one.");
        }
        LejerDTO lejer = null;
        try {
            String query  = "SELECT " +
                    "Lejer.LejerID," +
                    "Lejer.Type," +
                    "Lejer.Fornavn," +
                    "Lejer.Efternavn," +
                    "Lejer.AdresseID," +
                    "Lejer.Identifikation," +
                    "Lejer.Email," +
                    "Lejer.TlfNummer," +
                    "Lejer.LastUpdated," +
                    "Adresse.Vej," +
                    "Adresse.Nummer," +
                    "Adresse.Postnummer," +
                    "Adresse.LastUpdated " +
                    "FROM Lejer " +
                    "LEFT JOIN Adresse on Lejer.AdresseID = Adresse.AdresseID " +
                    "WHERE Lejer.LejerID = ?;";
            PreparedStatement stm = ConnectionHelper.getConnection().prepareStatement(query);
            stm.setInt(1, lejerID);
            ResultSet result = stm.executeQuery();

            if(!result.next())
                return null;

            lejer = new LejerDTO(
                    result.getString("Lejer.Type"),
                    result.getString("Lejer.Fornavn"),
                    result.getString("Lejer.Efternavn"),
                    result.getInt("Lejer.AdresseID"),
                    result.getString("Lejer.Identifikation"),
                    result.getString("Lejer.Email"),
                    result.getString("Lejer.TlfNummer"),
                    result.getTimestamp("Lejer.LastUpdated")
            );
            lejer.setLejerID(result.getInt("LejerID"));

            if(result.getInt("Lejer.AdresseID") != 0){
                lejer.setAdresse(new AdresseDTO(result.getString("Adresse.Vej"),
                        result.getString("Adresse.Nummer"), result.getString("Adresse.Postnummer")));
                lejer.getAdresse().setAdresseID(result.getInt("Lejer.AdresseID"));
                lejer.getAdresse().setLastUpdated(result.getTimestamp("Adresse.LastUpdated"));
            }


        } catch (SQLException e) {
            // Something should be done to tell the user of this method wether their query was wrong or the internet is down.
            e.printStackTrace();
        }
        return lejer;
    }

}
