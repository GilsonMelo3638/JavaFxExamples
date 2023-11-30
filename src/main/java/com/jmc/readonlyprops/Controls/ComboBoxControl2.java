package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ComboBoxControl2 extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        ComboBox<String> names = new ComboBox<>();
        names.getItems().addAll("Patrick", "Sam", "Sara");
        names.setCellFactory(ListView -> new ShapeNameCell());
        names.setButtonCell(new ShapeNameCell());
        root.getChildren().addAll(names);
        Scene scene = new Scene(root, 500, 450);
        root.requestFocus();
        stage.setScene(scene);
        stage.setTitle("ComboBox Control Example");
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
