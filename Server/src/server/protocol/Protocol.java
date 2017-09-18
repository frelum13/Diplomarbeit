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
        String info = null;
        Stringsplit spliten = null;
        Stringsplit split = new Stringsplit(msg, ";");
        
        String[] str = split.getStr();
       
        System.out.println("In Input verarbeiten");
            switch(str[0])
            {
                case "get":
                    
                break;
                case "water":
                    
                    System.out.format("%s\n",str[1]);
                    
                    return "on";
                case "stop":
                break;
                case "new":
                    spliten = new Stringsplit(str[1], ",");
                    String[] inserthorse = spliten.getStr();
                    
                    Datenbankschreiben.schreiben("horses", inserthorse);
                break;
                case "deletehorse":
                    
                    //new Datenbankloeschen(name).start;
                    
                break;
                case "deleteuser":
                break;
                case "infohorse":
                    
                    info = Datenbanklesen.lesen(str[1], "infohorse");
                    return info;
                    
                case "infouser":
                    
                    info = Datenbanklesen.lesen(str[1], "infouser");
                    return info;
   
                case "registrate":
                    spliten = new Stringsplit(str[1], ",");
                    String[] registrate = spliten.getStr();
                    
                    Datenbankschreiben.schreiben("login", registrate);
                    
                    return "";
                case "login":
                      Stringsplit splitten = new Stringsplit(str[1], ",");
                      String[] login = splitten.getStr();
                      
                       for (String login1 : login) {
                        System.out.format("%s\n", login1);
                        }
                      
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
