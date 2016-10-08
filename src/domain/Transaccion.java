package domain;

/**
 * @author adrian
 */
public class Transaccion {
    
    private int idTransaccion;
    private String tipo;
    private float monto;
    private String cedulaDestino;

    public Transaccion(int idTransaccion, String tipo, float monto, String cedulaDestino) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.monto = monto;
        this.cedulaDestino = cedulaDestino;
    }

    public Transaccion() {
        this.idTransaccion = 0;
        this.tipo = "";
        this.monto = 0;
        this.cedulaDestino = "";
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

    public String getCedulaDestino() {
        return cedulaDestino;
    }

    public void setCedulaDestino(String cedulaDestino) {
        this.cedulaDestino = cedulaDestino;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "idTransaccion=" + idTransaccion + ", tipo=" + tipo + ", monto=" + monto + ", cedulaDestino=" + cedulaDestino + '}';
    }
}
