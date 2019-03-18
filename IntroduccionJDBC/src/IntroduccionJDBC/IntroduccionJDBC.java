package IntroduccionJDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Connection;


public class IntroduccionJDBC {

	public static void main(String[] args) {
		// Cadena de conexion MySQL, el parametro useSSL es opcional
		String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
		// Cargamos el driver de MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Creamos el objeto conexion
			Connection connection = (Connection)DriverManager.getConnection(url, "root", "Peru123.");
			//Creamos un objeto Statement
			Statement statement = connection.createStatement();
			//Creamos el query
			String sql = "SELECT idpersona,nombre,apellido FROM SGA.PERSONA;";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("IdPersona :" + resultSet.getInt(1));
				System.out.println("Nombre    :" + resultSet.getString(2));
				System.out.println("Apellido  :" + resultSet.getString(3));		
				System.out.println("-----------------------------------" );	
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception ex) {
			System.out.println("Mensaje :" + ex.getMessage());
		}
	}

}
