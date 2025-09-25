package EjerciciosDeRepaso.Ejercicio8;

public class Modulo {

	String nombre;
	int numeroHoras;
	String nombreProfesor;
	boolean esConvaldable;

	public Modulo() {
		super();
	}

	public Modulo(String nombre, int numeroHoras, String nombreProfesor, boolean esConvaldable) {
		super();
		this.nombre = nombre;
		this.numeroHoras = numeroHoras;
		this.nombreProfesor = nombreProfesor;
		this.esConvaldable = esConvaldable;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public boolean isEsConvaldable() {
		return esConvaldable;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public void setEsConvaldable(boolean esConvaldable) {
		this.esConvaldable = esConvaldable;
	}

	@Override
	public String toString() {
		return " - Nombre modulo: " + nombre + " - Horas del modulo: " + numeroHoras + " - Nombre profesor: "
				+ nombreProfesor + " - Es convalidable: " + esConvaldable;
	}

}
