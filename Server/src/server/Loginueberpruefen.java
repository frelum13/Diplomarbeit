/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lukas
 */
public class Loginueberpruefen {
    
    
    static void ueberpruefen(String name) 
    {
        try
        {
            System.out.println("Loginüberprüfen: vor dem connecten");
            
            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();
            
            System.out.println("Loginüberprüfen: Mit Datenbank verbunden");
            
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM login WHERE firstname = " + "'" + name + "'");
            
            ResultSet myRs = st.executeQuery(sql);
           
            if(myRs.next())
                System.out.println("true");
            else
                System.out.println("false");
            
            
            conn.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }
}
