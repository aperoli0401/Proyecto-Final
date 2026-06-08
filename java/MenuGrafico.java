import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuGrafico {

    public static void abrir(Usuario usuario, Login login) {

        // Creamos la ventana
        Frame frame = new Frame("Menú Principal");

        frame.setLayout(new FlowLayout());

        frame.setSize(300, 250);
        
        Utilidades.centrarVentana(frame);

        // Botones
        Button btnIngreso = new Button("Añadir ingreso");
        Button btnGasto = new Button("Añadir gasto");
        Button btnBalance = new Button("Ver balance");
        Button btnHistorial = new Button("Ver historial");
        Button btnCerrar = new Button("Cerrar sesión");

        ActionListener escuchador = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Abrir ventana de ingreso
                if (e.getSource() == btnIngreso) {
                	
                	frame.setVisible(false);
                    IngresoGrafico.abrir(usuario, frame);
                }

                // Abrir ventana de gasto
                else if (e.getSource() == btnGasto) {
                	
                	frame.setVisible(false);
                    GastoGrafico.abrir(usuario, frame);
                }

                // Mostrar balance
                else if (e.getSource() == btnBalance) {

                    Dialog dialogo = new Dialog(frame, "Balance", true);

                    dialogo.setLayout(new FlowLayout());

                    dialogo.setSize(250, 180);
                    
                    Utilidades.centrarDialogo(dialogo);
                    
                    dialogo.add(new Label("----------------------------"));

                    dialogo.add(new Label("Ingresos: "
                            + usuario.getCuenta().getIngresos() + " €"));

                    dialogo.add(new Label("Gastos: "
                            + usuario.getCuenta().getGastos() + " €"));

                    dialogo.add(new Label("Balance: "
                            + usuario.getCuenta().getBalance() + " €"));
                    
                    dialogo.add(new Label("----------------------------"));

                    Button cerrar = new Button("Cerrar");

                    cerrar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            dialogo.dispose();
                        }

                    });

                    dialogo.add(cerrar);

                    dialogo.setVisible(true);
                }

                // Mostrar historial
                else if (e.getSource() == btnHistorial) {

                	Dialog dialogo = new Dialog(frame, "Historial", true);

                	dialogo.setLayout(new BorderLayout());

                	dialogo.setSize(700, 450);

                	TextArea area = new TextArea();
                	area.setEditable(false);

                	area.setText("------ HISTORIAL ------\n\n");

                	for (Movimiento movimiento : usuario.getCuenta().getMovimientos()) {
                	    area.append(movimiento + "\n");
                	}

                	Button cerrar = new Button("Cerrar");

                	cerrar.addActionListener(new ActionListener() {
                	    @Override
                	    public void actionPerformed(ActionEvent e) {
                	        dialogo.dispose();
                	    }
                	});

                	dialogo.add(area, BorderLayout.CENTER);
                	dialogo.add(cerrar, BorderLayout.SOUTH);

                	Utilidades.centrarDialogo(dialogo);

                	dialogo.setVisible(true);
                }

                // Cerrar sesión
                else if (e.getSource() == btnCerrar) {

                    frame.dispose();

                    LoginGrafico.abrir(login);
                }
            }
        };

        btnIngreso.addActionListener(escuchador);
        btnGasto.addActionListener(escuchador);
        btnBalance.addActionListener(escuchador);
        btnHistorial.addActionListener(escuchador);
        btnCerrar.addActionListener(escuchador);

        frame.add(btnIngreso);
        frame.add(btnGasto);
        frame.add(btnBalance);
        frame.add(btnHistorial);
        frame.add(btnCerrar);

        // Para cerrar la ventana desde la X
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                frame.dispose();

            }

        });

        frame.setVisible(true);
    }
}
