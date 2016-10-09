package data;

import domain.Empleado;
import domain.Transaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProcesoData {

    private Connection connection;

    public ProcesoData() throws ClassNotFoundException, SQLException {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://163.178.107.130:1433;databaseName=Proyecto_Operativos_B24814_B35781_B35783_B36630;user=sqlserver;password=saucr.12";
            this.connection = DriverManager.getConnection(connectionURL);
            System.out.println("Se ha conectado correctamente");
    }

    public boolean deposito(Transaccion transaccion) throws SQLException {
        boolean flag = true;
        
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Transaccion(tipo, monto, cuentaOrigen) VALUES ('" + transaccion.getTipo() + "', '" + transaccion.getMonto() + "', '" + transaccion.getCuentaOrigen() + "')");
        
        this.connection.close();
        statement.close();
        return flag;
    }

    public Empleado getEmpleado(String cuenta) throws SQLException{
        Empleado empleado = new Empleado();
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Empleado WHERE numeroCuenta='"+cuenta+"'");
        
        while (resultSet.next()){
            empleado.setNumeroCuenta(resultSet.getString("numeroCuenta"));
            empleado.setNombre(resultSet.getString("nombre"));
            empleado.setApellidos(resultSet.getString("apellidos"));
            empleado.setCedula(resultSet.getString("cedula"));
            empleado.setFondo((float) resultSet.getFloat("fondo"));
            empleado.setContrasenia(resultSet.getString("contrasenia"));
        }
        resultSet.close();
        
        return empleado;
    }
    /*
        transferencia
        consulta
        retiro
        deposito
     */
}
