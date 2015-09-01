package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USR")
public class Usuario extends Persona implements Serializable{

	/*La hago serializable porque hibernate me pide que lo implemente para borrar :/ */
	private static final long serialVersionUID = 1L;

	public Usuario() {
		this.setActiva(true);
	}

	public Usuario(String dni, String apellido, String nombre,
			Date fechaNacimiento, String sexo, Domicilio domicilio, String email,
			String clave) {
		super(dni, apellido, nombre, fechaNacimiento, sexo, domicilio, email, clave);
	}

}
