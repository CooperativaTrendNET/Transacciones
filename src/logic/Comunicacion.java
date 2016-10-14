package logic;

import business.ProcesoBusiness;
import data.ProcesoData;
import domain.Empleado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import util.Strings;

public class Comunicacion implements Runnable {

    private String numCuenta;
    private String contrasennia;
    private String tipo;
    private float monto;
    private String cuentaDestino;
    private JTextArea jtaConsola;
    private int puerto;
    private boolean flag;

    public Comunicacion() {
        super();
        this.puerto = 8080;
        this.flag = true;
    }

    public void Hilo(JTextArea jtaConsola) {
        this.jtaConsola = jtaConsola;
    }

    @Override
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(this.puerto);

            do {
                Socket socket = serverSocket.accept();
                PrintStream enviar = new PrintStream(socket.getOutputStream());
                BufferedReader recibir = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                this.tipo = recibir.readLine();

                ProcesoData pd = new ProcesoData();
                ProcesoBusiness pb = new ProcesoBusiness();

                switch (this.tipo) {
                    case "login":
                        this.numCuenta = recibir.readLine();
                        this.contrasennia = recibir.readLine();

                        if (pb.loginCorrecto(this.numCuenta, this.contrasennia) == false) {
                            enviar.println("false");

                        } else {
                            enviar.println("true");
                        }
                        break;

                    case "consulta":
                        this.numCuenta = recibir.readLine();
                        Empleado emp = pd.getEmpleado(this.numCuenta);
                        float fondo = emp.getFondo();

                        enviar.println(fondo);

                        break;

                    case "deposito":
                        this.numCuenta = recibir.readLine();
                        this.monto = Float.parseFloat(recibir.readLine());
                        
                        break;

                    case "retiro":

                        break;

                    case "transferencia":

                        break;

                }
                socket.close();
            } while (this.flag);
        } catch (BindException e) {
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
