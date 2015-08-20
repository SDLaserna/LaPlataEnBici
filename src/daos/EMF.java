package daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
//	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("jyaa2015_bd2");
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("jyaai");			
	public static EntityManagerFactory getEMF() {
		System.out.println("se creo la conexion");
		return em;
		}
	}
