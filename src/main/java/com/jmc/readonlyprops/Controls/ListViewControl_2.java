package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ListViewControl_2 extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um contêiner VBox para organizar os elementos na cena
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Cria uma ListView para exibir as tarefas
        ListView<Task> taskListView = new ListView<>();

        // Cria uma lista observável de tarefas e adiciona algumas tarefas a ela
        ObservableList<Task> tasks = FXCollections.observableArrayList(
                new Task("Create Java Project"),
                new Task("Create Bug Report"),
                new Task("Commit changes to repo")
        );

        // Define uma fábrica de células personalizada para a ListView
        taskListView.setCellFactory(taskListView1 -> new CustonTaskCell());

        // Adiciona as tarefas à ListView
        taskListView.getItems().addAll(tasks);

        // Adiciona a ListView ao contêiner VBox
        root.getChildren().addAll(taskListView);

        // Cria uma cena com o contêiner VBox como nó raiz
        Scene scene = new Scene(root, 500, 450);

        // Configura a cena no palco (Stage)
        stage.setScene(scene);

        // Define o título do palco
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
