package server.server;

import server.protocol.Protocol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import json.Jsonendcoding;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ConnectionThreadServer implements Runnable
{
    
    private final Socket socket;

    public ConnectionThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run() {
    
        try{
            JSONObject json; 
            System.out.println("Im connection Thread");
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
            JSONObject obj = new JSONObject(jsonString.toString(r.readLine()));
            System.out.format("%s\n", obj);
            
            //String antwort = Protocol.input(msg);
            Jsonendcoding.decoiding(obj);
            
            
            w.write(/*antwort*/"Hallo");
            w.flush();
            
             
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
