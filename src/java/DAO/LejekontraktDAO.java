package DAO;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


}
