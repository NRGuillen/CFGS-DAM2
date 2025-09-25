package ejercicioBiblioteca;

public class Revista extends Biblioteca {

	private boolean esPrestado = false;

	public Revista(int codigo, String titulo, String añoPublicacion, boolean esPrestado) {
		super(codigo, titulo, añoPublicacion);
		this.esPrestado = esPrestado;
	}

	public boolean isEsPrestado() {
		return esPrestado;
	}

	public void setEsPrestado(boolean esPrestado) {
		this.esPrestado = esPrestado;
	}

	@Override
	public String añoPublicacion() {
		// TODO Auto-generated method stub
		return "El año de pubicacion de la revista fue en: " + getAñoPublicacion();
	}

	@Override
	public String codigoProducto() {
		// TODO Auto-generated method stub
		return "El codigo de producto de la revista es: " + getCodigo();
	}
	
	@Override
	public String toString() {
		return "Revista -> Codigo: "+codigo+ " -Titulo: "+titulo+" -Año de publicacion: " +añoPublicacion+ " -Prestado: "+esPrestado;
	}

}
