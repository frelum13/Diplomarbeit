/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.test;

/**
 *
 * @author Lukas
 */
public class StringSplit {
    
    public static void main(String[] args) {
        
        final String srg = "Lukas;Freyler;23";
        
        String[] split = srg.split(";");
        
        for(int i = 0; i<split.length;i++)
            System.out.format("%s\n",split[i]);
        
    }
    
}
