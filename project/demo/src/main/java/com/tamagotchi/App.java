package com.tamagotchi;

import javafx.application.Application;



/**
 * JavaFX App
 */
public class App  {

    


    public static void main(String[] args) {
        String starting = Choice.start();
        System.out.println(starting);
        if ("1".equals(starting)) {
            Application.launch(JavaFx.class, args);
        } else {
            GameManager gameManager = new GameManager();

            gameManager.gamemanager();
        }
    }

}