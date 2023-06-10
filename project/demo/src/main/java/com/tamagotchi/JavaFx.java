package com.tamagotchi;

import java.nio.file.Files;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    PlayFx playFx = new PlayFx();
           playFx.start(primaryStage);
    });
 button2.setOnMouseClicked(e -> {
           CleanFx cleanFx = new CleanFx();
           cleanFx.start(primaryStage);
 });
 button3.setOnMouseClicked(e -> {
   FeedFx feedFx = new FeedFx();
    feedFx.start(primaryStage);
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
