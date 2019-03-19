package com.arquitecturajava.model;

public class Usuario {

	private int Id;
	private String NombreUsuario;
	private String NombreCompleto;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombreUsuario, String nombreCompleto) {
		super();
		Id = id;
		NombreUsuario = nombreUsuario;
		NombreCompleto = nombreCompleto;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getNombreCompleto() {
		return NombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}

}
