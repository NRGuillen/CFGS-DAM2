package tema1.EjerciciosDeRepaso.Ejercicio6;

public class Directivo {

	String dni;
	String nombre;
	String apellidos;
	double salario;
	boolean esSalesiano;
	Turno turno;

	public Directivo(String dni, String nombre, String apellidos, double salario, boolean esSalesiano, Turno turno) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.esSalesiano = esSalesiano;
		this.turno = turno;
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

	public boolean isEsSalesiano() {
		return esSalesiano;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + " ,Nombre: " + nombre + " ,Apellido: " + apellidos + " ,Salario: " + salario
				+ " ,Es salesiano: " + esSalesiano + ", Turno: " + turno;
	}

}
