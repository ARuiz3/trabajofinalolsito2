package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static Controllers.BBDD.conectarDB;
import static Controllers.BBDD.smt;

public class LolController implements Initializable {
    @FXML
    private TableView<BBDD> tabla;
    @FXML
    private TableColumn<BBDD,String> nombre;
    @FXML
    private TableColumn<BBDD,String> dificultad;
    @FXML
    private TableColumn<BBDD,String> rol;
    @FXML
    private TableColumn<BBDD,String> posicion;
    @FXML
    private TableColumn<BBDD,String> region;
    @FXML
    private TableColumn<BBDD,Integer> esencia;
    @FXML
    private TableColumn<BBDD,Integer> rp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            conectarDB();
            ResultSet rs = smt.executeQuery("select nombre, dificultad, rol, posicion, region, esencia, rp from plol inner join precio on plol.id_precio=precio.id_precio;");
            ObservableList<BBDD> dataList = FXCollections.observableArrayList();
            while (rs.next()){
                BBDD data = new BBDD(rs.getString("nombre"),rs.getString("dificultad"), rs.getString("rol"),rs.getString("posicion"),rs.getString("region"),rs.getInt("esencia"),rs.getInt("rp"));
                dataList.add(data);
            }
            tabla.setItems(dataList);
            nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            dificultad.setCellValueFactory(new PropertyValueFactory<>("dificultad"));
            rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
            posicion.setCellValueFactory(new PropertyValueFactory<>("posicion"));
            region.setCellValueFactory(new PropertyValueFactory<>("region"));
            esencia.setCellValueFactory(new PropertyValueFactory<>("esencia"));
            rp.setCellValueFactory(new PropertyValueFactory<>("rp"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
