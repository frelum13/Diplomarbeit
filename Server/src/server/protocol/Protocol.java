/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.protocol;

import server.datenbank.Datenbanklesen;
import server.datenbank.Datenbankloeschen;
import server.string.Stringsplit;
import server.datenbank.Loginueberpruefen;
import server.datenbank.Datenbankschreiben;



/**
 *
 * @author Lukas
 */
public class Protocol {
      

    public static String input(String[] str)
    {
        String info = null;
        Stringsplit spliten = null;
       
        System.out.println("In Input verarbeiten");
            switch(str[0])
            {
                case "get":
                    
                break;
                case "water":
                    
                    System.out.format("%s\n",str[1]);
                    
                    return str[1];
                case "stop":
                break;
                case "new":
                    String[] inserthorse = null;
                    for(int j = 1; j < str.length; j++)
                        inserthorse[j-1] = str[j]; 
                    
                    Datenbankschreiben.schreiben("horses", inserthorse);
                break;
                case "updatehorse":
                case "updatelogin":
                case "deletehorse":
                    
                    Datenbankloeschen.loeschen("login", str[1]);
                    
                    return "Pferd " + str[1] + " wurde erfolgreich geloescht";
                case "deleteuser":
                    
                    Datenbankloeschen.loeschen("horses", str[1]);
                    
                    return "User " + str[1] + " wurde erfolgreich geloescht";
                case "infohorse":
                    
                    info = Datenbanklesen.lesen(str[1], "infohorse");
                    return info;
                    
                case "infouser":
                    
                    info = Datenbanklesen.lesen(str[1], "infouser");
                    return info;
   
                case "registrate":
                    String[] registrate = null;
                    for(int z = 0; z < str.length; z++)
                     registrate[z-1] = str[z];
                    
                    Datenbankschreiben.schreiben("login", registrate);
                    
                    return "erfolgreich registriert";
                case "login":
                      String[] login = null;
                      for(int i=0 ; i < str.length ; i++)
                       login[i-1] = str[i]; 
                      
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
