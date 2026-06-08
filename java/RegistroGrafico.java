import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroGrafico {

    public static void abrir(Login login) {

        Frame frame = new Frame("Registro");

        frame.setLayout(new FlowLayout());

        frame.setSize(300, 200);

        frame.setVisible(true);

        // Usuario
        Label lblUsuario = new Label("Usuario:");
        TextField txtUsuario = new TextField(20);

        // Contraseña
        Label lblContraseña = new Label("Contraseña:");
        TextField txtContraseña = new TextField(20);
        txtContraseña.setEchoChar('*');

        // Botones
        Button btnRegistrar = new Button("Registrar");
        Button btnCancelar = new Button("Cancelar");

        ActionListener escuchador = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Registrar usuario
                if (e.getSource() == btnRegistrar) {

                    String nombre = txtUsuario.getText();
                    String contraseña = txtContraseña.getText();

                    // Comprobar campos vacíos
                    if (nombre.isEmpty() || contraseña.isEmpty()) {

                        Dialog dialogo = new Dialog(frame, "Error", true);

                        dialogo.setLayout(new FlowLayout());

                        dialogo.setSize(250,120);

                        dialogo.add(new Label("Debe rellenar todos los campos."));

                        Button cerrar = new Button("Cerrar");

                        cerrar.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                dialogo.dispose();

                            }

                        });

                        dialogo.add(cerrar);

                        dialogo.setVisible(true);

                        return;
                    }

                    // Comprobar usuario repetido
                    if (login.existeUsuario(nombre)) {

                        Dialog dialogo = new Dialog(frame, "Error", true);

                        dialogo.setLayout(new FlowLayout());

                        dialogo.setSize(250,120);

                        dialogo.add(new Label("Ese usuario ya existe."));

                        Button cerrar = new Button("Cerrar");

                        cerrar.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                dialogo.dispose();

                            }

                        });

                        dialogo.add(cerrar);

                        dialogo.setVisible(true);

                        return;
                    }

                    Usuario nuevo = new Usuario(nombre, contraseña);

                    login.registrarUsuario(nuevo);

                    UsuarioDAO dao = new UsuarioDAO();

                    dao.insertarUsuario(nuevo);

                    Dialog dialogo = new Dialog(frame, "Registro", true);

                    dialogo.setLayout(new FlowLayout());

                    dialogo.setSize(250,120);

                    dialogo.add(new Label("Usuario registrado correctamente."));

                    Button cerrar = new Button("Aceptar");

                    cerrar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            dialogo.dispose();

                            frame.dispose();

                        }

                    });

                    dialogo.add(cerrar);

                    dialogo.setVisible(true);

                }

                // Cancelar
                else if (e.getSource() == btnCancelar) {

                    frame.dispose();

                }

            }

        };

        btnRegistrar.addActionListener(escuchador);

        btnCancelar.addActionListener(escuchador);

        frame.add(lblUsuario);
        frame.add(txtUsuario);

        frame.add(lblContraseña);
        frame.add(txtContraseña);

        frame.add(btnRegistrar);
        frame.add(btnCancelar);

    }

}
