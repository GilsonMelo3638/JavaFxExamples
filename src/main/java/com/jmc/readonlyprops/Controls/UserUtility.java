package com.jmc.readonlyprops.Controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class UserUtility {
    public static ObservableList<User> getUsersList() {
        return FXCollections.observableArrayList(
                new User("Sam", "M", LocalDate.of(1997, 10, 1)),
                new User("Ken", "Mak", LocalDate.of(1990, 2, 5)),
                new User("Sara", "May", LocalDate.of(1987, 5, 10))
        );
    }

    public static TableColumn<User, String> getFirstNameColumn() {
        TableColumn<User, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        fNameCol.setSortable(false);
        return fNameCol;
    }

    public static TableColumn<User, String> getLastNameColumn() {
        TableColumn<User, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lNameCol;
    }

    public static TableColumn<User, LocalDate> getBirthDateColumn() {
        TableColumn<User, LocalDate> bDataCol = new TableColumn<>("Birth Date");
        bDataCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        return bDataCol;
    }

    public static TableColumn<User, Button> getDeleteUserColumn() {
        TableColumn<User, Button> dUserCol = new TableColumn<>("Delete");
        dUserCol.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                setText(null);
                setGraphic(null);
                if (!empty) {
                    Button button = new Button("Delete");
                    button.setOnAction(actionEvent -> {
                        int rowIndex = this.getTableRow().getIndex();
                        this.getTableView().getItems().remove(rowIndex);
                    });
                    setText(null);
                    setGraphic(button);
                }
            }
        });
        return dUserCol;
    }
}
