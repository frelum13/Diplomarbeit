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
public class Datenbankschreiben {
    
    
    
    public static String schreiben(String table, String[] inhalt)
    {   
        
        try {
            
                String sql;
            
                Connect connect = new Connect("horse");
                Connection myCon = connect.getConn();
            
                System.out.println("Mit Datenbank verbunden");
                Statement myStmt = myCon.createStatement();
                if(table == "login")
                {
                    sql ="insert into "+ table + 
                            "(firstname,secondname,username,password)"+ 
                            "values ('" + inhalt[0] + "','" + inhalt[1] + "','" + inhalt[2] + "','" + inhalt[3] + "')";
                }
                else
                {
                    sql ="insert into "+ table + "(id,name,age)"+ "values ('5','" + inhalt[0] + "','" + inhalt[1] + "')";
                }
                myStmt.executeUpdate(sql);
                           
        } catch (SQLException e) {
            e.printStackTrace();
            return "err02";
        }
        return "true";
    }
    
}
