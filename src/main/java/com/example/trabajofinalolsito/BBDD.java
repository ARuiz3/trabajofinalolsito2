package com.example.trabajofinalolsito;
import java.sql.*;
public class BBDD {
    final private String USER = "root";
    final private String CONTRA = "TheRAnto44";
    protected String nombre;
    protected String dificultad;
    protected String rol;
    protected String posicion;
    protected String region;
    protected int esencia;
    protected int rp;

    public BBDD(String nombre, String dificultad, String rol, String posicion, String region, int esencia, int rp) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.rol = rol;
        this.posicion = posicion;
        this.region = region;
        this.esencia = esencia;
        this.rp = rp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getEsencia() {
        return esencia;
    }

    public void setEsencia(int esencia) {
        this.esencia = esencia;
    }

    public int getRp() {
        return rp;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }


    public void crearTablas(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lolsito", USER, CONTRA);
            Statement smt = con.createStatement();
            //creacion de la tabla de personajes
            smt.executeUpdate("CREATE TABLE precio(id_precio INT auto_increment primary key not null, esencia INT not null, rp INT not null);");
            smt.executeUpdate("CREATE TABLE plol(id_plol INT auto_increment primary key not null, nombre varchar(20) not null, dificultad varchar(20) not null, rol varchar(50) not null, posicion varchar(50) not null,region varchar(20) not null, id_precio INT, foreign key (id_precio) references precio(id_precio));");
            smt.executeUpdate("CREATE TABLE pvalorant(id_pvalorant INT auto_increment primary key not null, nombre varchar(20) not null, clase varchar(20) not null, nacionalidad varchar(20) not null );");
            smt.executeUpdate("CREATE TABLE usuario(id_usuario INT auto_increment primary key not null, nombre varchar(50) not null, correo varchar(40),fecha_nacimiento date not null, contraseña varchar(20) not null);");
            smt.executeUpdate("CREATE TABLE avalorant(id_avalorant INT auto_increment primary key not null, nombre varchar(20) not null, tipo varchar(20) not null, precio int not null);");
            smt.executeUpdate("CREATE TABLE tusuariopvalorant(id_tusuariopvalorant INT auto_increment primary key not null, id_pvalorant INT , id_usuario INt , foreign key (id_pvalorant) references pvalorant(id_pvalorant), foreign key (id_usuario) references usuario(id_usuario));");
            smt.executeUpdate("CREATE TABLE tusuarioavalorant(id_tusuarioavalorant INT auto_increment primary key not null, id_avalorant INT , id_usuario INT , foreign key (id_avalorant) references avalorant(id_avalorant), foreign key (id_usuario) references usuario(id_usuario));");
            smt.executeUpdate("CREATE TABLE tusuarioplol(id_tusuarioplol INT auto_increment primary key not null, id_plol INT , id_usuario INt , foreign key (id_plol) references plol(id_plol), foreign key (id_usuario) references usuario(id_usuario));");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
