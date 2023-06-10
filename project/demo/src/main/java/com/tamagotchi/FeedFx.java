package com.tamagotchi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FeedFx extends Application {
    Tamagotchi tamagotchi;
    public void start(Stage primaryStage) {
        tamagotchi = tamagotchi.loadTamagotchi();
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
    }
}