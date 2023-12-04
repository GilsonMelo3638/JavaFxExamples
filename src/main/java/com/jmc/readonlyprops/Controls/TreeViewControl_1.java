package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class TreeViewControl_1 extends Application {

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

        // Configuração da fábrica de células da TreeView
        treeView.setCellFactory(tCell -> {
            TreeCell<String> cell = new TreeCell<>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(null);
                    setGraphic(null);
                    if (!empty) {
                        // Condição para verificar o valor do nó e definir a cor do retângulo
                        if (this.getTreeItem().getValue().equals("Patrick")) {
                            setText(item);
                            setGraphic(new Rectangle(15, 15, Color.BLUE));
                        } else {
                            setText(item);
                            setGraphic(new Rectangle(15, 15, Color.VIOLET));
                        }
                    }
                }
            };
            return cell;
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
