import java.util.Scanner;

public class Gasto extends Movimiento{
    
    public Gasto(int id, double cantidad, String descripcion,
                  String fecha, Categoria categoria) {

        super(id, cantidad, descripcion, fecha, categoria);
    }
    
    public static void añadirGasto(Usuario usuario, Scanner sc) {

        System.out.print("Cantidad gasto: ");
        double cantidad = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        Categoria categoria = Categoria.elegirCategoria(sc);

        Gasto gasto = new Gasto(
                usuario.getCuenta().getMovimientos().size() + 1,
                cantidad,
                descripcion,
                "20/05/2026",
                categoria
        );

        usuario.getCuenta().añadirMovimiento(gasto);

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