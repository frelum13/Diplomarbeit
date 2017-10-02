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
 * @author Lukas
 */
public class Loginueberpruefen {
    
    private final String name;
    private final String tabelle;

    private String check;
    
    public Loginueberpruefen(String name, String tabelle) {
        this.name = name;
        this.tabelle = tabelle;
        
        ueberpruefen();
    }
    
    private void ueberpruefen() 
    {
        
        try
        {
            String sql;
            boolean abfrage = false;
            
            System.out.println("Loginüberprüfen: vor dem connecten");

            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();

                       
            System.out.println("Loginüberprüfen: Mit Datenbank verbunden");
            Statement st = conn.createStatement();
            System.out.println("Statment");
            
            if(tabelle == "login")
                sql = ("SELECT * FROM login WHERE username = " + "'" + name + "'");         
            else
                sql = ("SELECT * FROM horse WHERE name = " + "'" + name + "'");
            ResultSet myRs = st.executeQuery(sql);
            
            abfrage = myRs.next();
            
            check = String.valueOf(abfrage);
            
        } catch (SQLException ex)
        {
            check = "false";
        }
    }

    public String getCheck() {
        return check;
    }
}
