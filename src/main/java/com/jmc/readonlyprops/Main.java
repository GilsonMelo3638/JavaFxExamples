package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Main extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um layout VBox como root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        Label label = new Label("Welcome");
        TextField field = new TextField();
        Button button = new Button("Bind Label To Field");
   //     TextField field1 = new TextField();
        field.setMaxWidth(200);
     //   field.textProperty().addListener((obs, oldVal, newVal) -> label.setText(newVal));
     //   label.textProperty().bind(field.textProperty());
     //   field1.textProperty().bindBidirectional(field.textProperty());
      //  root.getChildren().addAll(label, field);
        root.getChildren().addAll(label, field, button);
        button.setOnAction(actionEvent -> label.textProperty().bind(field.textProperty()));
      //  root.getChildren().addAll(label, field, field1);
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
