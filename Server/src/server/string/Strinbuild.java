/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.string;

/**
 *
 * @author Lukas
 */
public class Strinbuild {
    
    
    public static String stringbuild(String[] liste)
    {
        String back = null;
        
        back = liste[0];
        for(int i=1; i<liste.length;i++)
        {
            back = back + ",";
            back = back + liste[i];
        }
        
       return  back;
    }
}
