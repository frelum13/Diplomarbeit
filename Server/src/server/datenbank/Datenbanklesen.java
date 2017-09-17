/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marinaspari
 */
public class Datenbanklesen
{
  
    public static String lesen(String read, String name)
    {
        try
        {
            String sql;
            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();
            
            Statement st = conn.createStatement();
            
            switch(read)
            {
                case "Password":
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
                    ResultSet myRs = st.executeQuery(sql);
                    while (myRs.next()) {
                          
                        System.out.println("Password: " + myRs.getString(5));
                        return myRs.getString(5);
                    }
                break;
                case "Infouser":
                break;
                case "Infohorse":
                break;
                    
            }            
                      
            
            
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}