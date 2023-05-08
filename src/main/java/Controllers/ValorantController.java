package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import static Controllers.Armas.InsertarArmas;
import static Controllers.Personajes.InsertarPersonajes;

public class ValorantController implements Initializable {
    @FXML
    private TableView<BBDD> Tablapv;
    @FXML
    private TableColumn<BBDD,String> Nombrepv;
    @FXML
    private TableColumn<BBDD,String> Clasepv;
    @FXML
    private TableColumn<BBDD,String> Nacionalidadpv;
    @FXML
    private TableView<BBDD> Tablaav;
    @FXML
    private TableColumn<BBDD,String> Nombreav;
    @FXML
    private TableColumn<BBDD,String> Tipoav;
    @FXML
    private TableColumn<BBDD,Integer> Precioav;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InsertarPersonajes(Nombrepv,Clasepv,Nacionalidadpv,Tablapv);
        InsertarArmas(Nombreav,Tipoav,Precioav,Tablaav);
    }
}
