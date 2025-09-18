package Ejercicio7;

public class Padre {

	String dni;
	String nombre;
	String apellidos;
	double salario;

	public Padre(String dni, String nombre, String apellidos, double salario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}

	public Padre() {
		// TODO Auto-generated constructor stub
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

}
