package tema1.ejercicios.LanzarComando;

public class Comando {

	String directorio;

	public Comando(String directorio) {
		super();
		this.directorio = directorio;
	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

	@Override
	public String toString() {
		return "Comando [directorio=" + directorio + "]";
	}

}
