package Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import static Controllers.BBDD.conectarDB;
import static Controllers.BBDD.smt;

public class Personajes {
    public static void InsertarPersonajes(TableColumn<BBDD,String> nombre, TableColumn<BBDD,String> clase, TableColumn<BBDD,String> nacionalidad, TableView<BBDD> tabla) {
        try{
            conectarDB();
            ResultSet rs = smt.executeQuery("select nombre,clase,nacionalidad from pvalorant;");
            ObservableList<BBDD> dataList = FXCollections.observableArrayList();
            while (rs.next()){
                BBDD data = new BBDD(rs.getString("nombre"),rs.getString("clase"),rs.getString("nacionalidad"));
                dataList.add(data);
            }
            tabla.setItems(dataList);
            nombre.setCellValueFactory(new PropertyValueFactory<>("Nombrepv"));
            clase.setCellValueFactory(new PropertyValueFactory<>("Clasepv"));
            nacionalidad.setCellValueFactory(new PropertyValueFactory<>("Nacionalidadpv"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
