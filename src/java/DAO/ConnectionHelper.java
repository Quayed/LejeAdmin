package DAO;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by mathias on 06/10/2016.
 */
public class ConnectionHelper {
    private static Connection conn;

    private ConnectionHelper(){

    }

    public static Connection getConnection(){
        // If the connection has not yet been set, set it.
        if (conn == null)
            try {
                javax.naming.Context ctx = new InitialContext();
                javax.naming.Context envCtx = (javax.naming.Context) ctx.lookup("java:comp/env");
                DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/LejeDB");
                conn = ds.getConnection();
            } catch(NamingException | SQLException e){
                // TODO HANDLE THIS ERROR IN A GOOD WAY
                e.printStackTrace();
            }
        // return the connection, which at this point will be set - unless an exception has happend.
        return conn;
    }
}
