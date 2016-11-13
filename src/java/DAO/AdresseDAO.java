package DAO;

import Domain.Adresse;
import Helpers.NamedParameterStatement;
import Helpers.SQLStringHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Helpers.GeneralHelper.isNullOrEmpty;

/**
 * Created by mathias on 12/10/2016.
 */
public class AdresseDAO {
    public Adresse getAdresse(int adresseID){

        return null;
    }

    public ArrayList<Adresse> getAdresser(){
        String query = "SELECT AdresseID, Vej, Nummer, Postnummer, LastUpdated FROM Adresse;";

        ArrayList<Adresse> adresser = null;

        try {

            adresser = new ArrayList<>();
            ResultSet result = ConnectionHelper.getConnection().prepareStatement(query).executeQuery();

            while (result.next()) {
                Adresse nuværendeAdresse = new Adresse(
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

    public Adresse createAdresse(Adresse adresse){
        if (isNullOrEmpty(adresse.getVej()))
            throw new IllegalArgumentException("Ingen vej!");

        if (isNullOrEmpty(adresse.getNummer()))
            throw new IllegalArgumentException("Intet Nummer!");

        if (isNullOrEmpty(adresse.getPostnummer()))
            throw new IllegalArgumentException("Intet postnummer!");

        SQLStringHelper sqlStringHelper = new SQLStringHelper("INSERT INTO Adresse (", "VALUES (");

        sqlStringHelper.addField("Vej", "String");
        sqlStringHelper.addField("Nummer", "String");
        sqlStringHelper.addField("Postnummer", "String");

        try{
            NamedParameterStatement stm = new NamedParameterStatement(ConnectionHelper.getConnection(), sqlStringHelper.getCompleteString());


        for(String[] field : sqlStringHelper.getFields()){
            switch (field[2]){
                case "String":
                    String myString = (String) adresse.getClass().getDeclaredMethod("get" + field[1]).invoke(adresse);
                    stm.setString(field[0], myString);
            }
        }


            stm.execute();

            ResultSet generatedKeys = stm.getStatement().getGeneratedKeys();

            if(generatedKeys.next()) {
                adresse.setAdresseID(generatedKeys.getInt(1));
            }
            // TODO HANDLE THESE EXCEPTIONs
        } catch(SQLException e){
            // This should throw some exception so it can actually be handled in the layer above.
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return adresse;
    }
}
