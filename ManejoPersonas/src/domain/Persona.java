package domain;

public class Persona {
	private int IdPersona;
	private String Nombre;
	private String Apellido;

	public int getIdPersona() {
		return IdPersona;
	}

	public void setIdPersona(int idPersona) {
		IdPersona = idPersona;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [IdPersona=" + IdPersona + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}

}
