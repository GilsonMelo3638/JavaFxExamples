package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Flowpane extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um layout FlowPane como root
        FlowPane flowPane = new FlowPane();

        // Configurações de layout para o FlowPane
        // flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        // flowPane.setRowValignment(VPos.BOTTOM);
        flowPane.setColumnHalignment(HPos.RIGHT);

        // Cria botões, uma área de texto e os adiciona ao FlowPane
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        TextArea textArea = new TextArea();
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        Button button6 = new Button("Button6");
        flowPane.getChildren().addAll(button1, button2, button3, textArea, button4, button5, button6);

        // Cria uma cena com o layout FlowPane e define o tamanho
        Scene scene = new Scene(flowPane, 500, 450);

        // Define a cena no palco
        stage.setScene(scene);

        // Define o título da janela
        stage.setTitle("Flow Pane Layout Example");

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void Flowpane(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
