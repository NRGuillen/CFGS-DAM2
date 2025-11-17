package HilosNuevoProfesor.SincronizacionHilos;

import java.util.Date;

public class Cliente {

	private static int contador = 0;

	private String nombre;
	private String ape1;
	private String ape2;
	private String tlf;
	private String dni;
	private Date d_nac;
	private boolean isActive;

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Cliente.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getD_nac() {
		return d_nac;
	}

	public void setD_nac(Date d_nac) {
		this.d_nac = d_nac;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
