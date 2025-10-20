package tema1.EjerciciosDeRepaso.Ejercicio7;

public class Directivo extends Padre {

	boolean esSalesiano;
	Turno turno;

	public Directivo(String dni, String nombre, String apellidos, double salario, boolean esSalesiano, Turno turno) {
		super(dni, nombre, apellidos, salario);
		this.esSalesiano = esSalesiano;
		this.turno = turno;
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
