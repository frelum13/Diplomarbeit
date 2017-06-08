/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
/**
 *
 * @author lukas
 */
public class Dip01
{

  /**
   * @param args the command line arguments
   */
  public static void main (String[] args)
          throws IOException
  {
    String serverAdress = "192.168.0.122";
    Socket s = new Socket();
    s.connect(new InetSocketAddress(serverAdress, 9090), 2000);
    s.setSoTimeout(2000);
    
    //BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    //String answer = input.readLine();
    PrintWriter writer = new PrintWriter(s.getOutputStream(),true);
    writer.println("Lukas Laptop");
 
    //JOptionPane.showMessageDialog(null, answer);
    System.exit(0);
    
  }
  
}
