package com.jmc.readonlyprops.Controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserUtility {
    // Método para obter uma lista de usuários de exemplo
    public static ObservableList<User> getUsersList() {
        return FXCollections.observableArrayList(
                new User("Sam", "M", LocalDate.of(1997, 10, 1)),
                new User("Ken", "Mak", LocalDate.of(1990, 2, 5)),
                new User("Sara", "May", LocalDate.of(1987, 5, 10))
        );
    }

    // Método para obter a coluna do primeiro nome para a tabela
    public static TableColumn<User, String> getFirstNameColumn() {
        TableColumn<User, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        // Permite a edição do primeiro nome diretamente na tabela
        fNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        // Define o comportamento ao confirmar a edição do primeiro nome
        fNameCol.setOnEditCommit(e -> {
            e.getRowValue().setFirstName(e.getNewValue());
        });
        fNameCol.setSortable(false);
        return fNameCol;
    }

    // Método para obter a coluna do último nome para a tabela
    public static TableColumn<User, String> getLastNameColumn() {
        TableColumn<User, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lNameCol;
    }

    // Método para obter a coluna da data de nascimento para a tabela
    public static TableColumn<User, LocalDate> getBirthDateColumn() {
        TableColumn<User, LocalDate> bDataCol = new TableColumn<>("Birth Date");
        bDataCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateStringConverter converter = new LocalDateStringConverter(formatter, null);
        // Permite a edição da data de nascimento diretamente na tabela
        bDataCol.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        // Define o comportamento ao confirmar a edição da data de nascimento
        bDataCol.setOnEditCommit(e -> {
            e.getRowValue().setBirthDate(e.getNewValue());
            System.out.println(e.getRowValue());
        });

        return bDataCol;
    }

    // Método para obter a coluna de exclusão de usuário para a tabela
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
                    // Define o comportamento ao clicar no botão "Delete"
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
