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
import sun.security.pkcs11.Secmod;





public class Datenbank {
    
    
    
    public static void main(String[] args) {
        
        final String hostname = "LFreyler";
        final String port = "3306";
        final String dbname = "demo";
        final String user = "root";
        final String password = "Lukas";
        
        System.out.println("!");
        try {
            System.out.println("!");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + dbname, user , password);   
            System.out.println("4");
            Statement myStmt = myCon.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from employes");
            System.out.println("!");
            while(myRs.next())
            {
                System.out.println("!");
                System.out.println(myRs.getString("firstname") + myRs.getString("secondname"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
