public class Cuenta {
    private double balance;
    private double ingresos;
    private double gastos;


    private ArrayList<Movimiento> movimientos;

    public Cuenta() {
        movimientos = new ArrayList<>();
    }

    public void añadirMovimiento(Movimiento movimiento) {

        movimientos.add(movimiento);

        if (movimiento instanceof Ingreso) {
            ingresos += movimiento.getCantidad();
        }

        if (movimiento instanceof Gasto) {
            gastos += movimiento.getCantidad();
        }

        calcularBalance();
    }

    public void eliminarMovimiento(Movimiento movimiento) {

        if (movimientos.remove(movimiento)) {

            if (movimiento instanceof Ingreso) {
                ingresos -= movimiento.getCantidad();
            }

            if (movimiento instanceof Gasto) {
                gastos -= movimiento.getCantidad();
            }

            calcularBalance();
        }
    }
    
    }
    public double calcularBalance(){
        balance = ingresos - gastos;
        return balance;
    }

    public void mostrarMovimientos() {

        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getIngresos() {
        return ingresos;
    }

    public double getGastos() {
        return gastos;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
}

