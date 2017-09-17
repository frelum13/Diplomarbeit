/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.protocol;

import server.datenbank.Datenbanklesen;
import server.string.Stringsplit;
import server.datenbank.Loginueberpruefen;
import server.datenbank.Datenbankschreiben;



/**
 *
 * @author Lukas
 */
public class Protocol {
      

    public static String input(String msg)
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
                    
                    return "Blabla";
                case "stop":
                break;
                case "info":
                break;
                case "new":
                    //Datenbankschreiben.schreiben("horse", "");
                break;
                case "delete":
                    
                    //new Datenbankloeschen(name).start;
                    
                break;
                case "toedit":
                    
                    //new Datenbanklesen(name).start;
                    
                break;
                case "registrate":
                    Stringsplit spliten = new Stringsplit(str[1], ",");
                    String[] registrate = spliten.getStr();
                    
                    Datenbankschreiben.schreiben("login", registrate);
                    
                break;
                case "login":
                      Stringsplit splitten = new Stringsplit(str[1], ",");
                      String[] login = splitten.getStr();
                      
                      for(int i = 0; i<login.length;i++)
                          System.out.format("%s\n",login[i]);
                      
                      boolean abfrage = Loginueberpruefen.ueberpruefen(login[0],"login");
                      if(abfrage = true)
                      {
                         Datenbanklesen.lesen("Password",login[1]);
                         return "true";
                      }
                      else
                      {
                          return "Error4";
                      }
                default:
                    System.out.println("Falsche Anweisung");
                    return "Error4";
                
            }
        return "Error4";
    }
}
