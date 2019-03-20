package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.datos.Conexion;

public class TestProcedimientos {

	public static void main(String[] args) {
		int idEmpleado = 100;
		double IncrementoSalario = 1.1;

		try {
			Connection cn = Conexion.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			CallableStatement cstmt = null;

			stmt = cn.createStatement();

			System.out.println("Aumento del 10% al empleado " + idEmpleado);
			cstmt = cn.prepareCall("{ call HR.SET_EMPLOYEE_SALARY(?,?) }");
			cstmt.setInt(1, idEmpleado);
			cstmt.setDouble(2, IncrementoSalario);
			cstmt.execute();

			String query = "SELECT First_Name,salary " + "FROM employees " + "wherE employee_id =" + idEmpleado;

			rs = stmt.executeQuery(query);
			rs.next();

			System.out.println("Nombre : " + rs.getString(1));
			System.out.println("Salario Nuevo : " + rs.getDouble(2));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
