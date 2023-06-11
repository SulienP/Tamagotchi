package com.tamagotchi;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;


public class FeedFx extends Application {
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
                    JavaFx java = new JavaFx();
                    java.start(new Stage());
                    stage.close();
                }
            }
        });
        ImageView backgroundImage = new ImageView(new Image(getClass().getResource("/youngHapipng.png").toExternalForm()));
            if (tamagotchi.happyness <= 10 && tamagotchi.state == 1) {
              Image newImage = new Image(getClass().getResource("/youngNotHapi.png").toExternalForm());

              backgroundImage.setImage(newImage);
            }
            if (tamagotchi.state == 2) {
              Image newImage = new Image(getClass().getResource("/old.png.png").toExternalForm());
              backgroundImage.setImage(newImage);
            }
            if (tamagotchi.happyness <= 10 && tamagotchi.state == 3) {
              Image newImage = new Image(getClass().getResource("/oldNotHap.png").toExternalForm());

              backgroundImage.setImage(newImage);
            }
           if(tamagotchi.happyness >=10 && tamagotchi.state ==3){
           Image newImage = new Image(getClass().getResource("/oldHapi.png").toExternalForm());
            backgroundImage.setImage(newImage);
          }
Group allElemenGroup = new Group(backgroundImage, groupScene); 

Scene scene = new Scene(allElemenGroup, 600, 600);
        backgroundImage.setFitWidth(scene.getWidth());
backgroundImage.setFitHeight(scene.getHeight());

        stage.setScene(scene);
        stage.show();
               stage.setOnCloseRequest(event -> {

        tamagotchi.SaveTamagotchi(tamagotchi);
                });
        tamagotchi.SaveTamagotchi(tamagotchi);
    }
}
