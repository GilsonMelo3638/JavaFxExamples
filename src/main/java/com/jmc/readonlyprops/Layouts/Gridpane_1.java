package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Gridpane_1 extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        Button b1 = new Button("One");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");


        root.getChildren().addAll(b1, b2, b3);

        GridPane.setConstraints(b1, 0, 0);
        GridPane.setConstraints(b2, 1, 0);
        GridPane.setConstraints(b3, 0, 1);
        root.setStyle("-fx-padding: 10;"+"-fx-border-style: solid inside;"+"-fx-border-width: 2;"+"-fx-border-insets: 5;"+"-fx-border-radius: 5;"+"-fx-border-color:blue;");

        Scene scene = new Scene(root);

        // Define o título da janela
        stage.setTitle("GridPane Layout Example");

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
