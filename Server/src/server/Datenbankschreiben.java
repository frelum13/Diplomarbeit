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

/**
 *
 * @author Lukas
 */
public class Datenbankschreiben {
    
    
    
    static void schreiben()
    {
        
        final String hostname = "109.73.158.173";
        final String port = "3306";
        final String dbname = "horse";
        final String user = "root";
        final String password = "Campus02";
        
        
        try {
            try(Connection myCon = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false", user , password)) 
            {
                System.out.println("Mit Datenbank verbunden");
                Statement myStmt = myCon.createStatement();
                String sql ="insert into horses" + "(id,name,age)"+ "values ('5','Mörth','37')";
                myStmt.executeUpdate(sql);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
