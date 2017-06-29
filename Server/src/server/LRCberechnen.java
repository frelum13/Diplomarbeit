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
public class LRCberechnen {
    
    final StringBuilder sb;

    public LRCberechnen(StringBuilder sb) {
        this.sb = sb;
    }
    
    private static void addLRC()
    {
        byte [] ba = sb.toString().getBytes();
        int sum = 0;
        for (int i=1; i<ba.length; i++) 
        {
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
}
