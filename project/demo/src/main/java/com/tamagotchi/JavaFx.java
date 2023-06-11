package com.tamagotchi;

import java.nio.file.Files;
import java.nio.file.Path;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
* PAge principal du tamagotci
*/
public class JavaFx extends Application {
  public Tamagotchi tamagotchi;
  ImageView imageView;
  
  /*
  * Création de la Stage
  */
  @Override
  public void start(Stage primaryStage) {
    tamagotchi = tamagotchi.loadTamagotchi();

    Label label = new Label("hapiness :" + tamagotchi.happyness);
    Path path = Path.of("./tamagotchi.dat");
    /*
    * Vérification de si le tamagotchi existe
    */
    if (Files.exists(path)) {
      /*
      * Définition du fond 
      */
      String cssPath = getClass().getResource("/app.css").toString();
      
      tamagotchi = tamagotchi.loadTamagotchi();
      imageView = new ImageView(new Image(getClass().getResource("/youngHapipng.png").toExternalForm()));
      if (tamagotchi.happyness <= 10 && tamagotchi.state == 1) {
        Image newImage = new Image(getClass().getResource("/youngNotHapi.png").toExternalForm());
        
        imageView.setImage(newImage);
      }
      if (tamagotchi.state == 2) {
        Image newImage = new Image(getClass().getResource("/old.png").toExternalForm());
        imageView.setImage(newImage);
      }
      if (tamagotchi.happyness <= 10 && tamagotchi.state == 3) {
        Image newImage = new Image(getClass().getResource("/oldNotHap.png").toExternalForm());
        
        imageView.setImage(newImage);
      }
      if (tamagotchi.happyness >= 10 && tamagotchi.state == 3) {
        Image newImage = new Image(getClass().getResource("/oldHapi.png").toExternalForm());
        imageView.setImage(newImage);
      }
      /*
      * Ajout des boutons de jeu clean et feed et soigner si il est malade. A chaque fois elle fermera la fenetre principale
      */
      Button button1 = new Button("play");
      Button button2 = new Button("Clean");
      Button button3 = new Button("Feed");
      Button button4 = new Button("Sick");
      button4.setVisible(false);
      if (tamagotchi.isSisck) {
        button4.setVisible(true);
      }
      button4.setOnMouseClicked(v -> {
        tamagotchi.cure();
        tamagotchi.SaveTamagotchi(tamagotchi);
      });
      button1.setOnMouseClicked(e -> {
        PlayFx playFx = new PlayFx();
        playFx.start(new Stage());
        primaryStage.close();      
      });
      button2.setOnMouseClicked(e -> {
        CleanFx cleanFx = new CleanFx();
        cleanFx.start(new Stage());
        primaryStage.close();        
      });
      button3.setOnMouseClicked(e -> {
        FeedFx feedFx = new FeedFx();
        feedFx.start(new Stage());
        primaryStage.close();
      });
      
      /*
       * Ajotu des boutons sur bars horizontal
       */
      HBox buttonBox = new HBox(button1, button2, button3, button4);
      buttonBox.getStyleClass().add("button-container");
      
      /*
       * Définition de la taille de l'image
       */
      imageView.setFitWidth(500);
      imageView.setFitHeight(400);
      
      VBox labelBox = new VBox(label);
      /*
       * Création et ajout des éléments dans un borderPane afin d'avoir des éléments déja pré installé
       */
      BorderPane scene = new BorderPane();
      scene.setTop(labelBox);
      scene.setCenter(imageView);
      scene.setBottom(buttonBox);
      /*
       * Création de la scene principale
       */
      Scene mainScene = new Scene(scene, 600, 600);
      mainScene.getStylesheets().add(cssPath);
      /*
       * Ajout du stye, et condition de fermeture de la page
       */
      primaryStage.setOnCloseRequest(event -> {
        tamagotchi.SaveTamagotchi(tamagotchi);
      });
      primaryStage.setScene(mainScene);
      primaryStage.show();
      if (!tamagotchi.isAlive) {
        primaryStage.close();
        DeadJfx deadJfx = new DeadJfx();
        deadJfx.start(new Stage());
      }
    } else {
      /*
       * Création d'un tamagotchi si il existe pas 
       */
      NoTamaFx fx = new NoTamaFx();
      fx.start(new Stage());
    }
  }
}
