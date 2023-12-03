package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class TabPaneControl extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um painel de borda para organizar os componentes
        BorderPane root = new BorderPane();

        // Cria um painel de abas
        TabPane pane = new TabPane();

        // Cria duas abas, "One" e "Two"
        Tab one = new Tab("One");
        Tab two = new Tab("Two");

        // Define que a aba "Two" não pode ser fechada
        two.setClosable(false);

        // Cria conteúdo para a aba "One"
        VBox contentOne = new VBox();
        contentOne.setAlignment(Pos.CENTER);
        contentOne.getChildren().addAll(new Label("Content for Tab One"));

        // Cria conteúdo para a aba "Two"
        VBox contentTwo = new VBox();
        contentTwo.setAlignment(Pos.CENTER);
        contentTwo.getChildren().addAll(new Button("Content Two"));

        // Define o conteúdo das abas
        one.setContent(contentOne);
        two.setContent(contentTwo);

        // Adiciona as abas ao painel de abas
        pane.getTabs().addAll(one, two);

        // Define o painel de abas no centro do painel de borda
        root.setCenter(pane);

        // Cria uma cena com o painel de borda
        Scene scene = new Scene(root, 500, 450);

        // Configura a cena no palco (stage)
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("TabPane Control Example");

        // Exibe o palco
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
