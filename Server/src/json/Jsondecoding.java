package json;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.simple.JSONObject;


public class Jsondecoding {
    
    public static void main(String[] args){
      JSONObject obj = new JSONObject();

      obj.put("Anweisung", "Lukas");
      obj.put("num", new Integer(100));
      obj.put("balance", new Double(1000.21));
      obj.put("is_vip", new Boolean(true));

      System.out.print(obj);
   }
    
}
