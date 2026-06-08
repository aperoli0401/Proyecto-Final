import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovimientoDAO {

	// Guardamos un movimiento en la base de datos
	
	public void insertarMovimiento(Movimiento movimiento, int usuarioId, String tipo) {
		
		String sql = "INSERT INTO movimientos(cantidad, descripcion, fecha, categoria, tipo, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (
				Connection con = ConexionBD.conectar();
				PreparedStatement ps = con.prepareStatement(sql)
		){
			ps.setDouble(1, movimiento.getCantidad());
			ps.setString(2, movimiento.getDescripcion());
			ps.setString(3, movimiento.getFecha());
			ps.setString(4, movimiento.getCategoria().toString());
			ps.setString(5, tipo);
			ps.setInt(6, usuarioId);
			
			ps.executeUpdate();
			
			System.out.println("Movimiento guardado correctamente.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Obtener movimientos de un usuario
    public ArrayList<Movimiento> obtenerMovimientos(int usuarioId) {

        ArrayList<Movimiento> movimientos =
                new ArrayList<>();

        String sql =
                "SELECT * FROM movimientos WHERE usuario_id = ?";

        try (
                Connection con = ConexionBD.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

        	ps.setInt(1, usuarioId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));

                if (rs.getString("tipo").equals("INGRESO")) {

                    Ingreso ingreso = new Ingreso(
                            rs.getInt("id"),
                            rs.getDouble("cantidad"),
                            rs.getString("descripcion"),
                            rs.getString("fecha"),
                            categoria
                    );

                    movimientos.add(ingreso);

                } else {

                    Gasto gasto = new Gasto(
                            rs.getInt("id"),
                            rs.getDouble("cantidad"),
                            rs.getString("descripcion"),
                            rs.getString("fecha"),
                            categoria
                    );

                    movimientos.add(gasto);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return movimientos;
    }
	
}
