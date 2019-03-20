package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.datos.Conexion;
import oracle.jdbc.OracleResultSetMetaData;

public class TestMetadatos {

	public static void main(String[] args) {
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			cn = Conexion.getConnection();
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM HR.EMPLOYEES");
			OracleResultSetMetaData oResultSetMetaData = null;

			oResultSetMetaData = (OracleResultSetMetaData) rs.getMetaData();

		
			if (oResultSetMetaData == null) {
				System.out.println("Metadatos no disponibles");
			} else {
				int columnCount = oResultSetMetaData.getColumnCount();

				System.out.println("N° Columnas => " + columnCount);

				for (int i = 1; i <= columnCount; i++) {
					System.out.print("Nombre Columna => " + oResultSetMetaData.getColumnName(i));

					System.out.print(" , Tipo de Columna => " + oResultSetMetaData.getColumnTypeName(i));

					switch (oResultSetMetaData.isNullable(i)) {
					case OracleResultSetMetaData.columnNoNulls:
						System.out.print(" , No Acepta Nulos");
						break;
					case OracleResultSetMetaData.columnNullable:
						System.out.print(" , Si Acepta Nulos");
						break;
					case OracleResultSetMetaData.columnNullableUnknown:
						System.out.print(" , Valor nulo desconocido");
						break;
					default:
						break;
					}
					System.out.println("");
				}

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());

			ex.printStackTrace();
		} finally {
			Conexion.close(rs);
			Conexion.close(cn);
		}
	}

}
