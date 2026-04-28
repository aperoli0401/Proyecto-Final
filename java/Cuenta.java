public class Cuenta {
    double balance;
    double ingresos;
    double gastos;

    public void añadirMovimiento(){

    }
    public void eliminarMovimiento(){

    }
    public double calcularBalance(){
        balance = ingresos - gastos;
        return balance;
    }
}
