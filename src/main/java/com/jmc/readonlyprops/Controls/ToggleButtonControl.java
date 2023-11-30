// Declaração do pacote ao qual a classe pertence
package com.jmc.readonlyprops.Controls;

// Importação de classes do JavaFX necessárias
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Definição da classe principal, que estende a classe Application do JavaFX
public class ToggleButtonControl extends Application {

    // Variável para rastrear o estado do botão (ligado/desligado)
    Boolean isLightOn;

    // Método init, chamado antes do método start, usado para inicialização
    @Override
    public void init() {
        // Inicializa a variável isLightOn como false (desligado)
        isLightOn = false;
    }

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um VBox (layout de caixa vertical) como root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER); // Define a posição dos nós filhos no centro


        // Cria um retângulo vermelho com largura 200, altura 100
        Rectangle rectangle = new Rectangle(200, 100, Color.RED);

        // Cria um ToggleButton com o texto inicial "OFF"
        ToggleButton light = new ToggleButton("OFF");

        // Adiciona o retângulo e o ToggleButton ao VBox
        root.getChildren().addAll(rectangle, light);

        // Define a ação a ser executada quando o ToggleButton é clicado
        light.setOnAction(actionEvent -> {
            // Inverte o estado atual do botão (ON para OFF, OFF para ON)
            isLightOn = !isLightOn;

            // Atualiza a cor do retângulo e o texto do botão com base no novo estado
            if (isLightOn) {
                rectangle.setFill(Color.GREEN);
                light.setText("ON");
            } else {
                rectangle.setFill(Color.RED);
                light.setText("OFF");
            }
        });

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
