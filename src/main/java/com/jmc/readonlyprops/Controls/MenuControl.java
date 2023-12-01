package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class MenuControl extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um painel de borda para organizar os componentes
        BorderPane root = new BorderPane();

        // Cria uma barra de menus
        MenuBar menu = new MenuBar();

        // Cria um menu "File" com itens "Save" e "Exit"
        Menu file = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(actionEvent -> Platform.exit());
        file.getItems().addAll(save, exit);

        // Cria um menu "Edit" com itens "Options" e "Settings"
        Menu edit = new Menu("Edit");
        RadioMenuItem option = new RadioMenuItem("Options");
        RadioMenuItem settings = new RadioMenuItem("Settings");

        // Cria um submenu "Preferences" com itens "Pref: One" e "Pref: Two"
        Menu prefs = new Menu("Preferences");
        MenuItem prefOne = new MenuItem("Pref: One");
        MenuItem prefTwo = new MenuItem("Pref: Two");
        edit.getItems().addAll(option, settings, new SeparatorMenuItem(), prefs);
        prefs.getItems().addAll(prefOne, prefTwo);

        // Adiciona os menus à barra de menus
        menu.getMenus().addAll(file, edit);

        // Define a barra de menus no topo do painel de borda
        root.setTop(menu);

        // Cria uma cena com o painel de borda
        Scene scene = new Scene(root, 500, 450);

        // Configura a cena no palco (stage)
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("Menu Control Example");

        // Exibe o palco
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
