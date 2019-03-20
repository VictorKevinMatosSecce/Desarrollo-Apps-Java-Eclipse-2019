package com.datos;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexionesMySql {

	public static Connection getConexion() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			System.out.println("Mensaje => " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("Peru123.");
		ds.setUrl("jdbc:mysql://localhost:3306/sga?useSSL=false");
		ds.setInitialSize(5);
		return ds;
	}
}
