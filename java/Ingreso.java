import java.time.LocalDate;
import java.util.Scanner;

public class Ingreso extends Movimiento{
    
    public Ingreso(int id, double cantidad, String descripcion,
                    String fecha, Categoria categoria) {

        super(id, cantidad, descripcion, fecha, categoria);
    }
    
    public static void añadirIngreso(Usuario usuario, Scanner sc) {
    	
    	double cantidad;
    	
    	//Repetimos mientras el usuario introduzca una cantidad no valida
    	do {
    		//Pedimos la cantidad
    		System.out.print("Cantidad ingreso: ");
            cantidad = sc.nextDouble();
            sc.nextLine();
            
            //Comprobamos que la cantidad sea mayor que 0
            if (cantidad <= 0) {
            	System.out.println("La cantidad debe ser mayor que 0.");
            }
            
        // Si la cantidad es menor o igual que 0, vuelve a pedirla
    	} while (cantidad <= 0);
    	
        

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        Categoria categoria = Categoria.elegirCategoria(sc);

        Ingreso ingreso = new Ingreso(
                usuario.getCuenta().getMovimientos().size() + 1,
                cantidad,
                descripcion,
                LocalDate.now().toString(),
                categoria
        );
        usuario.getCuenta().añadirMovimiento(ingreso);
        
        //Insertamos ingreso en Base de datos
        MovimientoDAO dao = new MovimientoDAO();
        
        dao.insertarMovimiento(ingreso, usuario.getId(), "INGRESO");
        
        //Confirmamos la operacion
        ingreso.aplicarMovimiento();
        
    }
    
    @Override
    public void aplicarMovimiento(){
        System.out.println("Ingreso añadido correctamente");
    }

    @Override
    public String toString() {
        return "[INGRESO] " + super.toString();
    }
}