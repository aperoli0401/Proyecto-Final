import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	// Guardar usuario en la base de datos
    public void insertarUsuario(Usuario usuario) {

        String sql =
                "INSERT INTO usuarios(nombre, contraseña) VALUES (?, ?)";

        try (
                Connection con = ConexionBD.conectar();
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());

            ps.executeUpdate();

            System.out.println("Usuario guardado");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
	 // Obtener todos los usuarios de la base de datos
	 public ArrayList<Usuario> obtenerUsuarios() {
	
	     ArrayList<Usuario> usuarios = new ArrayList<>();
	
	     String sql = "SELECT * FROM usuarios";
	
	     try (
	             Connection con = ConexionBD.conectar();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()
	     ) {
	
	         // DAO para obtener los movimientos
	         MovimientoDAO movimientoDAO = new MovimientoDAO();
	
	         while (rs.next()) {
	
	             Usuario usuario = new Usuario(
	                     rs.getString("nombre"),
	                     rs.getString("contraseña"));
	
	             usuario.setId(rs.getInt("id"));
	
	             // Cargar movimientos del usuario
	             for (Movimiento movimiento :
	                     movimientoDAO.obtenerMovimientos(usuario.getId())) {
	
	                 usuario.getCuenta().añadirMovimiento(movimiento);
	             }
	             
	             
	             usuarios.add(usuario);
	         }
	
	     } catch (SQLException e) {
	
	         e.printStackTrace();
	     }
	
	     return usuarios;
	 }

}