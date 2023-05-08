package Controllers;
import java.sql.*;
public class BBDD {
    public static Connection con = null;
    public static Statement smt;

    protected String nombre;
    protected String dificultad;
    protected String rol;
    protected String posicion;
    protected String region;
    protected int esencia;
    protected int rp;
    protected String nombrepv;
    protected String clasepv;
    protected String nacionalidadpv;
    protected String nombreav;
    protected String tipoav;
    protected int precioav;

    public BBDD(String nombreav, String tipoav, int precioav) {
        this.nombreav = nombreav;
        this.tipoav = tipoav;
        this.precioav = precioav;
    }

    public BBDD(String nombrepv, String clasepv, String nacionalidadpv) {
        this.nombrepv = nombrepv;
        this.clasepv = clasepv;
        this.nacionalidadpv = nacionalidadpv;
    }

    public BBDD(String nombre, String dificultad, String rol, String posicion, String region, int esencia, int rp) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.rol = rol;
        this.posicion = posicion;
        this.region = region;
        this.esencia = esencia;
        this.rp = rp;
    }

    public String getNombreav() {
        return nombreav;
    }

    public void setNombreav(String nombreav) {
        this.nombreav = nombreav;
    }

    public String getTipoav() {
        return tipoav;
    }

    public void setTipoav(String tipoav) {
        this.tipoav = tipoav;
    }

    public int getPrecioav() {
        return precioav;
    }

    public void setPrecioav(int precioav) {
        this.precioav = precioav;
    }

    public String getNombrepv() {
        return nombrepv;
    }

    public void setNombrepv(String nombrepv) {
        this.nombrepv = nombrepv;
    }

    public String getClasepv() {
        return clasepv;
    }

    public void setClasepv(String clasepv) {
        this.clasepv = clasepv;
    }

    public String getNacionalidadpv() {
        return nacionalidadpv;
    }

    public void setNacionalidadpv(String tipopv) {
        this.nacionalidadpv = nacionalidadpv;
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

    public static void conectarDB(){
        try{
            final  String USER = "root";
            final  String CONTRA = "TheRAnto44";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lolsito", USER, CONTRA);
            smt = con.createStatement();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void crearTablas(){
        try {
            //creacion de la tabla de personajes
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS precio(id_precio INT auto_increment primary key not null, esencia INT not null, rp INT not null);");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS plol(id_plol INT auto_increment primary key not null, nombre varchar(20) not null, dificultad varchar(20) not null, rol varchar(50) not null, posicion varchar(50) not null,region varchar(20) not null, id_precio INT, foreign key (id_precio) references precio(id_precio));");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS pvalorant(id_pvalorant INT auto_increment primary key not null, nombre varchar(20) not null, clase varchar(20) not null, nacionalidad varchar(20) not null );");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS usuario(id_usuario INT auto_increment primary key not null, nombre varchar(50) not null, correo varchar(40),fecha_nacimiento date not null, contraseña varchar(20) not null);");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS avalorant(id_avalorant INT auto_increment primary key not null, nombre varchar(20) not null, tipo varchar(20) not null, precio int not null);");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS tusuariopvalorant(id_tusuariopvalorant INT auto_increment primary key not null, id_pvalorant INT , id_usuario INt , foreign key (id_pvalorant) references pvalorant(id_pvalorant), foreign key (id_usuario) references usuario(id_usuario));");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS tusuarioavalorant(id_tusuarioavalorant INT auto_increment primary key not null, id_avalorant INT , id_usuario INT , foreign key (id_avalorant) references avalorant(id_avalorant), foreign key (id_usuario) references usuario(id_usuario));");
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS tusuarioplol(id_tusuarioplol INT auto_increment primary key not null, id_plol INT , id_usuario INt , foreign key (id_plol) references plol(id_plol), foreign key (id_usuario) references usuario(id_usuario));");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
