/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Json_{

    public static JSONObject write() 
    {
        JSONObject obj = new JSONObject();
        obj.put("anweisung", "infouser");

        JSONArray list = new JSONArray();
        list.add("Stefano");
              
        
        obj.put("messages", list);
        
        System.out.print(obj);
        return obj;
    }

}