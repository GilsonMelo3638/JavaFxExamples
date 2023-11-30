// Declaração do pacote ao qual a classe pertence
package com.jmc.readonlyprops.Controls;

// Importação de classes do JavaFX necessárias
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;

// Definição da classe principal, que estende a classe Application do JavaFX
public class HiperLinkControl extends Application {

    // Método start, chamado quando a aplicação é iniciada
    @Override
    public void start(Stage stage) {
        // Cria um BorderPane (layout que organiza os nós em regiões: topo, centro, fundo, esquerda e direita)
        BorderPane root = new BorderPane();

        // Cria um HBox (layout de caixa horizontal) para armazenar os Hyperlinks
        HBox linksLayout = new HBox();
        linksLayout.setAlignment(Pos.CENTER); // Define a posição dos nós filhos no centro

        // Cria dois Hyperlinks com os textos "Google" e "Youtube"
        Hyperlink link1 = new Hyperlink("Google");
        Hyperlink link2 = new Hyperlink("Youtube");

        // Cria um WebView, que é um componente JavaFX para exibição de conteúdo web
        WebView webView = new WebView();

        // Define a ação a ser executada quando o primeiro Hyperlink é clicado
        link1.setOnAction(actionEvent -> webView.getEngine().load("https://www.google.com"));

        // Define a ação a ser executada quando o segundo Hyperlink é clicado
        link2.setOnAction(actionEvent -> webView.getEngine().load("https://www.youtube.com"));

        // Adiciona os Hyperlinks ao HBox
        linksLayout.getChildren().addAll(link1, link2);

        // Define o HBox como a parte superior do BorderPane
        root.setTop(linksLayout);

        // Define o WebView como o centro do BorderPane
        root.setCenter(webView);

        // Cria uma cena com o BorderPane como nó raiz e define a largura e altura
        Scene scene = new Scene(root, 500, 450);

        // Configura o título da janela
        stage.setTitle("HyperLink Control Example");

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
