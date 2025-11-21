package tema1.EjerciciosDeRepaso.Ejercicio8;

public class Directivo extends Padre {

	boolean esSalesiano;
	Turno turno;

	public Directivo(String dni, String nombre, String apellidos, double salario, boolean esSalesiano, Turno turno) {
		super(dni, nombre, apellidos, salario);
		this.esSalesiano = esSalesiano;
		this.turno = turno;
	}

	public Directivo() {
		super();
	}

	public boolean isEsSalesiano() {
		return esSalesiano;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setEsSalesiano(boolean esSalesiano) {
		this.esSalesiano = esSalesiano;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return " - DNI: " + dni + "\n - Nombre: " + nombre + "\n - Apellido: " + apellidos + "\n - Salario: " + salario
				+ "\n - Es salesiano: " + esSalesiano + "\n - Turno: " + turno;
	}

}
