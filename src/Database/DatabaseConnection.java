package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String SCONN = ("jdbc:sqlite:HospitalDatabase.db");

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SCONN);
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
