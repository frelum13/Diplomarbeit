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
import server.datenbank.Datenbankupdate;
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
        //Boolean abfrage = false;
        String getfromloeschen = null;
        String antwortwrite = null;
        String bolean = null;
        String[] get = new String[5];
        
        Datenbanklesen lesen = null;
        Datenbankschreiben schreiben = null;
        
        Loginueberpruefen ueberpfruefen = null;
        
        
        System.out.println("In Input verarbeiten");
            switch(str[0])
            {
                case "get":
                    
                break;
                case "start":
                
                    return Jsondecodingsingle.write("start", "true");
                    
                case "water":
                    
                    System.out.format("%s\n",str[1]);
                    
                    
                    
                    return Jsondecodingsingle.write("water", str[1]);
                case "stop":
                    System.out.format("%s\n",str[1]);
                    return Jsondecodingsingle.write("stop", str[1]);
            
                case "new":
                    String[] inserthorse = new String[str.length-1];
                    for(int j = 1; j < str.length; j++)
                        inserthorse[j-1] = str[j]; 
                    
                    schreiben = new Datenbankschreiben("horses", inserthorse);
                    antwortwrite = schreiben.getAbfrage();
                                   
                    return Jsondecodingsingle.write("new", antwortwrite);
                    
                case "updatehorse":

                case "updatelogin":
                    
                    
                case "deletehorse":
                    
                    getfromloeschen = Datenbankloeschen.loeschen("login", str[1]);
                    
                    return Jsondecodingsingle.write("deletehorse", getfromloeschen);
                case "deleteuser":
                    
                    getfromloeschen = Datenbankloeschen.loeschen("horses", str[1]);
                    
                    return Jsondecodingsingle.write("deleteusr", getfromloeschen);
                case "infohorse":
                    
                    lesen = new Datenbanklesen("Infohorse", str[1]);
                    get = lesen.getListe();
                    
                   return Jsondecoding.write("infohorse", get);
                    
                case "infouser":
                    
                    lesen = new Datenbanklesen("Infouser", str[1]);
                    get = lesen.getListe();
                    
                    return Jsondecoding.write("infouser", get);
                case "registrate":
                    String[] registrate = new String[100];
                    for(int z = 1; z < str.length; z++)
                     registrate[z-1] = str[z];
                    
                    schreiben = new Datenbankschreiben("login", registrate);
                    antwortwrite = schreiben.getAbfrage();
                    
                    return Jsondecodingsingle.write("registrate", antwortwrite);
                    
                case "login":
                      String[] login = new String[100];
                      for(int i=1 ; i < str.length ; i++)
                        login[i-1] = str[i]; 
                       
                      ueberpfruefen = new Loginueberpruefen(login[0], "login");
                      antwortwrite = ueberpfruefen.getCheck();
                      
                      
                      if(antwortwrite == "true")
                      {
                          lesen = new Datenbanklesen("Password", login[0]);
                          get = lesen.getListe();
                                                    
                          System.out.println(get[1]);
                          System.out.println(login[1]);
                          
                          if(login[1].equals(get[1]))
                          {
                              return Jsondecodingsingle.write("login", "true");
                          }
                          else
                          {
                              return Jsondecodingsingle.write("login", "Falsches Passwort");
                          }
                          
                      }
                      else
                      {
                          return Jsondecodingsingle.write("login", "false1");
                      }
                default:
                    System.out.println("Falsche Anweisung");
                    return Jsondecodingsingle.write("default", "err03");
                
            }
        return Jsondecoding.write("water", str);
    }
}
