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

    public static void storeFootballAssociation(Verein verein) {
        try {
            File footballAssociationStorageFile = new File(verein.name);
            FileOutputStream outputStream = new FileOutputStream(footballAssociationStorageFile);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(verein);
            oos.close();
        } catch (IOException ernjo) {
            System.out.println(ernjo.getMessage());
        }
    }
}
