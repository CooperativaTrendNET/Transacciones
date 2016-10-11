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
    private String descripcion;

    /**
     * Constructor para la trasferencia
     * @param tipo Tipo de transaccion a realizarse
     * @param monto Cantidad de dinero en la transaccion
     * @param cuentaOrigen Numero de cuenta de la cual se reducira el dinero
     * @param cuentaDestino Numero de cuenta a la que se depositara el dinero
     **/
    public Transaccion(String tipo, float monto, String cuentaOrigen, String cuentaDestino) {
        this.idTransaccion = 0;
        this.tipo = tipo;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fechaTransaccion = "";
        this.descripcion = "";
    }
    
    public Transaccion(String tipo, float monto, String cuentaOrigen){
        this.idTransaccion = 0;
        this.tipo = tipo;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaOrigen;
        this.fechaTransaccion = "";
        this.descripcion = "";
    }

    /**
     * Consulta
     **/
    public Transaccion(String tipo, String cuentaOrigen) {
        this.tipo = tipo;
        this.cuentaOrigen = cuentaOrigen;
        this.idTransaccion = 0;
        this.monto = 0;
        this.cuentaDestino = "";
        this.fechaTransaccion = "";
        this.descripcion = "";
    }
    
    public Transaccion() {
        this.idTransaccion = 0;
        this.tipo = "";
        this.monto = 0;
        this.cuentaOrigen = "";
        this.cuentaDestino = "";
        this.fechaTransaccion = "";
        this.descripcion = "";
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "idTransaccion=" + idTransaccion + ", tipo=" + tipo + ", monto=" + monto + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + ", fechaTransaccion=" + fechaTransaccion + ", descripcion=" + descripcion + '}';
    }
}
