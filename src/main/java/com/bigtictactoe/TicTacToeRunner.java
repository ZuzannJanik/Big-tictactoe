package com.bigtictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeRunner extends Application { //rozszerzenie dla javafx
    @Override //metoda abstrakcyjna uruchamiająca
    public void start(Stage stage) throws IOException {
        VBox bigBoard = FXMLLoader.load(getClass().getResource("hello-view.fxml")); //wywołanie pliku z scene buildera
        Scene mainScene = new Scene(bigBoard); //utworzenie nowej sceny
        stage.setScene(mainScene); //dodawanie sceny
        stage.setTitle("TicTacToe 10x10");
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);

    }
}
