package com.jmc.readonlyprops.Controls;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CustonTaskCell extends ListCell<Task> {
        @Override
        public void updateItem(Task item, boolean empty) {
            // Chama a implementação da classe pai
            super.updateItem(item, empty);

            // Verifica se o item é vazio (null ou não visível)
            if (empty) {
                // Limpa o texto e a representação gráfica
                setText(null);
                setGraphic(null);
            } else {
                // Cria um CheckBox e um Text para exibir a tarefa
                CheckBox check = new CheckBox();
                Text text = new Text(item.getTask());

                // Cria um HBox para organizar o CheckBox e o Text
                HBox cell = new HBox(10, check, text);

                // Adiciona um ouvinte para a mudança na propriedade de seleção do CheckBox
                check.selectedProperty().addListener(observable -> {
                    // Altera o estilo do texto com base na seleção do CheckBox
                    if (check.isSelected()) {
                        text.setStyle("-fx-strikethrough: true;");
                    } else {
                        text.setStyle("-fx-strikethrough: false;");
                    }
                });

                // Limpa o texto padrão da célula
                setText(null);

                // Define a representação gráfica da célula como o HBox criado
                setGraphic(cell);
            }
        }
    }
