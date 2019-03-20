package com.personas.dto;

public class PersonaDTO {

	private int IdPersona;
	private String Nombre;
	private String Apellido;

	public PersonaDTO() {

	}

	public PersonaDTO(int idPersona) {
		super();
		IdPersona = idPersona;
	}

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
		return "PersonaDTO [IdPersona=" + IdPersona + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}

}
