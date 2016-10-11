package business;

import data.ProcesoData;
import domain.Transaccion;
import java.sql.SQLException;
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean credito_debito(Transaccion transaccion){
        boolean flag = false;
        
        try {
            if (transaccion.getTipo().equalsIgnoreCase("deposito")) {
                flag = this.procesoData.credito_debito(transaccion);
            }else if(transaccion.getTipo().equalsIgnoreCase("retiro")){
                flag = this.procesoData.credito_debito(transaccion);
            }else{
                System.err.println("No es un deposito ni retiro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }
        return flag;
    }
    
    public boolean transferencia(Transaccion transaccion){
        boolean flag = false;
        
        try {
            if (transaccion.getTipo().equalsIgnoreCase("transferencia")) {
                flag = this.procesoData.transferencia(transaccion);
            }else{
                System.err.println("No es una trasferencia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }
        
        return flag;
    }
}
