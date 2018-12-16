/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportverein;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rauerjakob
 */
public class SportVerein extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        //Verein[] vereine = new Verein[3];
        ArrayList<Verein> Vereine = new ArrayList<Verein>();
        Vereine.add(new Verein("Lauxel l"));
        Vereine.add(new Verein("Lauxel 2"));
        Vereine.add(new Verein("Lauxel 3"));

        MainApplicationManageController.storeFootballAssociation(Vereine);
        Vereine = MainApplicationManageController.loadFootballAssociatenFile();
        ArrayList<Paarung> Paarungen = new ArrayList<Paarung>();
        while (Vereine.size() > 0) {
            if (Vereine.size() > 1) {
                Paarungen.add(new Paarung(Vereine.get(0), Vereine.get(1)));
                Vereine.remove(0);
                Vereine.remove(0);
            } else {
                Paarungen.add(new Paarung(Vereine.get(0), null));
                Vereine.remove(0);

            }
        }
        for (Paarung p : Paarungen) {
            System.out.println(p.toString());
        }

        Runtime.getRuntime().exit(0);
    }

}
