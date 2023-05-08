package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.net.URL;
import java.util.ResourceBundle;

import static Controllers.BBDD.conectarDB;

public class InicioSesionController implements Initializable {


    @FXML
    private Button login;
    @FXML
    private TextField user;
    @FXML
    private PasswordField contra;
    @FXML
    private Button crearCuenta;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void iniciarSesion(ActionEvent event) {
        try{
            conectarDB();
            String nombre = this.user.getText();
            String contra = this.contra.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}