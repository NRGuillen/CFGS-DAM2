package EjerciciosDeRepaso.Ejercicio6;

public class Administracion {

	String dni;
	String nombre;
	String apellidos;
	double salario;
	String estudios;
	int antiguedad;

	public Administracion(String dni, String nombre, String apellidos, double salario, String estudios,
			int antiguedad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.estudios = estudios;
		this.antiguedad = antiguedad;
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

	public String getEstudios() {
		return estudios;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + " ,Nombre: " + nombre + " ,Apellido: " + apellidos + " ,Salario: " + salario
				+ " ,Estudios: " + estudios + ", Antiguedad: " + antiguedad+ " años";
	}

}
