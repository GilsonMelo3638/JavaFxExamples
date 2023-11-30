// Importações necessárias do pacote JavaFX e do Java
package com.jmc.readonlyprops.Controls;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class RadioButtonControl extends Application {
    // Rótulo para exibir a seleção do usuário
    Label userSelection;

    // Método init, chamado antes do start, usado para inicializar recursos
    public void init(){
        // Inicializa o rótulo com texto padrão
        userSelection = new Label("Your Selection: None");
    }

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um contêiner VBox para organizar os elementos verticalmente
        VBox root = new VBox(10); // Espaçamento vertical de 10 pixels entre os elementos
        root.setAlignment(Pos.CENTER); // Centraliza os elementos verticalmente

        // Cria botões de rádio para diferentes estações
        RadioButton spring = new RadioButton("Spring");
        RadioButton summer = new RadioButton("Summer");
        RadioButton fall = new RadioButton("Fall");
        RadioButton winter = new RadioButton("Winter");

        // Cria um grupo para os botões de rádio, garantindo que apenas um possa ser selecionado por vez
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(spring, summer, fall, winter);

        // Adiciona um ouvinte para o evento de seleção do grupo
        group.selectedToggleProperty().addListener(this::changed);

        // Adiciona elementos ao contêiner VBox
        root.getChildren().addAll(userSelection, spring, summer, fall, winter);

        // Cria uma cena com o contêiner VBox e define o tamanho da janela
        Scene scene = new Scene(root, 500, 450);

        // Configurações da janela principal
        stage.setTitle("RadioButton Control Example"); // Título da janela
        stage.setScene(scene); // Define a cena na janela
        stage.show(); // Exibe a janela
    }

    // Método chamado quando a seleção do grupo de botões de rádio é alterada
    public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldBtn, Toggle newBtn) {
        // String para armazenar o rótulo selecionado
        String selectedLabel = "None";

        // Verifica se um novo botão de rádio foi selecionado
        if (newBtn != null) {
            // Obtém o texto do rótulo do botão de rádio selecionado
            selectedLabel = ((Labeled) newBtn).getText();
        }

        // Atualiza o texto do rótulo de seleção do usuário
        userSelection.setText("Your Selection: " + selectedLabel);
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}