package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ButtonControl extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um AnchorPane como root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Button button = new Button("Click Me");
        Button other = new Button("Other");
        Rectangle rectangle = new Rectangle(20,20, Color.CYAN);
        other.setGraphic(rectangle);
        root.getChildren().addAll(other, button);
        button.setCancelButton(true);
        button.setOnAction(actionEvent -> {
            System.out.println("Quiting Program!");
            Platform.exit();
        });
        Scene scene = new Scene(root, 500, 450);
        stage.setTitle("Button Control Example");
        stage.setScene(scene);
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
