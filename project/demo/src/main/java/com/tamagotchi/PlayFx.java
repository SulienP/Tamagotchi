package com.tamagotchi;


import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * CLasse de jeu en java fx avec un dessin en canvas a faire
 */
public class PlayFx extends Application {
    Tamagotchi tamagotchi;
    BorderPane page;

    /*
     * Démarrage de la page
     */
    @Override
    public void start(Stage mainStage) {
        tamagotchi = tamagotchi.loadTamagotchi();
        /*
         * Ajout du'n BorderPane afind d'avoir une page déja structuré 
         */
        page = new BorderPane();
        Label label = new Label("Dessine moi un dessin ");
        label.getStylesheets().add("label");
        /*
         * Ajout ud canvas 
         */
        Canvas canvas = new Canvas(500, 500);
        canvas.getStyleClass().add("canvas");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        /*
         * Dessin du canvas et détection du clik
         */
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
        /*
         * Voutton de sorti
         */
        Button exit = new Button("Exit");
        exit.setOnMouseClicked(event -> {
            /*
             * Sauvegarde et ermeture et crétion d'une nouvelle fenetre
             */
            tamagotchi.play();
            tamagotchi.SaveTamagotchi(tamagotchi);
            mainStage.close();
            JavaFx java = new JavaFx();
            java.start(new Stage());

        });
        /*
         * Sélecteur de couleur
         */
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(e -> {
            gc.setStroke(getSelectedColor());
        });
        /*
         * Positionemment des éléments
         */
        page.setTop(label);

        page.setCenter(canvas);
        page.setRight(colorPicker);
        page.setBottom(exit);

        /*
         * Différentes images de fond pour le tamagotchi en fonction des états et de la joie du tama
         */
        ImageView backgroundImage = new ImageView(new Image(getClass().getResource("/youngHapipng.png").toExternalForm()));
        if (tamagotchi.happyness <= 10 && tamagotchi.state == 1) {
            Image newImage = new Image(getClass().getResource("/youngNotHapi.png").toExternalForm());
            backgroundImage.setImage(newImage);
        }
        if (tamagotchi.state == 2) {
            Image newImage = new Image(getClass().getResource("/old.png").toExternalForm());
            backgroundImage.setImage(newImage);
        }
        if (tamagotchi.happyness <= 10 && tamagotchi.state == 3) {
            Image newImage = new Image(getClass().getResource("/oldNotHap.png").toExternalForm());
            backgroundImage.setImage(newImage);
        }
        if (tamagotchi.happyness >= 10 && tamagotchi.state == 3) {
            Image newImage = new Image(getClass().getResource("/oldHapi.png").toExternalForm());
            backgroundImage.setImage(newImage);
        }

        /*
         * Ajout de tout les éléments a la scene et a la page
         */
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundImage, page);

        Scene scene = new Scene(stackPane, 750, 750);
        String cssPath = getClass().getResource("/play.css").toString();
        scene.getStylesheets().add(cssPath);
        page.getStyleClass().add("mainPage");

        mainStage.setScene(scene);
        mainStage.show();
        /*
         * Sauvegarde du tamagotchi si on ferme
         */
        mainStage.setOnCloseRequest(close -> {
            tamagotchi.SaveTamagotchi(tamagotchi);
       
        });
    }

    private Color getSelectedColor() {
        ColorPicker colorPicker = (ColorPicker) page.getRight();
        return colorPicker.getValue();
    }
}
