package data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author adrian
 */
public class AhorroAutomaticoData extends Thread{
    
    private boolean flag;
    private Connection connection;
    
    public AhorroAutomaticoData() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://163.178.107.130:1433;databaseName=Proyecto_Operativos_B24814_B35781_B35783_B36630;user=sqlserver;password=saucr.12";
        this.connection = DriverManager.getConnection(connectionURL);
        this.flag = true;
    }
    
    @Override
    public void run() {
        try {
            Statement statement = this.connection.createStatement();
            
            while (this.flag) {
                CallableStatement cs = this.connection.prepareCall("{call sp_Cuenta_Maestra_Ahorro()}");
                cs.execute();
                cs.close();
                Thread.sleep(180000);//180000
            }
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcesoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
