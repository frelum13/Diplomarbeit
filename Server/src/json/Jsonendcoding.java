/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Lukas
 */
public class Jsonendcoding {
    
   public static void decoiding(Object obj)
   {
       String[] str = null;
       JSONParser parser = new JSONParser();
       JSONObject jsonObject = (JSONObject) obj;
       System.out.println(jsonObject);
       String name = (String) jsonObject.get("anweisung");
       System.out.println(name);
       // loop array
       JSONArray msg = (JSONArray) jsonObject.get("messages");
       Iterator<String> iterator = msg.iterator();
       while (iterator.hasNext()) {
           System.out.println(iterator.next());
           
       }
       
       
       //return str;
   }
}
