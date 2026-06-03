import java.util.ArrayList;

public class Cuenta {
    private double balance;
    private double ingresos;
    private double gastos;


    private ArrayList<Movimiento> movimientos;
    
    // Creamos la lista de los movimientos
    public Cuenta() {
        movimientos = new ArrayList<>();
    }

    // Creamos el metodo para poder añadir movimientos
    public void añadirMovimiento(Movimiento movimiento) {

        // Aqui añadimos un movimiento a la lista
        movimientos.add(movimiento);

        // Comprobamos si el movimiento es un ingreso
        if (movimiento instanceof Ingreso) {
            ingresos += movimiento.getCantidad(); // Si es así toma el valor de la cantidad y lo suma a la variable ingreso
        }

        // Comprobamos si el movimiento es un gasto
        if (movimiento instanceof Gasto) {
            gastos += movimiento.getCantidad(); // Si es así toma el valor de la cantidad y lo suma a la variable gasto
        }

        // LLamamos al metodo calcularBalance
        calcularBalance();
    }

    // Creamos el metodo eliminar movimiento 
    public void eliminarMovimiento(Movimiento movimiento) {

        // Elimina el movimiento de la lista si se encuentra en la lista
        if (movimientos.remove(movimiento)) {

            // Comprobamos si el movimiento es un ingreso 
            if (movimiento instanceof Ingreso) {
                ingresos -= movimiento.getCantidad(); // Si es así elimina el valor de la cantidad del movimiento a ingresos
            }
            // Comprobamos si el movimiento es un gasto
            if (movimiento instanceof Gasto) {
                gastos -= movimiento.getCantidad(); // Si es así elimina el vlaor de la cantidad del movimiento a gastos
            }

            // LLamamos al metodo calcularBalance
            calcularBalance();
        }
    }
    
    
    public double calcularBalance(){
        balance = ingresos - gastos;
        return balance;
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
    
    // Mostramos el resumen financiero
    public void mostrarBalance() {

        System.out.println();
        System.out.println("------ RESUMEN FINANCIERO ------");

        System.out.println("Ingresos: "+ ingresos + "€");

        System.out.println("Gastos: "+ gastos + "€");

        System.out.println("Balance: "+ balance + "€");
    }
    
    //Mostramos el historial completo
    public void mostrarHistorial() {

        System.out.println();
        System.out.println("------ HISTORIAL ------");

        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

}
