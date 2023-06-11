package com.tamagotchi;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.shape.Circle;public class FeedFx extends Application {
    Tamagotchi tamagotchi;
    int value = 0;

    public void start(Stage stage) {
        tamagotchi = tamagotchi.loadTamagotchi();

        Circle circle = new Circle(150.0f, 150.0f, 30.0f);
        Group groupScene = new Group(circle);
        circle.setFill(Color.BLUEVIOLET);

        circle.setOnMouseClicked(e -> {
            if (value == 0) {
                circle.setRadius(circle.getRadius() * 2);
                value += 1;
                circle.setFill(Color.BISQUE);
            } else if (value == 1) {
                circle.setRadius(25.0f);
                value += 1;
            } else if (value == 2) {
                circle.setRadius(700.0f);
                circle.setFill(Color.BLACK);
                tamagotchi.feed();
                tamagotchi.SaveTamagotchi(tamagotchi);
                value += 1;
                if (value == 3) {
                    stage.close();
                }
            }
        });
   
        Scene scene = new Scene(groupScene, 600, 600);
        stage.setScene(scene);
        stage.show();

        tamagotchi.SaveTamagotchi(tamagotchi);
    }
}
