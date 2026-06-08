import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginGrafico {

    public static void abrir(Login login) {

        // Creamos la ventana
        Frame frame = new Frame("Gestor Financiero");

        frame.setLayout(new FlowLayout());

        frame.setSize(300, 200);
        
        Utilidades.centrarVentana(frame);

        frame.setVisible(true);

        // Usuario
        Label lblUsuario = new Label("Usuario:");

        TextField txtUsuario = new TextField(20);

        // Contraseña
        Label lblContraseña = new Label("Contraseña:");

        TextField txtContraseña = new TextField(20);

        txtContraseña.setEchoChar('*');

        // Botones
        Button btnLogin = new Button("Iniciar sesión");

        Button btnRegistro = new Button("Registrarse");

        Button btnSalir = new Button("Salir");

        ActionListener escuchador = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Iniciar sesión
                if (e.getSource() == btnLogin) {

                    Usuario usuario = login.iniciarSesion(
                            txtUsuario.getText(),
                            txtContraseña.getText());

                    if (usuario != null) {

                        frame.dispose();

                        MenuGrafico.abrir(usuario, login);
                    }
                }

                // Registrarse
                else if (e.getSource() == btnRegistro) {
                	
                	frame.setVisible(false);
                    RegistroGrafico.abrir(login, frame);
                }

                // Salir
                else if (e.getSource() == btnSalir) {

                    frame.dispose();
                }
            }
        };

        btnLogin.addActionListener(escuchador);
        btnRegistro.addActionListener(escuchador);
        btnSalir.addActionListener(escuchador);

        frame.add(lblUsuario);
        frame.add(txtUsuario);

        frame.add(lblContraseña);
        frame.add(txtContraseña);

        frame.add(btnLogin);
        frame.add(btnRegistro);
        frame.add(btnSalir);
        
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
