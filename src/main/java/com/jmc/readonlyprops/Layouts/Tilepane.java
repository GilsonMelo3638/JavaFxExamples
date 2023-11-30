package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Tilepane extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um layout TilePane com espaçamento horizontal e vertical de 5 pixels
        TilePane tilePane = new TilePane(5, 5);

        // Define o número desejado de colunas para o TilePane
        tilePane.setPrefColumns(3);

        // Define a alinhamento dos elementos dentro dos "tiles"
        tilePane.setTileAlignment(Pos.BOTTOM_LEFT);

        // Adiciona botões ao TilePane
        tilePane.getChildren().addAll(
                new Button("Tiles"),
                new Button("are"),
                new Button("aligned"),
                new Button("at"),
                new Button("CENTER")
        );

        // Cria uma cena com o layout TilePane
        Scene scene = new Scene(tilePane);

        // Define a cena no palco
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("TilePane Layout Example");

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void BorderPane(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
