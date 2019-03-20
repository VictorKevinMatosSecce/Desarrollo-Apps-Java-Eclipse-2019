package ManejoPersonas;

import java.sql.Connection;
import java.util.List;
import datos.Conexion;
import datos.PersonasJDBC;
import domain.Persona;

public class ManejoPersonas {

	public static void main(String[] args) {

		// jdbPersonasJDBC.Insert("Alberto", "Juarez");

		// jdbPersonasJDBC.Update(3, "Prueba3", "Prueba3");

		// jdbPersonasJDBC.Delete(4);

		/*
		 * List<Persona> personas = jdbPersonasJDBC.Select(); for(Persona persona :
		 * personas) { System.out.println(persona); System.out.println(""); }
		 */

		Connection cn = null;

		try {
			cn = Conexion.getConnection();

			if (cn.getAutoCommit()) {
				cn.setAutoCommit(false);
			}

			PersonasJDBC jdbPersonasJDBC = new PersonasJDBC(cn);

			jdbPersonasJDBC.Insert("Kevin", "Matos");
			
			cn.commit();
		} catch (Exception e) {
			try {
				System.out.println("Encontramos al RollBack");
				e.printStackTrace(System.out);
				cn.rollback();
			} catch (Exception e2) {
				e.printStackTrace(System.out);
			}
		}

	}

}
