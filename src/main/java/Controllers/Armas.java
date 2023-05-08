package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import static Controllers.BBDD.conectarDB;
import static Controllers.BBDD.smt;

public class Armas {
    public static void InsertarArmas(TableColumn<BBDD,String> nombre, TableColumn<BBDD,String> tipo, TableColumn<BBDD,Integer> precio, TableView<BBDD> tabla){
        try{
            conectarDB();
            ResultSet rs = smt.executeQuery("select nombre,tipo,precio from avalorant;");
            ObservableList<BBDD> dataList = FXCollections.observableArrayList();
            while (rs.next()){
                BBDD data = new BBDD(rs.getString("nombre"),rs.getString("tipo"),rs.getInt("precio"));
                dataList.add(data);
            }
            tabla.setItems(dataList);
            nombre.setCellValueFactory(new PropertyValueFactory<>("Nombreav"));
            tipo.setCellValueFactory(new PropertyValueFactory<>("Tipoav"));
            precio.setCellValueFactory(new PropertyValueFactory<>("Precioav"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
