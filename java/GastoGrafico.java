import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class GastoGrafico {

    public static void abrir(Usuario usuario, Frame menuFrame) {

        // Creamos la ventana
        Frame frame = new Frame("Nuevo gasto");

        frame.setLayout(new FlowLayout());

        frame.setSize(550, 250);
        
        Utilidades.centrarVentana(frame);

        // Cantidad
        Label lblCantidad = new Label("Cantidad:");
        TextField txtCantidad = new TextField(15);

        // Descripción
        Label lblDescripcion = new Label("Descripción:");
        TextField txtDescripcion = new TextField(20);

        // Categoría
        Label lblCategoria = new Label("Categoría:");

        Choice choiceCategoria = new Choice();

        for (Categoria categoria : Categoria.values()) {

            choiceCategoria.add(categoria.toString());
        }

        // Botones
        Button btnGuardar = new Button("Guardar");
        Button btnCancelar = new Button("Cancelar");

        ActionListener escuchador = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Guardar gasto
                if (e.getSource() == btnGuardar) {

                    try {

                        double cantidad =
                                Double.parseDouble(txtCantidad.getText());

                        String descripcion =
                                txtDescripcion.getText();

                        Categoria categoria =
                                Categoria.valueOf(
                                        choiceCategoria.getSelectedItem());

                        Gasto gasto = new Gasto(

                                usuario.getCuenta()
                                       .getMovimientos()
                                       .size() + 1,

                                cantidad,

                                descripcion,

                                LocalDate.now().toString(),

                                categoria
                        );

                        // Añadir a la cuenta
                        usuario.getCuenta().añadirMovimiento(gasto);

                        // Guardar en la base de datos
                        MovimientoDAO dao = new MovimientoDAO();

                        dao.insertarMovimiento(
                                gasto,
                                usuario.getId(),
                                "GASTO"
                        );

                        gasto.aplicarMovimiento(); 
                        
                        // Diálogo de confirmación 
                        Dialog dialogo = new Dialog(frame, "Movimiento guardado", true); 
                        dialogo.setLayout(new FlowLayout()); 
                        dialogo.setSize(250, 120); 
                        Utilidades.centrarDialogo(dialogo);
                        dialogo.add(new Label("Gasto guardado correctamente.")); 
                        
                        Button btnAceptar = new Button("Aceptar"); 
                        
                        btnAceptar.addActionListener(new ActionListener() { 
                        	@Override 
                        	public void actionPerformed(ActionEvent e) { 
                        		dialogo.dispose(); 
                        		frame.dispose(); 
                        		menuFrame.setVisible(true); 
                        	} 
                        }); 
                        dialogo.add(btnAceptar); 
                        dialogo.setVisible(true);

                    } catch (NumberFormatException ex) {

                        System.out.println(
                                "La cantidad debe ser un número.");
                    }

                }

                // Cancelar
                else if (e.getSource() == btnCancelar) {

                    frame.dispose();

                    menuFrame.setVisible(true);
                }

            }

        };

        btnGuardar.addActionListener(escuchador);

        btnCancelar.addActionListener(escuchador);

        frame.add(lblCantidad);
        frame.add(txtCantidad);

        frame.add(lblDescripcion);
        frame.add(txtDescripcion);

        frame.add(lblCategoria);
        frame.add(choiceCategoria);

        frame.add(btnGuardar);
        frame.add(btnCancelar);
        
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
