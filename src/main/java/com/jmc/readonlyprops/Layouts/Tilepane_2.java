package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Tilepane_2 extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria dois TilePanes com diferentes alinhamentos e os coloca em um layout HBox
        TilePane tileCenter = createTilePane(Pos.CENTER);
        TilePane tileLeft = createTilePane(Pos.BOTTOM_LEFT);
        HBox root = new HBox(10, tileCenter, tileLeft);

        // Cria uma cena com o layout HBox
        Scene scene = new Scene(root);

        // Define a cena no palco
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("TilePane Layout Example");

        // Exibe a janela
        stage.show();
    }

    // Método que cria um TilePane com botões e um alinhamento específico
    public TilePane createTilePane(Pos tileAlignment) {
        Button[] buttons = new Button[]{
                new Button("Tiles"),
                new Button("are"),
                new Button("aligned"),
                new Button("at"),
                new Button(tileAlignment.toString())
        };

        // Cria um TilePane com espaçamento horizontal e vertical de 5 pixels e os botões fornecidos
        TilePane pane = new TilePane(5, 5, buttons);

        // Define o alinhamento dos "tiles"
        pane.setTileAlignment(tileAlignment);

        // Define o número desejado de colunas para o TilePane
        pane.setPrefColumns(3);

        // Retorna o TilePane criado
        return pane;
    }

    // Método main, ponto de entrada da aplicação
    public static void BorderPane(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
