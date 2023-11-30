// Declaração do pacote ao qual a classe pertence
package com.jmc.readonlyprops.Controls;

// Importação de classes do JavaFX necessárias
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// Definição da classe principal, que estende a classe Application do JavaFX
public class MenuButtonControl extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um HBox (layout de caixa horizontal) como root
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER); // Define a posição dos nós filhos no centro

        // Cria um MenuButton com o texto "Sites"
        MenuButton Sites = new MenuButton("Sites");

        // Cria dois MenuItem: "Google" e "Youtube"
        MenuItem google = new MenuItem("Google");
        MenuItem youtube = new MenuItem("Youtube");

        // Define a ação a ser executada quando o MenuItem "Google" é clicado
        google.setOnAction(actionEvent -> System.out.println("Visiting Google.com"));

        // Define a ação a ser executada quando o MenuItem "Youtube" é clicado
        youtube.setOnAction(actionEvent -> System.out.println("Visiting Youtube.com"));

        // Adiciona os MenuItem ao MenuButton
        Sites.getItems().addAll(google, youtube);

        // Adiciona o MenuButton ao HBox
        root.getChildren().addAll(Sites);

        // Cria uma cena com o HBox como nó raiz e define a largura e altura
        Scene scene = new Scene(root, 500, 450);

        // Configura o título da janela
        stage.setTitle("MenuButton Control Example");

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
