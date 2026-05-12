public class Login {
    
    private ArrayList<Usuario> usuarios;

    public Login() {
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean iniciarSesion(String nombre, String contraseña) {

        for (Usuario usuario : usuarios) {

            if (usuario.getNombre().equals(nombre)
                    && usuario.getContraseña().equals(contraseña)) {

                System.out.println("Inicio de sesión correcto");
                return true;
            }
        }

        System.out.println("Usuario o contraseña incorrectos");
        return false;
    }

    public void cerrarSesion() {
        System.out.println("Sesión cerrada correctamente");
    }
}
