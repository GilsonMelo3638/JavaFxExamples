package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class LabelControl extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um AnchorPane como root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Hello World");
        Rectangle rectangle = new Rectangle(20, 20, Color.RED);
        label.setGraphic(rectangle);
        label.setUnderline(true);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        label.setTextFill(Color.GREEN);
        root.getChildren().addAll(label);
        Scene scene = new Scene(root, 500, 450);
        stage.setTitle("Label Control Example");
        stage.setScene(scene);
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
