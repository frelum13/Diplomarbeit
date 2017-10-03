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
        obj.put("anweisung", "updatelogin");

        JSONArray list = new JSONArray();
        list.add("Fisch");
        list.add("Lulu");
        list.add("Pilz");
        list.add("Hi");
        
        obj.put("messages", list);
        
        System.out.println(obj);
        return obj;
    }

}