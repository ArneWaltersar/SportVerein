/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportverein;
import java.io.*;
/**
 *
 * @author Jakob
 */
public class Paarung implements Serializable{
    Verein verein1;
    Verein verein2;
    Integer ergebnis1;
    Integer ergebnis2;
    
    public Paarung(Verein Verein1, Verein Verein2) {
        this.verein1 = Verein1;
        this.verein2 = Verein2;
    }
    
    public String toString() {
       if(verein2 == null) {
           return this.verein1 + " ist spielfrei";
       }
       return this.verein1 + " - " + this.verein2;
    }
}
