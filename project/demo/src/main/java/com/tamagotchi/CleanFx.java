package com.tamagotchi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

/*
 * Jeux du clean du tamagotchi plusieurs on clique dessus et si tous cliqué c'est néttoyé 
 */
public class CleanFx extends Application {
    Tamagotchi tamagotchi;
    int value = 0;

    public void start(Stage stage) {
        tamagotchi = tamagotchi.loadTamagotchi();

        Stage myStage = new Stage();
        /*
         * Création des cercles 
         */
        Circle circle1 = new Circle(150.0f, 150.0f, 30.0f);
        circle1.setFill(Color.BLUEVIOLET);

        Circle circle2 = new Circle(25.0f, 30.0f, 21.0f);
        circle2.setFill(Color.GREEN);

        Circle circle3 = new Circle(550.0f, 250.0f, 15.0f);
        circle3.setFill(Color.GRAY);

        Circle circle4 = new Circle(8.0f, 8.0f, 25.0f);
        circle4.setFill(Color.AZURE);

        Circle circle5 = new Circle(445.0f, 450.0f, 30.0f);
        circle5.setFill(Color.RED);

        Circle circle6 = new Circle(26.0f, 26.0f, 150.0f);
        circle6.setFill(Color.TRANSPARENT);
        /*
         * conditions de win
         */
        circle1.setOnMouseClicked(e -> {
            circle1.setVisible(false);
            value++;
            if (value == 6) {
                tamagotchi.toilet();
                tamagotchi.SaveTamagotchi(tamagotchi);
                myStage.close();
                JavaFx java = new JavaFx();
                java.start(new Stage());
            }
        });

        circle2.setOnMouseClicked(e -> {
            circle2.setVisible(false);
            value++;
            if (value == 6) {
                tamagotchi.toilet();
                tamagotchi.SaveTamagotchi(tamagotchi);
                myStage.close();
                JavaFx java = new JavaFx();
                java.start(new Stage());
            }
        });

        circle3.setOnMouseClicked(e -> {
            circle3.setVisible(false);
            value++;
            if (value == 6) {
                tamagotchi.toilet();
                tamagotchi.SaveTamagotchi(tamagotchi);
                myStage.close();
                JavaFx java = new JavaFx();
                java.start(new Stage());
            }
        });

        circle4.setOnMouseClicked(e -> {
            circle4.setVisible(false);
            value++;
            if (value == 6) {
                tamagotchi.toilet();
                tamagotchi.SaveTamagotchi(tamagotchi);
                myStage.close();
                JavaFx java = new JavaFx();
                java.start(new Stage());
            }
        });

        circle5.setOnMouseClicked(e -> {
            circle5.setVisible(false);
            value++;
            if (value == 6) {
                tamagotchi.toilet();
                tamagotchi.SaveTamagotchi(tamagotchi);
                myStage.close();
                JavaFx java = new JavaFx();
                java.start(new Stage());
            }
        });

        circle6.setOnMouseClicked(e -> {
            circle6.setVisible(false);
            value++;
            if (value == 6) {
                tamagotchi.toilet();
                tamagotchi.SaveTamagotchi(tamagotchi);
                myStage.close();
                JavaFx java = new JavaFx();
                java.start(new Stage());
            }
        });
        /*
         * Ajout des élement et des conditons de femture
         */
        Group allEmlement = new Group(circle1, circle2, circle3, circle4, circle5, circle6);

        Scene scene = new Scene(allEmlement, 600, 600);
        myStage.setScene(scene);
        myStage.show();
        tamagotchi.SaveTamagotchi(tamagotchi);

        myStage.setOnCloseRequest(event -> {

            tamagotchi.SaveTamagotchi(tamagotchi);
        });
    }

}
