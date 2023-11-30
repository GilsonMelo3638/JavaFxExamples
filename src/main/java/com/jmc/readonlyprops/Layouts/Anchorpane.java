package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Anchorpane extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um AnchorPane como root
        AnchorPane root = new AnchorPane();

        // Cria uma cena com o AnchorPane e define sua largura e altura
        Scene scene = new Scene(root, 500, 450);

        // Cria dois botões
        Button bottonRight = new Button("Button Right");
        Button topLeft = new Button("Top Left");

        // Define a posição do botão 'bottonRight' no canto inferior direito
        AnchorPane.setBottomAnchor(bottonRight, 10.0);
        AnchorPane.setRightAnchor(bottonRight, 10.0);

        // Define a posição do botão 'topLeft' no canto superior esquerdo
        AnchorPane.setTopAnchor(topLeft, 20.0);
        AnchorPane.setLeftAnchor(topLeft, 50.0);

        // Adiciona os botões ao AnchorPane
        root.getChildren().addAll(topLeft, bottonRight);

        // Define o título da janela
        stage.setTitle("AnchorPane Layout Example");

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
