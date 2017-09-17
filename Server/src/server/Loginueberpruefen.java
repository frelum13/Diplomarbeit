/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

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
    
    
    static void ueberpruefen(String name) 
    {
        System.out.format("%s\n",name);
        String name2 = "'" + name + "'";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Loginüberprüfen: vor dem connecten");
            
<<<<<<< HEAD
//            Conection connect = new Conection("horse");
//            String url = connect.getUrl();
//            System.out.format("url = %s\n",url);
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.6:3306/horse?useSSL=false","root","Campus02");
=======
            Connect connect = new Connect("horse");
            Connection conn = connect.getConn();
>>>>>>> 9dcbf0be50d9a850da9145797a265562125d909f
            
            System.out.println("Loginüberprüfen: Mit Datenbank verbunden");
                
            Statement st = conn.createStatement();
<<<<<<< HEAD
            System.out.println("Statment");
            String sql = ("SELECT * FROM login WHERE firstname = " + name2);
                
=======
            String sql = ("SELECT * FROM login WHERE firstname = " + "'" + name + "'");
            
>>>>>>> 9dcbf0be50d9a850da9145797a265562125d909f
            ResultSet myRs = st.executeQuery(sql);
                
            if(myRs.next())
                System.out.println("true");
            else
                System.out.println("false");
            
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }
}
