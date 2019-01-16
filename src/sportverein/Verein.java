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
public class Verein implements Serializable, Comparable<Verein>{
    String name;
    Integer punkte;
    Integer tore;
    Integer gegentore;
    
    
    public Verein(String name) {
        this.name = name;
        this.punkte = 0;
        this.tore = 0;
        this.gegentore = 0;
    }
    public String toString() {
       return this.name;
    }
    
    public String toStringTable() {
        return this.name + " - " + this.punkte + " - " + (this.tore - this.gegentore) + " - " + this.tore + " - " + this.gegentore;
    }

    @Override
    public int compareTo(Verein o) {
        if(this.punkte > o.punkte) {
            return -1;
        } else if(this.punkte < o.punkte) {
            return 1;
        } else if (this.tore > o.tore){
            return -1;
        } else if (this.tore < o.tore){
            return 1;
        } else {
            return 0;
        }
    }
    
}
