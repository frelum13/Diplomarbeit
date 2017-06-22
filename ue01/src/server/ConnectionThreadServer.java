/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lukas
 */
public class ConnectionThreadServer implements Runnable
{
    
    private final Socket socket;

    public ConnectionThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run() {
    
        try{
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
            w.write("Hallo Lukas\n");
            w.flush();
            String msg = r.readLine();
            System.out.format("%s",msg);
        }
        catch (IOException ex) {
            Logger.getLogger(ConnectionThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }        
        finally
        {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        }
}
