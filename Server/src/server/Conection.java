/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Lukas
 */
public class Conection {
    
    
        private final String hostname = "109.73.158.173";
        private final String port = "3306";
        private final String dbname;
        private final String user = "root";
        private final String password = "Campus02";
        private String url;
        //private Connection conn;

        public Conection(String dbname) {
            this.dbname = dbname;
            
            conection();
        }
        
        private void conection()
        {
        
            System.out.println("LoginConnection: Beim Connecten");
            //                Properties connectionProps = new Properties();
//                connectionProps.put("user", user);
//                connectionProps.put("password", password);

            //Class.forName("com.mysql.jdbc.Driver");
            //"jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false", user , password
            url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false";
            System.out.format("%s",url);
            //conn = DriverManager.getConnection(url, connectionProps);
            
            
        }

    public String getUrl() {
        return url;
    }
   
        
        
    
}
