import java.time.LocalDate;
import java.util.Scanner;

public class Gasto extends Movimiento{
    
    public Gasto(int id, double cantidad, String descripcion,
                  String fecha, Categoria categoria) {

        super(id, cantidad, descripcion, fecha, categoria);
    }
    
    public static void añadirGasto(Usuario usuario, Scanner sc) {
    	
    	double cantidad;
    	
    	// Repetimos mientras el usuario introduzca una cantidad no válida
    	do {
    		System.out.print("Cantidad gasto: ");
            cantidad = sc.nextDouble();
            sc.nextLine();
            
            // Comprobamos que la cantidad sea mayor que 0
            if (cantidad <= 0) {
            	System.out.println("La cantiad debe ser mayor que 0.");
            }
        
        // Si la cantidad es menor o igual que 0, vuelve a pedirla
    	} while (cantidad <= 0);
    	

        
    	// Pedimos la descripcion
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        
        // Elegimos la categoría
        Categoria categoria = Categoria.elegirCategoria(sc);
        
        //  Creamos el gasto
        Gasto gasto = new Gasto(
                usuario.getCuenta().getMovimientos().size() + 1,
                cantidad,
                descripcion,
                LocalDate.now().toString(),
                categoria
        );
        
        // Lo añadimos a la cuenta
        usuario.getCuenta().añadirMovimiento(gasto);
        
        // Añadimos el gasto a la Base de datos
        MovimientoDAO dao = new MovimientoDAO();
        
        dao.insertarMovimiento(gasto, usuario.getId(), "GASTO");
        
        // Confirmamos la operacion
        gasto.aplicarMovimiento();
    }
    
    @Override
    public void aplicarMovimiento(){
        System.out.println("Gasto añadido correctamente");
    }

    @Override
    public String toString() {
        return "[GASTO] " + super.toString();
    }
    
}