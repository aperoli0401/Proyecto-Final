public class Gasto extends Movimiento{
    
    public Gasto(int id, double cantidad, String descripcion,
                  String fecha, Categoria categoria) {

        super(id, cantidad, descripcion, fecha, categoria);
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
