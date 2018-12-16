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

public class MainApplicationManageController {

    private static final String FootballAssociationFilepath = "FootballAssociationObjectStorage.txt";

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

        try {
            File FootballAssociationStorageFile = new File(FootballAssociationFilepath);
            FileInputStream fis = new FileInputStream(FootballAssociationStorageFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            try {

                read = (ArrayList<Verein>) ois.readObject();
                for (Verein v : read) {
                    System.out.println(v.toString());
                }

            } catch (Exception e) {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return read;
    }
}
