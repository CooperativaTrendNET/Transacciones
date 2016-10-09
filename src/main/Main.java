package main;

import business.ProcesoBusiness;
import data.ProcesoData;
import domain.Transaccion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
    }

    public Main() {
        Transaccion t = new Transaccion('d', 1000, "00010");
        ProcesoBusiness p = new ProcesoBusiness();
        System.out.println("El deposito fue exitoso? "+p.deposito(t));
        
        
//        try {
//            ProcesoData pd = new ProcesoData();
//            System.out.println(pd.getEmpleado("00110"));
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
