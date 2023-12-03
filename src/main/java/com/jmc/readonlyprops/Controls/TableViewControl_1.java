package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class TableViewControl_1 extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("TableView Control Example");
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
