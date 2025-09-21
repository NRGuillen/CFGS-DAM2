package Ejercicio8;

public class Profesor extends Padre {

	int numeroAsignaturas;
	boolean esTutor;

	public Profesor() {
		super();
	}

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

	public void setNumeroAsignaturas(int numeroAsignaturas) {
		this.numeroAsignaturas = numeroAsignaturas;
	}

	public void setEsTutor(boolean esTutor) {
		this.esTutor = esTutor;
	}

	@Override
	public String toString() {
		return " - DNI: " + dni + "\n - Nombre: " + nombre + "\n - Apellido: " + apellidos + "\n - Salario: " + salario
				+ "\n - Numero asignaturas: " + numeroAsignaturas + "\n - Es tutor: " + esTutor;
	}

}
