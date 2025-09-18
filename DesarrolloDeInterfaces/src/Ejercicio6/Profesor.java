package Ejercicio6;

public class Profesor {

	String dni;
	String nombre;
	String apellidos;
	double salario;
	int numeroAsignaturas;
	boolean esTutor;

	public Profesor(String dni, String nombre, String apellidos, double salario, int numeroAsignaturas,
			boolean esTutor) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.numeroAsignaturas = numeroAsignaturas;
		this.esTutor = esTutor;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public double getSalario() {
		return salario;
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
