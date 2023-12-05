package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class TreeViewControl_2 extends Application {

    @Override
    public void start(Stage stage) {
        // Configuração do layout principal
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Criação da TreeView
        TreeView<String> treeView = new TreeView<>();

        // Criação dos itens da TreeView
        TreeItem<String> classes = new TreeItem<>("Classes");
        TreeItem<String> classOne = new TreeItem<>("Class One");
        classOne.setExpanded(true);
        classOne.getChildren().addAll(
                new TreeItem<>("Patrick"),
                new TreeItem<>("Sam"),
                new TreeItem<>("James"),
                new TreeItem<>("Sara")
        );
        TreeItem<String> classTwo = new TreeItem<>("Class Two");
        classTwo.setExpanded(true);
        classTwo.getChildren().addAll(
                new TreeItem<>("Peter"),
                new TreeItem<>("Abigail"),
                new TreeItem<>("Gisele"),
                new TreeItem<>("Gilson")
        );

        // Adiciona um manipulador de evento para o evento de recolher um nó da TreeView
        classTwo.addEventHandler(TreeItem.branchCollapsedEvent(), e ->
                System.out.println(e.getTreeItem().getValue()));

        // Adiciona os itens à TreeView
        classes.getChildren().addAll(classOne, classTwo);
        treeView.setRoot(classes);
        treeView.setShowRoot(false);

        // Configuração de edição da TreeView
        treeView.setEditable(true);
        treeView.setCellFactory(TextFieldTreeCell.forTreeView());
        treeView.setOnEditCommit(e -> {
            // Atualiza o valor do nó com o novo valor após a edição
            e.getTreeItem().setValue(e.getNewValue());
        });

        // Adiciona a TreeView ao layout principal
        root.getChildren().addAll(treeView);

        // Configuração da cena
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("TreeView Control Example");
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
