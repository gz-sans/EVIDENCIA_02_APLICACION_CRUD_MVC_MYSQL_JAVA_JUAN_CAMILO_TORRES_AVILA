package model;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/java3";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
    public static void main(String[]args){
        Conexion.conectar();
    }
}
