package entidades;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USR")
public class Usuario extends Persona {

	protected Usuario() {
	}

	public Usuario(String dni, String apellido, String nombre,
			Date fechaNacimiento, String sexo, Domicilio domicilio, String email,
			String clave) {
		super(dni, apellido, nombre, fechaNacimiento, sexo, domicilio, email, clave);
	}

}
