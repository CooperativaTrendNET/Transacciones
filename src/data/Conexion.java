package data;

import java.sql.*;

public class Conexion {

    public Conexion() {

    }

    public void insertar(String nombre, String cedula, String nacionalidad, String ocupacion, String direccion, String sexo, String estado, String nivel, String pregunta1, String pregunta2, String pregunta3, String pregunta4, String pregunta5, String pregunta6, String pregunta7) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://163.178.107.130:1433;databaseName=Proyecto_Operativos_B36630_B24814;user=sqlserver;password=saucr.12";
        Connection connection = DriverManager.getConnection(connectionURL);

        System.out.println("Se ha conectado correctamente");

        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO respuestasXEmpleado " + "VALUES ('" + nombre + "', '" + cedula + "')");

        connection.close();
    }
}
