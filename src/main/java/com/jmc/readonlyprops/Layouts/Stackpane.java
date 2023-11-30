package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Stackpane extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um layout StackPane como root
        StackPane pane = new StackPane();

        // Cria um retângulo com largura 300 e altura 250 e o preenche com a cor LAVENDER
        Rectangle rectangle = new Rectangle(300, 250);
        rectangle.setFill(Color.LAVENDER);

        // Cria um rótulo "A Rectangle"
        Label label = new Label("A Rectangle");

        // Alinha o rótulo no canto superior esquerdo do StackPane
        StackPane.setAlignment(label, Pos.TOP_LEFT);

        // Adiciona o retângulo e o rótulo ao StackPane
        pane.getChildren().addAll(rectangle, label);

        // Cria uma cena com o layout StackPane e define o tamanho
        Scene scene = new Scene(pane, 400, 350);

        // Define a cena no palco
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("StackPane Layout Example");

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void BorderPane(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
