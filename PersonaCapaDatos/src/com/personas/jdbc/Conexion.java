package com.personas.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "Peru123.";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Fallo en cargar el driver JDBC");
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void close(Connection cn) {
		try {
			if (cn != null) {
				cn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
