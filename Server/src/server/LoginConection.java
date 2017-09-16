/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Lukas
 */
public class LoginConection {
    
    
        private final String hostname = "109.73.158.173";
        private final String port = "3306";
        private final String dbname;
        private final String user = "root";
        private final String password = "Campus02";
        private Connection conn;

        public LoginConection(String dbname) {
            this.dbname = dbname;
            
            conection();
        }
        
        private void conection()
        {
        
            try {
                System.out.println("LoginConnection: Beim Connecten");
                Properties connectionProps = new Properties();
                connectionProps.put("user", user);
                connectionProps.put("password", password);

                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false";
                conn = DriverManager.getConnection(url, connectionProps);
                
            }
            catch(SQLException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            
            
        }

    public Connection getConn() {
        return conn;
    }
        
        
    
}
