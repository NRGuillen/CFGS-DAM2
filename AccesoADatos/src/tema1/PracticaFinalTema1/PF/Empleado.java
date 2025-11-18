package tema1.PracticaFinalTema1.PF; //Para funcionar el paquete deberia llamarse solo PF

import java.io.Serializable;


public class Empleado implements Serializable {

	private static final long serialVersionUID = 9144443773906433590L;

	private int identificacion; // Se genera de forma aleatoria
	private String nombre;
	private String password;// 5 - 7 longitud
	private String cargo;

	public Empleado(String nombre, String contraseña, String cargo) {
		super();
		this.identificacion = generarID();
		this.nombre = nombre;
		this.password = contraseña;
		this.cargo = cargo;
	}

	public Empleado() {
		super();
	}

	public int generarID() {

		return (int) ((1000 + Math.random() * 8999));

	}

	public boolean comprobarCargo() {

		if (cargo.toLowerCase().trim().equals("vendedor") || cargo.toLowerCase().trim().equals("gestor")) {
			return true;
		}

		return false;
	}

	public boolean comprobarContraseña() {

		String expRegStrings = "^[a-zA-Z0-9ñ._!$%&@()+-]{5,7}$";

		if (password.matches(expRegStrings)) {
			return true;
		}

		return false;

	}

	public boolean comprobarNombre() {

		String expRegStrings = "^[a-zA-Z0-9ñ._!$ %&@()+-]{5,7}$";

		if (password.matches(expRegStrings)) {
			return true;
		}

		return false;

	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String contraseña) {
		this.password = contraseña;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Empleado: " + identificacion + " |  Nombre: " + nombre + " | Contraseña: " + password
				+ " | Cargo: " + cargo;
	}

}
