package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Gridpane3 extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um GridPane
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); // Define o alinhamento do GridPane para o centro
        root.setGridLinesVisible(true); // Torna as linhas da grade visíveis para depuração

        root.setHgap(10); // Define o espaçamento horizontal entre as células da grade
        root.setVgap(10); // Define o espaçamento vertical entre as células da grade

        // Cria componentes GUI
        Label label = new Label("First Name:");
        TextField field = new TextField();
        Button button = new Button("COMMENT");
        TextArea area = new TextArea();
        area.setPromptText("Enter Your Message Here"); // Define um texto de orientação para a área de texto

        // Adiciona os componentes à grade
        root.addRow(0, label, field, button); // Adiciona a primeira linha da grade
        root.add(area, 0, 1, GridPane.REMAINING, 1); // Adiciona a área de texto na segunda linha, ocupando várias colunas

        // Estiliza o GridPane
        root.setStyle("-fx-padding: 10; " +
                "-fx-border-style: solid inside; " +
                "-fx-border-width: 2; " +
                "-fx-border-insets: 5; " +
                "-fx-border-radius: 5; " +
                "-fx-border-color: blue;");

        // Cria uma cena com o GridPane
        Scene scene = new Scene(root);
        root.requestFocus(); // Define o foco no GridPane

        // Define o título da janela
        stage.setTitle("GridPane Layout Example");

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
