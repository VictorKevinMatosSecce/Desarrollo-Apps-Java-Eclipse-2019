package com.test;

import java.sql.Connection;

import com.datos.Conexion;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class TestCursores {
	public static void main(String[] args) {
	
		try {
			OracleCallableStatement oCallableStatement = null;
			OracleResultSet oResultSet = null;

			Connection cn = Conexion.getConnection();

			oCallableStatement = (OracleCallableStatement) cn
					.prepareCall("{ ? = call HR.REF_CURSOR_PACKAGE.GET_DEPT_REF_CURSOR(?) }");

			oCallableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			oCallableStatement.setInt(2, 200);
			oCallableStatement.execute();
			oResultSet = (OracleResultSet) oCallableStatement.getCursor(1);

			while (oResultSet.next()) {
				System.out.print(" IdDepartamento => " + oResultSet.getInt(1));
				System.out.print(" - NombreDepartamento => " + oResultSet.getString(2));
				System.out.print(" - IdUbicacion => " + oResultSet.getString(3));
				System.out.println();
			}
			oCallableStatement.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
