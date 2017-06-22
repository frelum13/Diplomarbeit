
package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author steiner
 */
public class Server
{
  private final int port;

  public Server (int port)
  {
    this.port = port;
  }
    
public void start() throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(port);
    // accept blockiert Programmablauf bis ein Client
    // eine Verbindung herstellt (SYN, SYN+ACK, ACK)
    while (true)
    {
      Socket socket = serverSocket.accept();
      socket.setSoTimeout(0);
      System.out.println("Verbindung hergstellt: " + socket);
      new Thread(new server.ConnectionThreadServer(socket)).start();
    }
    
//            serverSocket.close();
//            System.out.println("socket closed");
  }

  public static void main (String[] args) throws IOException
  {
    new Server(1111).start();
  }
  
}
