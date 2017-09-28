/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.protocol;

import org.json.simple.JSONObject;
import server.datenbank.Datenbanklesen;
import server.datenbank.Datenbankloeschen;

import server.datenbank.Loginueberpruefen;
import server.datenbank.Datenbankschreiben;
import server.json.Jsondecoding;
import server.json.Jsondecodingsingle;



/**
 *
 * @author Lukas
 */
public class Protocol {
      

    public static JSONObject input(String[] str)
    {
        String info = null;
        Boolean abfrage = false;
        String bolean = null;
        String[] get = new String[100];
        
        
        System.out.println("In Input verarbeiten");
            switch(str[0])
            {
                case "get":
                    
                break;
                case "start":
                
                    return Jsondecodingsingle.write("start", "true");
                break;
                case "water":
                    
                    System.out.format("%s\n",str[1]);
                    
                    
                    
                    return Jsondecodingsingle.write("water", str[1]);
                case "stop":
                    System.out.format("%s\n",str[1]);
                    
                    
                    
                    return Jsondecodingsingle.write("stop", str[1]);
            
                case "new":
                    String[] inserthorse = new String[5];
                    for(int j = 1; j < str.length; j++)
                        inserthorse[j-1] = str[j]; 
                    
                    abfrage = Datenbankschreiben.schreiben("horses", inserthorse);
                                   
                    return Jsondecodingsingle.write("new", abfrage.toString());
                    
                case "updatehorse":
                case "updatelogin":
                case "deletehorse":
                    
                    abfrage = Datenbankloeschen.loeschen("login", str[1]);
                    
                    return Jsondecodingsingle.write("deletehorse", abfrage.toString());
                case "deleteuser":
                    
                    abfrage = Datenbankloeschen.loeschen("horses", str[1]);
                    
                    return Jsondecodingsingle.write("deleteusr", abfrage.toString());
                case "infohorse":
                    
                    get = Datenbanklesen.lesen("Infohorse", str[1]);
                    
                   return Jsondecoding.write("infohorse", get);
                    
                case "infouser":
                    
                    get = Datenbanklesen.lesen("Infouser", str[1]);
                    
                    return Jsondecoding.write("infouser", get);
                case "registrate":
                    String[] registrate = new String[100];
                    for(int z = 1; z < str.length; z++)
                     registrate[z-1] = str[z];
                    
                    Datenbankschreiben.schreiben("login", registrate);
                    
                    return Jsondecodingsingle.write("registrate", abfrage.toString());
                case "login":
                      String[] login = new String[100];
                      for(int i=1 ; i < str.length ; i++)
                       login[i-1] = str[i]; 
                      
                       for (String login1 : login) {
                        System.out.format("%s\n", login1);
                        }
                      
                      abfrage = Loginueberpruefen.ueberpruefen(login[0],"login");
                      if(abfrage = true)
                      {
                         Datenbanklesen.lesen("Password",login[1]);
                         return Jsondecodingsingle.write("login", "true");
                      }
                      else
                      {
                          return Jsondecodingsingle.write("login", "false");
                      }
                case "test":
                    return Jsondecoding.write("water", str);
                default:
                    System.out.println("Falsche Anweisung");
                    return Jsondecodingsingle.write("default", "err03");
                
            }
        return Jsondecoding.write("water", str);
    }
}
