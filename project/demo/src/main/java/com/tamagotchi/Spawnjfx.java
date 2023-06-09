package com.tamagotchi;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Spawnjfx extends Application {


    @Override
    public  void start(Stage primaryStage) {
        Menujfx menufx = new Menujfx();
      
        Button bouton1 = new Button("Eclore");
        Button bouton2 = new Button("Quitter");
       

        bouton1.setOnMouseClicked(e->{
            menufx.menuPage();
            System.out.println("1");
            primaryStage.close();
        });

        bouton2.setOnMouseClicked(e->{
            primaryStage.close();
        });


        VBox menu = new VBox(10); 
        menu.getChildren().addAll(bouton1, bouton2);
        bouton1.setStyle("-fx-background-color: #FF0000;");
        bouton2.setStyle("-fx-background-color: #FF0016;");
        

        // Création de la scène principale avec le menu
        Scene scene = new Scene(menu, 600, 450);

        // Configuration de la scène principale et affichage de la fenêtre
        primaryStage.setTitle("Menu JFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}