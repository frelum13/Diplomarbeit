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
public class Protocol {
      

    static void input(String msg)
    {
        Stringsplit split = new Stringsplit(msg, ";");
        
        String[] str = split.getStr();
       
        System.out.println("In Input verarbeiten");
            switch(str[0])
            {
                case "get":
                    
                break;
                case "send":
                    
                    //new Datenbanklesen(name).start;
                    
                break;
                case "water":
                    
                    System.out.format("%s\n",str[1]);
                    
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
                case "login":
                      Stringsplit splitten = new Stringsplit(str[1], ",");
                      String[] login = splitten.getStr();
                      
                      for(int i = 0; i<=login.length;i++)
                          System.out.format("%s\n",login[i]);
                      
                      Loginueberpruefen.ueberpruefen(login[0]);
                break;
                default:
                    System.out.println("Falsche Anweisung");
                
            }
        
    }
    

   
}
