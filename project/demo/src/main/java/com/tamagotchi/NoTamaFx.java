package com.tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Fenetre de création du tamagotchi 
 */
public class NoTamaFx extends Application {
  Tamagotchi tamagotchi;

@Override
public void start(Stage window){
    tamagotchi = new Tamagotchi();
    /*
     * Ajout d'une champs pour ajouter le nom au tama
     */
    TextField textField = new TextField();
    textField.getStyleClass().add("text-field");
    /*
     * Texte de bienve nue avec ajout du css
     */
    Label welcome = new Label("Welcome on tamagotchi");
    VBox newUser = new VBox();
    Button nextStep = new Button("Next Step");
    nextStep.getStyleClass().add("next-step");
    welcome.getStyleClass().add("welcome");
    /*
     * Background de l'oeuf
     */
    ImageView image = new ImageView(new Image(getClass().getResource("/state1.png").toExternalForm()));
    if (textField.getText().isEmpty()) {
        tamagotchi.name = "empty value";
    }
    /*
     * Début du jeu au clique
     */
    nextStep.setOnMouseClicked(e -> {
        tamagotchi.name = textField.getText();
        window.close();
        tamagotchi.state = 1;

        tamagotchi.SaveTamagotchi(tamagotchi);
        JavaFx start = new JavaFx();
        start.start(new Stage());
    });
    /*
     * Ajout de tout les éléments
     */
    HBox buttonBox = new HBox(image, nextStep);
    buttonBox.getStyleClass().add("button-box");

    newUser.getChildren().addAll(textField, welcome, buttonBox);
    Scene scene = new Scene(newUser, 900, 600);
    window.setScene(scene);
    window.show();
    tamagotchi.SaveTamagotchi(tamagotchi);

    scene.getStylesheets().add(getClass().getResource("/noTama.css").toString());
}

    }