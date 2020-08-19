package LoginApp;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    Connection connection;

    public LoginModel(){
        try{
            this.connection = DatabaseConnection.getConnection();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        if(this.connection == null){
            System.exit(1);
        }
    }
    public boolean isDatabaseConnected(){

        return this.connection !=null;
    }
    public boolean isLogin(String Username, String Password, String Division) throws Exception{

        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Login WHERE Username = ? and Password = ? and Division = ?";

        try{
            pr = this.connection.prepareStatement(sql);

            pr.setString(1, Username);
            pr.setString(2, Password);
            pr.setString(3, Division);

            rs = pr.executeQuery();

            boolean bool;

            if(rs.next()){
                return true;
            }
            return false;
        }
        finally {
            pr.close();
            rs.close();
        }
    }
}
