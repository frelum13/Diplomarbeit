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
    
    
    static void input(String msg)
    {
//        final int stringlength = string.length();
//        String lrc = string.substring(stringlength-2);
//        String data = string.substring(0, stringlength-2);
//        
//        
//        
//        boolean vergleich = LRCuebpruefen(lrc,data);
//        
//        System.out.println(vergleich);
//        
//        if(vergleich == true)
//  
        
        System.out.println("In Input verarbeiten");
            switch(msg)
            {
                case "get":
                    
                break;
                case "send":
                    
                    //new Datenbanklesen(name).start;
                    
                break;
                case "wateron":
                break;
                case "wateroff":
                break;
                case "stop":
                break;
                case "new":
                    Datenbankschreiben.schreiben();
                break;
                case "delete":
                    
                    //new Datenbankloeschen(name).start;
                    
                break;
                case "toedit":
                    
                    //new Datenbanklesen(name).start;
                    
                break;
                
            }
        
    }
    

   
}
