package ManejoPersonas;

import java.util.List;

import datos.PersonasJDBC;
import domain.Persona;

public class ManejoPersonas {

	public static void main(String[] args) {
		PersonasJDBC jdbPersonasJDBC = new PersonasJDBC();
		//jdbPersonasJDBC.Insert("Alberto", "Juarez");
		
		//jdbPersonasJDBC.Update(3, "Prueba3", "Prueba3");
		
		//jdbPersonasJDBC.Delete(4);
		
		List<Persona> personas = jdbPersonasJDBC.Select();
		for(Persona persona : personas) {
			System.out.println(persona);
			System.out.println("");
		}

	}

}
