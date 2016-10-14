package logic;

import business.ProcesoBusiness;
import data.ProcesoData;
import domain.Empleado;
import domain.Transaccion;
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
    private String resultado;
    private Transaccion transaccion;

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

                ProcesoBusiness pb = new ProcesoBusiness();

                switch (this.tipo) {
                    case "login":
                        this.numCuenta = recibir.readLine();
                        this.contrasennia = recibir.readLine();
                        
                        if (pb.loginCorrecto(this.numCuenta, this.contrasennia)) {
                            enviar.println("true");
                            Empleado empleado = pb.getEmpleado(numCuenta, contrasennia);
                            enviar.println(empleado.getNumeroCuenta());
                            enviar.println(empleado.getNombre());
                            enviar.println(empleado.getApellidos());
                            enviar.println(empleado.getCedula());
                            enviar.println(empleado.getFondo());
                        }
                        break;

                    case "consulta":
                        this.numCuenta = recibir.readLine();
                        this.contrasennia = recibir.readLine();
                        this.transaccion = new Transaccion(this.tipo, this.numCuenta, this.contrasennia);
                        this.resultado = String.valueOf(pb.consulta(transaccion));
                        enviar.println(this.resultado);
                        break;

                    case "deposito":
                        this.numCuenta = recibir.readLine();
                        this.contrasennia = recibir.readLine();
                        this.monto = Float.parseFloat(recibir.readLine());
                        
                        this.transaccion = new Transaccion(this.tipo, this.monto, this.numCuenta, this.contrasennia);
                        this.resultado = String.valueOf(pb.credito_debito(this.transaccion));
                        enviar.println(this.resultado);

                        break;
                        
                    case "retiro":
                        this.numCuenta = recibir.readLine();
                        this.contrasennia = recibir.readLine();
                        this.monto = Float.parseFloat(recibir.readLine());

                        this.transaccion = new Transaccion(this.tipo, this.monto, this.numCuenta, this.contrasennia);
                        this.resultado = String.valueOf(pb.credito_debito(this.transaccion));
                        enviar.println(this.resultado);
                        break;
                        
                    case "transferencia":
                        this.numCuenta = recibir.readLine();
                        this.contrasennia = recibir.readLine();
                        this.monto = Float.parseFloat(recibir.readLine());
                        this.cuentaDestino = recibir.readLine();

                        this.transaccion = new Transaccion(this.tipo, this.monto, this.numCuenta, this.cuentaDestino, this.contrasennia);
                        this.resultado = String.valueOf(pb.transferencia(this.transaccion));
                        enviar.println(this.resultado);
                        break;

                    default:
                        break;
                }
                socket.close();
            } while (this.flag);
        } catch (BindException e) {
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
