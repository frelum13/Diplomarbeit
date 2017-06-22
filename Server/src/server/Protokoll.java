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
//    if (devAddr < 0 || devAddr > 255)
//      throw new IllegalArgumentException("invalid device address");
//    
//    if (addr < 0 || addr > 0x0100)
//      throw new IllegalArgumentException("invalid register address");
//    
//    if (quantity < 0 || quantity > 0x7f)
//      throw new IllegalArgumentException("invalid quantity");
    
    
    final StringBuilder sb = new StringBuilder();
        if(ok == true)
            sb.append(200);
        else
            sb.append(400);
        
        
    
    return sb.toString().getBytes();
  }
  
  private static void addLRC (StringBuilder sb) 
  {
    byte [] ba = sb.toString().getBytes();
    int sum = 0;
    for (int i=1; i<ba.length; i++) {
      sum += sum;
      if (sum > 255) 
        sum  -= 256;
    }
    sum = 255 - sum;
    sum++;
    if (sum > 255) 
      sum  -= 256;
    int value = sum;
    sb.append(String.format("%02X", sum));
  }
  
  private Protokoll () 
  {
    
  }
        
    
}
