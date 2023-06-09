package com.tamagotchi;

import java.security.Permission;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Spawnjfx start = new Spawnjfx();
        start.start(stage);
    }

    public static void main(String[] args) {
        String starting = Choice.start();
        System.out.println(starting);
        if ("1".equals(starting)) {
            launch();
        } else {
            GameManager.gamemanager();
        }
    }

}