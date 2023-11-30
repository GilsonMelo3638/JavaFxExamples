package com.jmc.readonlyprops.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Textflow extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        TextFlow root = new TextFlow();
        Text heading = new Text("Lorem Ipsum");
        heading.setFill(Color.BLUE);
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        Text paragraph = new Text("\n" +
                "A devastação equivale a quase duas vezes o tamanho de Brasília: 11 mil km² no período de agosto do ano passado a julho deste ano. Os dados são do Prodes, o sistema de monitoramento por satélite do Inpe.\n" +
                "É o quarto ano consecutivo de aumento da derrubada de vegetação nativa, mas o governo ressaltou que os 3% de agora representam um ritmo menor de destruição na comparação com o governo anterior.");

        root.setLineSpacing(5);
        root.setTextAlignment(TextAlignment.CENTER);
        root.setPrefWidth(300);

        root.getChildren().addAll(heading, paragraph);
        Scene scene = new Scene(root);


        // Define o título da janela
        stage.setTitle("TextFlow Layout Example");

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
