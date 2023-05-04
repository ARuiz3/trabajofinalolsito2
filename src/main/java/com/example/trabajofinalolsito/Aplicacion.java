package com.example.trabajofinalolsito;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.trabajofinalolsito.BBDD.*;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        crearTablas();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("RiotInformation");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public static void main(String[] args) {

        launch();

    }
}