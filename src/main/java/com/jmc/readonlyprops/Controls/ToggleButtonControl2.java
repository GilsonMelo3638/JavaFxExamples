// Declaração do pacote ao qual a classe pertence
package com.jmc.readonlyprops.Controls;

// Importação de classes do JavaFX necessárias
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

// Definição da classe principal, que estende a classe Application do JavaFX
public class ToggleButtonControl2 extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um VBox (layout de caixa vertical) como root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER); // Define a posição dos nós filhos no centro

        // Cria um rótulo (Label) inicializado com "Your Selection is: "
        Label label = new Label("Your Selection is: ");

        // Cria quatro ToggleButtons representando as estações do ano
        ToggleButton spring = new ToggleButton("Spring");
        ToggleButton summer = new ToggleButton("Summer");
        ToggleButton fall = new ToggleButton("Fall");
        ToggleButton winter = new ToggleButton("Winter");

        // Cria um ToggleGroup para agrupar os ToggleButtons
        ToggleGroup seasons = new ToggleGroup();
        seasons.getToggles().addAll(spring, summer, fall, winter);

        // Cria um HBox (layout de caixa horizontal) para organizar os ToggleButtons
        HBox seasonsLayout = new HBox();
        seasonsLayout.setAlignment(Pos.CENTER); // Define a posição dos nós filhos no centro
        seasonsLayout.setSpacing(5); // Define o espaçamento entre os nós
        seasonsLayout.getChildren().addAll(spring, summer, fall, winter);

        // Adiciona o rótulo e o HBox ao VBox
        root.getChildren().addAll(label, seasonsLayout);

        // Adiciona um ouvinte para o evento de seleção do ToggleGroup
        seasons.selectedToggleProperty().addListener(((observableValue, toggle, t1) -> {
            // Atualiza o rótulo com base na seleção atual
            label.setText("Your Selection is " + ((Labeled)t1).getText());
        }));

        // Cria uma cena com o VBox como nó raiz e define a largura e altura
        Scene scene = new Scene(root, 500, 450);

        // Configura o título da janela
        stage.setTitle("ToggleButton Control Example");

        // Define a cena no palco (Stage)
        stage.setScene(scene);

        // Exibe a janela
        stage.show();
    }

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX chamando o método launch()
        launch();
    }
}