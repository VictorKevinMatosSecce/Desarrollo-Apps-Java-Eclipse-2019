package com.personas.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.personas.dto.PersonaDTO;

public class PersonaDAOJDBC implements PersonaDAO {
	private Connection usrConn = null;
	private final String SQL_INSERT = "INSERT INTO SGA.PERSONA(NOMBRE,APELLIDO) VALUES (?,?);";
	private final String SQL_UPDATE = "UPDATE SGA.PERSONA SET NOMBRE = ?,  APELLIDO = ? where IDPERSONA = ?;";
	private final String SQL_DELETE = "DELETE FROM SGA.PERSONA where IDPERSONA = ?;";
	private final String SQL_SELECT = "SELECT idpersona,nombre,apellido FROM SGA.PERSONA ORDER BY idpersona;";

	public PersonaDAOJDBC(Connection cn) {
		this.usrConn = cn;
	}

	@Override
	public int Insert(PersonaDTO persona) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			// connection = Conexion.getConnection();
			connection = (this.usrConn != null) ? this.usrConn : Conexion.getConnection();
			statement = connection.prepareStatement(SQL_INSERT);
			int index = 1;
			statement.setString(index++, persona.getNombre());
			statement.setString(index++, persona.getApellido());
			System.out.println("Ejecutando query : " + SQL_INSERT);
			rows = statement.executeUpdate();
			System.out.println("Registros afectados : " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			// Conexion.close(connection);
			if (this.usrConn == null) {
				Conexion.close(usrConn);
			}
		}
		return rows;
	}

	@Override
	public int Update(PersonaDTO persona) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			// connection = Conexion.getConnection();
			connection = (this.usrConn != null) ? this.usrConn : Conexion.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE);
			int index = 1;

			statement.setString(index++, persona.getNombre());
			statement.setString(index++, persona.getApellido());
			statement.setInt(index++, persona.getIdPersona());
			System.out.println("Ejecutando query : " + SQL_UPDATE);
			rows = statement.executeUpdate();
			System.out.println("Registros afectados : " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			// Conexion.close(connection);
			if (this.usrConn == null) {
				Conexion.close(usrConn);
			}
		}
		return rows;
	}

	@Override
	public int Delete(PersonaDTO persona) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		try {
			// connection = Conexion.getConnection();
			connection = (this.usrConn != null) ? this.usrConn : Conexion.getConnection();
			statement = connection.prepareStatement(SQL_DELETE);
			statement.setInt(1, persona.getIdPersona());
			System.out.println("Ejecutando query : " + SQL_DELETE);
			rows = statement.executeUpdate();
			System.out.println("Registros afectados : " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			// Conexion.close(connection);
			if (this.usrConn == null) {
				Conexion.close(usrConn);
			}
		}
		return rows;
	}

	@Override
	public List<PersonaDTO> Select() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PersonaDTO persona = null;
		List<PersonaDTO> list = new ArrayList<PersonaDTO>();

		try {

			// connection = Conexion.getConnection();
			connection = (this.usrConn != null) ? this.usrConn : Conexion.getConnection();
			statement = connection.prepareStatement(SQL_SELECT);
			System.out.println("Ejecutando query : " + SQL_SELECT);
			resultSet = statement.executeQuery();
			System.out.println("Registros afectados : " + resultSet.getRow());
			while (resultSet.next()) {
				persona = new PersonaDTO();
				persona.setIdPersona(resultSet.getInt(1));
				persona.setNombre(resultSet.getString(2));
				persona.setApellido(resultSet.getString(3));
				list.add(persona);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.close(statement);
			// Conexion.close(connection);
			if (this.usrConn == null) {
				Conexion.close(usrConn);
			}
		}
		return list;
	}

}
