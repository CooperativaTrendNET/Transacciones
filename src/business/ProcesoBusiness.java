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
    
    public boolean deposito(Transaccion transaccion){
        boolean flag = false;
        
        try {
            if (transaccion.getTipo()=='d') {
                flag = this.procesoData.deposito(transaccion);
            }else{
                System.err.println("No es un deposito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }
        return flag;
    }
}
