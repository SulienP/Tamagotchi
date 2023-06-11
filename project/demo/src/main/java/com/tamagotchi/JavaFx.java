package com.tamagotchi;

import java.nio.file.Files;
import java.nio.file.Path;

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
import javafx.stage.Stage;

public class JavaFx extends Application {
    public Tamagotchi tamagotchi;
    ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("");
        Path path = Path.of("./tamagotchi.dat");
        if (Files.exists(path)) {
            String cssPath = getClass().getResource("/app.css").toString();

            tamagotchi = tamagotchi.loadTamagotchi();
            imageView = new ImageView(new Image(getClass().getResource("/test.jpg").toExternalForm()));

            Button button1 = new Button("play");
            Button button2 = new Button("Clean");
            Button button3 = new Button("Feed");
            Button button4 = new Button("Sick");
            button4.setVisible(false);
            if (tamagotchi.isSisck) {
              button4.setVisible(true);
            }
            button1.setOnMouseClicked(e -> {
                PlayFx playFx = new PlayFx();
              playFx.start(primaryStage);
                label.setText("You have play with your tamagothci");
            });
            button2.setOnMouseClicked(e -> {
              CleanFx cleanFx = new CleanFx();
              label.setText("You have play with your tamagothci");
                cleanFx.start(primaryStage);
            });
            button3.setOnMouseClicked(e -> {
              FeedFx feedFx = new FeedFx();
              label.setText("You have feed whti  with your tamagothci");
                feedFx.start(new Stage());
            });

            HBox buttonBox = new HBox(button1, button2, button3, button4);
            buttonBox.getStyleClass().add("button-container");

            imageView.setFitWidth(500);
            imageView.setFitHeight(500);

            VBox labelBox = new VBox(label);

            BorderPane scene = new BorderPane();
            scene.setTop(labelBox);
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
            if (!tamagotchi.isAlive) {
              primaryStage.close();
              DeadJfx deadJfx = new DeadJfx();
              deadJfx.start(new Stage());
            }
        } else {
            NoTamaFx fx = new NoTamaFx();
            fx.start(new Stage());
        }
    }
}
