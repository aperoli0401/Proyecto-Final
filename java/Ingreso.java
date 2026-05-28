import java.util.Scanner;

public class Ingreso extends Movimiento{
    
    public Ingreso(int id, double cantidad, String descripcion,
                    String fecha, Categoria categoria) {

        super(id, cantidad, descripcion, fecha, categoria);
    }
    
    public static void añadirIngreso(Usuario usuario, Scanner sc) {

        System.out.print("Cantidad ingreso: ");
        double cantidad = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        Categoria categoria = Categoria.elegirCategoria(sc);

        Ingreso ingreso = new Ingreso(
                usuario.getCuenta().getMovimientos().size() + 1,
                cantidad,
                descripcion,
                "20/05/2026",
                categoria
        );
        usuario.getCuenta().añadirMovimiento(ingreso);

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