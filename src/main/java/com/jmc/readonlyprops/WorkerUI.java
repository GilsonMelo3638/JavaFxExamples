package com.jmc.readonlyprops;

import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Uma classe que representa uma interface gráfica customizada para exibir informações sobre um Worker do JavaFX.
 */
public class WorkerUI extends GridPane {
    // Labels para exibir informações do Worker
    private final Label title = new Label("");
    private final Label message = new Label("");
    private final Label running = new Label("");
    private final Label state = new Label("");
    private final Label totalWork = new Label("");
    private final Label workDone = new Label("");
    private final Label progress = new Label("");

    // Barra de progresso para exibir o progresso do Worker
    private final ProgressBar progressBar = new ProgressBar();

    // Áreas de texto para exibir valores e exceções do Worker
    private final TextArea value = new TextArea();
    private final TextArea exception = new TextArea();

    /**
     * Constrói uma instância da classe WorkerUI.
     *
     * @param worker O Worker do JavaFX que será monitorado e exibido.
     */
    public WorkerUI(Worker<ObservableList<Integer>> worker) {
        configurarUI();      // Método para configurar o layout
        vincularAWorker(worker);  // Método para vincular os elementos de interface às propriedades do Worker
    }

    /**
     * Configura o layout e adiciona elementos de interface à GridPane.
     */
    private void configurarUI() {
        // Configuração das áreas de texto
        value.setPrefColumnCount(20);
        value.setPrefRowCount(4);
        value.setWrapText(true);

        exception.setPrefColumnCount(20);
        exception.setPrefRowCount(5);

        // Configuração do espaçamento na GridPane
        this.setHgap(5);
        this.setVgap(5);

        // Adição de rótulos e elementos de interface à GridPane
        addRow(0, new Label("Título"), title);
        addRow(1, new Label("Mensagem"), message);
        addRow(2, new Label("Executando"), running);
        addRow(3, new Label("Estado"), state);
        addRow(4, new Label("Trabalho Total"), totalWork);
        addRow(5, new Label("Trabalho Concluído"), workDone);
        addRow(6, new Label("Progresso"), new HBox(2, progressBar, progress));
        addRow(7, new Label("Valor"), value);
        addRow(8, new Label("Exceção"), exception);
    }

    /**
     * Vincula os elementos de interface às propriedades do Worker fornecido.
     *
     * @param worker O Worker do JavaFX a ser monitorado.
     */
    private void vincularAWorker(Worker<ObservableList<Integer>> worker) {
        // Vinculação das propriedades do Worker aos elementos de interface correspondentes
        title.textProperty().bind(worker.titleProperty());
        message.textProperty().bind(worker.messageProperty());
        running.textProperty().bind(worker.runningProperty().asString());
        state.textProperty().bind(worker.stateProperty().asString());

        // Configuração do texto com base no valor da propriedade totalWork do Worker
        totalWork.textProperty().bind(
                new When(worker.totalWorkProperty().isEqualTo(-1))
                        .then("Desconhecido")
                        .otherwise(worker.totalWorkProperty().asString()));

        // Configuração do texto com base no valor da propriedade workDone do Worker
        workDone.textProperty().bind(
                new When(worker.workDoneProperty().isEqualTo(-1))
                        .then("Desconhecido")
                        .otherwise(worker.workDoneProperty().asString()));

        // Configuração do texto com base no valor da propriedade progress do Worker
        progress.textProperty().bind(
                new When(worker.progressProperty().isEqualTo(-1))
                        .then("Desconhecido")
                        .otherwise(worker.progressProperty().multiply(100).asString("%.2f%%")));

        // Vinculação da propriedade progress do Worker à propriedade progress da barra de progresso
        progressBar.progressProperty().bind((worker.progressProperty()));

        // Vinculação da propriedade value do Worker à propriedade text da área de texto "value"
        value.textProperty().bind(worker.valueProperty().asString());

        // Listener para atualizar a área de texto "exception" quando uma exceção ocorre
        worker.exceptionProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                exception.setText(newVal.getMessage());
            } else {
                exception.setText("");
            }
        });
    }
}
