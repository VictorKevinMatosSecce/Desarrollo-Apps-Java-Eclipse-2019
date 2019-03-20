package com.datos;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexionesOracle {
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
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("hr");
		ds.setPassword("hr");
		ds.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
		ds.setInitialSize(5);
		return ds;
	}
}