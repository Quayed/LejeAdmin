package DAO;

import DTO.AdresseDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static Helpers.GeneralHelper.isNullOrEmpty;

/**
 * Created by mathias on 12/10/2016.
 */
public class AdresseDAO {
    private AdresseDTO getAdresse(int adresseID){
        return null;
    }
    private ArrayList<AdresseDTO> getAdresser(){
        return null;
    }
    private void createAdresse(AdresseDTO adresse){
        if (isNullOrEmpty(adresse.getVej()) || isNullOrEmpty(adresse.getNummer()) || isNullOrEmpty(adresse.getPostnummer()))
            throw new IllegalArgumentException("One or more of the arguments are either empty or null");

        String query = "INSERT INTO Adresse (Vej, Nummer, Postnummer)" +
                        "VALUES (?, ?, ?);";
        try{
            PreparedStatement stm = ConnectionHelper.getConnection().prepareStatement(query);
            stm.setString(1, adresse.getVej());
            stm.setString(2, adresse.getNummer());
            stm.setString(3, adresse.getPostnummer());

            stm.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
