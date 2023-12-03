package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ListViewControl_1 extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um VBox como contêiner principal
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Cria uma etiqueta para exibir o item selecionado
        Label selected = new Label();

        // Cria um botão para selecionar o primeiro item na lista
        Button selectFirst = new Button("Select First");

        // Cria um ListView com orientação horizontal e seleção múltipla
        ListView<String> list = new ListView<>();
        ObservableList<String> names = FXCollections.observableArrayList("Gilson", "Márcia", "Danielly", "Isabelly");

        // Adiciona um ouvinte para a mudança de seleção
        list.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVal, newVal) -> selected.setText(newVal));

        // Configura o ListView com orientação horizontal e seleção múltipla
        list.setOrientation(Orientation.HORIZONTAL);
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list.getItems().addAll(names);

        // Adiciona um botão para selecionar o primeiro item
        selectFirst.setOnAction(actionEvent -> list.getSelectionModel().selectFirst());

        // Adiciona os elementos ao contêiner principal
        root.getChildren().addAll(selected, list, selectFirst);

        // Cria uma cena com o contêiner principal
        Scene scene = new Scene(root, 500, 450);

        // Configura a cena no palco (stage)
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("ListView Control Example");

        // Exibe o palco
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
