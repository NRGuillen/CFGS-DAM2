package tema1.ClasesAbstractasEInterfaces.ejercicioSort;

public class Directivo extends Persona {

	boolean esSalesiano;
	Turno turno;

	public Directivo(String dni, String nombre, String apellido, double salario, boolean esSalesiano, Turno turno) {
		super(dni, nombre, apellido, salario);
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
		return " - DNI: " + getDni() + "\n - Nombre: " + getNombre() + "\n - Apellido: " + getApellido()
				+ "\n - Salario: " + getSalario() + "\n - Es salesiano: " + esSalesiano + "\n - Turno: " + turno;
	}

}
