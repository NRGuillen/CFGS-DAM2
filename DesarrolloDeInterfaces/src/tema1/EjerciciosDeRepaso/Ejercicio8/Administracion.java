package tema1.EjerciciosDeRepaso.Ejercicio8;

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

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return " - DNI: " + dni 
				+ "\n - nNombre: " + nombre 
				+ "\n - Apellido: " + apellidos 
				+ "\n - Salario: " + salario
				+ "\n - Estudios: " + estudios 
				+ "\n - Antiguedad: " + antiguedad 
				+ " años";
	}

}
