/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportverein;
import java.io.*;
/**
 *
 * @author rauerjakob
 */
public class Verein implements Serializable{
    String name;
    
    
    public Verein(String name) {
        this.name = name;
    }
    
    public String toString() {
       return this.name;
    }
    
}
