package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroController implements Initializable {
    @FXML
    private PasswordField contrasenaRegistro;
    @FXML
    private TextField nombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int maxLength = 16 ; // Límite máximo de caracteres
        TextFormatter<String> textFormatter = new TextFormatter<>(change ->
                change.getControlNewText().length() <= maxLength ? change : null);
        contrasenaRegistro.setTextFormatter(textFormatter);
    }
}
