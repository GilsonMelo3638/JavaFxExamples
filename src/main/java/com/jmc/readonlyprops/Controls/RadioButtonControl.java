package com.jmc.readonlyprops.Controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class RadioButtonControl extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um AnchorPane como root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Your Selection is: ");
        ToggleButton spring = new ToggleButton("Spring");
        ToggleButton summer = new ToggleButton("Summer");
        ToggleButton fall = new ToggleButton("Fall");
        ToggleButton winter = new ToggleButton("Winter");
        ToggleGroup seasons = new ToggleGroup();
        seasons.getToggles().addAll(spring, summer, fall, winter);
        HBox seasonsLayout = new HBox();
        seasonsLayout.setAlignment(Pos.CENTER);
        seasonsLayout.setSpacing(5);
        seasonsLayout.getChildren().addAll(spring, summer, fall, winter);
        root.getChildren().addAll(label, seasonsLayout);
        seasons.selectedToggleProperty().addListener(((observableValue, toggle, t1) -> {
            label.setText("Your Selection is " + ((Labeled)t1).getText());
        }));

        Scene scene = new Scene(root, 500, 450);
        stage.setTitle("MenuButton Control Example");
        stage.setScene(scene);
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
