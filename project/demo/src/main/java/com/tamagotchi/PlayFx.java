package com.tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayFx extends Application {
    Tamagotchi tamagotchi;
    BorderPane root;

    @Override
    public void start(Stage primaryStage) {
        tamagotchi = tamagotchi.loadTamagotchi();
        String cssPath = getClass().getResource("/play.css").toString();

        root = new BorderPane();
        Label label = new Label("Dessine moi un dessin ");

        Canvas canvas = new Canvas(500, 500);
        canvas.getStyleClass().add("canvas");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(e -> {
            gc.beginPath();
            gc.moveTo(e.getX(), e.getY());
            gc.setStroke(getSelectedColor());
            gc.setLineWidth(2.0);
        });

        canvas.setOnMouseDragged(e -> {
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });

        Button exit = new Button("Exit");
        exit.setOnMouseClicked(event -> {
            tamagotchi.play();
            tamagotchi.SaveTamagotchi(tamagotchi);
                        JavaFx javaFx = new JavaFx();
            javaFx.start(primaryStage);
        });

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(e -> {
            gc.setStroke(getSelectedColor());
        });

        root.setTop(label);
        root.setCenter(canvas);
        root.setRight(colorPicker);
        root.setBottom(exit);

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(cssPath);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(close -> {

            tamagotchi.SaveTamagotchi(tamagotchi);
        });
    }

    private Color getSelectedColor() {
        ColorPicker colorPicker = (ColorPicker) root.getRight();
        return colorPicker.getValue();
    }

  
}
