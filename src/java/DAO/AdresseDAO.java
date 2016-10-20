package DAO;

import DTO.AdresseDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Helpers.GeneralHelper.isNullOrEmpty;

/**
 * Created by mathias on 12/10/2016.
 */
public class AdresseDAO {
    public AdresseDTO getAdresse(int adresseID){

        return null;
    }

    public ArrayList<AdresseDTO> getAdresser(){
        String query = "SELECT AdresseID, Vej, Nummer, Postnummer, LastUpdated FROM Adresse;";

        ArrayList<AdresseDTO> adresser = null;

        try {

            adresser = new ArrayList<>();
            ResultSet result = ConnectionHelper.getConnection().prepareStatement(query).executeQuery();

            while (result.next()) {
                AdresseDTO nuværendeAdresse = new AdresseDTO(
                        result.getString("Vej"),
                        result.getString("Nummer"),
                        result.getString("Postnummer")
                );
                nuværendeAdresse.setAdresseID(result.getInt("AdresseID"));
                nuværendeAdresse.setLastUpdated(result.getTimestamp("LastUpdated"));
                adresser.add(nuværendeAdresse);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return adresser;


    }

    public AdresseDTO createAdresse(AdresseDTO adresse){
        if (isNullOrEmpty(adresse.getVej()))
            throw new IllegalArgumentException("Ingen vej!");

        if (isNullOrEmpty(adresse.getNummer()))
            throw new IllegalArgumentException("Ingen Nummer!");

        if (isNullOrEmpty(adresse.getPostnummer()))
            throw new IllegalArgumentException("Ingen postnummer!");

        String query = "INSERT INTO Adresse (Vej, Nummer, Postnummer)" +
                        "VALUES (?, ?, ?);";
        try{
            PreparedStatement stm = ConnectionHelper.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, adresse.getVej());
            stm.setString(2, adresse.getNummer());
            stm.setString(3, adresse.getPostnummer());

            stm.execute();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if(generatedKeys.next()) {
                adresse.setAdresseID(generatedKeys.getInt(1));
            }
        } catch(SQLException e){
            // This should throw some exception so it can actually be handled in the layer above.
            e.printStackTrace();
        }

        return adresse;
    }
}
