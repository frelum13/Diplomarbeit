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
  
    static void lesen() 
    {
        final String hostname = "109.73.158.173";
        final String port = "3306";
        final String dbname = "horse";
        final String user = "root";
        final String password = "Campus02";
        final String name = "'Lisa'";

        try
        {
            Connection conn;
            Properties connectionProps = new Properties();
            connectionProps.put("user", user);
            connectionProps.put("password", password);

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false";
            conn = DriverManager.getConnection(url, connectionProps);
            
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM horses Where name = " + name);
            
            ResultSet myRs = st.executeQuery(sql);
            
            while (myRs.next()) {
                System.out.println("Name: " + myRs.getString(3));
            }
            
//            int colum = myRs.getMetaData().getColumnCount();
//            
//            System.out.println(myRs.getMetaData().getColumnLabel(2));

            conn.close();
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }
}