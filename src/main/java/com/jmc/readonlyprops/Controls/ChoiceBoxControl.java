// Importações necessárias do pacote JavaFX e do Java
package com.jmc.readonlyprops.Controls;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Classe principal que estende Application, representando a aplicação JavaFX
public class ChoiceBoxControl extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um contêiner VBox para organizar os elementos verticalmente
        VBox root = new VBox(10); // Espaçamento vertical de 10 pixels entre os elementos
        root.setSpacing(10); // Espaçamento vertical adicional de 10 pixels
        root.setAlignment(Pos.CENTER); // Centraliza os elementos verticalmente

        // Rótulo para a pergunta
        Label label = new Label("Your Direction:");

        // ChoiceBox para selecionar direções
        ChoiceBox<String> directions = new ChoiceBox<>();
        // Lista observável de direções
        ObservableList<String> directionList = FXCollections.observableArrayList("North", "South", "East", "West");
        // Adiciona as direções à ChoiceBox
        directions.getItems().addAll(directionList);
        // Seleciona a primeira direção como padrão
        directions.getSelectionModel().select(0);

        // Adiciona um ouvinte para o evento de alteração de seleção
        directions.getSelectionModel().selectedItemProperty().addListener(observable ->
                label.setText("Your Direction: " + directions.getSelectionModel().getSelectedItem()));

        // Adiciona elementos ao contêiner VBox
        root.getChildren().addAll(label, directions);

        // Cria uma cena com o contêiner VBox e define o tamanho da janela
        Scene scene = new Scene(root, 500, 450);

        // Configurações da janela principal
        stage.setTitle("ChoiceBox Control Example"); // Título da janela
        stage.setScene(scene); // Define a cena na janela
        stage.show(); // Exibe a janela
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}
