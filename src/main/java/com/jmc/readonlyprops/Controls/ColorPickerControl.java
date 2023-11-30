package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ColorPickerControl extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um VBox como root
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Cria um ColorPicker
        ColorPicker colorPicker = new ColorPicker();

        // Adiciona um evento ao ColorPicker para mudar o fundo do VBox
        colorPicker.setOnAction(actionEvent ->
                root.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY))));

        // Adiciona o ColorPicker ao VBox
        root.getChildren().addAll(colorPicker);

        // Cria uma cena com o VBox como nó raiz
        Scene scene = new Scene(root, 500, 450);

        // Define a cena no palco
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("Color Picker Control Example");

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
