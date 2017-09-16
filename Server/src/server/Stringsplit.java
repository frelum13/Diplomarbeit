/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Lukas
 */
public class Stringsplit {
 
    private final String msg;
    private final String trennzeichen;
    private String[] str;

    public Stringsplit(String msg, String trennzeichen) {
        this.msg = msg;
        this.trennzeichen = trennzeichen;
        
        teilen();
    }

    Stringsplit(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    private void teilen()
    {
        System.out.println("String wird zerteilt");
        str = msg.split(trennzeichen);
    }

    public String[] getStr() {
        return str;
    }
    
    
}
