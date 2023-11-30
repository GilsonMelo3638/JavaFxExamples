package com.jmc.readonlyprops.Controls;

import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

// Classe que personaliza a exibição de células em um ListView, associando formas gráficas aos nomes exibidos
public class ShapeNameCell extends ListCell<String> {

    // Método chamado quando uma célula precisa ser atualizada com novos dados
    @Override
    public void updateItem(String item, boolean empty) {
        // Chama o método da superclasse para garantir o comportamento padrão
        super.updateItem(item, empty);

        // Verifica se a célula está vazia ou se o item é nulo
        if (empty || item == null) {
            // Se estiver vazia ou o item for nulo, limpa o texto e a forma gráfica da célula
            setText(null);
            setGraphic(null);
        } else {
            // Se não estiver vazia, define o texto com o valor do item e associa a forma gráfica
            setText(item);
            Shape shape = getShape(item);
            setGraphic(shape);
        }
    }

    // Método que associa um nome a uma forma gráfica específica
    public Shape getShape(String name) {
        Shape shape = null;
        // Usa um switch para determinar a forma com base no nome fornecido (ignorando maiúsculas/minúsculas)
        switch (name.toLowerCase()) {
            case "patrick":
                // Se o nome for "patrick", associa a forma de uma linha horizontal
                shape = new Line(0, 10, 20, 10);
                break;
            case "sam":
                // Se o nome for "sam", associa a forma de um retângulo
                shape = new Rectangle(0, 0, 20, 20);
                break;
            case "sara":
                // Se o nome for "sara", associa a forma de um círculo
                shape = new Circle(20, 20, 10);
                break;
            default:
                // Se o nome não corresponder a nenhum caso, você pode definir um comportamento padrão
                // ou simplesmente não fazer nada (como está no seu código original).
                break;
        }
        return shape;
    }
}
