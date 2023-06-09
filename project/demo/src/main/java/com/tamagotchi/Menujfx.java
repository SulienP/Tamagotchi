package com.tamagotchi;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menujfx{


    public void menuPage() {
        Stage menuStage = new Stage();
        // Création des boutons du menu
        Button bouton1 = new Button("Manger");
        Button bouton2 = new Button("Laver");
        Button bouton3 = new Button("Jouer");

        Button bouton4 = new Button("Quitter");

        bouton1.setOnMouseClicked(event ->{
        });

        bouton2.setOnAction(event -> {
            Menujfx.show();
        });

        bouton4.setOnMouseClicked(e->{
            menuStage.close();
        });

        VBox menu = new VBox(10); 
        menu.getChildren().addAll(bouton1, bouton2);
        bouton1.setStyle("-fx-background-color: #FF0000;");
        bouton2.setStyle("-fx-background-color: #FF0016;");
      
        menu.getChildren().addAll(bouton1, bouton2, bouton3, bouton4);

        Scene scene = new Scene(menu, 600, 450);

        menuStage.setTitle("Menu JFX");
        menuStage.setScene(scene);
        menuStage.show();
    }

    private static void show() {
    }


}