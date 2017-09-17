/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Lukas
 */
public class Loginueberpruefen {
    
    
    public static boolean ueberpruefen(String name, String tabelle) 
    {
        boolean check = false;
        
        System.out.format("%s\n",name);
        name = "'" + name + "'";
        try
        {
            String sql;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Loginüberprüfen: vor dem connecten");

            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();

                       
            System.out.println("Loginüberprüfen: Mit Datenbank verbunden");
                
            Statement st = conn.createStatement();

            System.out.println("Statment");
            
            if(tabelle == "login")
                sql = ("SELECT * FROM login WHERE username = " + name);         
            else
                sql = ("SELECT * FROM horse WHERE name = " + name);
            ResultSet myRs = st.executeQuery(sql);
            
            check = myRs.next();
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            System.out.println(check);
            return check;
        }
    }
}
