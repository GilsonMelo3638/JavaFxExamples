package com.jmc.readonlyprops.Controls;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class User {
    // Propriedade para armazenar o primeiro nome do usuário
    private final StringProperty firstName;
    // Propriedade para armazenar o último nome do usuário
    private final StringProperty lastName;
    // Propriedade para armazenar a data de nascimento do usuário
    private final ObjectProperty<LocalDate> birthDate;

    // Construtor da classe User
    public User(String firstname, String lastname, LocalDate birthdate) {
        // Inicializa a propriedade do primeiro nome
        this.firstName = new SimpleStringProperty(this, "firstName", firstname);
        // Inicializa a propriedade do último nome
        this.lastName = new SimpleStringProperty(this, "lastName", lastname);
        // Inicializa a propriedade da data de nascimento
        this.birthDate = new SimpleObjectProperty<>(this, "birthDate", birthdate);
    }

    // Método para obter o primeiro nome do usuário
    public String getFirstName() {
        return firstName.get();
    }

    // Método para definir o primeiro nome do usuário
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    // Método para obter o último nome do usuário
    public String getLastName() {
        return lastName.get();
    }

    // Método para obter a data de nascimento do usuário
    public LocalDate getBirthDate() {
        return birthDate.get();
    }

    // Método para definir a data de nascimento do usuário
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate.set(birthDate);
    }

    // Sobrescrita do método toString para retornar uma representação de string do objeto User
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " " + this.getBirthDate();
    }
}
