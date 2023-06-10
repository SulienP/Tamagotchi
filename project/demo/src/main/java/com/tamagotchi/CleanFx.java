package com.tamagotchi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CleanFx extends Application {
    Tamagotchi tamagotchi;
    @Override
    public void start(Stage primaryStage) {
        int clickedValue = 3;
        tamagotchi = tamagotchi.loadTamagotchi();
        Stage newStage = new Stage();
        VBox newVBox = new VBox();
        Button exit = new Button("Retour");
        exit.setVisible(false);
        Scene newScene = new Scene(newVBox, 600, 600);

        newStage.setScene(newScene);
        newStage.show();
        if (clickedValue == 3) {
                    tamagotchi.SaveTamagotchi(tamagotchi);
        tamagotchi.toilet();

            exit.setVisible(true);
        }
        exit.setOnMouseClicked(event -> newStage.close());
    }


}
