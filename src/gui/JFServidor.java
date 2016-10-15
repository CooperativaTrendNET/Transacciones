package gui;

import business.ProcesoBusiness;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import logic.Comunicacion;
import logic.TablaEmpleados;

/**
 *
 * @author Daniel
 */
public class JFServidor extends JFrame implements ActionListener {

    private JPanel jPanelEmpleados;
    private JPanel jPanelActividad;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem jmIniciar;
    private JMenuItem jmiFinalizar;
    private JTable jTabla;
    private JScrollPane scrollTabla;
    private JScrollPane scrollTA;
    private JLabel jlempleados;
    private JLabel jlActividad;
    private JTextArea jtActividad;
    private ProcesoBusiness procesoBusiness;
    private Comunicacion comunicacion;
    private Calendar calendar;
    private String[] columnas;
    private String[][] tabla;
    
    public JFServidor() {
        super("Servidor");
        this.calendar = Calendar.getInstance();
        this.columnas = new String[5];
        this.columnas[0] = "Nombre";
        this.columnas[1] = "Apellidos";
        this.columnas[2] = "Cédula";
        this.columnas[3] = "Fondos";
        this.columnas[4] = "Num. Cuenta";
        this.tabla = new String[20][columnas.length];
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            this.procesoBusiness = new ProcesoBusiness();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setLayout(new BorderLayout());
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();

        this.setVisible(true);

    }

    public void init() {
        this.jPanelEmpleados = new JPanel();
        this.jPanelEmpleados.setLayout(new BorderLayout());
        this.jPanelEmpleados.setBackground(new Color(60, 85, 220));

        this.jPanelActividad = new JPanel(new BorderLayout());
        this.jPanelActividad.setBackground(new Color(80, 145, 220));

        this.jlempleados = new JLabel("Empleados en el sistema", SwingConstants.CENTER);
        this.jlempleados.setForeground(Color.WHITE);
        this.jlempleados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.jMenuBar = new JMenuBar();

        this.jMenu = new JMenu("Opciones");
        this.jMenuBar.add(this.jMenu);

        this.jmIniciar = new JMenuItem("Iniciar");
        this.jmIniciar.addActionListener(this);
        this.jMenu.add(this.jmIniciar);
        this.jmiFinalizar = new JMenuItem("Finalizar");
        this.jmiFinalizar.addActionListener(this);
        this.jmiFinalizar.setEnabled(false);
        this.jMenu.add(this.jmiFinalizar);

        this.jlActividad = new JLabel("Actividad", SwingConstants.CENTER);
        this.jlActividad.setForeground(Color.WHITE);
        this.jlActividad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.jTabla = new JTable(tabla, columnas);
        this.jTabla.setEnabled(false);

        this.scrollTabla = new JScrollPane(jTabla);
        this.scrollTabla.setBorder(BorderFactory.createEmptyBorder(90, 10, 90, 10));
        this.scrollTabla.setBackground(new Color(80, 145, 220));
        
        int dia = calendar.get(Calendar.DATE);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int annio = calendar.get(Calendar.YEAR);
        this.jtActividad = new JTextArea("Bitácora de procesos del día: "+ dia + " / " + mes + " / " + annio + "\n\n");
        this.jtActividad.setEditable(false);
        this.scrollTA = new JScrollPane(jtActividad);
        this.scrollTA.setBorder(BorderFactory.createCompoundBorder());

        this.jPanelActividad.add(this.jlActividad, BorderLayout.NORTH);
        this.jPanelActividad.add(this.scrollTA, BorderLayout.CENTER);
        this.jPanelEmpleados.add(this.scrollTabla, BorderLayout.CENTER);
        this.jPanelEmpleados.add(this.jlempleados, BorderLayout.NORTH);
        this.add(this.jPanelEmpleados, BorderLayout.EAST);
        this.add(this.jPanelActividad, BorderLayout.CENTER);
        this.add(this.jMenuBar, BorderLayout.NORTH);
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmIniciar) {

            this.jmiFinalizar.setEnabled(true);
            this.jmIniciar.setEnabled(false);
            this.comunicacion = new Comunicacion();
            this.comunicacion.Hilo(jtActividad);

            Thread h = new Thread(comunicacion);
            h.start();
            
            this.procesoBusiness.iniciarAhorro();
            
            TablaEmpleados te = new TablaEmpleados(this.jTabla, this.columnas, this.tabla);
            te.start();
        
        } else if (e.getSource() == jmiFinalizar) {
            System.exit(0);

        }

    }

}
