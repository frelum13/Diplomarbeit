/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
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
    String serverAdress = JOptionPane.showInputDialog("IP");
    InetAddress address = InetAddress.getByName(serverAdress);
    Socket s = new Socket(address, 5555);
    BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    String answer = input.readLine();
    JOptionPane.showMessageDialog(null, answer);
    System.exit(0);
    
  }
  
}
