//package server;
//
//import java.sql.Connection;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DatenbankLogin {
//    
//    static void registrate()
//    {
//        try
//        {
//            Conection connect = new Conection("login");
//            Connection conn = connect.getConn(); 
//            Statement st = conn.createStatement();
//            
//            
//            String sql = ("SELECT * FROM login;");
//                
//            ResultSet myRs = st.executeQuery(sql);
//                
//            while (myRs.next()) {
//                System.out.println("Name: " + myRs.getString(5));
//                
//            }
//        } catch (SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//
//    }
//}
