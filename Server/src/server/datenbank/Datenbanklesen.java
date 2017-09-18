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
import server.string.Strinbuild;

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
            int i;
            String sql;
            String[] liste = null;
            ResultSet myRs;
            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();
            
            Statement st = conn.createStatement();
            
            switch(read)
            {
                case "Password":
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
                    myRs = st.executeQuery(sql);
                    while (myRs.next()) {
                          
                        System.out.println("Password: " + myRs.getString(5));
                        return myRs.getString(5);
                    }
                break;
                case "Infouser":
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
                    myRs = st.executeQuery(sql);
                    while (myRs.next()) {
                        for(i=1; i<=5; i++)
                             liste[i-1]=myRs.getString(i);
                        
                        
                        return Strinbuild.stringbuild(liste);
                    }
                case "Infohorse":
                    sql =  "SELECT * FROM horses WHERE name = '" + name + "'";
                    myRs = st.executeQuery(sql);
                    while (myRs.next()) {
                        for(i=1; i<=3; i++)
                             liste[i-1]=myRs.getString(i);
                        
                        
                        return Strinbuild.stringbuild(liste);
                    }
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