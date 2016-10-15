
package logic;

import business.ProcesoBusiness;
import domain.Empleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 * 
 * @author daniel
 */
public class TablaEmpleados extends Thread{

    private JTable jtaEmpleados;
    private ProcesoBusiness procesoBusiness;
    private String[] columnas; 
    private String[][] tabla;
    
    
    public TablaEmpleados(JTable jtaEmpleados, String[] columnas, String[][] filas) {
        this.jtaEmpleados = jtaEmpleados;
        this.procesoBusiness = new ProcesoBusiness(); 
        this.columnas = columnas;
        this.tabla = filas;
        
    }
    
     public void llenaTabla() {
         
         List<Empleado> lista = lista = procesoBusiness.getEmpleados();
       
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {

                switch (j) {
                    case 0:
                        tabla[i][j] = lista.get(i).getNombre();
                        break;
                    case 1:
                        tabla[i][j] = lista.get(i).getApellidos();
                        break;
                    case 2:
                        tabla[i][j] = lista.get(i).getCedula();
                        break;
                    case 3:
                        tabla[i][j] = lista.get(i).getFondo() + "";
                        break;
                    default:
                        tabla[i][j] = lista.get(i).getNumeroCuenta();
                        break;
                }
            }

        }

        
        

    }

    @Override
    public void run() {
          while(true){
        
            llenaTabla();
            this.jtaEmpleados.repaint();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TablaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
