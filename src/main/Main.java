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
        Transaccion t = new Transaccion("deposito", 5000, "00011");
        ProcesoBusiness p = new ProcesoBusiness();
        System.out.println("El deposito fue exitoso? "+p.deposito(t));
    }
    
}
