module com.example.trabajofinalolsito {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.trabajofinalolsito to javafx.fxml;
    exports com.example.trabajofinalolsito;
}