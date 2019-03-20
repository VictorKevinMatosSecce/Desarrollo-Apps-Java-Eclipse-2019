package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.datos.Conexion;

public class TestFunciones {

	public static void main(String[] args) {
		int idEmpleado = 100;

		try {
			Connection cn = Conexion.getConnection();
			CallableStatement cstmt = null;
			double SalarioMensual;

			cstmt = cn.prepareCall("{ ? = call HR.GET_EMPLOYEE_SALARY(?) }");

			cstmt.registerOutParameter(1, Types.INTEGER);

			cstmt.setInt(2, idEmpleado);
			cstmt.execute();
			SalarioMensual = cstmt.getDouble(1);
			cstmt.close();
			System.out.println("IdEmpleado : " + idEmpleado);
			System.out.println("Salario Mensual : " + SalarioMensual);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
