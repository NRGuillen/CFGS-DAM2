package ClasesAbstractasEInterfaces.ejercicioSort;

public class Persona {

	protected String dni;
	protected String nombre;
	protected String apellido;
	protected double salario;

	public Persona(String dni, String nombre, String apellido, double salario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
	}

	public Persona() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salarioAdm) {
		this.salario = salarioAdm;
	}

}
