import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class Utilidades {
	
	// Centrar Frame
    public static void centrarVentana(Frame frame) {
    	
    	
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (pantalla.width - frame.getWidth()) / 2;
        int y = (pantalla.height - frame.getHeight()) / 2;

        frame.setLocation(x, y);
    }
    
    
    // Centrar Dialog
    public static void centrarDialogo(Dialog dialogo) {

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (pantalla.width - dialogo.getWidth()) / 2;
        int y = (pantalla.height - dialogo.getHeight()) / 2;

        dialogo.setLocation(x, y);
    }

}