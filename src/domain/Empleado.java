package domain;

/**
 *
 * @author adrian
 */
public class Empleado {
    private String nombre;
    private String apellidos;
    private String cedula;
    private float fondo;
    private String contrasenia;

    public Empleado(String nombre, String apellidos, String cedula, float fondo, String contrasenia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fondo = fondo;
        this.contrasenia = contrasenia;
    }

    public Empleado() {
        this.nombre = "";
        this.apellidos = "";
        this.cedula = "";
        this.fondo = 0;
        this.contrasenia = "";
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + ", fondo=" + fondo + ", contrasenia=" + contrasenia + '}';
    }
    
}
