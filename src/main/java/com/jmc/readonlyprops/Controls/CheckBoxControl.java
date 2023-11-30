// Importações necessárias do pacote JavaFX e do Java
package com.jmc.readonlyprops.Controls;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class CheckBoxControl extends Application {
    // Rótulo para exibir a resposta do usuário
    Label answer;
    // CheckBox para escolha do usuário
    CheckBox checkBox;

    // Método init, chamado antes do start, usado para inicializar recursos
    public  void init(){
        // Inicializa o rótulo com texto padrão
        answer = new Label("Your Answer: None");
        // Inicializa a CheckBox com o texto "Choice"
        checkBox = new CheckBox("Choice");
    }

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um contêiner VBox para organizar os elementos verticalmente
        VBox root = new VBox(10); // Espaçamento vertical de 10 pixels entre os elementos
        root.setAlignment(Pos.CENTER); // Centraliza os elementos verticalmente
        root.setSpacing(10); // Espaçamento vertical adicional de 10 pixels

        // Rótulo para a pergunta
        Label question = new Label("Are you in favor?");

        // Configura a CheckBox para permitir estados indeterminados
        checkBox.setAllowIndeterminate(true);

        // Adiciona ouvintes para os eventos de alteração da CheckBox
        checkBox.selectedProperty().addListener(this::changed);
        checkBox.indeterminateProperty().addListener(this::changed);

        // Adiciona elementos ao contêiner VBox
        root.getChildren().addAll(answer, question, checkBox);

        // Cria uma cena com o contêiner VBox e define o tamanho da janela
        Scene scene = new Scene(root, 500, 450);

        // Configurações da janela principal
        stage.setTitle("CheckBox Control Example"); // Título da janela
        stage.setScene(scene); // Define a cena na janela
        stage.show(); // Exibe a janela
    }

    // Método chamado quando o valor da CheckBox é alterado
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldVal, Boolean newVal) {
        // String para armazenar a escolha do usuário
        String choice;

        // Verifica se a CheckBox está em estado indeterminado
        if (checkBox.isIndeterminate()) {
            choice = "Neutral"; // Escolha neutra se indeterminado
        } else if (checkBox.isSelected()) {
            choice = "Agree"; // Escolha "Concordo" se selecionado
        } else {
            choice = "Disagree"; // Escolha "Discordo" se não selecionado
        }

        // Atualiza o texto do rótulo de resposta do usuário
        answer.setText("Your Answer: " + choice);
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
