package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class SlideControl extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um contêiner VBox para organizar os controles verticalmente
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Cria controles deslizantes (sliders) para as componentes de cor vermelha, verde e azul
        Slider red = new Slider(0, 255, 0);
        Slider green = new Slider(0, 255, 0);
        Slider blue = new Slider(0, 255, 0);

        // Agrupa os sliders em um array para facilitar a iteração
        Slider[] sliders = { red, green, blue };

        // Adiciona um ouvinte de alteração para cada slider
        for (Slider slider : sliders) {
            // Configura os sliders para exibir marcas de intervalo e incremento de bloco de 5
            slider.setShowTickMarks(true);
            slider.setBlockIncrement(5);

            // Adiciona um ouvinte para a propriedade de valor de cada slider
            slider.valueProperty().addListener(observable -> {
                // Obtém os valores atuais de cada slider
                int redColor = (int) red.getValue();
                int greenColor = (int) green.getValue();
                int blueColor = (int) blue.getValue();

                // Atualiza o estilo do contêiner para refletir a cor selecionada
                root.setStyle("-fx-background-color: rgb(" + redColor + "," + greenColor + "," + blueColor + ");");
            });
        }

        // Adiciona os sliders ao contêiner VBox
        root.getChildren().addAll(red, green, blue);

        // Cria uma cena com o contêiner VBox
        Scene scene = new Scene(root, 500, 450);

        // Configura a cena no palco (stage)
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("Color Picker Control Example");

        // Exibe o palco
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
