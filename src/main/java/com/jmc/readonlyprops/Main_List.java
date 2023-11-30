package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Main_List extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um layout VBox como root
        VBox root = new VBox();

        // Configurações de layout para o VBox
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);

        // Cria uma lista observável com alguns itens iniciais
        ObservableList<String> list = FXCollections.observableArrayList("One", "Two", "Three");

        // Cria uma ListView para exibir os itens
        ListView<String> items = new ListView<>();

        // Cria um campo de texto para inserir novos itens
        TextField field = new TextField();
        field.setMaxWidth(200);

        // Cria um botão para adicionar itens à lista
        Button button = new Button("ADD");
        button.setOnAction(actionEvent -> {
            // Verifica se o campo de texto não está vazio antes de adicionar um novo item
            if (!field.textProperty().get().isEmpty()) {
                list.add(field.getText());
            }
        });

        // Define a lista observável como os itens da ListView
        items.setItems(list);

        // Adiciona a ListView, o campo de texto e o botão ao layout VBox
        root.getChildren().addAll(items, field, button);

        // Cria uma cena com o layout VBox e define o tamanho
        Scene scene = new Scene(root, 500, 500);

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