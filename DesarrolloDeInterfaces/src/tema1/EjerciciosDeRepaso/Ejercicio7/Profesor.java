package tema1.EjerciciosDeRepaso.Ejercicio7;

public class Profesor extends Padre {

	int numeroAsignaturas;
	boolean esTutor;

	public Profesor(String dni, String nombre, String apellidos, double salario, int numeroAsignaturas,
			boolean esTutor) {
		super(dni, nombre, apellidos, salario);
		this.numeroAsignaturas = numeroAsignaturas;
		this.esTutor = esTutor;
	}

	public int getNumeroAsignaturas() {
		return numeroAsignaturas;
	}

	public boolean isEsTutor() {
		return esTutor;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + " ,Nombre: " + nombre + " ,Apellido: " + apellidos + " ,Salario: " + salario
				+ " ,Numero asignaturas: " + numeroAsignaturas + " ,Es tutor: " + esTutor;
	}

}
