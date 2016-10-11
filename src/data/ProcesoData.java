package data;

import domain.Empleado;
import domain.Transaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProcesoData {

    private Connection connection;

    public ProcesoData() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://163.178.107.130:1433;databaseName=Proyecto_Operativos_B24814_B35781_B35783_B36630;user=sqlserver;password=saucr.12";
        this.connection = DriverManager.getConnection(connectionURL);
        System.out.println("Se ha conectado correctamente");
    }

    public boolean credito_debito(Transaccion transaccion) throws SQLException {
        boolean flag = true;

        if (getEmpleado(transaccion.getCuentaOrigen()).getNombre() != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Transaccion(tipo, monto, cuentaOrigen) VALUES ('" + transaccion.getTipo()
                    + "', '" + transaccion.getMonto() + "', '" + transaccion.getCuentaOrigen() + "')");
            statement.close();
        } else {
            flag = false;
        }

        this.connection.close();
        return flag;
    }

    public boolean transferencia(Transaccion transaccion) throws SQLException {
        boolean flag = true;

        if (getEmpleado(transaccion.getCuentaOrigen()).getNombre() != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Transaccion(tipo, monto, cuentaOrigen, cuentaDestino) VALUES ('" + transaccion.getTipo()
                    + "', '" + transaccion.getMonto() + "', '" + transaccion.getCuentaOrigen() + "', '"
                    + transaccion.getCuentaDestino() + "')");
            statement.close();
        } else {
            flag = false;
        }

        return flag;
    }

    public float consulta(Transaccion transaccion) throws SQLException {

        String cuenta = transaccion.getCuentaOrigen();
        Empleado empleado = getEmpleado(cuenta);
        float monto = 0;

        if (empleado.getNombre() != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT fondo FROM Empleado WHERE numeroCuenta='" + cuenta + "'");

            while (resultSet.next()) {
                monto = (float) resultSet.getFloat("fondo");
            }

            statement.close();
            resultSet.close();
        }

        return monto;
    }

    public Empleado getEmpleado(String cuenta) throws SQLException {
        Empleado empleado = new Empleado();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Empleado WHERE numeroCuenta='" + cuenta + "'");

        while (resultSet.next()) {
            empleado.setNumeroCuenta(resultSet.getString("numeroCuenta"));
            empleado.setNombre(resultSet.getString("nombre"));
            empleado.setApellidos(resultSet.getString("apellidos"));
            empleado.setCedula(resultSet.getString("cedula"));
            empleado.setFondo((float) resultSet.getFloat("fondo"));
            empleado.setContrasenia(resultSet.getString("contrasenia"));
        }

        statement.close();
        resultSet.close();
        return empleado;
    }

    public List getEmpleados() throws SQLException {
        List<Empleado> listaEmpleados = new ArrayList();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Empleado");

        while (resultSet.next()) {
            Empleado empleado = new Empleado();
            empleado.setNumeroCuenta(resultSet.getString("numeroCuenta"));
            empleado.setNombre(resultSet.getString("nombre"));
            empleado.setApellidos(resultSet.getString("apellidos"));
            empleado.setCedula(resultSet.getString("cedula"));
            empleado.setFondo((float) resultSet.getFloat("fondo"));
            empleado.setContrasenia(resultSet.getString("contrasenia"));
            listaEmpleados.add(empleado);
        }

        statement.close();
        resultSet.close();
        return listaEmpleados;
    }
    /*
        credito_debito - deposito - retiro
        transferencia
        consulta
     */
}
