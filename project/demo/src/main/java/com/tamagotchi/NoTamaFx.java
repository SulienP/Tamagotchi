package com.tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoTamaFx extends Application {
    Tamagotchi tamagotchi;
     @Override
    public void start(Stage window) {
                  tamagotchi = new Tamagotchi();

                  TextField textField = new TextField();
textField.getStyleClass().add("text-field");

        Label welcome = new Label("Welcome on tamagotchi");
        VBox newUser = new VBox();
        Button nextStep = new Button("Next Step");
        nextStep.getStyleClass().add("next-step");
        welcome.getStyleClass().add("welcome");

        nextStep.setOnMouseClicked(e -> {
            tamagotchi.name = textField.getText();
            window.close();
            JavaFx start = new JavaFx();
            start.start(new Stage());
        });
    
        newUser.getChildren().addAll(textField, welcome,nextStep);
        Scene scene = new Scene(newUser, 600, 600);
        window.setScene(scene);
        window.show();
                  tamagotchi.SaveTamagotchi(tamagotchi);
                            scene.getStylesheets().add(getClass().getResource("/noTama.css").toString());

    }}
