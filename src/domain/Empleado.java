package domain;

/**
 *
 * @author adrian
 */
public class Empleado {
    private String nombre;
    private String apellidos;
    private char[] cedula;
    private float fondo;
    private char[] contrasenia;

    public Empleado(String nombre, String apellidos, char[] cedula, float fondo, char[] contrasenia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fondo = fondo;
        this.contrasenia = contrasenia;
    }

    public Empleado() {
        this.nombre = "";
        this.apellidos = "";
        this.cedula = new char[10];
        this.fondo = 0;
        this.contrasenia = new char[30];
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

    public char[] getCedula() {
        return cedula;
    }

    public void setCedula(char[] cedula) {
        this.cedula = cedula;
    }

    public float getFondo() {
        return fondo;
    }

    public void setFondo(float fondo) {
        this.fondo = fondo;
    }

    public char[] getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(char[] contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + ", fondo=" + fondo + ", contrasenia=" + contrasenia + '}';
    }
    
}
