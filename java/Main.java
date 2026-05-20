public class Main {

    public static void main(String[] args) {

        Login login = new Login();

        Usuario usuario1 = new Usuario("Adrian", "1234");
        Usuario usuario2 = new Usuario("Alejandro", "4567");
        Usuario usuario3 = new Usuario("Raul", "0000");

        login.registrarUsuario(usuario1);

        boolean acceso = login.iniciarSesion("Adrian", "1234");

        if (acceso) {

            Ingreso ingreso1 = new Ingreso(
                    1,
                    1200,
                    "Nómina",
                    "12/05/2026",
                    Categoria.SALARIO
            );

            Gasto gasto1 = new Gasto(
                    2,
                    50,
                    "Compra supermercado",
                    "12/05/2026",
                    Categoria.COMIDA
            );

            usuario1.getCuenta().añadirMovimiento(ingreso1);
            usuario1.getCuenta().añadirMovimiento(gasto1);

            ingreso1.aplicarMovimiento();
            gasto1.aplicarMovimiento();

            System.out.println();
            System.out.println("=== RESUMEN FINANCIERO ===");
            System.out.println("Ingresos: " + usuario1.getCuenta().getIngresos() + "€");
            System.out.println("Gastos: " + usuario1.getCuenta().getGastos() + "€");
            System.out.println("Balance: " + usuario1.getCuenta().getBalance() + "€");

            System.out.println();
            System.out.println("=== HISTORIAL ===");
            usuario1.getCuenta().mostrarMovimientos();
        }
    }
}
