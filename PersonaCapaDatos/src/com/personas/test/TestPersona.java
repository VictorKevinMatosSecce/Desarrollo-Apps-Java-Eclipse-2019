package com.personas.test;

import java.sql.Connection;

import com.personas.dto.PersonaDTO;
import com.personas.jdbc.Conexion;
import com.personas.jdbc.PersonaDAOJDBC;



public class TestPersona {

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

			PersonaDAOJDBC jdbPersonasJDBC = new PersonaDAOJDBC(cn);
			
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setNombre("XXX");
			personaDTO.setApellido("XXX");

			jdbPersonasJDBC.Insert(personaDTO);
			
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
