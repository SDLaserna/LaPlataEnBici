package entidades;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADM")
public class Administrador extends Persona {

	public Administrador(String dni, String apellido, String nombre,
			Date fechaNacimiento, String sexo, Domicilio domicilio, String email,
			String clave) {
		super(dni, apellido, nombre, fechaNacimiento, sexo, domicilio, email, clave);
	}

}
