package com.tamagotchi;

import java.nio.file.Files;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFx extends Application {
    public  Tamagotchi tamagotchi;
    @Override
    public void start(Stage primaryStage) {
    Path path = Path.of("./tamagotchi.dat");
            if (Files.exists(path)) {
                tamagotchi = tamagotchi.loadTamagotchi();
              } else {
                tamagotchi = new Tamagotchi();
                tamagotchi.SaveTamagotchi(tamagotchi);
              }
      String cssPath = getClass().getResource("/app.css").toString();

        Button button1 = new Button("play");
        Button button2 = new Button("feed");
        Button button3 = new Button("clean");
        HBox buttonBox = new HBox(button1, button2, button3);

buttonBox.getStyleClass().add("button-container");

        Scene mainScene = new Scene(buttonBox, 600, 600);
        mainScene.getStylesheets().add(cssPath);

        button1.setOnMouseClicked(e -> {
            Stage newStage = new Stage();
          VBox newVBox = new VBox();
          Label label = new Label("test"); 
          HBox hBox = new HBox(label);
            Button backButton = new Button("test");
            backButton.setOnMouseClicked(v ->{
            tamagotchi.essaye();
                if (tamagotchi.test >= 1) {
            label.setText("test réussi");
          }
              System.out.println(tamagotchi.test);
          });

      
                newVBox.getChildren().addAll(hBox, backButton);

            Scene newScene = new Scene(newVBox, 600, 600);

            newStage.setScene(newScene);
            newStage.show();

            //backButton.setOnMouseClicked(event -> newStage.close());
        });
        button2.setOnMouseClicked(e -> {
              Stage newStage = new Stage();
            VBox newVBox = new VBox();
            Button backButton = new Button("Retour");

            Scene newScene = new Scene(newVBox, 600, 600);

            newStage.setScene(newScene);
            newStage.show();
 tamagotchi.feed();
            tamagotchi.SaveTamagotchi(tamagotchi);
            backButton.setOnMouseClicked(event -> newStage.close());
        });
           
         
        
        primaryStage.setScene(mainScene);

        primaryStage.show();
    }
}