package business;

import data.ProcesoData;
import domain.Empleado;
import domain.Transaccion;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author adrian
 */
public class ProcesoBusiness {

    private ProcesoData procesoData;

    public ProcesoBusiness() {
        try {
            this.procesoData = new ProcesoData();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean iniciarAhorro(){
        try {
            return this.procesoData.iniciarAhorro();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
            
    public boolean credito_debito(Transaccion transaccion) {
        boolean flag = false;

        try {
            if (transaccion.getTipo().equalsIgnoreCase("deposito")) {
                flag = this.procesoData.credito_debito(transaccion);
            } else if (transaccion.getTipo().equalsIgnoreCase("retiro")) {
                flag = this.procesoData.credito_debito(transaccion);
            } else {
                System.err.println("No es un deposito ni retiro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }
        return flag;
    }

    public boolean transferencia(Transaccion transaccion) {
        boolean flag = false;

        try {
            if (transaccion.getTipo().equalsIgnoreCase("transferencia")) {
                flag = this.procesoData.transferencia(transaccion);
            } else {
                System.err.println("No es una trasferencia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }

        return flag;
    }
    public float consulta(Transaccion transaccion){
        try {
            return this.procesoData.consulta(transaccion);
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean loginCorrecto(String cuenta, String pass) {
        boolean flag = false;
        
        try {
            Empleado empleado = this.procesoData.getEmpleado(cuenta, pass);
            if (empleado.getNumeroCuenta() != null) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }
    
    public Empleado getEmpleado(String cuenta, String contrasennia){
        try {
            return this.procesoData.getEmpleado(cuenta, contrasennia);
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List getEmpleados(){
        try {
            return this.procesoData.getEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
