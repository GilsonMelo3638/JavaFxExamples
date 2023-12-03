package com.jmc.readonlyprops.Controls;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class User {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<LocalDate> birthDate;

    public  User(String firstname, String lastname, LocalDate birthdate) {
        this.firstName = new SimpleStringProperty(this, "firstName", firstname );
        this.lastName = new SimpleStringProperty(this, "lastName", lastname );
        this.birthDate = new SimpleObjectProperty<>(this, "birthDate", birthdate);
    }

    public String getFirstName(){
        return  firstName.get();
    }
    public String getLastName(){
        return  lastName.get();
    }
    public  LocalDate getBirthDate(){
        return birthDate.get();
    }
    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getLastName() + " " + this.getBirthDate();  }
}
