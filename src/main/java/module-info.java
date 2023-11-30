module com.jmc.readonlyprops {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.jmc.readonlyprops to javafx.fxml;
    exports com.jmc.readonlyprops;
    exports com.jmc.readonlyprops.Layouts;
    opens com.jmc.readonlyprops.Layouts to javafx.fxml;
    exports com.jmc.readonlyprops.Controls;
    opens com.jmc.readonlyprops.Controls to javafx.fxml;
}