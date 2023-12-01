package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ComboBoxControl_1 extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um contêiner VBox para organizar os elementos na cena
        VBox root = new VBox(10); // Espaçamento vertical de 10 pixels entre os nós
        root.setAlignment(Pos.CENTER); // Alinha o VBox ao centro da cena

        // Rótulo para exibir a seleção do nome
        Label label = new Label("Name Selected:");

        // ComboBox que permite a seleção de nomes, com um texto de prompt
        ComboBox<String> names = new ComboBox<>();
        names.setPromptText("Select a Name"); // Define o texto de prompt
        names.setEditable(true); // Permite a edição do ComboBox

        // Lista de nomes disponíveis
        ObservableList<String> nameList = FXCollections.observableArrayList("Patrick", "San", "Ken", "Sara");

        // Adiciona os nomes à lista de opções do ComboBox
        names.getItems().addAll(nameList);

        // Adiciona um ouvinte para capturar a mudança de seleção
        names.getSelectionModel().selectedItemProperty().addListener(o ->
                label.setText("Name Selected: " + names.getSelectionModel().getSelectedItem()));

        // Adiciona os elementos ao VBox
        root.getChildren().addAll(label, names);

        // Cria a cena com o VBox, definindo sua largura e altura
        Scene scene = new Scene(root, 500, 450);

        // Define o foco no VBox para interação do usuário
        root.requestFocus();

        // Define a cena no palco (Stage) e exibe o palco
        stage.setScene(scene);
        stage.setTitle("ComboBox Control Example"); // Define o título da janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
