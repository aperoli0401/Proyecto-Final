
public class MainGrafico {

	public static void main(String[] args) {
		//Creamos el login
		Login login = new Login();
		
		//Cargamos los usuarios de la base de datos
		UsuarioDAO dao = new UsuarioDAO();
		login.cargarUsuarios(dao.obtenerUsuarios());
		
		//Abrimos la interfaz grafica
		LoginGrafico.abrir(login);
	}

}
