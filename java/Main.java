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

             do{
                //Menú de opciones
                System.out.println();
                System.out.println("--------MENÚ--------");
                System.out.println("1. Añadir ingreso");
                System.out.println("2. Añadir gasto");
                System.out.println("3. Ver balance");
                System.out.println("4. Ver historial");
                System.out.println("5. Salir");

                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion){
                    case 1:
                        Ingreso.añadirIngreso(usuarioActual, sc);
                        break;
                    case 2:
                        Gasto.añadirGasto(usuarioActual, sc);
                        break;

                    case 3:
                        Cuenta.mostrarBalance(usuarioActual);
                        break;

                    case 4:
                        Cuenta.mostrarHistorial(usuarioActual);
                        break;

                    case 5:
                        System.out.println("Sesión cerrada");
                        break;

                    default:
                        System.out.println("Opción incorrecta");	
                }
             } while (opcion != 5);
        }
        sc.close();
    }
}
