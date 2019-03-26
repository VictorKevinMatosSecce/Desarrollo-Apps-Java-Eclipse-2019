package restful.spring.boot.restful.spring.boot.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class CopyUser {
	private int Id;
	@NotEmpty(message = "El campo no debe ser vacio.")
	@Size(min = 5, max = 10, message = "El numero de caracteres no es permitido")
	private String Nombre;
	@NotEmpty(message = "El campo no debe ser vacio.")
	private String Apellido;
	@Email
	private String Email;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
