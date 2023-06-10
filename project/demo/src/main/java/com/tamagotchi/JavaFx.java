package com.tamagotchi;

import java.nio.file.Files;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFx extends Application {
  public Tamagotchi tamagotchi;
    ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
              String cssPath = getClass().getResource("/app.css").toString();

        Path path = Path.of("./tamagotchi.dat");
        if (Files.exists(path)) {
            tamagotchi = tamagotchi.loadTamagotchi();
        } else {
            tamagotchi = new Tamagotchi();
            tamagotchi.SaveTamagotchi(tamagotchi);
        }
          imageView = new ImageView(new Image(getClass().getResource("/test.jpg").toExternalForm()));
        

  

        Button button1 = new Button("play");
        Button button2 = new Button("feed");
        Button button3 = new Button("clean");
button1.setOnMouseClicked(e -> {
            Stage newStage = new Stage();
        VBox newVBox = new VBox();
        Label label = new Label("test");
        HBox hBox = new HBox(label);
        Button backButton = new Button("test");

        newVBox.getChildren().addAll(hBox, backButton);

        Scene newScene = new Scene(newVBox, 600, 600);

        newStage.setScene(newScene);
        newStage.show();
          backButton.setOnMouseClicked(c -> {
            tamagotchi.essaye();
          });

        // backButton.setOnMouseClicked(event -> newStage.close());
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
 button3.setOnMouseClicked(e -> {
    Stage newStage = new Stage();
    VBox newVBox = new VBox();
    Button backButton = new Button("Retour");

    Scene newScene = new Scene(newVBox, 600, 600);

    // Définir le fond de couleur beige
    BackgroundFill backgroundFill = new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(backgroundFill);
    newVBox.setBackground(background);

    newStage.setScene(newScene);
    newStage.show();

    //tamagotchi.clean();
    tamagotchi.SaveTamagotchi(tamagotchi);

    backButton.setOnMouseClicked(event -> newStage.close());
});
    
        HBox buttonBox = new HBox(button1, button2, button3);
            buttonBox.getStyleClass().add("button-container");
          
           imageView.setFitWidth(550); 
        imageView.setFitHeight(550); 

        BorderPane scene = new BorderPane();
        scene.setCenter(imageView);
        scene.setBottom(buttonBox);
        BorderPane.setMargin(buttonBox, new Insets(20));


        Scene mainScene = new Scene(scene, 600, 600);
        mainScene.getStylesheets().add(cssPath);
  primaryStage.setOnCloseRequest(event -> {
    tamagotchi.SaveTamagotchi(tamagotchi);
          });
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

   
}
