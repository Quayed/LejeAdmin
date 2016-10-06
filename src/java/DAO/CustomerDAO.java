/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CustomerDTO;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mathias
 */
public class CustomerDAO {

    public CustomerDAO(){

    }

    public CustomerDTO[] getCustomers(){
        String query = "SELECT * FROM customer";
        try {
            ResultSet result = ConnectionHelper.getConnection().prepareStatement(query).executeQuery();
            while(result.next()){
                CustomerDTO currentCustomer = new CustomerDTO(
                        result.getInt("id"),
                        result.getString("navn"),
                        result.getString("vejNavn"),
                        result.getString("husNr"),
                        result.getString("byNavn"),
                        result.getString("postNr"),
                        result.getString("cprNr"),
                        result.getString("email"),
                        result.getString("tlfNr")
                );
            }
        } catch (SQLException e) {
            // TODO Think about if this can be handled nicely
            e.printStackTrace();
        }
        return null;
    }
    
}
