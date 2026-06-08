import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       
        // LOGIN
        Login login = new Login();
        
        // DAO
        UsuarioDAO dao = new UsuarioDAO();
        
        // Cargar usuarios de la base de datos
        login.cargarUsuarios(dao.obtenerUsuarios());
        
        
        /*
        // USUARIOS DE PRUEBA
        login.registrarUsuario(new Usuario("Adrian", "1234")); 
        login.registrarUsuario(new Usuario("Alejandro", "4567")); 
        login.registrarUsuario(new Usuario("Raul", "0000"));
        */
        
        int opcionInicial;
        
        do { //Menú para Crear usuario o Iniciar sesión
        	System.out.println(); 
        	System.out.println("------ GESTOR FINANCIERO ------"); 
        	System.out.println("1. Iniciar sesión"); 
        	System.out.println("2. Registrarse"); 
        	System.out.println("3. Salir"); 
        	
        	System.out.print("Seleccione una opción: "); 
        	opcionInicial = sc.nextInt(); 
        	sc.nextLine(); 
        	
        	switch (opcionInicial) {
        		case 1: 
        			iniciarSesion(login, sc); 
        			break; 
        		case 2: 
        			registrarUsuario(login, sc); 
        			break; 
        		case 3: 
        			System.out.println("Programa finalizado"); 
        			break; 
        		default: 
        			System.out.println("Opción incorrecta"); 
        	} 
        } while (opcionInicial != 3); 
        sc.close(); 
        }
        
    	public static void iniciarSesion(Login login, Scanner sc) {
    		
    		System.out.println(); 
    		System.out.println("------ INICIO DE SESIÓN ------"); 
    		System.out.print("Nombre de usuario: "); 
    		String nombre = sc.nextLine(); 
    		
    		System.out.print("Contraseña: "); 
    		String contraseña = sc.nextLine(); 
    		
    		Usuario usuarioActual = login.iniciarSesion(nombre, contraseña); 
    		
    		if (usuarioActual != null) { 
    			menuUsuario(usuarioActual, sc); 
    		} 
    	}
    	
    	
    	public static void registrarUsuario(Login login, Scanner sc) {

    	    System.out.println();
    	    System.out.println("------ REGISTRO ------");

    	    System.out.print("Nombre de usuario: ");
    	    String nombre = sc.nextLine();

    	    System.out.print("Contraseña: ");
    	    String contraseña = sc.nextLine();
    	    
    	    //Comprobar que no haya campos vacíos
    	    if (nombre.isEmpty() || contraseña.isEmpty()) {
    	    	
    	    	System.out.println("Debe rellenar todos los campos.");
    	    	return;
    	    }
    	    // Comprobar que el usuario no exista
    	    if (login.existeUsuario(nombre)) {
    	    	System.out.println("Ese nombre de usuario ya existe.");
    	    	return;
    	    }
    	    
    	    Usuario nuevoUsuario = new Usuario(nombre,contraseña);
    	    // Lo añadimos al ArrayList
    	    login.registrarUsuario(nuevoUsuario);
    	    
    	    try {
    	    	// Lo guardamos en la base de datos
    	    	UsuarioDAO dao = new UsuarioDAO();
    	    	dao.insertarUsuario(nuevoUsuario);
    	    	
    	    } catch (Exception e) {
    	    	// Añadimos error por si no se puede conectar a la bbdd
    	    	System.out.println("No se ha podido conectar con la base de datos");
    	    }
    	}
    	
    	public static void menuUsuario( Usuario usuarioActual, Scanner sc) {
    		
            int opcion;

             do{
                //Menú de opciones
                System.out.println();
                System.out.println("--------MENÚ--------");
                System.out.println("1. Añadir ingreso");
                System.out.println("2. Añadir gasto");
                System.out.println("3. Ver balance");
                System.out.println("4. Ver historial");
                System.out.println("5. Cerrar sesión");

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
                        usuarioActual.getCuenta().mostrarBalance();
                        break;

                    case 4:
                        usuarioActual.getCuenta().mostrarHistorial();;
                        break;

                    case 5:
                        System.out.println("Sesión cerrada");
                        break;

                    default:
                        System.out.println("Opción incorrecta");	
                }
             } while (opcion != 5);
        }
    }
