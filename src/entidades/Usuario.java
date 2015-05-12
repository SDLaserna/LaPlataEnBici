package entidades;

import java.util.Date;

public class Usuario extends Persona {

	public Usuario(String dni, String apellido, String nombre,
			Date fechaNacimiento, String sexo, Domicilio domicilio, String email,
			String clave) {
		super(dni, apellido, nombre, fechaNacimiento, sexo, domicilio, email, clave);
	}

}
