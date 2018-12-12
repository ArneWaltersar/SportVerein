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

public class MainApplicationManageController {
 private static final String FootballAssociationFilepath = "FootballAssociationObjectStorage.txt";
    public static void storeFootballAssociation(Verein[] FootballAssociationArray) {
        try {
           
            File footballAssociationStorageFile = new File(FootballAssociationFilepath);
            FileOutputStream outputStream = new FileOutputStream(footballAssociationStorageFile, true);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(FootballAssociationArray);
            System.out.println("stored");
            oos.close();
        } catch (IOException ernjo) {
            System.out.println(ernjo.getMessage());
        }
    }
    
    public static void loadFootballAssociatenFile() {
        try{
        File FootballAssociationStorageFile = new File(FootballAssociationFilepath);
        FileInputStream fis = new FileInputStream(FootballAssociationStorageFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        Object read = null;
       
        while(true) {
            try {
                read = ois.readObject();
                System.out.println(read.toString());
            } catch(Exception e ) {
                break;
            }
                
        }
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
