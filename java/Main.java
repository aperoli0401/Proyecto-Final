import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // LOGIN
        Login login = new Login();
        // USUARIOS
        Usuario usuario1 = new Usuario("Adrian", "1234");
        Usuario usuario2 = new Usuario("Alejandro", "4567");
        Usuario usuario3 = new Usuario("Raul", "0000");
        // REGISTRAR USUARIOS
        login.registrarUsuario(usuario1);
        login.registrarUsuario(usuario2);
        login.registrarUsuario(usuario3);
        

        System.out.println("--------Inicio de sesión--------");
        //Pedimos el nombre al usuario y lo guardamos
        System.out.print("Nombre de usuario: ");
        String nombre = sc.nextLine();
        //Pedimos la contraseña al usuario y la guardamos
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        Usuario usuarioActual = login.iniciarSesion(nombre, contraseña);

        if (usuarioActual != null) {
            //Opción para usar después un menú de acciones
             int opcion;
            //Menú de opciones
             System.out.println();
                System.out.println("--------MENÚ--------");
                System.out.println("1. Añadir ingreso");
                System.out.println("2. Añadir gasto");
                System.out.println("3. Ver balance");
                System.out.println("4. Ver historial");
                System.out.println("5. Salir");

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
