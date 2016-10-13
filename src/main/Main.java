package main;

import business.ProcesoBusiness;
import data.ProcesoData;
import domain.Empleado;
import domain.Transaccion;
import gui.JFServidor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

//        Transaccion t = new Transaccion("deposito", 5000, "00011");
//        ProcesoBusiness p = new ProcesoBusiness();
//        System.out.println("El deposito fue exitoso? "+p.credito_debito(t));
        JFServidor server = new JFServidor();
//        List<Empleado> lista = new ArrayList<Empleado>();

//        Transaccion t = new Transaccion('d', 1000, "00010");
//        ProcesoBusiness p = new ProcesoBusiness();
//        System.out.println("El credito_debito fue exitoso? "+p.credito_debito(t));
//        try {
//            ProcesoData pd = new ProcesoData();
//            lista = pd.getEmpleados();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).toString());
//
//        }

    }

}
