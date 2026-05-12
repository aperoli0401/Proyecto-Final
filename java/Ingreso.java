public class Ingreso extends Movimiento{
    
    public Ingreso(int id, double cantidad, String descripcion,
                    String fecha, Categoria categoria) {

        super(id, cantidad, descripcion, fecha, categoria);
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
