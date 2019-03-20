package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Persona;

public class PersonasJDBC {
	private final String SQL_INSERT = "INSERT INTO SGA.PERSONA(NOMBRE,APELLIDO) VALUES (?,?);";
	private final String SQL_UPDATE = "UPDATE SGA.PERSONA SET NOMBRE = ?,  APELLIDO = ? where IDPERSONA = ?;";
	private final String SQL_DELETE = "DELETE FROM SGA.PERSONA where IDPERSONA = ?;";
	private final String SQL_SELECT = "SELECT idpersona,nombre,apellido FROM SGA.PERSONA ORDER BY idpersona;";

	public int Insert(String Nombre, String Apellido) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			connection = Conexion.getConnection();
			statement = connection.prepareStatement(SQL_INSERT);
			int index = 1;
			statement.setString(index++, Nombre);
			statement.setString(index++, Apellido);
			System.out.println("Ejecutando query : " + SQL_INSERT);
			rows = statement.executeUpdate();
			System.out.println("Registros afectados : " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			Conexion.close(connection);
		}
		return rows;
	}

	public int Update(int IdPersona, String Nombre, String Apellido) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			connection = Conexion.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE);
			int index = 1;

			statement.setString(index++, Nombre);
			statement.setString(index++, Apellido);
			statement.setInt(index++, IdPersona);
			System.out.println("Ejecutando query : " + SQL_UPDATE);
			rows = statement.executeUpdate();
			System.out.println("Registros afectados : " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			Conexion.close(connection);
		}
		return rows;
	}

	public int Delete(int IdPersona) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			connection = Conexion.getConnection();
			statement = connection.prepareStatement(SQL_DELETE);
			statement.setInt(1, IdPersona);
			System.out.println("Ejecutando query : " + SQL_DELETE);
			rows = statement.executeUpdate();
			System.out.println("Registros afectados : " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			Conexion.close(connection);
		}
		return rows;
	}

	public List<Persona> Select() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		List<Persona> list = new ArrayList<Persona>();

		try {

			connection = Conexion.getConnection();
			statement = connection.prepareStatement(SQL_SELECT);
			System.out.println("Ejecutando query : " + SQL_SELECT);
			resultSet = statement.executeQuery();
			System.out.println("Registros afectados : " + resultSet.getRow());
			while (resultSet.next()) {
				persona = new Persona();
				persona.setIdPersona(resultSet.getInt(1));
				persona.setNombre(resultSet.getString(2));
				persona.setApellido(resultSet.getString(3));
				list.add(persona);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			Conexion.close(connection);
		}
		return list;
	}
}
