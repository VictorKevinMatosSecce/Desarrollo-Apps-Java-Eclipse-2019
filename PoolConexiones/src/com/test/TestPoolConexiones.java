package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.datos.PoolConexionesMySql;
import com.datos.PoolConexionesOracle;

public class TestPoolConexiones {

	public static void main(String[] args) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			cn = PoolConexionesMySql.getConexion();
			System.out.println("Utilizamos el pool de conexiones de MySql");
			ps = cn.prepareStatement("SELECT * from persona");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(" IdPersona => " + rs.getInt(1));
				System.out.print(" Nombre  => " + rs.getString(2));
				System.out.println(" Apellido => " + rs.getString(3));
			}

			cn = PoolConexionesOracle.getConexion();
			System.out.println("Utilizamos el pool de conexiones de Oracle");
			ps = cn.prepareStatement("SELECT * FROM HR.EMPLOYEES WHERE EMPLOYEE_ID IN (100, 101, 102)");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(" IdPersona => " + rs.getInt(1));
				System.out.print(" Nombre  => " + rs.getString(2));
				System.out.println(" Apellido => " + rs.getString(3));
			}
			cn.close();
			rs.close();
			ps.close();
		} catch (Exception ex) {
			System.out.println("Mensaje => " + ex.getMessage());
		}

	}

}
