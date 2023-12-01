package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class DataPickerControl extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um VBox como root
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Cria um Label para exibir a data escolhida
        Label dateLabel = new Label();

        // Cria um DatePicker
        DatePicker datePicker = new DatePicker();

        // Desativa a edição direta do DatePicker
        datePicker.setEditable(false);

        // Adiciona um evento ao DatePicker para atualizar o Label com a data escolhida
        datePicker.setOnAction(actionEvent -> dateLabel.setText(datePicker.getValue().toString()));

        // Adiciona o Label e o DatePicker ao VBox
        root.getChildren().addAll(dateLabel, datePicker);

        // Cria uma cena com o VBox como nó raiz
        Scene scene = new Scene(root, 500, 450);

        // Define a cena no palco
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("DatePicker Control Example");

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}