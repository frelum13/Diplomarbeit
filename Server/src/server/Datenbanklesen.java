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

    private final String data;

    public Datenbanklesen(String data) {
        this.data = data;
        
        lesen();
    }    
    
    
    private void lesen()
    {
        final String hostname = "192.168.0.6";
        final String port = "3306";
        final String dbname = "horse";
        final String user = "root";
        final String password = "Campus02";

        try
        {
            Connection conn;
            Properties connectionProps = new Properties();
            connectionProps.put("user", user);
            connectionProps.put("password", password);

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
            conn = DriverManager.getConnection(url, connectionProps);
            
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM horses;");
            
            ResultSet myRs = st.executeQuery(sql);
            
            int colum = myRs.getMetaData().getColumnCount();
            
            System.out.println(myRs.getMetaData().getColumnLabel(2));

            conn.close();
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }
}