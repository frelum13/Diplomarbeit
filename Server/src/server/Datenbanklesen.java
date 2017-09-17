/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author marinaspari
 */
public class Datenbanklesen
{
  
    static void lesen() throws SQLException
    {
        try
        {
            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();
            
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM tabellenName WHERE spaltenName = wert;");
            
            ResultSet myRs = st.executeQuery(sql);
            
            while (myRs.next()) {
                
                System.out.println("Name: " + myRs.getString(3));
            }
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}