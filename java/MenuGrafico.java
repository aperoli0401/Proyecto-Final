import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGrafico {

    public static void abrir(Usuario usuario) {

        // Creamos la ventana
        Frame frame = new Frame("Menú Principal");

        frame.setLayout(new FlowLayout());

        frame.setSize(300, 250);

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

                    IngresoGrafico.abrir(usuario);
                }

                // Abrir ventana de gasto
                else if (e.getSource() == btnGasto) {

                    GastoGrafico.abrir(usuario);
                }

                // Mostrar balance
                else if (e.getSource() == btnBalance) {

                    Dialog dialogo = new Dialog(frame, "Balance", true);

                    dialogo.setLayout(new FlowLayout());

                    dialogo.setSize(250, 180);

                    dialogo.add(new Label("Ingresos: "
                            + usuario.getCuenta().getIngresos() + " €"));

                    dialogo.add(new Label("Gastos: "
                            + usuario.getCuenta().getGastos() + " €"));

                    dialogo.add(new Label("Balance: "
                            + usuario.getCuenta().getBalance() + " €"));

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

                    dialogo.setLayout(new FlowLayout());

                    dialogo.setSize(500, 300);

                    TextArea area = new TextArea(12, 50);

                    for (Movimiento movimiento :
                            usuario.getCuenta().getMovimientos()) {

                        area.append(movimiento.toString() + "\n");
                    }

                    dialogo.add(area);

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

                // Cerrar sesión
                else if (e.getSource() == btnCerrar) {

                    frame.dispose();

                    LoginGrafico.abrir(new Login());
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

        frame.setVisible(true);
    }
}
