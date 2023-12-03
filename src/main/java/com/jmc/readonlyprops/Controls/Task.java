package com.jmc.readonlyprops.Controls;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {
    // Propriedade para armazenar a tarefa como uma StringProperty
    private final StringProperty task;

    // Construtor que aceita uma String para inicializar a tarefa
    public Task(String task) {
        // Inicializa a StringProperty com o nome "task" e o valor fornecido
        this.task = new SimpleStringProperty(this, "task", task);
    }

    // Método para obter o valor da tarefa como uma String
    public String getTask() {
        return task.get();
    }

    // Método para obter a StringProperty associada à tarefa
    public StringProperty getTaskProperty() {
        return this.task;
    }

    // Sobrescreve o método toString para fornecer uma representação de string da tarefa
    @Override
    public String toString() {
        return this.task.get();
    }
}
