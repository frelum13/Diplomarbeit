/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.test;

/**
 *
 * @author Lukas
 */

import java.sql.*;






public class Datenbank {
    
    
    
    public static void main(String[] args) {
        
        final String hostname = "192.168.0.6";
        final String port = "3306";
        final String dbname = "horse";
        final String user = "Lukas";
        final String password = "Campus02";
        
        
        try {
            try(Connection myCon = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false", user , password)) {
                Statement myStmt = myCon.createStatement();
                String sql ="insert into employes" + "(id,firstname,secondname,email)"+ "values ('2','Marina','Spari','test@test.at')";
                myStmt.executeUpdate(sql);
                ResultSet myRs = myStmt.executeQuery("select * from employes");
                while(myRs.next())
                {
                    System.out.println(myRs.getString("firstname") + " " + myRs.getString("secondname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
