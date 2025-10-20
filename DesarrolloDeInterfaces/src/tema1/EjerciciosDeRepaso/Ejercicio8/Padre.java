package tema1.EjerciciosDeRepaso.Ejercicio8;

public class Padre {

	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected double salario;

	public Padre() {
		super();
	}

	public Padre(String dni, String nombre, String apellidos, double salario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
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

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

}
