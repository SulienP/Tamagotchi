package com.tamagotchi;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Page de mort du tamagotchi
 */
public class DeadJfx extends Application{
    public void start(Stage stage) {
        /*
         * Ajout du seul bouton de la page qui fera en sorte que ca lance le tamagotchi
         */
        Button replay = new Button("replay");
        replay.setOnMouseClicked(e ->{
            stage.close();
            NoTamaFx newTama = new NoTamaFx();
            newTama.start(new Stage());
        });
        VBox vbox = new VBox(replay);
vbox.getStyleClass().addAll("button-container", "centered-vbox");
/*
 * élement déja centrer acvec border pane
 */
        BorderPane scene = new BorderPane();
        scene.setCenter(vbox);

        Scene mainScene = new Scene(scene, 600, 600);
        mainScene.getStylesheets().add(getClass().getResource("/dead.css").toString());

        stage.setScene(mainScene);
        stage.show();
    }



}