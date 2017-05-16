/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ue01;

import java.net.ServerSocket; 
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
/**
 *
 * @author Lukas
 */
public class Ue01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws Exception
    {
        String write = "geill";
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true)
            {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(write);
                }
                finally
                {
                    socket.close();
                }
            }
            
        } 
        finally {
            listener.close();
        }
        
    }
    
}
