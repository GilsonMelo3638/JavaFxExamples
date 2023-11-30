package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Borderpane extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();

        // Left Nodes
        ListView<String> FruitList = new ListView<>();
        ObservableList<String> itens = FXCollections.observableArrayList();
        itens.add("Apples");
        itens.add("Oranges");
        itens.add("Peneapples");
        FruitList.setItems(itens);
        //Top Nodes
        Label topLabel = new Label("FuitList Application");
        topLabel.setPadding(new Insets(10));
        // Button Nodes
        Label bottonLabel = new Label("Recently Added Fruit: None");
        bottonLabel.setPadding(new Insets(10));

        // Right Nodes
        Label rightLabel = new Label("Total Number Of Fruit Types" + FruitList.getItems().size());
        rightLabel.setRotate(90);
        rightLabel.setPadding(new Insets(0, 0,0,60));

        // Center Nodes
        TextField field = new TextField();
        Button btn = new Button("ADD");
        HBox centerContainer = new HBox(10, field, btn);

        // Setting BorderPane Regions
        borderPane.setTop(topLabel);
        borderPane.setRight(rightLabel);
        borderPane.setBottom(bottonLabel);
        borderPane.setLeft(FruitList);
        borderPane.setCenter(centerContainer);

        // Register Event Handler
        btn.setOnMouseClicked(mouseEvent -> {
            String item = field.getText();
            itens.add(item);
            bottonLabel.setText("Recently Added Fruit: " + item);
            rightLabel.setText("Total Number Of Fruit Types: " + FruitList.getItems().size());
            field.clear();
        });

        Scene scene = new Scene(borderPane, 700, 650);
        stage.setScene(scene);
        stage.setTitle("Border Pane Layout Example");
        stage.show();
    }

    public static void BorderPane(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
