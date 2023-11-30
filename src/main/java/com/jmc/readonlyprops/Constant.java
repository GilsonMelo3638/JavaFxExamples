package com.jmc.readonlyprops;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

// Classe que representa uma constante inteira com propriedades de leitura apenas
public class Constant {

    // Wrapper para a constante inteira, tornando-a uma propriedade de leitura apenas
    private final ReadOnlyIntegerWrapper numWrapper;

    // Construtor que aceita um valor inicial para a constante
    public Constant(int num) {
        this.numWrapper = new ReadOnlyIntegerWrapper(num);
    }

    // Obtém a propriedade de leitura apenas associada à constante
    public ReadOnlyIntegerProperty getReadOnlyNumber() {
        return numWrapper.getReadOnlyProperty();
    }

    // Método que permite alterar o valor da constante (note que a constante é tecnicamente "read-only",
    // mas podemos alterar o valor encapsulado usando o wrapper)
    public void changeConstant() {
        this.numWrapper.set(200);
    }
}
