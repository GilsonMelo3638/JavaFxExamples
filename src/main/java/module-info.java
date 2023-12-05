module com.jmc.readonlyprops {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports com.jmc.readonlyprops;
    opens com.jmc.readonlyprops to javafx.fxml;

    exports com.jmc.readonlyprops.Layouts;
    opens com.jmc.readonlyprops.Layouts to javafx.fxml;

    exports com.jmc.readonlyprops.Controls;
    opens com.jmc.readonlyprops.Controls to javafx.fxml;

    exports com.jmc.readonlyprops.Concurrency; // Adicionado
    opens com.jmc.readonlyprops.Concurrency to javafx.fxml; // Adicionado
}
