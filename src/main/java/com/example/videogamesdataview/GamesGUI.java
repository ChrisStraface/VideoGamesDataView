package com.example.videogamesdataview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GamesGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GamesGUI.class.getResource("GamesGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 984, 470);
        stage.setTitle("Game Sales Table");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}