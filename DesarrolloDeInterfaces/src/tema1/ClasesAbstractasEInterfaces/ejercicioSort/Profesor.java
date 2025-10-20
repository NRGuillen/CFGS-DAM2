package tema1.ClasesAbstractasEInterfaces.ejercicioSort;

public class Profesor extends Persona  implements Comparable<Profesor> {

	int numeroAsignaturas;
	boolean esTutor;

	public Profesor(String dni, String nombre, String apellido, double salario, int numeroAsignaturas,
			boolean esTutor) {
		super(dni, nombre, apellido, salario);
		this.numeroAsignaturas = numeroAsignaturas;
		this.esTutor = esTutor;
	}

	public Profesor() {
		super();
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
		return " - DNI: " + dni + "\n - Nombre: " + nombre + "\n - Apellido: " + apellido + "\n - Salario: " + salario
				+ "\n - Numero asignaturas: " + numeroAsignaturas + "\n - Es tutor: " + esTutor;
	}

	@Override
	public int compareTo(Profesor p) {

		if (salario < p.getSalario()) {
			return 1;
		}
		if (salario > p.getSalario()) {
			return -1;
		}

		return 0;

	}

}
