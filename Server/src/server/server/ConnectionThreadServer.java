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
    private final static Logger log = Logger.getLogger(ConnectionThreadServer.class.getName());
    
    private final Socket socket;

    public ConnectionThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run() {
        
       
        try{
            // Variablen deklaration
            String[] str;
            JSONObject antwort = null;
            String stringantwort = null;
            JSONParser parser = new JSONParser();
            
            log.info("In Connection Thread");
            
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
                        
            // Empfangen 
            JSONObject obj = (JSONObject) parser.parse(r.readLine());
            
            log.info("ConnectionThread:" + obj + "Empfangenes Telegramm");
            str = Jsonendcoding.decoiding(obj);
            log.info("ConnectionThread: Start des Protokolls");
            
            // Aufruf Protokoll
            antwort = Protocol.input(str);
            
            // Umwandeln von Antwort in String
            stringantwort = antwort.toJSONString();
            
            //senden
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
