package domain;

/**
 *
 * @author adrian
 */
public class Empleado {
    private String numeroCuenta;
    private String nombre;
    private String apellidos;
    private String cedula;
    private float fondo;

    public Empleado(String numeroCuenta, String nombre, String apellidos, String cedula) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fondo = 0;
    }

    public Empleado() {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fondo = 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public float getFondo() {
        return fondo;
    }

    public void setFondo(float fondo) {
        this.fondo = fondo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + ", fondo=" + fondo + '}';
    }
}
