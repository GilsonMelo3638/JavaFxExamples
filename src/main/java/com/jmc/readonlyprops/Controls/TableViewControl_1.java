package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class TableViewControl_1 extends Application {

    @Override
    public void start(Stage stage) {
        // Configuração do layout principal
        VBox root = new VBox(10);

        // Criação da tabela de usuários
        TableView<User> usersTable = new TableView<>(UserUtility.getUsersList());
        usersTable.setEditable(true);

        // Adiciona as colunas à tabela
        usersTable.getColumns().addAll(
                UserUtility.getFirstNameColumn(),
                UserUtility.getLastNameColumn(),
                UserUtility.getBirthDateColumn(),
                UserUtility.getDeleteUserColumn()
        );

        // Seleciona o primeiro item na tabela
        usersTable.getSelectionModel().selectFirst();

        // Adiciona a tabela ao layout principal
        root.getChildren().addAll(usersTable);

        // Configuração da cena
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("TableView Control Example");
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
