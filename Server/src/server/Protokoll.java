/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Lukas
 */
public class Protokoll {
    
    public static byte [] createRequestReadRegister(boolean ok)
  {

    final StringBuilder sb = new StringBuilder();
        if(ok == true)
            sb.append(200);
        else
            sb.append(400);
        
        
    
    return sb.toString().getBytes();
  }
  
  private static void addLRC (StringBuilder sb) 
  {
   
  }
  
  private Protokoll () 
  {
    
  }
        
    
}
