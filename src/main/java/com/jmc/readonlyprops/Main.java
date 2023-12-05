package com.jmc.readonlyprops;

import com.jmc.readonlyprops.Concurrency.EvenNumTask;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Main extends Application {
    // Botões para iniciar, cancelar e sair
    Button startBtn = new Button("Iniciar");
    Button cancelBtn = new Button("Cancelar");
    Button exitBtn = new Button("Sair");

    // Tarefa para verificar números pares
    EvenNumTask task = new EvenNumTask(1, 20, 1000);

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Ação do botão iniciar
        startBtn.setOnAction(e -> {
            // Cria uma nova thread para executar a tarefa
            Thread bgThread = new Thread(task);
            bgThread.setDaemon(true);
            bgThread.start();
        });

        // Ação do botão cancelar
        cancelBtn.setOnAction(e -> task.cancel());

        // Ação do botão sair
        exitBtn.setOnAction(e -> stage.close());

        // Painel para exibir informações da tarefa
        GridPane pane = new WorkerUI(task);

        // Caixa de botões na parte inferior
        HBox box = new HBox(5, startBtn, cancelBtn, exitBtn);

        // Layout principal da aplicação
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(box);

        // Cena principal
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Verificador de Números Pares");
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch(args);
    }
}
