package Ejercicio7;

public class Administracion extends Padre {

	String estudios;
	int antiguedad;

	public Administracion(String dni, String nombre, String apellidos, double salario, String estudios,
			int antiguedad) {
		super(dni, nombre, apellidos, salario);
		this.estudios = estudios;
		this.antiguedad = antiguedad;
	}
	
	

	public Administracion() {
		super();
	}



	public String getEstudios() {
		return estudios;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + " ,Nombre: " + nombre + " ,Apellido: " + apellidos + " ,Salario: " + salario
				+ " ,Estudios: " + estudios + ", Antiguedad: " + antiguedad + " años";
	}

}
