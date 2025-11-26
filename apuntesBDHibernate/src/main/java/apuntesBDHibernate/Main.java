package apuntesBDHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void insertarDatos(Session session, Transaction transaction) {

		Persona persona = new Persona("Ruben", 19);
		session.save(persona);
		transaction.commit(); // Ejecuto la sentencia

	}

	// Leer un select
	public static void lectura(int clavePrimaria, Session session, Transaction transaction) {
		Persona personaResultante = session.get(Persona.class, clavePrimaria);
		if (personaResultante != null) {
			System.out.println(personaResultante.toString());
		}
		transaction.commit(); // Ejecuto la consulta

	}

	// Update de una tabla
	public static void modificacion(int clavePrimaria, Session session, Transaction transaction) {
		Persona personaModificar = session.get(Persona.class, clavePrimaria);
		if (personaModificar != null) {
			personaModificar.setNombre("Mateo");
		}
		transaction.commit(); // Ejecuto la sentencia

	}

	// Borrar persona de una tabla
	public static void borrar(int clavePrimaria, Session session, Transaction transaction) {
		Persona personaBorrar = session.get(Persona.class, clavePrimaria);
		if (personaBorrar != null) {
			session.delete(personaBorrar);
		}
		transaction.commit(); // Ejecuto la sentencia

	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		insertarDatos(session, transaction);
		lectura(1, session, transaction);
		session.close();
		HibernateUtil.shutdown();
	}
}
