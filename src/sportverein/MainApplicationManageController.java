/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportverein;

/**
 *
 * @author rauerjakob
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainApplicationManageController {

    public static final String FootballAssociationFilepath = "FootballAssociationObjectStorage.txt";
    public static final String PairingFilepath = "PairingObjectStorage.txt";

    public static void storeFootballAssociation(ArrayList<Verein> FootballAssociationArray) {
        try {

            File footballAssociationStorageFile = new File(FootballAssociationFilepath);
            FileOutputStream outputStream = new FileOutputStream(footballAssociationStorageFile);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(FootballAssociationArray);
            System.out.println("stored");

            oos.close();
        } catch (IOException ernjo) {
            System.out.println(ernjo.getMessage());
        }
    }

    public static ArrayList<Verein> loadFootballAssociatenFile() {
        ArrayList<Verein> read = null;
        File FootballAssociationStorageFile = null;
        FileInputStream fis  = null;
        BufferedInputStream bis  = null;
        ObjectInputStream ois  = null;

        try {
            FootballAssociationStorageFile = new File(FootballAssociationFilepath);
            fis = new FileInputStream(FootballAssociationStorageFile);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            try {

                read = (ArrayList<Verein>) ois.readObject();
                //Collections.shuffle(read);
                for (Verein v : read) {
                    //System.out.println(v.toString());
                }

            } catch (Exception e) {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally {
            try {
                ois.close();
            } catch(Exception e) {
                
            }
        }
        
        return read;
    }
    
    public static void storePairing(ArrayList<Paarung> PairingArray) {
        try {

            File PairingStorageFile = new File(PairingFilepath);
            FileOutputStream outputStream = new FileOutputStream(PairingFilepath);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(PairingArray);
            System.out.println("stored");

            oos.close();
        } catch (IOException ernjo) {
            System.out.println(ernjo.getMessage());
        }
    }
    
    public static ArrayList<Paarung> loadPairingFile() {
        ArrayList<Paarung> read = null;

        File PairingStorageFile = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        
        try {
            PairingStorageFile = new File(PairingFilepath);
            fis = new FileInputStream(PairingStorageFile);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
           
            try {

                read = (ArrayList<Paarung>) ois.readObject();
                //Collections.shuffle(read);
                for (Paarung v : read) {
                    //System.out.println(v.toString());
                }

            } catch (Exception e) {
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally {
            try {
                ois.close();
            } catch(Exception e) {
                
            }
        }
        
        return read;
    }
}
