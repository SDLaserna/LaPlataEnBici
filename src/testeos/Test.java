package testeos;

import java.util.Date;

import daos.FactoryDAO;
import daos.UsuarioDAOImp;
import entidades.Domicilio;
import entidades.Usuario;

public class Test {

	public static void main(String[] args) {
		Domicilio dom= new Domicilio("calle 12", (long) 12, "La Plata");
		Usuario usr=new Usuario("123", "Laserna", "Sergioooo", new Date(), "Masculino", dom, "sergio@mail.com", "123");
		UsuarioDAOImp usuarioDAO = FactoryDAO.getUsuarioDAO();
		usuarioDAO.crear(usr);
		System.out.println("se persisitió un usuario y un domicilio por cascada");
		
		/*Es necesario verificar que el id que se va a crear coincida con el que le asignamos
		 * a la variable id, por ejemplo si persisti una vez, y lo quiero volver a ejecutar
		 * entonces debería cambiar el valor de id a 2, para que lo encuentre. Cada vez que se
		 * ejecuta el valor de id debe ser +1 al id que autogenera la bbdd*/
		Long id = new Long(10);
		Usuario usr2=usuarioDAO.obtener(id);
		
		System.out.println("Apellido: "+usr2.getApellido());
		System.out.println("Clave: "+usr2.getClave());
		System.out.println("DNI: "+usr2.getDni());
		System.out.println("Email: "+usr2.getEmail());
		System.out.println("Nombre: "+usr2.getNombre());
		System.out.println("Sexo: "+usr2.getSexo());
		System.out.println("Calle: "+usr2.getDomicilio().getCalle());
		System.out.println("Localidad: "+usr2.getDomicilio().getLocalidad());
		System.out.println("Numero: "+usr2.getDomicilio().getNumero());

		usr.setApellido("ASDASDASDASD");
		usuarioDAO.actualizar(usr);
		System.out.println("se actualizó su apellido por 'ASDASDASDASD'");
		System.out.println("Los datos del usuario ingresados son: ");

		Usuario usr3=usuarioDAO.obtener(id);
		System.out.println("Apellido: "+usr3.getApellido());
		System.out.println("Clave: "+usr3.getClave());
		System.out.println("DNI: "+usr3.getDni());
		System.out.println("Email: "+usr3.getEmail());
		System.out.println("Nombre: "+usr3.getNombre());
		System.out.println("Sexo: "+usr3.getSexo());
		System.out.println("Calle: "+usr3.getDomicilio().getCalle());
		System.out.println("Localidad: "+usr3.getDomicilio().getLocalidad());
		System.out.println("Numero: "+usr3.getDomicilio().getNumero());
		usuarioDAO.borrar(id);
		System.out.println("se borro el usuario creado y su domicilio por cascada");
	}

}
