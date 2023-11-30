package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Gridpane4 extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um GridPane, que é um layout em grade
        GridPane root = new GridPane();
        root.setGridLinesVisible(true); // Torna as linhas da grade visíveis para depuração

        // Loop para criar botões em uma matriz 3x3 e adicioná-los ao GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button b = new Button(col + "|" + row);
                root.add(b, col, row); // Adiciona o botão na posição (col, row) da grade
            }
        }

        // Configuração de colunas e suas restrições
        ColumnConstraints cc1 = new ColumnConstraints(100);
        cc1.setHalignment(HPos.LEFT);
        ColumnConstraints cc2 = new ColumnConstraints(200);
        cc2.setHalignment(HPos.CENTER);
        ColumnConstraints cc3 = new ColumnConstraints(200);
        cc3.setHalignment(HPos.RIGHT);

        // Configuração de linhas e suas restrições
        RowConstraints rc1 = new RowConstraints(50);
        rc1.setValignment(VPos.TOP);
        RowConstraints rc2 = new RowConstraints(70);
        rc2.setValignment(VPos.CENTER);
        RowConstraints rc3 = new RowConstraints(60);

        // Adiciona as configurações de coluna e linha ao GridPane
        root.getColumnConstraints().addAll(cc1, cc2, cc3);
        root.getRowConstraints().addAll(rc1, rc2, rc3);

        // Estilização do GridPane
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
