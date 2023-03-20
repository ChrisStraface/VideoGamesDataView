package com.example.videogamesdataview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GamesGUI extends Application {
    GamesController myController;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(GamesGUI.class.getResource("GamesGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 807, 520);
        myController = fxmlLoader.getController();
        stage.setTitle("Game Sales Table");
        stage.setScene(scene);
        stage.show();
    }
    public void stop() throws Exception {
        myController.saveData();
    }
    public static void main(String[] args) {
        launch();
    }
}