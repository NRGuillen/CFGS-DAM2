package EjerciciosDeRepaso.Ejercicio8;

import java.util.ArrayList;

public class Alumno {

	String dni;
	String nombre;
	String apellidos;
	String fechaNacimiento;
	Sexo sexo;
	boolean repetidor;
	ArrayList<Modulo> modulos ;

	public Alumno(String dni, String nombre, String apellidos, String fechaNacimiento, Sexo sexo, boolean repetidor) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.repetidor = repetidor;
		this.modulos = new ArrayList<Modulo>();

	}

	public Alumno() {
		super();
		this.modulos = new ArrayList<Modulo>();

	}

	public void añadirModulo(Modulo modulo) {

		modulos.add(modulo);
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public boolean isRepetidor() {
		return repetidor;
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

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		String modulosAlumnos = "";
		if (modulos != null) {
			for (Modulo modulo : modulos) {
				modulosAlumnos += modulo + "\n";
			}
		}
		sb.append(" - DNI: " + dni).append("\n - Nombre: " + nombre)
				.append("\n - Apellidos: " + apellidos).append("\n - Fecha de nacimiento: " + fechaNacimiento)
				.append("\n - Sexo: " + sexo).append("\n - Repetidor: " + repetidor + "")
				.append("\n - Modulos: " + modulosAlumnos);

		return sb.toString();
	}

	
	
}
