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
    BorderPane page;

    @Override
    public void start(Stage primaryStage) {
        tamagotchi = tamagotchi.loadTamagotchi();

        page = new BorderPane();
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

        page.setTop(label);
        page.setCenter(canvas);
        page.setRight(colorPicker);
        page.setBottom(exit);

        Scene scene = new Scene(page, 600, 600);
                String cssPath = getClass().getResource("/play.css").toString();

        scene.getStylesheets().add(cssPath);
        page.getStyleClass().add("mainPage");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(close -> {
        page.getStyleClass().add("mainPage");

            tamagotchi.SaveTamagotchi(tamagotchi);
        });
    }

    private Color getSelectedColor() {
        ColorPicker colorPicker = (ColorPicker) page.getRight();
        return colorPicker.getValue();
    }

  
}
