package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 *
 * @author steiner
 */
public class Client
{
  private final String host;
  private final int port;

  public Client (String host, int port)
  {
    this.host = host;
    this.port = port;
  }
  
  public void start () throws IOException {
    final Socket socket = new Socket();
    try
    {
      socket.connect(new InetSocketAddress(host, port), 3000);
      socket.setSoTimeout(0);
      final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      w.write("Lukas Laptop\n");
      w.flush();
      String msg = r.readLine();
      System.out.println("Message from server: " + msg);
    }
    catch (IOException ex) 
    {
      System.out.println("Fehler aufgetreten");
      ex.printStackTrace(System.out);
    }
    finally
    {
      socket.close();
      System.out.println("socket closed");
    }
    
  }
  
  public static void main (String[] args) throws IOException
  {
    //new Client("127.0.0.1", 8080).start();
    new Client("127.0.0.1", 1111).start();
  }
}
