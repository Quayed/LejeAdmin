package DAO;

import DTO.LejekontraktDTO;
import Helpers.NamedParameterStatement;
import Helpers.SQLStringHelper;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.reflect.Method;

/**
 * Created by mathias on 24/10/2016.
 */
public class LejekontraktDAO {

    public int uploadFile(String filepath) throws IOException, SQLException{
        File fileToUpload = new File(filepath);
        byte[] pdfData = new byte[(int) fileToUpload.length()];
        DataInputStream in = new DataInputStream(new FileInputStream(fileToUpload));
        in.readFully(pdfData);
        in.close();

        Connection conn = ConnectionHelper.getConnection();

        PreparedStatement stm = conn.prepareStatement("INSERT INTO LejekontraktFil(Fil, Filnavn) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        stm.setBytes(1, pdfData);
        stm.setString(2, filepath.substring(filepath.lastIndexOf('/') +1));

        stm.execute();

        ResultSet generatedKeys = stm.getGeneratedKeys();

        int generatedID = 0;

        if (generatedKeys.next()){
            generatedID = generatedKeys.getInt(1);
        }

        return generatedID;
    }

    public byte[] getLejekontraktFile(String filename) throws IOException, SQLException{
        Connection conn = ConnectionHelper.getConnection();

        PreparedStatement stm = conn.prepareStatement("SELECT * FROM LejekontraktFil WHERE LejekontraktFilID = ? LIMIT 1");

        stm.setString(1, filename);

        ResultSet result = stm.executeQuery();

        if (result.next()){
            byte[] pdfFile = result.getBytes("Fil");
            return pdfFile;
        }

        return null;

    }

    public void createLejekontrakt(LejekontraktDTO lejekontrakt) throws Exception{
        if(lejekontrakt.getLejerID() == 0 || lejekontrakt.getLejemålID() == 0 || lejekontrakt.getBegyndelse() == null || lejekontrakt.getBetalingsstedID() == 0)
            throw new IllegalArgumentException("Required fields not filled");

        Connection conn = ConnectionHelper.getConnection();

        SQLStringHelper sqlStringHelper = new SQLStringHelper("INSERT INTO Lejekontrakt (", "VALUES(");

        sqlStringHelper.addField("LejerID", "Int");
        sqlStringHelper.addField("LejemålID", "Int");
        sqlStringHelper.addField("Begyndelse", "Date");

        if (lejekontrakt.getUdflytningsDato() != null){
            sqlStringHelper.addField("UdflytningsDato", "Date");
        }

        sqlStringHelper.addField("BetalingsstedID", "Int");

        if(lejekontrakt.getDepositumDato() != null){
            sqlStringHelper.addField("DepositumDato", "String");
        }

        if(lejekontrakt.getDepositumBeløb() != null){
            sqlStringHelper.addField("DepositumBeløb", "Double");
        }

        if(lejekontrakt.getForudbetaltLejeDato() != null ){
            sqlStringHelper.addField("ForudbetaltLejeDato", "String");
        }

        if(lejekontrakt.getForudbetaltLejeBeløb() != null){
            sqlStringHelper.addField("ForudbetaltLejeBeløb", "Double");
        }

        if(lejekontrakt.getIndbetalingDato() != null){
            sqlStringHelper.addField("IndbetalingDato", "String");
        }

        if(lejekontrakt.getForudbetaltlejeStartDato() != null){
            sqlStringHelper.addField("ForudbetaltLejeStartDato", "String");
        }

        if(lejekontrakt.getForudbetaltlejeSlutDato() != null){
            sqlStringHelper.addField("ForudbetaltLejeSlutDato", "String");
        }

        if(lejekontrakt.getFørstHusleje() != null){
            sqlStringHelper.addField("FørsteHusleje", "String");
        }

        if(lejekontrakt.getVandregnskabsÅrBegynderDato() != null){
            sqlStringHelper.addField("VandregnskabsÅrBegynderDato", "String");
        }

        if(lejekontrakt.getElregnskabsÅrBeygnderDato() != null){
            sqlStringHelper.addField("ElregnskabsÅrBegynderDato", "String");
        }

        if(lejekontrakt.getVedligeholdelseskontoBeløb() != null){
            sqlStringHelper.addField("VedligeholdelseskontoBeløb", "Double");
        }

        if(lejekontrakt.getSærligeVilkår() != null){
            sqlStringHelper.addField("SærligeVilkår", "String");
        }

        if(lejekontrakt.getUnderskriftUdlejerDato() != null){
            sqlStringHelper.addField("UnderskriftUdlejerDato", "Date");
        }

        if(lejekontrakt.getUnderskriftLejerDato() != null){
            sqlStringHelper.addField("UnderskriftLejerDato", "Date");
        }

        NamedParameterStatement stm = new NamedParameterStatement(conn, sqlStringHelper.getCompleteString());

        for (String[] field : sqlStringHelper.getFields()) {
            switch (field[2]){
                case "String":
                    String myString = (String) lejekontrakt.getClass().getDeclaredMethod("get" + field[1]).invoke(lejekontrakt);
                    stm.setString(field[0], myString);
                    break;
                case "Int":
                    int myInteger = (int) lejekontrakt.getClass().getDeclaredMethod("get" + field[1]).invoke(lejekontrakt);
                    stm.setInt(field[0], myInteger);
                    break;
            }
        }

    }
}
