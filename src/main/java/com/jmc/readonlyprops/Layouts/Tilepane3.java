package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Tilepane3 extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        TilePane root = new TilePane(5, 5);
        Button b12 = new Button("One\nTwo");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");
        Button b5 = new Button("Five");
        Button b6 = new Button("Six");

        TilePane.setAlignment(b3, Pos.BOTTOM_RIGHT);
        root.getChildren().addAll(b12, b3, b4, b5, b6);
        root.setPrefColumns(3);

        Scene scene = new Scene(root);

        // Define o título da janela
        stage.setTitle("TilePane Layout Example");

        // Define a cena no palco
        stage.setScene(scene);

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
