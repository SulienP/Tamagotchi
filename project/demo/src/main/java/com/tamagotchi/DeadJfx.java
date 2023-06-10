package com.tamagotchi;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
public class DeadJfx extends Application{
    public void start(Stage stage) {
        Button replay = new Button("replay");
        replay.setOnMouseClicked(e ->{
            stage.close();
            NoTamaFx newTama = new NoTamaFx();
            newTama.start(new Stage());
        });
        VBox vbox = new VBox(replay);
        vbox.getStyleClass().add("button-container");

        BorderPane scene = new BorderPane();
        scene.setCenter(vbox);

        Scene mainScene = new Scene(scene, 600, 600);
        mainScene.getStylesheets().add(getClass().getResource("/app.css").toString());

        stage.setScene(mainScene);
        stage.show();
    }



}