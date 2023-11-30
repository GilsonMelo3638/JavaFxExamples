package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Hbox extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um layout HBox como root
        HBox hBox = new HBox();

        // Configurações de layout para o HBox
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setFillHeight(false);  // Permite que os elementos dentro do HBox não ocupem toda a altura disponível

        // Cria um rótulo "Hello World!"
        Label label = new Label("Hello World!");

        // Cria uma área de texto
        TextArea textArea = new TextArea();

        // Configurações para o crescimento horizontal da área de texto
        HBox.setHgrow(textArea, Priority.ALWAYS);

        // Margem da área de texto
        HBox.setMargin(textArea, new Insets(0, 10, 0, 10));

        // Adiciona o rótulo e a área de texto ao layout HBox
        hBox.getChildren().addAll(label, textArea);

        // Cria uma cena com o layout HBox e define o tamanho
        Scene scene = new Scene(hBox, 750, 500);

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
