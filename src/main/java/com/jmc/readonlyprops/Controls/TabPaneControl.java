package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class TabPaneControl extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("TabPane Control Example");
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
