package com.jmc.readonlyprops;

import com.jmc.readonlyprops.Concurrency.EvenNumTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Provider;

// Classe principal que estende Application, representando a aplicação JavaFX
public class Main extends Application {
    // Botões para iniciar, resetar, cancelar e sair
    Button startBtn = new Button("Iniciar");
    Button resetBtn = new Button("Reset");
    Button cancelBtn = new Button("Cancelar");
    Button exitBtn = new Button("Sair");
    boolean onceStarted = false;

    //Service<ObservableList<Integer>> service = new Service<>() {
    ScheduledService<ObservableList<Integer>> service = new ScheduledService<>() {
        @Override
        protected Task<ObservableList<Integer>> createTask() {
           // return new EvenNumTask(1, 20, 1000);
            return new EvenNumTask(1, 20, 100);
        }
    };

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        service.setPeriod(Duration.seconds(5));
        // Ação do botão iniciar
        startBtn.setOnAction(e -> {
            if (onceStarted) {
                service.restart();
            } else {
                service.start();
                onceStarted = true;
                startBtn.setText("Restart");
            }
        });

        // Ação do botão cancelar
        cancelBtn.setOnAction(e -> service.cancel());
        // Ação do botão resetar
        resetBtn.setOnAction(e -> service.reset());
        // Ação do botão sair
        exitBtn.setOnAction(e -> Platform.exit());

        // Painel para exibir informações da tarefa
        GridPane pane = new WorkerUI(service);

        // Caixa de botões na parte inferior
        HBox box = new HBox(5, startBtn, resetBtn, cancelBtn, exitBtn);

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
