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
import server.json.Jsonendcoding;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConnectionThreadServer implements Runnable
{
    
    private final Socket socket;

    public ConnectionThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run() {
    
        try{
            String[] str;
            JSONObject antwort = null;
            String stringantwort = null;
            System.out.println("Im connection Thread");
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
                        
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(r.readLine());
            
            System.out.format("%s\n", obj);
            str = Jsonendcoding.decoiding(obj);
            System.out.println("vor dem Protocol");
            antwort = Protocol.input(str);
            
            stringantwort = antwort.toJSONString();
            
            w.write(stringantwort);
            w.flush();
            
             
        }
        catch (IOException ex) {
            Logger.getLogger(ConnectionThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
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
