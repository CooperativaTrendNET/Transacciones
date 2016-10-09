package domain;

/**
 * @author adrian
 */
public class Transaccion {
    
    private int idTransaccion;
    private String tipo;
    private float monto;
    private String cuentaOrigen;
    private String cuentaDestino;
    private String fechaTransaccion;

    public Transaccion(String tipo, float monto, String cuentaOrigen, String cuentaDestino) {
        this.idTransaccion = 0;
        this.tipo = tipo;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fechaTransaccion = "";
    }

    public Transaccion() {
        this.idTransaccion = 0;
        this.tipo = "";
        this.monto = 0;
        this.cuentaOrigen = "";
        this.cuentaDestino = "";
        this.fechaTransaccion = "";
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "idTransaccion=" + idTransaccion + ", tipo=" + tipo + ", monto=" + monto + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + ", fechaTransaccion=" + fechaTransaccion + '}';
    }
}
