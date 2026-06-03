import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(
			        "jdbc:mariadb://localhost:3306/gestor_finanzas?allowPublicKeyRetrieval=true&useSSL=false", "root", "");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
