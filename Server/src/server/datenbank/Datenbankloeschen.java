/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lukas
 */
public class Datenbankloeschen {
    
    public static String loeschen(String table, String name)
    {   
        
        try {
            
                String sql;
            
                Connect connect = new Connect("horse");
                Connection myCon = connect.getConn();
            
                System.out.println("Mit Datenbank verbunden");
                Statement myStmt = myCon.createStatement();
                if(table == "login")
                {
                    sql ="DELETE FROM login WHERE username = '" + name + "'";
                    
                }
                else
                {
                    sql = "DELETE FROM horses WHERE name = '" + name + "'";
                    
                }
                myStmt.executeUpdate(sql);
                return "true";
                           
        } catch (SQLException e) {
            e.printStackTrace();
            return "err02";
        }
    }
    
}
