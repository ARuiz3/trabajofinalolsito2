package com.example.trabajofinalolsito;

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
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lolsito", "root", "TheRAnto44");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select nombre,dificultad,rol,posicion,region,esencia,rp from plol inner join precio on plol.id_precio=precio.id_precio;");
            ObservableList<BBDD> dataList = FXCollections.observableArrayList();
            while (rs.next()){
                BBDD data = new BBDD(rs.getString("column1"),rs.getString("column2"), rs.getString("column3"),rs.getString("column4"),rs.getString("column5"),rs.getInt("column6"),rs.getInt("column7"));
                dataList.add(data);
            }
            tabla.setItems(dataList);
            nombre.setCellValueFactory(new PropertyValueFactory<>("column1"));
            dificultad.setCellValueFactory(new PropertyValueFactory<>("column2"));
            rol.setCellValueFactory(new PropertyValueFactory<>("column3"));
            posicion.setCellValueFactory(new PropertyValueFactory<>("column4"));
            region.setCellValueFactory(new PropertyValueFactory<>("column5"));
            esencia.setCellValueFactory(new PropertyValueFactory<>("column6"));
            rp.setCellValueFactory(new PropertyValueFactory<>("column7"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
