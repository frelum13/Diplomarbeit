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
public class InputVerarbeiten {
    
    private final String string;

    public InputVerarbeiten(String string) {
        this.string = string;
    }
    
     public boolean LRCuebpruefen(String lrc,String data)
    {
        byte [] ba = data.getBytes();
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
        
        String format = String.format("%02X", sum);
        
        return format == null ? lrc == null : format.equals(lrc);
        
    }
    
    
    private void input(String msg)
    {
        final int stringlength = string.length();
        String lrc = string.substring(stringlength-2);
        String data = string.substring(0, stringlength-2);
        
        
        
        boolean vergleich = LRCuebpruefen(lrc,data);
        
        System.out.println(vergleich);
        
        if(vergleich == true)
        {
            switch(data)
            {
                case "get":
                    
                break;
                case "send":
                break;
                case "wateron":
                break;
                case "wateroff":
                break;
                case "stop":
                break;
                case "new":
                break;
                case "delete":
                break;
                case "toedit":
                break;
                
            }
        }
    }
    
    private static void ausfuehren()
    {
        new InputVerarbeiten();
    }
   
}
