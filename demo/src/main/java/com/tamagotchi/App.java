package com.tamagotchi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public void start(Stage window) throws Exception {
        Button b = new Button("+");
        Button b2 = new Button("-");
        Label l = new Label("0"); 
        VBox root = new VBox();
        root.getChildren().addAll(b,b2,l);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        window.show();
        final int counter = 0;
        b.setOnAction((event) -> {
            int count = counter;
            count++;
            l.setText(count + "");
        });
        b2.setOnAction((event) -> {
            int count = counter;
            count--;
            l.setText(count + "");
        });
    }
    
    public static void main(String[] args){
        launch();
    }
}
