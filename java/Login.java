import java.util.ArrayList;

public class Login {
    
    private ArrayList<Usuario> usuarios;
    

    public Login() {
        usuarios = new ArrayList<>();
    }
    
    //Registrar usuario ya creado
    public void registrarUsuario(String nombre, String contraseña) {
    	
        Usuario usuario = new Usuario(nombre, contraseña);

        usuarios.add(usuario);

        System.out.println("Usuario registrado correctamente");
    }
    
    // Registrar un usuario ya creado
    public void registrarUsuario(Usuario usuario) {
    	usuarios.add(usuario);
    }
    
    // Comprobar si un usuario ya existe
    public boolean existeUsuario(String nombre) {
    	for (Usuario usuario : usuarios) {
    		if (usuario.getNombre().equals(nombre)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    // Cargar usuarios desde la base de datos
    public void cargarUsuarios(ArrayList<Usuario> lista) {
    	usuarios.addAll(lista);
    }
    
    // Iniciar sesión
    public Usuario iniciarSesion(String nombre, String contraseña) {

        for (Usuario usuario : usuarios) {

            if (usuario.getNombre().equals(nombre)
                    && usuario.getContraseña().equals(contraseña)) {

                System.out.println("Inicio de sesión correcto");
                return usuario;
            }
        }

        System.out.println("Usuario o contraseña incorrectos");
        return null;
    }
    
    // Cerrar sesión
    public void cerrarSesion() {
        System.out.println("Sesión cerrada correctamente");
    }
}